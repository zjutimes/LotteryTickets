package com.betterzw.lotterytickets.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.betterzw.lotterytickets.R;
import com.betterzw.lotterytickets.activity.BaseActivity;
import com.betterzw.lotterytickets.api.GitHubService;
import com.betterzw.lotterytickets.api.LotteryBaseData;
import com.betterzw.lotterytickets.api.LotteryService;
import com.betterzw.lotterytickets.api.Repo;
import com.betterzw.lotterytickets.api.RepoSearchResponse;
import com.betterzw.lotterytickets.network.RetrofitFactory;
import com.betterzw.lotterytickets.utils.L;
import com.betterzw.lotterytickets.widget.CustomLoadMoreView;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    private final String API_URL = "http://m.lottery.gov.cn/api/";

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    HomeAdapter homeAdapter;

    View emtpyView;
    View loadView;

    int page = 1;
    int pageSize = 20;

    int currentNum;

    String currentTerm = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L.d("oncreate");

        //判断是否要显示splash activity
       /* if(Prefs.isSplashEnabled() && savedInstanceState == null){
            //start splash activity
        }*/

        init();
        getData();
    }

    /**
     * 初始化
     */
    private void init() {

        toolbarTitle.setText(R.string.app_name);

        emtpyView = mInflater.inflate(R.layout.empty, null);
        loadView = mInflater.inflate(R.layout.loading, null);

        homeAdapter = new HomeAdapter(R.layout.home_item_view);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        swipeRefreshLayout.setOnRefreshListener(this);
        homeAdapter.setOnLoadMoreListener(this, recyclerView);

        homeAdapter.setEnableLoadMore(true);
        homeAdapter.setLoadMoreView(new CustomLoadMoreView());

        recyclerView.setAdapter(homeAdapter);
    }

    @Override
    public void onLoadMoreRequested() {
        L.v("onLoadMore");
        swipeRefreshLayout.setEnabled(false);
        page++;

        getData();
    }

    @Override
    public void onRefresh() {
        L.v("onRefresh");

        page = 1;
        getData();
    }


    /**
     * 获取数据
     */
    private void getData() {
        Retrofit retrofit = RetrofitFactory.newInstance(API_URL);
        // Create an instance of our GitHub API interface.
        LotteryService lotteryService = retrofit.create(LotteryService.class);

        Date date = new Date();


        currentNum = page * pageSize;


        Call<List<LotteryBaseData>> lotteryData = lotteryService.contributors(4, currentTerm, currentNum);
        lotteryData.enqueue(new Callback<List<LotteryBaseData>>() {
            @Override
            public void onResponse(Call<List<LotteryBaseData>> call, Response<List<LotteryBaseData>> response) {
                L.v("response:success->" + response.body().size());


                List<LotteryBaseData.LotteryData> mDataList = new ArrayList<>();

                for (LotteryBaseData lotteryBaseData : response.body()) {
                    for (LotteryBaseData.LotteryData lotteryData : lotteryBaseData.mdata) {
                        StringBuilder resultNumber = new StringBuilder();
                        for (String number : lotteryData.codeNumber) {
                            resultNumber.append(number).append("  ");
                        }
                        mDataList.add(lotteryData);
                    }
                }

                homeAdapter.setNewData(mDataList);
                homeAdapter.loadMoreComplete();

                if(swipeRefreshLayout.isRefreshing()){
                    swipeRefreshLayout.setRefreshing(false);
                }
            }

            @Override
            public void onFailure(Call<List<LotteryBaseData>> call, Throwable t) {
                homeAdapter.loadMoreFail();
            }
        });
    }
}
