package com.exchange.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.exchange.R;

/**
 * A custom ViewFlipper which flip his elements when swiping to right and left.
 *
 * @author vlad.fargutu
 */
public class TouchableViewFlipper extends ViewFlipper implements View.OnClickListener {

    private GestureDetector gestureDetector;
    private boolean isOpened = false;

    private ImageView next;
    private ImageView back;

    public TouchableViewFlipper(Context context) {
        super(context);
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    public TouchableViewFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    private void goNext() {
        if (!isOpened) {
            showNext();
            isOpened = !isOpened;
        }
    }

    private void goBack() {
        if (isOpened) {
            showPrevious();
            isOpened = !isOpened;
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        findViewById(R.id.button_next).setOnClickListener(TouchableViewFlipper.this);
        findViewById(R.id.button_back).setOnClickListener(TouchableViewFlipper.this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_next:
                goNext();
                break;
            case R.id.button_back:
                goBack();
                break;
            default:
                break;
        }
    }

    private final class GestureListener extends SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 50;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            boolean result = false;

            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();

            if (Math.abs(diffX) > Math.abs(diffY)) {

                if (Math.abs(diffX) > SWIPE_THRESHOLD
                        && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        goNext();
                    } else {
                        goBack();
                    }
                }

            }

            return result;
        }
    }
}
