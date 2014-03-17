package com.vlad.fargutu.exchange;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import ly.apps.android.rest.client.Callback;
import ly.apps.android.rest.client.Response;
import ly.apps.android.rest.client.RestClient;
import ly.apps.android.rest.client.RestClientFactory;
import ly.apps.android.rest.client.RestServiceFactory;
import ly.apps.android.rest.client.annotations.GET;
import ly.apps.android.rest.client.annotations.QueryParam;
import ly.apps.android.rest.client.annotations.RestService;

public class Main extends Activity {

//    private String baseUrl = "http://api.openweathermap.org/data/2.5";
    //    private String baseUrl = "http://vladdid.com";
        private String baseUrl = "http://53cd7b22-a3e7-496c-a47c-14e060.appspot.com";
    private TextView myTextView;

    @RestService
    public interface OpenWeatherAPI {

//        @GET("/weather")
//        @GET("/curs.php")
//        @GET("/cursuri.php")
        @GET("/banks")
        void getForecast(@QueryParam("course") String latitude, Callback<ForecastResponse> callback);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView) findViewById(R.id.myTextView);

        RestClient client = RestClientFactory.defaultClient(this);
        OpenWeatherAPI api = RestServiceFactory.getService(baseUrl, OpenWeatherAPI.class, client);

        api.getForecast("EUR", new Callback<ForecastResponse>() {

            @Override
            public void onResponse(Response<ForecastResponse> response) {
                // This will be invoke in the UI thread after serialization with your objects ready to use

                if (response.getRawData() != null) {
                    myTextView.setText(response.getRawData());
                }
            }

        });
    }

    public class ForecastResponse {

        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
