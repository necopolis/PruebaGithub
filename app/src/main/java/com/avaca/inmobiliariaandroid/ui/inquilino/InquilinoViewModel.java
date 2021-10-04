package com.avaca.inmobiliariaandroid.ui.inquilino;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.avaca.inmobiliariaandroid.modelo.Inmueble;
import com.avaca.inmobiliariaandroid.modelo.Inquilino;
import com.avaca.inmobiliariaandroid.request.ApiClient;

import java.util.ArrayList;

public class InquilinoViewModel extends ViewModel {
    MutableLiveData<ArrayList<Inmueble>> inmueble_inquilinos ;
    ApiClient api ;
    MutableLiveData<String> toasMT;

    public InquilinoViewModel(){
        api=ApiClient.getApi();
    }



    public MutableLiveData<String> getToasMT() {
        if (toasMT==null){
            toasMT= new MutableLiveData<>();
        }
        return toasMT;
    }

    public MutableLiveData<ArrayList<Inmueble>> getInmueble_inquilinos() {
        if (inmueble_inquilinos==null){
            inmueble_inquilinos=new MutableLiveData<>();
        }
        return inmueble_inquilinos;
    }

    public void setInmueble_inquilinos(){
        if (api.obtenerPropiedadesAlquiladas().size()>0){
            ArrayList<Inmueble> aux=api.obtenerPropiedadesAlquiladas();
            inmueble_inquilinos.setValue(aux);
            toasMT.setValue("Propiedades Alquiladas Encontradas");
        }else{
            toasMT.setValue("Sin propiedades Alquiladas");
        }

    }
    //

}