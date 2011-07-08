package com.Tony.HelloWorld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.os.CountDownTimer;

public class HelloWorld extends Activity {
    /** Called when the activity is first created. */
	private static int[] bgs = { R.drawable.graph1, R.drawable.graph2 };
    public int times=0;
    public boolean clickable=true;
    public boolean startable=true;
    public TextView textShown;
    public TextView timerShown;
    public CountDownTimer count;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
    	ImageView image1 = (ImageView)findViewById(R.id.imageView1);
    	image1.setImageDrawable(getResources().getDrawable(bgs[0]));
    	textShown = (TextView)findViewById(R.id.clicktimes);
        timerShown = (TextView)findViewById(R.id.timer);    	
        
        count = new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
            	timerShown.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
            	timerShown.setText("done!");
            	clickable=false;
            	
            }
         };
        
    }
    public void imbt1(View imbt1View){
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






