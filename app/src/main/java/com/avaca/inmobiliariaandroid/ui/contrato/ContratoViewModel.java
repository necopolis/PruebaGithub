package com.avaca.inmobiliariaandroid.ui.contrato;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.avaca.inmobiliariaandroid.modelo.Inmueble;
import com.avaca.inmobiliariaandroid.request.ApiClient;

import java.util.ArrayList;

public class ContratoViewModel extends ViewModel {

    MutableLiveData<ArrayList<Inmueble>> inmuebleLista ;
    ApiClient api;
    MutableLiveData<String> toast;
    public ContratoViewModel(){
        api = ApiClient.getApi();
    }

    public MutableLiveData<String> getToast() {
        if (toast==null){
            toast=new MutableLiveData<>();
        }
        return toast;
    }

    public MutableLiveData<ArrayList<Inmueble>> getinmuebleLista() {
        if (inmuebleLista== null){
            inmuebleLista=new MutableLiveData<>();
        }
        return inmuebleLista;
    }


    public void setinmuebleLista(){
        if(api.obtenerPropiedadesAlquiladas().size() == 0){
            toast.setValue("No hay inmuebles");
        }else {
            toast.setValue("Lista de nmuebles");
            inmuebleLista.setValue(api.obtenerPropiedadesAlquiladas());
        }
    }


}