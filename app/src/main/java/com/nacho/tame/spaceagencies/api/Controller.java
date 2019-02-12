package com.nacho.tame.spaceagencies.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
    Clase encargade de hacer las peticiones al servidor de la API
    y devolver los resultados al MainActivity para mostrarlos en el RecyclerView.
 */

public class Controller implements Callback<ResponseModel> {

    ServerResponse handler;

    public Controller(ServerResponse handler) {
        this.handler = handler;
    }

    static final String BASE_URL = "https://launchlibrary.net/1.4/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ResponseAPI api = retrofit.create(ResponseAPI.class);

        Call<ResponseModel> call = api.loadAgencies();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
        if(response.isSuccessful()){
            ResponseModel responseModel = response.body();
            handler.onResponse(responseModel);

            Log.d("CONTROLLER", responseModel.getTotal()+"");
        }else{
            Log.d("CONTROLLER", response.errorBody().toString());
        }
    }

    @Override
    public void onFailure(Call<ResponseModel> call, Throwable t) {
        t.printStackTrace();
    }

    public interface ServerResponse {
        void onResponse(ResponseModel response);
    }
}
