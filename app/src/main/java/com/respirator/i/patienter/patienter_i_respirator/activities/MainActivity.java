package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.fragments.MenuFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView call_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //hides notification bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        call_btn = (ImageView) findViewById(R.id.call_btn);
        call_btn.setOnClickListener(this);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new MenuFragment()).commit();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.call_btn:
                Intent call_main = new Intent(this, CallActivity.class);
                startActivity(call_main);
                break;
        }

    }

}