package com.avaca.inmobiliariaandroid.ui.perfil;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.avaca.inmobiliariaandroid.modelo.Propietario;
import com.avaca.inmobiliariaandroid.request.ApiClient;

public class PerfilViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private ApiClient api;
    private Propietario paux;
    private MutableLiveData<Boolean> CamposMT;
    private MutableLiveData<Propietario> propietarioMT;
    private MutableLiveData<Boolean> BTNEditarMT;
    private MutableLiveData<Boolean> BTNGuardarMT;
    private MutableLiveData<String> toastMT;

    public PerfilViewModel(){
        this.api=ApiClient.getApi();
        //propietarioMT.setValue(api.obtenerUsuarioActual());

    }
    public MutableLiveData<Boolean> getCamposMT(){
        if (CamposMT==null){
            CamposMT=new MutableLiveData<>();
        }
        return CamposMT;
    }

    public LiveData<Propietario> getPropietario(){
        if (propietarioMT==null){
            propietarioMT= new MutableLiveData<>();
        }
        return propietarioMT;
    }

    public MutableLiveData<Boolean> getBTNEditarMT(){
        if (BTNEditarMT==null){
            BTNEditarMT= new MutableLiveData<>();
        }
        return BTNEditarMT;
    }
    public MutableLiveData<String> gettoastMT(){
        if (toastMT==null){
            toastMT= new MutableLiveData<>();
        }
        return toastMT;
    }
    public MutableLiveData<Boolean> getBTNGuardarMT(){
        if (BTNGuardarMT==null){
            BTNGuardarMT= new MutableLiveData<>();
        }
        return BTNGuardarMT;
    }

    public void editarDatos(){
        this.CamposMT.setValue(true);
        this.BTNGuardarMT.setValue(true);
        this.BTNEditarMT.setValue(false);
    }

    public void GuardarDatos(Propietario p){
        this.api.actualizarPerfil(p);
        propietarioMT.setValue(p);
        this.BTNGuardarMT.setValue(false);
        this.BTNEditarMT.setValue(true);
        this.CamposMT.setValue(false);
        this.toastMT.setValue("Datos guardados correctamente");

    }
    public void bloquearCampor(){
        this.CamposMT.setValue(false);
    }
    //
    public void ActualizarPantalla(){
        propietarioMT.setValue(api.obtenerUsuarioActual());
        this.CamposMT.setValue(false);
    }
    public void PropietarioActual(){
        propietarioMT.setValue(api.obtenerUsuarioActual());
    }

}