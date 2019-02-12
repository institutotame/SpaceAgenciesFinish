package com.nacho.tame.spaceagencies.api;

import retrofit2.Call;
import retrofit2.http.GET;

/*
    Clase para manejar las distintas llamadas a la API de LaunchLibrary.net.
    Solo necesitamos un método porque solo usaremos una función de la API.
 */

public interface ResponseAPI {
    @GET("agency")
    Call<ResponseModel> loadAgencies();


}
