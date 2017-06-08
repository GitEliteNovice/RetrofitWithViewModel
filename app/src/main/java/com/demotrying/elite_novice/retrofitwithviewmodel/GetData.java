package com.demotrying.elite_novice.retrofitwithviewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.demotrying.elite_novice.retrofitwithviewmodel.model.Fixtures;
import com.demotrying.elite_novice.retrofitwithviewmodel.network.RequestInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetData extends ViewModel  {
    private MutableLiveData<List<Fixtures>> fixtures;
    AppController Obj;
    public LiveData<List<Fixtures>> getUsers() {
        if (fixtures == null) {
            fixtures = new MutableLiveData<List<Fixtures>>();
            loadUsers();
        }
        return fixtures;
    }
    private void loadUsers() {
        // do async operation to fetch users
        Obj=AppController.getInstance();
        RequestInterface requestInterface=Obj.getInterface();
        Call<List<Fixtures>> call =requestInterface.fixtures();
call.enqueue(new Callback<List<Fixtures>>() {
    @Override
    public void onResponse(Call<List<Fixtures>> call, Response<List<Fixtures>> response) {
        List<Fixtures> studentData = response.body();
        fixtures.setValue(studentData);
    }

    @Override
    public void onFailure(Call<List<Fixtures>> call, Throwable t) {

    }
});
    }
}
