package com.example.hal_9000.projetodevapps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hal_9000.projetodevapps.Model.Animal;
import com.example.hal_9000.projetodevapps.adapters.AnimalAdapter;
import com.example.hal_9000.projetodevapps.services.ConsultaService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import static com.google.android.gms.common.util.WorkSourceUtil.TAG;

public class AdotarFragment extends Fragment {

    public ConsultaService service = new ConsultaService();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_adotar, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rvAnimais);
        /*TODO aqui passa a colection que vai precisar pegar. por hora so sei pegar animais, mais da pra depois pegar
        * animais para adoçao por exemplo*/
        AnimalAdapter adapter = new AnimalAdapter("animais");
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return rootView;
    }
}
