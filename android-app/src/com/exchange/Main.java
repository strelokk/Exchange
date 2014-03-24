package com.exchange;

import android.app.Activity;
import android.os.Bundle;

import com.exchange.ui.ExchangeFragment;

public class Main extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getFragmentManager().beginTransaction().replace(R.id.main_container, new HistoryFragment()).commit();
        getFragmentManager().beginTransaction().replace(R.id.main_container, new ExchangeFragment()).commit();

//        new RestService(Main.this).doWork();

    }

}
