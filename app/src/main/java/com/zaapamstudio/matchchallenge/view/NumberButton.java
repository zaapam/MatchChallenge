package com.zaapamstudio.matchchallenge.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zaapamstudio.matchchallenge.R;

/**
 * Created by suthamaskamollasal on 3/3/15 AD.
 */
public class NumberButton extends LinearLayout {

    private ImageView imgNumber1;
    private ImageView imgNumber2;
    private ImageView imgNumber3;
    private ImageView imgNumber4;
    private LinearLayout container;
    private int currentNumber;

    public NumberButton(Context context) {
        super(context);

        initInstance();
    }

    public NumberButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        initInstance();
    }

    public NumberButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initInstance();
    }

    private void initInstance() {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_number, this, true);


        container = (LinearLayout) findViewById(R.id.contentContainer);
        imgNumber1 = (ImageView) findViewById(R.id.imgNumber1);
        imgNumber2 = (ImageView) findViewById(R.id.imgNumber2);
        imgNumber3 = (ImageView) findViewById(R.id.imgNumber3);
        imgNumber4 = (ImageView) findViewById(R.id.imgNumber4);



        //imgNumber1.setImageResource(R.drawable.number_2);
        //removeView(imgNumber1);

        //removeViewAt(0);
    }

    public void setText(String text) {
        //String[] strings = text.split("");
        char[] chars = text.toCharArray();

        //Log.d("MC", "Number str count: " + strings.length);

        container.removeAllViewsInLayout();

        //removeAllViews();
        //removeAllViewsInLayout();
        //removeView(imgNumber1);

        for (int i=0 ; i<chars.length ; i++) {
            switch (i) {
                case 0:
                    imgNumber1.setImageResource(getResourceIdByChar(String.valueOf(chars[i])));
                    container.addView(imgNumber1);
                    break;
                case 1:
                    imgNumber2.setImageResource(getResourceIdByChar(String.valueOf(chars[i])));
                    container.addView(imgNumber2);
                    break;
                case 2:
                    imgNumber3.setImageResource(getResourceIdByChar(String.valueOf(chars[i])));
                    container.addView(imgNumber3);
                    break;
                case 3:
                    imgNumber4.setImageResource(getResourceIdByChar(String.valueOf(chars[i])));
                    container.addView(imgNumber4);
                    break;

            }
        }
    }

    public int getNumber() {
        return currentNumber;
    }

    private int getResourceIdByChar(String c) {

        switch (c) {
            case "0": return R.drawable.number_0;
            case "1": return R.drawable.number_1;
            case "2": return R.drawable.number_2;
            case "3": return R.drawable.number_3;
            case "4": return R.drawable.number_4;
            case "5": return R.drawable.number_5;
            case "6": return R.drawable.number_6;
            case "7": return R.drawable.number_7;
            case "8": return R.drawable.number_8;
            case "9": return R.drawable.number_9;
            case "+": return R.drawable.char_plus;
            case "-": return R.drawable.char_minus;
            case "*": return R.drawable.char_multiply;
            case "/": return R.drawable.char_divine;
            default: return 0;
        }
    }
}
