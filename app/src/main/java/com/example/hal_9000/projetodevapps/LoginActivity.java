package com.example.hal_9000.projetodevapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends Fragment{

    private EditText edtEmail2;
    private EditText edtSenha2;
    private Button btnLogar2;
    private FirebaseAuth autenticacao;
    private Usuarios usuarios;


    /*protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.activity_login2, container, false);

        edtEmail2 = (EditText) rootView.findViewById(R.id.edtEmail2);
        edtSenha2 = (EditText) rootView.findViewById(R.id.edtSenha2);
        btnLogar2 = (Button) rootView.findViewById(R.id.btnLogar2);

        btnLogar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtEmail2.getText().toString().equals("") && !edtSenha2.getText().toString().equals("")){

                    usuarios = new Usuarios();
                    usuarios.setEmail(edtEmail2.getText().toString());
                    usuarios.setSenha(edtSenha2.getText().toString());

                    validarLogin();

                } else {
                    Toast.makeText(getActivity(), "Preencha os campos de e-mail e senha", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;

    }

    private void validarLogin(){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuarios.getEmail(), usuarios.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    abrirTelaPrincipal();
                    Toast.makeText(getActivity(), "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "E-mail ou senha inválidos", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void abrirTelaPrincipal(){

        Intent intentAbrirTelaPrincipal = new Intent(getActivity(), MainActivity.class);
        startActivity(intentAbrirTelaPrincipal);
    }

}
