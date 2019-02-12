package com.nacho.tame.spaceagencies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nacho.tame.spaceagencies.api.Controller;
import com.nacho.tame.spaceagencies.api.ResponseModel;

/*
    El MainActivity implementa la interfaz de ServerResponse
    para manejar la respuesta del servidor.
*/

public class MainActivity extends AppCompatActivity implements Controller.ServerResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Controller controller = new Controller(this);
        controller.start();
    }

    /*
        Método de la interfaz ServerResponse para avisar al MainActivity
        desde el Controller de que hemos recibido respuesta del servidor.
    */

    @Override
    public void onResponse(ResponseModel response) {
        
    }
}
