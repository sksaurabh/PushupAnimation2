package com.mmadapps.pushupanimation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity   extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        Display display = ((WindowManager)
                getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        if ((display.getRotation() == Surface.ROTATION_0) ||
                (display.getRotation() == Surface.ROTATION_180)) {
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        } else if ((display.getRotation() == Surface.ROTATION_90) ||
                (display.getRotation() == Surface.ROTATION_270)) {
            overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
        }
    }
}
