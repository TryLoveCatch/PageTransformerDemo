package io.github.trylovecatch.pagetransformerdemo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by lipeng21 on 2017/4/25.
 */

public class MyTransformer extends BasePageTransformer {

    @Override
    public void handleInvisiblePage(View view, float position) {
        view.setAlpha(0); //透明度设置为0
    }

    @Override
    public void handleLeftPage(View view, float position) {
        doJob(view, position);
    }

    @Override
    public void handleRightPage(View view, float position) {
        doJob(view, position);
    }

    private void doJob(View view, float position){

        view.setAlpha(1);
        float scrollXOffset = view.getWidth() * 1.5f;
        ViewGroup tViewGroup = (ViewGroup) view;
        View tView;
        for (int i = 0; i < tViewGroup.getChildCount(); i++) {
            tView = tViewGroup.getChildAt(i);
            if (tView == null || tView instanceof ImageView) {
                continue;
            }
            tView.setTranslationX(scrollXOffset * position);
            //                    scrollXOffset *= 0.5;
        }
    }
}
