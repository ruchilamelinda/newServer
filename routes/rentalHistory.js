const express = require('express');
const {Penyewaan} = require('../models');
const {Properti} = require('../models');
const router = express.Router();

router.get('/', async (req, res) => {
    try {console.log("tes oi");
        // Query to get all rentals with status 'Selesai'
        const rentals = await Penyewaan.findAll({
            where: { 
                status: "Selesai" }, // Sequelize syntax for where clause
            include: [{
                model: Properti, // Join with the Properti model
                attributes: ['nama_properti', 'pemilik'] // Select specific fields
            }]
        });

//format yg dikirim
        const formattedRentals = rentals.map((rental) => ({
            id_penyewaan: rental.id, 
            status: rental.status,
            tanggalOrder: rental.tanggalOrder,
            nama_properti: rental.Properti?.nama_properti || "Tidak diketahui",
            pemilik: rental.Properti?.pemilik || "Tidak diketahui",
        }));
        
        console.log("Found rentals:", rentals.length);
        console.log("Rental data:", JSON.stringify(rentals, null, 2));
        res.json(formattedRentals);
    } catch (error) {
        res.status(500).json({ message: 'Server Error', error: error.message });
    }
});
module.exports = router;