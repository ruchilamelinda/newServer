package com.example.esl.models.local.entities

data class Ulasan(
    val id_ulasan: Int,
    val id_users: Int,
    val id_penyewaan: Int,
    val ulasan: String,
    val rating: Int,
    val media_ulasan: String?,
    val tanggal_input: String
)
