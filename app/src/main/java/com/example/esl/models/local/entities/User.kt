package com.example.esl.models.local.entities

data class User(
    val id_users: Int,
    val nama: String,
    val no_Hp: String,
    val email: String,
    val username: String,
    val password: String,
    val foto_profil: String?,
    val created_at: String,
    val update_at: String?
)
