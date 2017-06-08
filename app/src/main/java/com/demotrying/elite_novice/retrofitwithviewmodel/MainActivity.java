package com.demotrying.elite_novice.retrofitwithviewmodel;

import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.demotrying.elite_novice.retrofitwithviewmodel.adapter.MyReportAdapter;
import com.demotrying.elite_novice.retrofitwithviewmodel.model.Fixtures;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends LifecycleActivity {
    MyReportAdapter reportAdapter;
    ListView listview;
    GetData mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=(ListView)findViewById(R.id.listview);
        reportAdapter=new MyReportAdapter(MainActivity.this,R.layout.fixturelayout);
        listview.setAdapter(reportAdapter);
        mViewModel  = ViewModelProviders.of(this).get(GetData.class);
        mViewModel .getUsers().observe(this,this::handleResponse);

    }

    private void handleResponse(List<Fixtures> dataList) {

        for (Fixtures data : dataList) {
            reportAdapter.add(data);
        }

    }

}
