const express = require('express');
const Penyewaan = require('../models/penyewaan');
const Properti = require('../models/properti');
const router = express.Router();

// GET rentals with status "Selesai"
router.get('/', async (req, res) => {
    try {console.log("testingOi")
    
        const rentals = await Penyewaan.find({ status: "Selesai" }).populate({
            path: 'propertiId', 
            select: 'nama_properti pemilik', 
        });

        // Format data yang akan dikirim
        const formattedRentals = rentals.map((rental) => ({
            status: rental.status,
            tanggalOrder: rental.tanggalOrder,
            nama_properti: rental.propertiId?.nama_properti || "Tidak diketahui",
            pemilik: rental.propertiId?.pemilik || "Tidak diketahui",
        }));

        res.json(formattedRentals);
    } catch (error) {
        res.status(500).json({ message: 'Server Error', error: error.message });
    }
});

module.exports = router;
