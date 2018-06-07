package com.example.hal_9000.projetodevapps

import android.os.AsyncTask
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.view.inputmethod.EditorInfo
import android.widget.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*

class LoginCadastro : Fragment(){

    private var mAuth:FirebaseAuth?=null

   override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
       val rootView = inflater!!.inflate(R.layout.activity_login, container, false)
       mAuth = FirebaseAuth.getInstance();
       rootView.btnLogar.setOnClickListener({
           loginToFireBase(edtEmail.text.toString(), edtSenha.text.toString())
       })
       return rootView
   }

    fun loginToFireBase(email:String,password:String){

        mAuth!!.createUserWithEmailAndPassword(email,password)
              .addOnCompleteListener(activity, { task ->
                  if (task.isSuccessful){
                      abrirTelaPrincipal()
                      Toast.makeText(context,"Cadastro efetuado com sucesso",Toast.LENGTH_LONG).show()
                  }else
                  {
                      Toast.makeText(context,"Cadastro falhou",Toast.LENGTH_LONG).show()
                  }

              })

    }

    fun abrirTelaPrincipal() {

        val intentAbrirTelaPrincipal = Intent(activity, MainActivity::class.java)
        startActivity(intentAbrirTelaPrincipal)
    }

}