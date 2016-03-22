package com.bzh.dytt.film;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.bzh.data.film.entity.FilmEntity;
import com.bzh.data.repository.Repository;
import com.bzh.dytt.base.BaseActivity;
import com.bzh.dytt.base.BaseFragment;
import com.bzh.dytt.base.BaseView;
import com.bzh.dytt.base.IFragmentPresenter;
import com.bzh.recycler.ExCommonAdapter;
import com.bzh.recycler.ExRecyclerView;
import com.bzh.recycler.ExViewHolder;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * ==========================================================<br>
 * <b>版权</b>：　　　别志华 版权所有(c)2016<br>
 * <b>作者</b>：　　  biezhihua@163.com<br>
 * <b>创建日期</b>：　16-3-20<br>
 * <b>描述</b>：　　　<br>
 * <b>版本</b>：　    V1.0<br>
 * <b>修订历史</b>：　<br>
 * ==========================================================<br>
 */
public abstract class RefreshRecyclerPresenter<Entity> implements IFragmentPresenter, SwipeRefreshLayout.OnRefreshListener, ExCommonAdapter.OnItemClickListener, ExRecyclerView.OnLoadMoreListener {

    private final BaseActivity baseActivity;
    private final BaseFragment baseFragment;
    private final RefreshRecyclerView refreshRecyclerView;

    private ExCommonAdapter<Entity> exCommonAdapter;

    public RefreshRecyclerPresenter(BaseActivity baseActivity, BaseFragment baseFragment, RefreshRecyclerView refreshRecyclerView) {
        this.baseActivity = baseActivity;
        this.baseFragment = baseFragment;
        this.refreshRecyclerView = refreshRecyclerView;
    }

    @Override
    public void onFirstUserVisible() {
        exCommonAdapter = getExCommonAdapter();
        refreshRecyclerView.getRecyclerView().setOnItemClickListener(this);
        refreshRecyclerView.getRecyclerView().setOnLoadingMoreListener(this);
        refreshRecyclerView.initRecyclerView(new LinearLayoutManager(baseActivity), exCommonAdapter);
        refreshRecyclerView.getSwipeRefreshLayout().setOnRefreshListener(this);
    }

    @Override
    public void onUserVisible() {
    }

    @Override
    public void onUserInvisible() {
    }

    @Override
    public void onRefresh() {
    }

    @Override
    public void onItemClick(ExViewHolder viewHolder) {
    }

    @Override
    public void onLoadingMore() {

    }

    public abstract ExCommonAdapter<Entity> getExCommonAdapter();
}
