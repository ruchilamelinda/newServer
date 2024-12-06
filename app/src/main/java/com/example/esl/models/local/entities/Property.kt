package com.example.esl.models.local.entities

data class Property(
    val id_properti: Int,
    val nama_properti: String,
    val jenis_properti: String, // Enum: Kendaraan, Rumah
    val deskripsi: String,
    val pemilik: String,
    val hargaSewa: Int,
    val lokasi: String,
    val lang: Double,
    val long: Double,
    val status_properti: Boolean,
    val foto_properti: String?
)
