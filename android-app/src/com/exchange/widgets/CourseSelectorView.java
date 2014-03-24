package com.exchange.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.exchange.R;
import com.exchange.adapters.CourseSpinnerAdapter;
import com.exchange.dao.Course;

import java.util.List;

/**
 * @author vlad.fargutu
 */
public class CourseSelectorView extends RelativeLayout implements View.OnClickListener {

    private Context context;

    private Spinner fromCourseSpinner;
    private Spinner toCourseSpinner;

    private List<Course> courses;

    public CourseSelectorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setContentView();
    }


    private void setContentView() {
        View root = inflate(context, R.layout.course_selector_layout, CourseSelectorView.this);

        this.fromCourseSpinner = (Spinner) root.findViewById(R.id.from_course_spinner);

        this.toCourseSpinner = (Spinner) root.findViewById(R.id.to_course_spinner);

        root.findViewById(R.id.inverse_courses).setOnClickListener(CourseSelectorView.this);
    }

    private void inverseCourses() {
        int pos1 = fromCourseSpinner.getSelectedItemPosition();
        int pos2 = toCourseSpinner.getSelectedItemPosition();

        fromCourseSpinner.setSelection(pos2);
        toCourseSpinner.setSelection(pos1);
    }

    private void initSpinners() {
        if (courses != null) {
            fromCourseSpinner.setAdapter(new CourseSpinnerAdapter(context, courses));
            fromCourseSpinner.setSelection(getCoursePositionByCode("RON"));
            toCourseSpinner.setAdapter(new CourseSpinnerAdapter(context, courses));
            toCourseSpinner.setSelection(getCoursePositionByCode("EUR"));
        }
    }

    private int getCoursePositionByCode(String code) {
        int position = -1;

        for (Course c : courses) {
            position++;
            if (c.getCode().equalsIgnoreCase(code)) {
                return position;
            }
        }

        return position;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;

        initSpinners();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.inverse_courses:
                inverseCourses();

            default:
                break;

        }

    }

}
