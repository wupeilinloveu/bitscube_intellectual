package cn.com.bitscube_intellectual.ui.activity;

import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.BaseActivity;
import cn.com.bitscube_intellectual.common.util.GsonUtil;
import cn.com.bitscube_intellectual.common.util.Utils;
import cn.com.bitscube_intellectual.model.bean.Search;
import cn.com.bitscube_intellectual.ui.adapter.SearchProjectsRvAdapter;
import cn.com.bitscube_intellectual.ui.adapter.SearchTalentsRvAdapter;

/**
 * 搜索页
 * Created by Emily on 9/9/21
 */
public class SearchActivity extends BaseActivity {
    private EditText mEtSearch;
    private ToggleButton mToggleClear;
    private LinearLayout mLlSearch;
    private RelativeLayout mRlSearchCancel;
    private Toolbar mToolbar;
    private TextView mTvSearchTalents;
    private LinearLayout mLlSearchTalentsNoHistory;
    private RecyclerView mRvSearchTalents;
    private Button mBtnSearchTalentsMore;
    private TextView mTvSearchProjects;
    private LinearLayout mLlSearchProjectsNoHistory;
    private RecyclerView mRvSearchProjects;
    private Button mBtnSearchProjectsMore;
    private LinearLayout mLlSearchResult;
    private String etSearch;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        mEtSearch = findViewById(R.id.et_search);
        mToggleClear = findViewById(R.id.toggleClear);
        mLlSearch = findViewById(R.id.ll_search);
        mRlSearchCancel = findViewById(R.id.rl_search_cancel);
        mToolbar = findViewById(R.id.toolbar);
        mTvSearchTalents = findViewById(R.id.tv_search_talents);
        mLlSearchTalentsNoHistory = findViewById(R.id.ll_search_talents_no_history);
        mRvSearchTalents = findViewById(R.id.rv_search_talents);
        mBtnSearchTalentsMore = findViewById(R.id.btn_search_talents_more);
        mTvSearchProjects = findViewById(R.id.tv_search_projects);
        mLlSearchProjectsNoHistory = findViewById(R.id.ll_search_projects_no_history);
        mRvSearchProjects = findViewById(R.id.rv_search_projects);
        mBtnSearchProjectsMore = findViewById(R.id.btn_search_projects_more);
        mLlSearchResult = findViewById(R.id.ll_search_result);

        mRvSearchTalents.setLayoutManager(new LinearLayoutManager(this));
        mRvSearchProjects.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initListener() {
        mRlSearchCancel.setOnClickListener(v -> finish());
        mEtSearch.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                etSearch = mEtSearch.getText().toString().trim();
                if (TextUtils.isEmpty(etSearch)) {
                    Utils.showToast(this,getString(R.string.search_empty));
                } else {
                    if(mEtSearch.getText().length()>0){
                        getData();
                    }
                }
                return true;
            }
            return false;
        });
    }

    public void getData(){
        mTvSearchTalents.setVisibility(View.VISIBLE);
        mTvSearchProjects.setVisibility(View.VISIBLE);
        Search search = GsonUtil.GsonToBean(readLocalJson(this, "Search.json"), Search.class);
        //搜索人才
        SearchTalentsRvAdapter searchTalentsRvAdapter = new SearchTalentsRvAdapter(this, search.getData().getTalents().getList());
        mRvSearchTalents.setAdapter(searchTalentsRvAdapter);
        //搜索项目
        SearchProjectsRvAdapter searchProjectsRvAdapter = new SearchProjectsRvAdapter(this, search.getData().getProjects().getList());
        mRvSearchProjects.setAdapter(searchProjectsRvAdapter);
    }

    @Override
    public void initData() {
    }

    @Override
    public void onClick(View v, int id) {
    }

    @Override
    public void onHttpSuccess(int reqType, Message msg) {
    }

    @Override
    public void onHttpError(int reqType, int code, ArrayList<String> error) {
    }

    @Override
    public void onHttpFailure(int reqType) {
    }

    @Override
    public void onServerError(int reqType) {
    }
}
