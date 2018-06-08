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
import com.example.hal_9000.projetodevapps.Model.Animal;
import com.example.hal_9000.projetodevapps.R;

import java.util.List;

public class MeusPetsAdapter extends RecyclerView.Adapter<MeusPetsAdapter.ViewHolder> {

    private List<Animal> mAnimais;

    // Pass in the contact array into the constructor
    public MeusPetsAdapter(List<Animal> animais) {
        mAnimais = animais;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row

        public android.support.v7.widget.AppCompatTextView categoria;
        public android.support.v7.widget.AppCompatTextView nome;
        public android.support.v7.widget.AppCompatTextView local;
        public android.support.v7.widget.AppCompatTextView interessados;
        public ImageView imagem;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(final View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nome = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.card_pet_nome);
            interessados = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.card_pet_interecados);
            categoria = (android.support.v7.widget.AppCompatTextView) itemView.findViewById(R.id.card_pet_tipo);

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

        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.card_meus_pets, parent, false);

        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get the data model based on position
        Animal animal = mAnimais.get(position);
        String catergoria = new String();

        android.support.v7.widget.AppCompatTextView nome = holder.nome;
        nome.setText(animal.getName());

        android.support.v7.widget.AppCompatTextView interessados = holder.interessados;
        interessados.setText(animal.getQtInteressados() + " INTERESSADOS");

        android.support.v7.widget.AppCompatTextView tipo = holder.categoria;
        tipo.setText(animal.getCategoria());

    }

    @Override
    public int getItemCount() {
        return mAnimais.size();
    }


}
