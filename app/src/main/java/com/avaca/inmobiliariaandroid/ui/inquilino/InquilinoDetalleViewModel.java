package com.avaca.inmobiliariaandroid.ui.inquilino;

import android.os.Bundle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.avaca.inmobiliariaandroid.modelo.Inmueble;
import com.avaca.inmobiliariaandroid.modelo.Inquilino;
import com.avaca.inmobiliariaandroid.request.ApiClient;

public class InquilinoDetalleViewModel extends ViewModel {
    ApiClient api;
    Inmueble inmuebleAux;
    MutableLiveData<Inquilino> inquilinoMT;

    public InquilinoDetalleViewModel(){
        api=ApiClient.getApi();
    }


    public MutableLiveData<Inquilino> getInquilinoMT(){
        if (inquilinoMT==null){
            inquilinoMT= new MutableLiveData<>();
        }
        return inquilinoMT;
    }
    //Actualizo el estado de disponible, el inmuble viaja desde el adapter

    //Se lo asigno a mi mutable
    public void setInquilinoMT(Bundle bundle){
        inmuebleAux=(Inmueble) bundle.getSerializable("inmueble");
        inquilinoMT.setValue(api.obtenerInquilino(inmuebleAux));
    }
}