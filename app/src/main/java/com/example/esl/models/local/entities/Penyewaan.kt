package com.example.esl.models.local.entities

data class Penyewaan(
    val id_penyewaan: Int,
    val id_users: Int,
    val id_properti: Int,
    val tanggalMulai: String,
    val tanggalAkhir: String,
    val tanggalOrder: String,
    val masaSewa: Int,
    val tanggalMulai_Update: String?,
    val tanggalAkhir_Update: String?,
    val status: String, // Enum: Aktif, Selesai, Dibatalkan
    val alasan_batal: String?
)
