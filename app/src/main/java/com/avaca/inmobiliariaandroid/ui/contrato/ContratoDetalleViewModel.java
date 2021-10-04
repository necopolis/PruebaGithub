package com.avaca.inmobiliariaandroid.ui.contrato;

import android.os.Bundle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.avaca.inmobiliariaandroid.modelo.Contrato;
import com.avaca.inmobiliariaandroid.modelo.Inmueble;
import com.avaca.inmobiliariaandroid.request.ApiClient;

public class ContratoDetalleViewModel extends ViewModel {
    ApiClient api;
    Inmueble inmuebleAux;
    MutableLiveData<Contrato> contratoMT;

    public ContratoDetalleViewModel(){
        api=ApiClient.getApi();
    }

    public MutableLiveData<Contrato> getcontratoMT(){
        if (contratoMT==null){
            contratoMT= new MutableLiveData<>();
        }
        return contratoMT;
    }

    //Se lo asigno a mi mutable
    public void setcontratoMT(Bundle bundle){
        inmuebleAux=(Inmueble) bundle.getSerializable("inmueble");
        contratoMT.setValue(api.obtenerContratoVigente(inmuebleAux));
    }
}