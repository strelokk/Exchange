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

        this.inflater = LayoutInflater.from(context);
        this.courses = courses;
    }

    @Override
    public int getCount() {
        return courses != null ? courses.size() : 0;
    }

    @Override
    public Course getItem(int position) {
        return courses != null && courses.size() > position ? courses.get(position) : null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.course_spinner_item, parent, false);

        if (v != null) {
            ((TextView) v.findViewById(R.id.spinner_item_textview)).setText(getItem(position).getCode());
            return v;
        }

        return super.getView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.course_spinner_item, parent, false);

        if (v != null) {
            ((TextView) v.findViewById(R.id.spinner_item_textview)).setText(getItem(position).getCode());
            return v;
        }

        return super.getDropDownView(position, convertView, parent);
    }

}
