package com.zaapamstudio.matchchallenge.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.zaapamstudio.matchchallenge.R;

/**
 * Created by suthamaskamollasal on 3/3/15 AD.
 */
public class NumberButton extends LinearLayout {
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

    }
}
