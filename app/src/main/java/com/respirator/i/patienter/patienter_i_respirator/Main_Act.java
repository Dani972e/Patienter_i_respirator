package com.respirator.i.patienter.patienter_i_respirator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Johnny on 05/11/17.
 */

public class Main_Act extends AppCompatActivity implements View.OnClickListener {

    ImageView call_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        call_btn = (ImageView) findViewById(R.id.call_btn);
        call_btn.setOnClickListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new Menu_Frag()).commit();
        }

    }

    @Override
    public void onClick(View v) {
        if (v == call_btn) {
            System.out.print("Not implemented yet");
        }
    }
}
