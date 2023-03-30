package com.conect.aplicativoconectoficial

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.conect.aplicativoconectoficial.databinding.ActivityTelaCadastroBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class tela_cadastro : AppCompatActivity() {

    private lateinit var googleSignInCliente: GoogleSignInClient
    private lateinit var binding: ActivityTelaCadastroBinding
    private var auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("597480850727-0irt4do3aq2vji291h1prps670fh058h.apps.googleusercontent.com").
        requestEmail().build()

        googleSignInCliente = GoogleSignIn.getClient(this, gso)

        binding.botaoCadastrar.setOnClickListener { view ->
            val email = binding.cadastroEmail.text.toString() // salvando na variavel email e senha o que o usuario insere
            val senha = binding.cadastroSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) { // caso senha e email seja diferente de vazio

                val snackbar = Snackbar.make( view, "Preencha todos os campos corretamente!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()

            } else {
                auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener{ cadastro->
                    if(cadastro.isSuccessful){ // caso o cadastro seja feito com sucesso
                        val snackbar = Snackbar.make(view, "Usuário criado com sucesso!", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.BLUE)
                        snackbar.show()

                        binding.cadastroEmail.setText("")
                        binding.cadastroSenha.setText("")
                    }

                }.addOnFailureListener { exception->
                    val mensagemErro = when(exception){
                        is FirebaseAuthWeakPasswordException -> "Digite uma senha com pelo menos 6 caracteres!"
                        is FirebaseAuthInvalidCredentialsException -> "Digite um email válido!"
                        is FirebaseAuthUserCollisionException -> "Essa conta já foi cadastrada!"
                        is FirebaseNetworkException -> "Sem conexão com a internet!"
                        else -> "Erro ao cadastrar usuário!"
                    }

                    val snackbar = Snackbar.make( view, mensagemErro, Snackbar.LENGTH_SHORT) // comando para monstrar mensagem de ao usuario
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                }
            }
        }

        binding.logoGoogle.setOnClickListener{
            signIn()
            MainActivity()
        }
    }


    private fun signIn(){
        val intent = googleSignInCliente.signInIntent
        abreActivity.launch(intent)
    }


    var abreActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
            result: androidx.activity.result.ActivityResult ->
        if (result.resultCode == AppCompatActivity.RESULT_OK){

            val intent = result.data
            val task = GoogleSignIn.getSignedInAccountFromIntent(intent)

            try {
                val conta = task.getResult(ApiException::class.java)
                loginComGoogle(conta.idToken!!)

            } catch (exception: ApiException){

            }
        }
    }
    private fun loginComGoogle(token: String) {
        val credencial = GoogleAuthProvider.getCredential(token, null)
        auth.signInWithCredential(credencial).addOnCompleteListener(this)
        { task: Task<AuthResult> ->
            if (task.isSuccessful) {
                Toast.makeText(baseContext, "Autenticação efetuada com o Google!", Toast.LENGTH_LONG).show()
                navegarTelaPrincipal()
            } else {
                Toast.makeText(
                    baseContext,
                    "Erro ao tentar autenticar com o Google!",
                    Toast.LENGTH_LONG
                ).show()

            }
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