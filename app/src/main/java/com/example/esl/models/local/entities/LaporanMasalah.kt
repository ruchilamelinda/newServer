package com.example.esl.models.local.entities

data class LaporanMasalah(
    val id_laporan: Int,
    val id_users: Int,
    val id_penyewaan: Int,
    val masalah: String,
    val media: String?,
    val tanggal_laporan: String
)

