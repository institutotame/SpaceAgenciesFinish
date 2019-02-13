package com.nacho.tame.spaceagencies.agenciesrecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nacho.tame.spaceagencies.R;
import com.nacho.tame.spaceagencies.api.Agencie;

import java.util.ArrayList;
import java.util.List;

public class AgenciesAdapter extends RecyclerView.Adapter<AgenciesAdapter.AgenciesViewHolder> {

    // Lista con los datos a mostrar.
    private List<Agencie> agenciesList = new ArrayList<>();

    // LayoutInflater encargado de "inflar" las vistas dentro del onCreateViewHolder.
    private LayoutInflater layoutInflater;

    // Constructor del adaptador dónde le pasamos un contexto
    // para dar valor a nuestro layoutInflater

    public AgenciesAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
    }

    // Clase obligatoria dentro del adapter
    // para generar ViewHolder para el método "onCreateViewHolder"

    class AgenciesViewHolder extends RecyclerView.ViewHolder {

        public final TextView txtName;
        public final TextView txtAbbrev;
        public final TextView txtCountryCode;

        public AgenciesViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAbbrev = itemView.findViewById(R.id.txtAbbrev);
            txtCountryCode = itemView.findViewById(R.id.txtCountryCode);
        }
    }

    // Método obligatorio para crear las distintas vistas para los item de la lista.

    @NonNull
    @Override
    public AgenciesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = layoutInflater.inflate(R.layout.agencie_item, viewGroup, false);
        return new AgenciesViewHolder(itemView);
    }

    // Método obligatorio para dar valor a los widgets (TextViews, ImageViews...) de cada item.

    @Override
    public void onBindViewHolder(@NonNull AgenciesViewHolder vh, int position) {
        Agencie agencie = agenciesList.get(position);

        vh.txtName.setText(agencie.getName());
        vh.txtAbbrev.setText(agencie.getAbbrev());
        vh.txtCountryCode.setText(agencie.getCountryCode());
    }

    // Método obligatorio para saber el tamaño de la lista.

    @Override
    public int getItemCount() {
        return agenciesList.size();
    }

    // Metodo para avisar al adaptador de que hemos actualizado la lista desde el servidor.
    public void setData(List<Agencie> newList){
        agenciesList = newList;
        notifyDataSetChanged();
    }
}
