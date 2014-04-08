package edu.virginia.cs2110;

//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBar;
//import android.support.v4.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.os.Build;

public class MainView extends View {
	public Bitmap bit;
	private DisplayMetrics disp;
	private Context cn;
	private int width;
	private int height;
	private int x, y;
	private Ghost g1, g2, g3;
	
	private Paint p;
	
	public MainView(Context c) {
		super(c);
		cn = c;
		init();
		// TODO Auto-generated constructor stub
	}
	
	public void setBit(Bitmap map){
	}

	public MainView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
		// TODO Auto-generated constructor stub
	}

	public MainView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		
		disp = new DisplayMetrics();
		((WindowManager) cn.getSystemService(Context.WINDOW_SERVICE))
				.getDefaultDisplay().getMetrics(disp);
		width = disp.widthPixels;
		height = disp.heightPixels;
		
		g1 = new Ghost(getResources(), bit, 15, 15, 0);
		g2 = new Ghost(getResources(), bit, 25, 25, 1);
		g3 = new Ghost(getResources(), bit, 35, 35 ,2);
		
		p = new Paint();
		p.setARGB(255, 255, 0, 0);
		p.setStyle(Paint.Style.STROKE);
		p.setStrokeWidth(5);
		
		this.setOnTouchListener(new OnTouchListener(){
			public boolean onTouch(View v, MotionEvent event) {
				x = (int) event.getX();
				y = (int) event.getY();
				return false;
			}
		});
		
	}

	@Override
	public void onDraw(Canvas c) {
		super.onDraw(c);
		c.drawCircle(x, y, 10, p);
		g1.draw(c, x, y, 8, width, height);
		g2.draw(c, x, y, 5, width, height);
		g3.draw(c, x, y, 3, width, height);
		invalidate();
	}
}
