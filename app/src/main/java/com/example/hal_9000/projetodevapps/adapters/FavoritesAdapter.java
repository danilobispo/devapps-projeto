package com.example.hal_9000.projetodevapps.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hal_9000.projetodevapps.DetalheAnimalFragment;
import com.example.hal_9000.projetodevapps.DetalheFavoritoFragment;
import com.example.hal_9000.projetodevapps.FavoritosFragment;
import com.example.hal_9000.projetodevapps.Model.Animal;
import com.example.hal_9000.projetodevapps.R;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

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

            nome = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.card_favoritos_nome);
            porte = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.card_favoritos_porte);
            sexo = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.card_favoritos_sexo);
            idade = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.card_favoritos_idade);
            localizacao = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.card_favoritos_localizaçao);
            imagem = (ImageView) itemView.findViewById(R.id.card_favoritos_imagem_pet);

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
                        Fragment myFragment = new DetalheFavoritoFragment();

                        Bundle arguments = new Bundle();
                        arguments.putSerializable( "animal" , clickedItem);
                        myFragment.setArguments(arguments);
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, myFragment).addToBackStack(null).commit();
                    }
                }
            });

        }
    }

    private List<Animal> mAnimais;

    // Pass in the contact array into the constructor
    public FavoritesAdapter(List<Animal> animais) {
        mAnimais = animais;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.fragment_card_favorito, parent, false);

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
