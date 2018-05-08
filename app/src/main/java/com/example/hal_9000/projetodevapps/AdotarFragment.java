package com.example.hal_9000.projetodevapps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hal_9000.projetodevapps.Model.Animal;
import com.example.hal_9000.projetodevapps.adapters.AnimalAdapter;
import com.example.hal_9000.projetodevapps.services.ConsultaService;

import java.util.List;

public class AdotarFragment extends Fragment {

    public ConsultaService service = new ConsultaService();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView rv = (RecyclerView) this.getView().findViewById(R.id.rvAnimais);
        AnimalAdapter adapter = new AnimalAdapter(getAnimalsFromService());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    public List<Animal> getAnimalsFromService() {
        return this.service.getAnimaisParaAdocao();
    }

}
