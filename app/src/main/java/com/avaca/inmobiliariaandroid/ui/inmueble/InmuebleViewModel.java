package com.avaca.inmobiliariaandroid.ui.inmueble;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.avaca.inmobiliariaandroid.modelo.Inmueble;
import com.avaca.inmobiliariaandroid.request.ApiClient;

import java.util.ArrayList;

public class InmuebleViewModel extends ViewModel {

    MutableLiveData<ArrayList<Inmueble>> inmuebles ;
    ApiClient api ;

    public InmuebleViewModel() {
        this.inmuebles = new MutableLiveData<>();
    }

    public MutableLiveData<ArrayList<Inmueble>> getInmuebles() {

        return inmuebles;
    }
    //
    public void setInmuebles(){
        api = ApiClient.getApi();

        inmuebles.setValue(api.obtnerPropiedades());
    }
}