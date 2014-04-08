package edu.virginia.cs2110;

//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBar;
//import android.support.v4.app.Fragment;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class Ghost extends BitmapDrawable {
	Bitmap bit;
	int xPosition;
	int yPosition;
	int ai;

	public Ghost(Resources res, Bitmap map, int x, int y, int ai) {
		super(res, map);
		bit = BitmapFactory.decodeResource(res,
				R.drawable.ic_launcher);
		xPosition = x;
		yPosition = y;
		this.ai = ai;
	}

	public void draw(Canvas c, int x, int y, int s, int w, int h) {
		super.draw(c);
		move(x,y,s, w, h);
		c.drawBitmap(bit, xPosition, yPosition, new Paint());
	}

	@Override
	public int getOpacity() {
		return 0;
	}

	@Override
	public void setAlpha(int a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColorFilter(ColorFilter arg0) {
		// TODO Auto-generated method stub

	}
	
	
	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public String toString() {
		return "Position: [" + xPosition + ", " + yPosition + "]";
	}

	public void move(int x, int y, int s, int width, int height) {
		if (ai == 0) {
			if (xPosition < x) {
				xPosition += s;
			}

			else if (xPosition > x) {
				xPosition -= s;
			}

			if (yPosition < y) {
				yPosition += s;
			}

			else if (yPosition > y) {
				yPosition -= s;
			}
		}
		if (ai == 1) {
			if (xPosition < x && xPosition > 10) {
				xPosition -= s;
			}

			else if (xPosition > x && xPosition < width-50) {
				xPosition += s;
			}

			if (yPosition < y && yPosition > 10) {
				yPosition -= s;
			}

			else if (yPosition > y && yPosition < height-75) {
				yPosition += s;
			}
		}

		if (ai == 2) {
			double d = Math.sqrt(Math.pow(x-xPosition,2)+Math.pow((y-yPosition), 2));
			if (d < 100) {
				if ( xPosition != x) {
					xPosition = xPosition - s*(x-xPosition)/Math.abs(xPosition-x);
				}
				if ( yPosition != y) {
					yPosition = yPosition - s*(y-yPosition)/Math.abs(yPosition-y);

				}
			}
			if (d > 120) {
				if ( xPosition != x) {
					xPosition = xPosition + s*(x-xPosition)/Math.abs(xPosition-x);
				}
				if ( yPosition != y) {
					yPosition = yPosition + s*(y-yPosition)/Math.abs(yPosition-y);
				}
			}
		}
	}
}
	
	

