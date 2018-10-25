package com.umeng.soexample.weighit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Shinelon on 2018/10/25.
 */

public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        this(context,null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private onItemClickListener listener;
    public interface onItemClickListener{
        void onItemClick(View v, int position);
    }
    public void setonItemClickListener(onItemClickListener listener) {
        this.listener=listener;
    }

    @Override
    protected void onLayout(boolean b, int l, int l1, int l2, int l3) {
        measureChildren(0,0);
        int totaLWidth=0;
        int totalHeight=0;
        for (int i = 0; i <getChildCount() ; i++) {
            View view = getChildAt(i);
            final int position=i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener!=null){
                        listener.onItemClick(view,position);
                    }
                }
            });
            int vw = view.getMeasuredWidth();
            int vh = view.getMeasuredHeight();
            if (totaLWidth+vw>getMeasuredWidth()){
                totaLWidth=0;
                totalHeight+=vh;
            }
            view.layout(totaLWidth,totalHeight,totaLWidth+vw,totalHeight+vh);
            totaLWidth+=vw;
        }
    }
}
