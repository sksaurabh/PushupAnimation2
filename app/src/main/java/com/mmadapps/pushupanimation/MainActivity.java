package com.mmadapps.pushupanimation;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements
        AdapterView.OnItemSelectedListener {
   Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_2);

        mFlipper = ((ViewFlipper) this.findViewById(R.id.flipper));
        mFlipper.startFlipping();
        button= (Button) findViewById(R.id.button);
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mStrings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, DaySeventeenActivity.class);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
               startActivity(intent);
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position,
                               long id) {
        switch (position) {

            case 0:
                mFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.push_up_in));
                mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.push_up_out));
                break;
            case 1:
                mFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.push_left_in));
                mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.push_left_out));
                break;
            case 2:
                mFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                        android.R.anim.fade_in));
                mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                        android.R.anim.fade_out));
                break;
            default:
                mFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.hyperspace_in));
                mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.hyperspace_out));
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    private String[] mStrings = { "Push up", "Push left", "Cross fade",
            "Hyperspace" };

    private ViewFlipper mFlipper;

}
