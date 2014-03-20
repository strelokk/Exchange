package com.vlad.fargutu.exchange;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.vlad.fargutu.exchange.models.Bank;

import java.util.List;

import ly.apps.android.rest.client.Callback;
import ly.apps.android.rest.client.Response;
import ly.apps.android.rest.client.RestClient;
import ly.apps.android.rest.client.RestClientFactory;
import ly.apps.android.rest.client.RestServiceFactory;
import ly.apps.android.rest.client.annotations.GET;
import ly.apps.android.rest.client.annotations.QueryParam;
import ly.apps.android.rest.client.annotations.RestService;

public class Main extends Activity {

    private String baseUrl = "http://53cd7b22-a3e7-496c-a47c-14e060.appspot.com";
    private TextView myTextView;

    private ProgressDialog mProgress;

    @RestService
    public interface OpenWeatherAPI {

        @GET("/banks")
        void getForecast(@QueryParam("course") String latitude, Callback<List<Bank>> callback);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView) findViewById(R.id.myTextView);

        mProgress = new ProgressDialog(Main.this);
        mProgress.setMessage("Please wait ...");
        mProgress.setCancelable(false);
        mProgress.setIndeterminate(true);
        mProgress.show();

        RestClient client = RestClientFactory.defaultClient(this);
        OpenWeatherAPI api = RestServiceFactory.getService(baseUrl, OpenWeatherAPI.class, client);

        api.getForecast("EUR", new Callback<List<Bank>>() {

            @Override
            public void onResponse(Response<List<Bank>> response) {
                // This will be invoke in the UI thread after serialization with your objects ready to use

                if (response.getRawData() != null) {

                    myTextView.setText(response.getResult().toString());

                }

                mProgress.dismiss();
            }

        });

    }

}
