package edu.virginia.cs2110;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_splash_screen);
		//TextView tv1 = (TextView) findViewById(R.id.textView1);
		
		new Handler().postDelayed(new Runnable() {

	        @Override
	        public void run() {
	        	init();
	        }
	    }, 3000);
		
 
	}
	
	public void init() {
		setContentView(R.layout.activity_main);
		getWindow().setBackgroundDrawableResource(R.drawable.dw_spooky_manor);
		
		Button startGame = (Button) findViewById(R.id.button1);
		final View vw = new MainView(this);
		
		startGame.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	getWindow().setBackgroundDrawableResource(R.drawable.dw_spooky_manor);
	                setContentView(vw);
	            }
		});
		Button button2 = (Button) findViewById(R.id.button2);
	}
	
}
