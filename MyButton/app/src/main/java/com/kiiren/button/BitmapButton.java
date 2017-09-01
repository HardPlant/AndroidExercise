package com.kiiren.button;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by 120897 on 2017-08-29.
 */

public class BitmapButton extends AppCompatButton {
    public BitmapButton(Context context) {
        super(context);

        init(context);

    }

    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        setBackgroundResource(R.drawable.frlgbtn);
        float textSize = getResources().getDimension(R.dimen.text_size);

        setTextSize(textSize);

        setTextColor(Color.BLUE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        switch(action){
            case MotionEvent.ACTION_DOWN:
                setBackgroundResource(R.drawable.ic_launcher_background);
                break;
            case MotionEvent.ACTION_UP:
                setBackgroundResource(R.drawable.frlgbtn);
                break;
        }

        invalidate();

        return true;
    }
}
