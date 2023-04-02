package com.conect.aplicativoconectoficial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.conect.aplicativoconectoficial.databinding.ActivityTelaBemVindo2Binding
import com.google.firebase.auth.FirebaseAuth

class tela_bem_vindo2 : AppCompatActivity() {

    private lateinit var binding: ActivityTelaBemVindo2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaBemVindo2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.setaClique.setOnClickListener {
            val navegarTerceiraTela = Intent(this, tela_bem_vindo3::class.java)
            startActivity(navegarTerceiraTela)
        }
    }

    private fun navegarTelaPrincipal() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        val usuario_total = FirebaseAuth.getInstance().currentUser // usuario atual que esta logado no sistema

        if(usuario_total != null){
            navegarTelaPrincipal()
        }
    }
}