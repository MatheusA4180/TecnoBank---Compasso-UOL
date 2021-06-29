package com.example.tecnobank.intro.model

class Cliente {
    private var nome: String? = null
    private var senha: String? = null

    fun getNome(): String? {
        return nome
    }

    fun setNome(nome: String?) {
        this.nome = nome
    }

    fun getsenha(): String? {
        return senha
    }

    fun setsenha(email: String?) {
        this.senha = email
    }


}

