package com.nacho.tame.spaceagencies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nacho.tame.spaceagencies.agenciesrecycler.AgenciesAdapter;
import com.nacho.tame.spaceagencies.api.Controller;
import com.nacho.tame.spaceagencies.api.ResponseModel;

/*
    El MainActivity implementa la interfaz de ServerResponse
    para manejar la respuesta del servidor.
*/

public class MainActivity extends AppCompatActivity implements Controller.ServerResponse {

    AgenciesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaro el controlador para recoger la información del servidor.
        Controller controller = new Controller(this);
        controller.start();

        // Declaro el recycler view buscando el ID en el layout.
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Doy valor al adaptador para el recycler view.
        adapter = new AgenciesAdapter(this);

        // Paso el adaptador al recycler
        recyclerView.setAdapter(adapter);

        // Indico al recycler view que quiero un layout linear (por defecto en vertical)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    /*
        Método de la interfaz ServerResponse para avisar al MainActivity
        desde el Controller de que hemos recibido respuesta del servidor.
    */

    @Override
    public void onResponse(ResponseModel response) {
        adapter.setData(response.getAgencies());
    }
}
