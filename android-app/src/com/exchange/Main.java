package com.exchange;

import android.app.Activity;
import android.os.Bundle;

import com.exchange.rest.RestService;
import com.exchange.ui.HistoryFragment;

public class Main extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction().replace(R.id.main_container, new HistoryFragment()).commit();

        new RestService(Main.this).doWork();

    }

}
