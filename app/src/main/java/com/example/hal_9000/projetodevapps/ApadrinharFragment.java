package com.example.hal_9000.projetodevapps;

import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class ApadrinharFragment extends Fragment {

    private ArrayList<Animal> animais;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View rootView = inflater.inflate(R.layout.fragment_adotar, container, false);
        rv = (RecyclerView) rootView.findViewById(R.id.rvAnimais);
        animais = new ArrayList<>();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("animais")
                .whereEqualTo("categoria", "Apadrinhar")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Animal animal = document.toObject(Animal.class);
                                animais.add(animal);
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                            AnimalAdapter adapter = new AnimalAdapter(animais);
                            rv.setAdapter(adapter);
                            rv.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

        return rootView;
    }
}
