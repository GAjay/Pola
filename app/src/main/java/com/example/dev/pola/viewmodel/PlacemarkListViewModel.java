package com.example.dev.pola.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.view.View;
import com.example.dev.pola.model.PlaceMarkerResponseModel;
import com.example.dev.pola.model.Placemark;
import com.example.dev.pola.network.RestClient;
import com.example.dev.pola.network.RestServices;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;

/**
 * @author Ranosys Technologies
 */
public class PlacemarkListViewModel extends ViewModel {
    private Context context;

    MutableLiveData<ArrayList<Placemark>> placemarkList =
            new MutableLiveData<>();

    public MutableLiveData<Integer> progressBar = new MutableLiveData<>();



    public void fetchPlaceMarkList() {
        progressBar.setValue(View.VISIBLE);
        RestServices restServices = RestClient.create();
        restServices.fetchPlaceMarkers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PlaceMarkerResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PlaceMarkerResponseModel placeMarkerResponseModel) {
                        progressBar.setValue(View.GONE);
                        placemarkList.setValue(placeMarkerResponseModel.getPlacemarks());

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public MutableLiveData<ArrayList<Placemark>> getPlacemarkList() {
        return placemarkList;
    }

    public MutableLiveData<Integer> getProgressBar(){
        return progressBar;
    }
}
