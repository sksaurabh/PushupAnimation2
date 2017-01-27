package com.mmadapps.pushupanimation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DaySeventeenActivity extends Activity {
	private TextView lblTextViewOne;
	private EditText editText1;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        lblTextViewOne = (TextView) findViewById(R.id.lblTextViewOne);
        lblTextViewOne.setText(R.string.test_one);//
        
        editText1 = (EditText) findViewById(R.id.editText1);
        editText1.setText(R.string.test_one);
        
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				lblTextViewOne.setText(editText1.getText());				
			}
		});
        
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), Main2Activity.class));
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
		});
    }
    
    
    
    
			
}