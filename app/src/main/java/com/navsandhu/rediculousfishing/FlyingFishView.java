package com.navsandhu.rediculousfishing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public class FlyingFishView extends View
{
    private Bitmap fish, fish2, fish3;
    private Bitmap bg;
    private float fishSpeed=20;
    private float fishX=1000, FishY;

    private Bitmap fishhuk;
    private float hukX=400;
    private float hukY=500;
    private float hukSpeed=20;

    private boolean isTouch=false;

    Paint paint;

    public FlyingFishView(Context context) {
        super(context);
        bg = BitmapFactory.decodeResource(getResources(), R.drawable.gamebg);
        fish = BitmapFactory.decodeResource(getResources(), R.drawable.fish1);
        fish2 = BitmapFactory.decodeResource(getResources(), R.drawable.fish2);
        fish3 = BitmapFactory.decodeResource(getResources(), R.drawable.fish3);
        fishhuk = BitmapFactory.decodeResource(getResources(), R.drawable.fishhuk);



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bg,null, new RectF(0,0,canvas.getWidth(),canvas.getHeight()), null);
      //  canvas.drawBitmap(fish,0,0, null);
        fishX = fishX-fishSpeed;
     //   canvas.drawBitmap(fish,null, new RectF(0+fishX,0,100,100), null);


        canvas.drawBitmap(fish,fishX,1000,null);
        canvas.drawBitmap(fish2,fishX,1100,null);
        canvas.drawBitmap(fish3,fishX,1200,null);
        canvas.drawBitmap(fish,fishX+300,1000,null);
        canvas.drawBitmap(fish2,fishX+200,1100,null);
        canvas.drawBitmap(fish3,fishX+400,1200,null);

        if(isTouch)
        {
            hukY=hukY+hukSpeed;

            isTouch=false;
        }
        else
        {
            if(hukY>=500)
            {
                hukY = hukY-20;
            }
        }
        canvas.drawBitmap(fishhuk,hukX,hukY,null);

       if(fishX<-500)
       {
           fishX=1000;
       }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
       if(event.getAction()==MotionEvent.ACTION_DOWN)
       {
           isTouch=true;
           hukSpeed=20;
       }
       return true;
    }
}
