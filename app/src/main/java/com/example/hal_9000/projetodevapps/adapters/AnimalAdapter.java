package com.example.hal_9000.projetodevapps.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hal_9000.projetodevapps.Model.Animal;
import com.example.hal_9000.projetodevapps.R;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

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
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nome = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.nome);
            porte = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.porte);
            sexo = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.sexo);
            idade = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.idade);
            localizacao = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.localizaçao);
            imagem = (ImageView) itemView.findViewById(R.id.imagem_pet);
        }
    }

    private List<Animal> mAnimais;

    // Pass in the contact array into the constructor
    public AnimalAdapter(List<Animal> animais) {
        mAnimais = animais;
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
        // Get the data model based on position
        Animal animal = mAnimais.get(position);

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

    }

    @Override
    public int getItemCount() {
        return mAnimais.size();
    }


}
