package io.github.trylovecatch.pagetransformerdemo;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private List<View> mArrViews;

    private int mIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIndex = getIntent().getIntExtra("index", 0);

        initData();
        initView();
    }

    private void initView(){
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setPageTransformer(true, createPageTransformer());
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mArrViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mArrViews.get(position));
                return mArrViews.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mArrViews.get(position));
            }
        });
    }

    private void initData(){
        mArrViews = new ArrayList<>();

        View tView ;
        for(int i = 0;i<5;i++) {
            tView = LayoutInflater.from(this).inflate(R.layout.activity_guide_page_01, null);
            ((TextView)tView.findViewById(R.id.guide_page_item_txt_msg))
                    .setText("fjdsalkjfldsafjlkdsafdsafsadgrewqewqr324354fdsabfdsafdsafsdafs" + (i+1));
            ((TextView)tView.findViewById(R.id.guide_page_item_txt_title))
                    .setText("Title" + (i + 1));
            mArrViews.add(tView);
        }

    }

    private ViewPager.PageTransformer createPageTransformer(){
        switch (mIndex){
            case 0:
                return new MyTransformer();
            case 1:
                return new ZoomOutPageTransformer();
            case 2:
                return new DepthPageTransformer();
            default:
                return new MyTransformer();
        }
    }
}
