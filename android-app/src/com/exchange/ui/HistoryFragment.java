package com.exchange.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vlad.fargutu.exchange.R;

/**
 * @author vlad.fargutu
 */
public class HistoryFragment extends Fragment {


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.graph1);
//        layout.addView(graphView);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.history_layout, container, false);
    }
}
