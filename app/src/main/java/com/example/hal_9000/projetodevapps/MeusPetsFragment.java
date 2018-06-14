package com.example.hal_9000.projetodevapps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hal_9000.projetodevapps.Model.Animal;
import com.example.hal_9000.projetodevapps.adapters.MeusPetsAdapter;
import com.example.hal_9000.projetodevapps.services.ConsultaService;

import java.util.List;


public class MeusPetsFragment extends Fragment {
    public ConsultaService service = new ConsultaService();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_meus_pets, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rvMeusPets);
        MeusPetsAdapter adapter = new MeusPetsAdapter(getAnimalsFromService());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return rootView;
    }

    public List<Animal> getAnimalsFromService() {
        return this.service.getMeusPets();
    }
}
