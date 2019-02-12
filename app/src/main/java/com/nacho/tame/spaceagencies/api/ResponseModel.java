package com.nacho.tame.spaceagencies.api;

import java.util.List;

/*
    Clase para manejar los objetos respuesta desde la API de Internet.
    Lo que nos interesa de esta clase es la lista de agencias
    que se la pasaremos al Adapter del RecyclerView.
*/

public class ResponseModel {
    private List<Agencie> agencies;
    private int total;
    private int count;
    private int offset;

    public ResponseModel() {
    }

    public List<Agencie> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agencie> agencies) {
        this.agencies = agencies;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
