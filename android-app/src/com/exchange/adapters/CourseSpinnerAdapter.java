package com.exchange.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.exchange.R;
import com.exchange.dao.Course;

import java.util.List;

/**
 * @author vlad.fargutu
 */
public class CourseSpinnerAdapter extends ArrayAdapter<Course> {

    private List<Course> courses;
    private LayoutInflater inflater;

    public CourseSpinnerAdapter(Context context, List<Course> courses) {
        super(context, R.layout.course_spinner_item, courses);
        this.courses = courses;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, parent);
    }

    public View getCustomView(int position, ViewGroup parent) {
        View convertView = inflater.inflate(R.layout.course_spinner_item, parent, false);

        if (courses != null && courses.size() > position) {
            ((TextView) convertView.findViewById(R.id.spinner_item_textview)).setText(courses.get(position).getCode());
        }

        return convertView;
    }

}
