package com.zaapamstudio.matchchallenge.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.zaapamstudio.matchchallenge.utils.Contextor;

/**
 * Created by suthamaskamollasal on 3/17/15 AD.
 */
public class FontTextView extends TextView {
    public FontTextView(Context context) {
        super(context);
        initInstance();
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInstance();
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInstance();
    }

    private void initInstance() {
        Typeface tf = Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/FONTNONGNAM.TTF");
        setTypeface(tf);
    }
}
