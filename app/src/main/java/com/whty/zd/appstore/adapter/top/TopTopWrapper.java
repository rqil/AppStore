package com.whty.zd.appstore.adapter.top;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.whty.zd.appstore.R;
import com.whty.zd.appstore.bean.TopBean;
import com.whty.zd.appstore.utils.UIUtils;
import com.whty.zd.smartpos.library.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.List;


/**
 * Created by wangwei on 2017/5/25.
 */

public class TopTopWrapper extends HeaderAndFooterWrapper {

    private Context mContext;
    private View headerView;
    private List<TopBean.TopTopBean> topBeanList;

    private GridView gv_title_grid;


    public TopTopWrapper(Context context, RecyclerView.Adapter adapter) {
        super(adapter);
        this.mContext = context;
        headerView = UIUtils.inflate(R.layout.header_top);
        gv_title_grid = (GridView) headerView.findViewById(R.id.gv_title_grid);
        addHeaderView(headerView);
    }

    public void addTopView() {
        addHeaderView(headerView);
    }

    public void deleteTopView() {
        deleteHeaderView(headerView);
    }

    public void addDataAll(List<TopBean.TopTopBean> list) {
        this.topBeanList = list;

        TopSubAdapter adapter = new TopSubAdapter(mContext, topBeanList);
        gv_title_grid.setNumColumns(topBeanList.size());
        gv_title_grid.setAdapter(adapter);
        gv_title_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mListener != null){
                    mListener.onItemClick(position);
                }
            }
        });
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void clearData() {
        if (topBeanList != null)
            topBeanList.clear();
    }
}
