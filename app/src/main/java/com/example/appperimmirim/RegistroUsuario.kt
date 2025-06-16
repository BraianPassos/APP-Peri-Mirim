package com.example.appperimmirim

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class CadastroActivity : AppCompatActivity() {

    private lateinit var edtNome: TextInputEditText
    private lateinit var edtCpf: TextInputEditText
    private lateinit var edtDataNascimento: TextInputEditText
    private lateinit var edtTelefone: TextInputEditText
    private lateinit var edtEmail: TextInputEditText
    private lateinit var edtSenha: TextInputEditText
    private lateinit var edtEndereco: TextInputEditText

    private lateinit var btnFotoDocumento: Button
    private lateinit var btnFotoPerfil: Button
    private lateinit var btnCadastrar: Button

    private var uriFotoDocumento: Uri? = null
    private var uriFotoPerfil: Uri? = null

    companion object {
        const val PICK_IMAGE_DOCUMENTO = 100
        const val PICK_IMAGE_PERFIL = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_cadastro) // Use o nome do seu XML aqui

        inicializarComponentes()

        btnFotoDocumento.setOnClickListener {
            selecionarImagem(PICK_IMAGE_DOCUMENTO)
        }

        btnFotoPerfil.setOnClickListener {
            selecionarImagem(PICK_IMAGE_PERFIL)
        }

        btnCadastrar.setOnClickListener {
            cadastrarUsuario()
        }
    }

    private fun inicializarComponentes() {
        edtNome = findViewById(R.id.edtNome)
        edtCpf = findViewById(R.id.edtCpf)
        edtDataNascimento = findViewById(R.id.edtDataNascimento)
        edtTelefone = findViewById(R.id.edtTelefone)
        edtEmail = findViewById(R.id.edtEmail)
        edtSenha = findViewById(R.id.edtSenha)
        edtEndereco = findViewById(R.id.edtEndereco)

        btnFotoDocumento = findViewById(R.id.btnFotoDocumento)
        btnFotoPerfil = findViewById(R.id.btnFotoPerfil)
        btnCadastrar = findViewById(R.id.btnCadastrar)
    }

    private fun selecionarImagem(codigo: Int) {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), codigo)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && data != null) {
            val imageUri = data.data
            when (requestCode) {
                PICK_IMAGE_DOCUMENTO -> {
                    uriFotoDocumento = imageUri
                    Toast.makeText(this, "Foto do documento selecionada", Toast.LENGTH_SHORT).show()
                }
                PICK_IMAGE_PERFIL -> {
                    uriFotoPerfil = imageUri
                    Toast.makeText(this, "Foto de perfil selecionada", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun cadastrarUsuario() {
        val nome = edtNome.text.toString()
        val cpf = edtCpf.text.toString()
        val dataNascimento = edtDataNascimento.text.toString()
        val telefone = edtTelefone.text.toString()
        val email = edtEmail.text.toString()
        val senha = edtSenha.text.toString()
        val endereco = edtEndereco.text.toString()

        // Validação simples
        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show()
            return
        }

        // Aqui você pode enviar os dados para o Firebase, API, ou salvar localmente
        Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show()

        // Exemplo: finalizar a activity após cadastro
        finish()
    }
}
