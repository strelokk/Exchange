package com.exchange.rest;

import com.exchange.rest.models.JBank;
import com.exchange.rest.models.JCourse;
import com.exchange.rest.models.JCourseValue;

import java.util.List;

import ly.apps.android.rest.client.Callback;
import ly.apps.android.rest.client.annotations.GET;
import ly.apps.android.rest.client.annotations.QueryParam;

/**
 * @author vlad.fargutu
 */

@ly.apps.android.rest.client.annotations.RestService
public interface RestFullAPI {

    @GET("/banks")
    void getBanks(Callback<List<JBank>> callback);

    @GET("/courses")
    void getCourses(Callback<List<JCourse>> callback);

    @GET("/coursevalues")
    void getCourseValues(@QueryParam("date") String date, Callback<List<JCourseValue>> callback);

}
