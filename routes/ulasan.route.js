// routes/ulasan.js
const express = require('express');
const router = express.Router();
const multer = require('multer');
const path = require('path');
const { Ulasan } = require('../models');

// Setup multer for file upload
const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, 'uploads/reviews/');
  },
  filename: (req, file, cb) => {
    cb(null, `${Date.now()}_${file.originalname}`);
  }
});
const upload = multer({ storage });

// Create Ulasan
router.post('/', upload.single('media_ulasan'), async (req, res) => {
  try {
    const { id_users, id_penyewaan, ulasan, rating } = req.body;
    const media_ulasan = req.file ? req.file.path : null;
    
    const review = await Ulasan.create({
      id_users,
      id_penyewaan,
      ulasan,
      rating,
      media_ulasan
    });
    res.status(201).json({ message: 'Ulasan berhasil ditambahkan', data: review });
  } catch (error) {
    res.status(400).json({ message: 'Gagal menambahkan ulasan', error: error.message });
  }
});

// Get Ulasan by Penyewaan
router.get('/penyewaan/:id_penyewaan', async (req, res) => {
  try {
    const reviews = await Ulasan.findAll({
      where: { id_penyewaan: req.params.id_penyewaan }
    });
    res.json(reviews);
  } catch (error) {
    res.status(500).json({ message: 'Gagal mendapatkan ulasan', error: error.message });
  }
});

router.put('/:id', upload.single('media_ulasan'), async (req, res) => {
    try {
        const { id } = req.params;
        const { ulasan, rating } = req.body;
        const media_ulasan = req.file ? `/uploads/${req.file.filename}` : undefined;

        const updatedFields = { ulasan, rating };
        if (media_ulasan) updatedFields.media_ulasan = media_ulasan;

        const updatedUlasan = await Ulasan.update(updatedFields, {
            where: { id_ulasan: id },
        });

        res.status(200).json({ message: 'Ulasan updated successfully.' });
    } catch (error) {
        console.error(error);
        res.status(500).json({ error: 'Failed to update ulasan.' });
    }
});

module.exports = router;
