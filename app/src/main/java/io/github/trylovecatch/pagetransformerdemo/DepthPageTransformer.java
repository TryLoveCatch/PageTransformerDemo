package io.github.trylovecatch.pagetransformerdemo;

import android.view.View;

/**
 * Created by lipeng21 on 2017/4/25.
 */

public class DepthPageTransformer extends BasePageTransformer {
    private static final float MIN_SCALE = 0.75f;

    @Override
    public void handleInvisiblePage(View view, float position) {
        view.setAlpha(0);
    }

    @Override
    public void handleLeftPage(View view, float position) {
        view.setAlpha(1);
        view.setTranslationX(0);
        view.setScaleX(1);
        view.setScaleY(1);
    }

    @Override
    public void handleRightPage(View view, float position) {
        int pageWidth = view.getWidth();
        // Fade the page out.
        view.setAlpha(1 - position);

        // Counteract the default slide transition
        view.setTranslationX(pageWidth * -position);

        // Scale the page down (between MIN_SCALE and 1)
        float scaleFactor = MIN_SCALE
                + (1 - MIN_SCALE) * (1 - Math.abs(position));
        view.setScaleX(scaleFactor);
        view.setScaleY(scaleFactor);
    }
}
