package com.example.esl.models.local.entities


data class Notifikasi(
    val id_notifikasi: Int,
    val id_users: Int,
    val tanggal_kirim: String,
    val status_notifikasi: String // Enum: unread, read)
)
