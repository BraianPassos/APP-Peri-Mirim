package com.example.appperimmirim

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class TelaUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_usuario)

        val nome = intent.getStringExtra("nome")
        val cpf = intent.getStringExtra("cpf")
        val email = intent.getStringExtra("email")
        val telefone = intent.getStringExtra("telefone")
        val dataNascimento = intent.getStringExtra("dataNascimento")
        val endereco = intent.getStringExtra("endereco")
        val uriFotoPerfil = intent.getStringExtra("uriFotoPerfil")

        val textNome = findViewById<TextView>(R.id.textNome)
        val textCpf = findViewById<TextView>(R.id.textCpf)
        val textEmail = findViewById<TextView>(R.id.textEmail)
        val imageUsuario = findViewById<ImageView>(R.id.imageUsuario)

        textNome.text = nome
        textCpf.text = cpf
        textEmail.text = email

        // Carrega a imagem de perfil se existir
        if (!uriFotoPerfil.isNullOrEmpty()) {
            imageUsuario.setImageURI(Uri.parse(uriFotoPerfil))
        }
    }
}