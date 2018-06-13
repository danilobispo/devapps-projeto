package com.example.hal_9000.projetodevapps.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hal_9000.projetodevapps.AdotarFragment;
import com.example.hal_9000.projetodevapps.AjudarFragment;
import com.example.hal_9000.projetodevapps.DetalheAnimalFragment;
import com.example.hal_9000.projetodevapps.Model.Animal;
import com.example.hal_9000.projetodevapps.R;
import com.example.hal_9000.projetodevapps.services.ConsultaService;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import static android.content.ContentValues.TAG;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    CountDownLatch cd = new CountDownLatch(1);
    ConsultaService service = new ConsultaService();

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row

        public android.support.v7.widget.AppCompatTextView nome;
        public android.support.v7.widget.AppCompatTextView porte;
        public android.support.v7.widget.AppCompatTextView sexo;
        public android.support.v7.widget.AppCompatTextView idade;
        public android.support.v7.widget.AppCompatTextView localizacao;
        public ImageView imagem;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(final View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nome = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.nome);
            porte = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.porte);
            sexo = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.sexo);
            idade = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.idade);
            localizacao = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.localizaçao);
            imagem = (ImageView) itemView.findViewById(R.id.imagem_pet);

            try {
                cd.await();
                itemView.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        int pos = getAdapterPosition();
                        // check if item still exists
                        if(pos != RecyclerView.NO_POSITION){

                            Animal clickedItem = mAnimais.get(pos);

                            AppCompatActivity activity = (AppCompatActivity) v.getContext();
                            Fragment myFragment = new DetalheAnimalFragment();

                            Bundle arguments = new Bundle();
                            arguments.putSerializable( "animal" , clickedItem);
                            myFragment.setArguments(arguments);
                            activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, myFragment).addToBackStack(null).commit();
                        }
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    private List<Animal> mAnimais;

    public List<Animal> getmAnimais() {
        return mAnimais;
    }

    public void setmAnimais(List<Animal> mAnimais) {
        this.mAnimais = mAnimais;
    }


    /*TODO  Aqui na hora de criar  o adapter a gente passa a colection do firebase q a gente quer pegar*/
    // Pass in the contact array into the constructor
    public AnimalAdapter(String tipo) {

        /*TODO aqui cria o listener pra pegar os dados e submete para o firebase, no caso eu criei um metodo no
        * service q faz isso, mas rola de criar o firebase aqui*/
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //get all animals
                Map<String, Animal> td = (HashMap<String,Animal>) dataSnapshot.getValue();
                //set animals
                setmAnimais(new ArrayList<Animal>(td.values()));

                /*TODO esse cd e um CountDownLatch. basicamente tem o await e o countDonw, o countDown libera
                * os outros awaits do codigo*/
                cd.countDown();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(WorkSourceUtil.TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        /*chama o banco*/
        service.callFirebase(postListener);

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.fragment_card_animal, parent, false);

        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            this.cd.await();
            // Get the data model based on position
            Animal animal = mAnimais.get(position);

            Log.d("animal", animal.getName());
            // Set item views based on your views and data model
            android.support.v7.widget.AppCompatTextView nome = holder.nome;
            nome.setText(animal.getName());

            android.support.v7.widget.AppCompatTextView porte = holder.porte;
            porte.setText(animal.getPorte());

            android.support.v7.widget.AppCompatTextView sexo = holder.sexo;
            sexo.setText(animal.getSexo());

            android.support.v7.widget.AppCompatTextView idade = holder.idade;
            idade.setText(Integer.toString(animal.getIdade()));

            android.support.v7.widget.AppCompatTextView localizacao = holder.localizacao;
            localizacao.setText(animal.getLocalizacao());

            ImageView imagem = holder.imagem;
            imagem.setImageURI(animal.getImagem_uri());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        try {
            cd.await();
            return mAnimais.size();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
    }


}
