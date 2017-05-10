package io.github.trylovecatch.pagetransformerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lipeng21 on 2017/4/25.
 */

public class FirstActivity extends AppCompatActivity {

    private RecyclerView mLstView;
    private MyAdapter mAdp;

    private String[] mDatas = {"默认", "ZoomOut", "Depth"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        initView();
    }

    private void initView(){
        mLstView = (RecyclerView)findViewById(R.id.main_lst);
        LinearLayoutManager tLinearLayoutManager = new LinearLayoutManager(this);
        tLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mLstView.setLayoutManager(tLinearLayoutManager);
        mAdp = new MyAdapter();
        mLstView.setAdapter(mAdp);
    }

    private class MyAdapter extends RecyclerView.Adapter{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder();
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            MyViewHolder tHolder = (MyViewHolder)holder;
            tHolder.bindData(mDatas[position]);
            tHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent tIntent = new Intent(FirstActivity.this, MainActivity.class);
                    tIntent.putExtra("index", position);
                    startActivity(tIntent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mDatas.length;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView mTxt;

        public MyViewHolder() {
            super(LayoutInflater.from(FirstActivity.this).inflate(R.layout.item, null));
            initView();
        }

        public void bindData(String pTxt){
            mTxt.setText(pTxt);
        }


        private void initView(){
            mTxt = (TextView) itemView.findViewById(R.id.item_txt);
        }
    }
}
