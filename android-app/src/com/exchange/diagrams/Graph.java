package com.exchange.diagrams;

import android.content.Context;

import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.vlad.fargutu.exchange.R;

import java.util.List;

/**
 * Created by Sparta on 22/3/2014.
 */
public class Graph extends LineGraphView {

    private GraphViewSeries graphViewSeries;

    private String graphName;
    private String days_ago;
    private String yesterday;
    private String today;

    public Graph(Context context) {
        super(context, "");

        graphName = context.getResources().getString(R.string.graph_name);

        days_ago = context.getResources().getString(R.string.days_ago);
        yesterday = context.getResources().getString(R.string.yesterday);
        today = context.getResources().getString(R.string.today);


        setTitle(graphName);

        getGraphViewStyle().setNumVerticalLabels(7);
        getGraphViewStyle().setTextSize(14);
        setDrawDataPoints(true);
        setDataPointsRadius(7f);
        setScrollable(true);
        setScalable(true);

    }

    public void addPoints(List<Double> values) {
        if (values != null && !values.isEmpty()) {

            graphViewSeries = new GraphViewSeries(getGraphViewDates(values));
            removeAllSeries();
            addSeries(graphViewSeries);


            String[] labels = getLabels(values.size());
            setHorizontalLabels(labels);
            getGraphViewStyle().setNumHorizontalLabels(values.size());
        }
    }

    private GraphViewData[] getGraphViewDates(List<Double> values) {
        GraphViewData[] graphViewDates = new GraphViewData[values.size()];

        int count = 0;
        for (Double value : values) {
            graphViewDates[count] = new GraphViewData(count + 1, value);
            count++;
        }

        return graphViewDates;
    }

    private String[] getLabels(int count) {
        String[] labels = new String[count];

        int i = count - 1;
        if (i >= 0) {
            labels[i] = today;
            i--;
        }

        if (i >= 0) {
            labels[i] = yesterday;
            i--;
        }

        for (; i >= 0; i--) {
            labels[i] = "" + (count - i - 1) + " " + days_ago;
        }


        return labels;
    }
}
