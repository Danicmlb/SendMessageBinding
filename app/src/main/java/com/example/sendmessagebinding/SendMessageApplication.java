package com.example.sendmessagebinding;

import android.app.Application;

import com.example.sendmessagebinding.data.User;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class SendMessageApplication extends Application {
    //Usuario que ha iniciado sesion. DATO GLOBAL: porque siempre se va a acceder a el
    //mediante el metodo getApplication().getUser()

    private User user;

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("Se ha inicializado el objeto Application");
        user = new User("Daniel CM","al.daniel.camacho.montes@gmail.com");
    }

    public User getUser(){
        return user;
    }
}
