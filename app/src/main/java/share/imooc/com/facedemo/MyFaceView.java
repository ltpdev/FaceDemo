package share.imooc.com.facedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by yls on 2017/4/18.
 */

public class MyFaceView  extends ImageView{
    private Paint p;
    private Rect rect;
    public MyFaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        p=new Paint();
        p.setColor(Color.BLUE);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(5);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (rect!=null){
            canvas.drawRect(rect,p);
        }

    }

    public void drawFace(Rect rect){
        this.rect=rect;
        invalidate();
    }
}
