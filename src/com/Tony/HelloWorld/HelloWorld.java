package com.Tony.HelloWorld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.os.CountDownTimer;

public class HelloWorld extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    public int times=0;
    public boolean clickable=true;
    public boolean startable=true;
    public TextView textShown;
    public TextView timerShown;
    public CountDownTimer count;
    public Button click;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
    	textShown = (TextView)findViewById(R.id.clicktimes);
        timerShown = (TextView)findViewById(R.id.timer); 
        click = (Button)findViewById(R.id.Click);
        click.setOnClickListener(this);
        
        count = new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
            	timerShown.setText(millisUntilFinished / 1000 + "\nseconds\nremained: ");
            }
            public void onFinish() {
            	timerShown.setText("done!");
            	clickable=false;
            }
         };
          
    }
    public void onClick(View v){
    	if(startable==true){
    		count.start();
    	}
    	if(clickable==true){
    		startable=false;
    		times++;
    	}
    	String tmp = Integer.toString(times);
    	textShown.setText(tmp);
    }
}



