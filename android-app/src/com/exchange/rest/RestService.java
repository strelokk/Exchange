package com.exchange.rest;

import android.app.ProgressDialog;
import android.content.Context;

import com.exchange.models.Bank;

import java.util.List;

import ly.apps.android.rest.client.Callback;
import ly.apps.android.rest.client.RestClient;
import ly.apps.android.rest.client.RestClientFactory;
import ly.apps.android.rest.client.RestServiceFactory;
import ly.apps.android.rest.client.annotations.GET;
import ly.apps.android.rest.client.annotations.QueryParam;

/**
 * Created by vlad.fargutu on 3/20/14.
 */
public class RestService {

    private String baseUrl = "http://53cd7b22-a3e7-496c-a47c-14e060.appspot.com";

    private ProgressDialog mProgress;

    private Context context;

    @ly.apps.android.rest.client.annotations.RestService
    public interface OpenWeatherAPI {

        @GET("/banks")
        void getForecast(@QueryParam("course") String latitude, Callback<List<Bank>> callback);

    }

    public RestService(Context context) {
        super();
        this.context = context;
    }

    private void doWork() {
        mProgress = new ProgressDialog(context);
        mProgress.setMessage("Please wait ...");
        mProgress.setCancelable(false);
        mProgress.setIndeterminate(true);
        mProgress.show();

        RestClient client = RestClientFactory.defaultClient(context);
        OpenWeatherAPI api = RestServiceFactory.getService(baseUrl, OpenWeatherAPI.class, client);

//        api.getForecast("EUR", new Callback<List<Bank>>() {
//
//            @Override
//            public void onResponse(Response<List<Bank>> response) {
        // This will be invoke in the UI thread after serialization with your objects ready to use

//                if (response.getRawData() != null) {

//                    myTextView.setText(response.getResult().toString());

//                }

        mProgress.dismiss();
//            }

//        });
    }

}
