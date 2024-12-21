// server.js
require('dotenv').config();
const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const sequelize = require('./config/config');
const db = require('./models');

const app = express();
const PORT = process.env.PORT || 3000;

// Middleware
app.use(cors({
  origin: '*', // Pastikan ini diubah jika ingin mengatur domain tertentu
  methods: ['GET', 'POST', 'PUT', 'DELETE'],
  allowedHeaders: ['Content-Type', 'Authorization']
}));

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Import Routes (contoh)
const authRoutes = require('./routes/auth.route');
app.use('/api/auth', authRoutes);


// Sinkronisasi Database
sequelize.sync(false)
  .then(() => {
    console.log('Database tersambung');
    app.listen(PORT, '0.0.0.0', () => {
      console.log(`Server berjalan di port ${PORT}`);
    });
  })
  .catch(err => {
    console.error('Gagal tersambung ke database:', err);
  });