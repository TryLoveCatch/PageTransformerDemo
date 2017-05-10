package io.github.trylovecatch.pagetransformerdemo;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by lipeng21 on 2017/5/10.
 */

public abstract class BasePageTransformer implements ViewPager.PageTransformer {
    /**
     * Apply a property transformation to the given page.
     *
     * @param view     Apply the transformation to this page
     * @param position Position of page relative to the current front-and-center
     *                 position of the pager. 0 is front and center. 1 is one full
     */
    @Override
    public void transformPage(View view, float position) {
        if (position < -1.0f) { // [-Infinity,-1) 不可见状态
            // This page is way off-screen to the left.
            handleInvisiblePage(view, position);
        } else if (position <= 0.0f) { // [-1,0] 可见状态，设置动画效果 左边的item
            // Use the default slide transition when moving to the left page
            handleLeftPage(view, position);
        } else if (position <= 1.0f) { // (0,1] 可见状态，设置动画效果 右边的item
            handleRightPage(view, position);
        } else { // (1,+Infinity] 不可见状态
            // This page is way off-screen to the right.
            handleInvisiblePage(view, position);
        }
    }

    public abstract void handleInvisiblePage(View view, float position);

    public abstract void handleLeftPage(View view, float position);

    public abstract void handleRightPage(View view, float position);
}
