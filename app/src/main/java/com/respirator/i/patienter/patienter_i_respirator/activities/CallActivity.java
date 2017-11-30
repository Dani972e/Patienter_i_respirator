package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.respirator.i.patienter.patienter_i_respirator.R;

public class CallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onWindowFocusChanged(true);

        setContentView(R.layout.call_activity);

    }


}
