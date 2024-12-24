// routes/penyewaan.js
const express = require('express');
const router = express.Router();
const moment = require('moment');
const { Penyewaan, Users, Properti } = require('../models');

// Create Penyewaan
router.post('/', async (req, res) => {
  try {
    const { id_users, id_properti, tanggalMulai, tanggalAkhir, status } = req.body;
    const startDate = moment(tanggalMulai);
    const endDate = moment(tanggalAkhir);
    const masaSewa = endDate.diff(startDate, 'days'); // Hitung selisih hari

    if (!id_users || !id_properti || !tanggalMulai || !tanggalAkhir) {
      console.warn('⚠️ Validasi gagal: Semua field harus diisi');
      return res.status(400).json({ message: 'Semua field harus diisi' });
    }
    const penyewaan = await Penyewaan.create({
        id_users,
        id_properti,
        tanggalMulai: startDate.format('YYYY-MM-DD HH:mm'),
        tanggalAkhir: endDate.format('YYYY-MM-DD HH:mm'),
        tanggalOrder: moment().format('YYYY-MM-DD HH:mm'),
        masaSewa, // Simpan masa sewa sebagai angka (jumlah hari)
        status
    });
    res.status(201).json({ 
      success: true,
      message: 'Penyewaan berhasil dibuat', data: penyewaan });
  } catch (error) {
    res.status(400).json({ message: 'Gagal membuat penyewaan', error: error.message });
  }
});

// Get Penyewaan By User
router.get('/user/:id_users', async (req, res) => {
  try {
    const penyewaan = await Penyewaan.findAll({
      where: { id_users: req.params.id_users },
      include: [{
        model: Users,
        attributes: ['id_users', 'nama', 'no_Hp', 'email', 'username']
    },
    {
        model: Properti,
        attributes: ['id_properti', 'nama_properti', 'jenis_properti', 'hargaSewa', 'lokasi']
    }]
    });
    res.json(penyewaan);
  } catch (error) {
    res.status(500).json({ message: 'Gagal mendapatkan penyewaan', error: error.message });
  }
});

// Update Status Penyewaan
router.put('/:id_penyewaan/status', async (req, res) => {
  try {
    const { status, alasan_batal } = req.body;
    await Penyewaan.update(
      { status, alasan_batal },
      { where: { id_penyewaan: req.params.id_penyewaan } }
    );
    res.json({ message: 'Status penyewaan berhasil diperbarui' });
  } catch (error) {
    res.status(400).json({ message: 'Gagal memperbarui status', error: error.message });
  }
});

module.exports = router;
