package io.github.trylovecatch.pagetransformerdemo;

import android.view.View;

/**
 * Created by lipeng21 on 2017/4/25.
 */

public class ZoomOutPageTransformer extends BasePageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

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
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();
        // Modify the default slide transition to shrink the page as well
        float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
        float vertMargin = pageHeight * (1 - scaleFactor) / 2;
        float horzMargin = pageWidth * (1 - scaleFactor) / 2;
        if (position < 0) {
            view.setTranslationX(horzMargin - vertMargin / 2);
        } else {
            view.setTranslationX(-horzMargin + vertMargin / 2);
        }

        // Scale the page down (between MIN_SCALE and 1)
        view.setScaleX(scaleFactor);
        view.setScaleY(scaleFactor);

        // Fade the page relative to its size.
        view.setAlpha(MIN_ALPHA +
                (scaleFactor - MIN_SCALE) /
                        (1 - MIN_SCALE) * (1 - MIN_ALPHA));
    }
}
