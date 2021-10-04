package com.avaca.inmobiliariaandroid;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.avaca.inmobiliariaandroid.modelo.Propietario;
import com.avaca.inmobiliariaandroid.request.ApiClient;

import java.io.Serializable;

/**
 *
 * */
public class LoginViewModel extends AndroidViewModel {
    // Atributos
    //Mutables
    private MutableLiveData<String> mensajeNoLogin;
    private Context context;


    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }
    public LiveData<String> getMensajeNoLogin(){
        if(mensajeNoLogin == null){
            mensajeNoLogin = new MutableLiveData<>();
        }
        return mensajeNoLogin;
    }

    public void iniciarSesion(String email, String password){
        ApiClient api = ApiClient.getApi();
        Propietario propietario = api.login(email,password);
        if(propietario != null) {
            mensajeNoLogin.setValue("Bienvenido");
            Intent intent = new Intent(context, MainActivity.class);
            intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }else{
            mensajeNoLogin.setValue("Usuario o contraseña incorrecta!!");
        }
    }
}
