const express = require('express');
const {Penyewaan} = require('../models');
const {Properti} = require('../models');
const router = express.Router();


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


        // Format data yang akan dikirim
        const formattedRentals = rentals.map((rental) => ({
            status: rental.status,
            tanggalOrder: rental.tanggalOrder,
            nama_properti: rental.Properti?.nama_properti || "Tidak diketahui",
            pemilik: rental.Properti?.pemilik || "Tidak diketahui",
        }));

        res.json(formattedRentals);
    } catch (error) {
        res.status(500).json({ message: 'Server Error', error: error.message });
    }
});
module.exports = router;