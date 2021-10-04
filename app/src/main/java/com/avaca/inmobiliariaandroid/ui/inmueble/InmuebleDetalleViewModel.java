package com.avaca.inmobiliariaandroid.ui.inmueble;

import android.os.Bundle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.avaca.inmobiliariaandroid.modelo.Inmueble;
import com.avaca.inmobiliariaandroid.request.ApiClient;

public class InmuebleDetalleViewModel extends ViewModel {
    ApiClient api;
    Inmueble inmuebleAux;
    MutableLiveData<Inmueble> inmuebleMT;

    public InmuebleDetalleViewModel(){
        api=ApiClient.getApi();
    }

    public MutableLiveData<Inmueble> getInmuebleMT(){
        if (inmuebleMT==null){
            inmuebleMT= new MutableLiveData<>();
        }
        return inmuebleMT;
    }
    //Actualizo el estado de disponible, el inmuble viaja desde el adapter
    public void actualizarEstado(boolean disponible){
        inmuebleAux.setEstado(disponible);
        api.actualizarInmueble(inmuebleAux);
        inmuebleMT.setValue(inmuebleAux);
    }

    //Se lo asigno a mi mutable
    public void setInmuebleMT(Bundle bundle){
        inmuebleAux=(Inmueble) bundle.getSerializable("inmueble");
        inmuebleMT.setValue(inmuebleAux);
    }

}