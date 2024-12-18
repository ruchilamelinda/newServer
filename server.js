// server.js
require('dotenv').config();
const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const sequelize = require('./config/config');

const app = express();
const PORT = process.env.PORT || 3000;

// Middleware
app.use(cors());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// Import Routes (contoh)
const authRoutes = require('./routes/auth.route');
app.use('/api/auth', authRoutes);


// Sinkronisasi Database
sequelize.sync()
  .then(() => {
    console.log('Database tersambung');
    app.listen(PORT, () => {
      console.log(`Server berjalan di port ${PORT}`);
    });
  })
  .catch(err => {
    console.error('Gagal tersambung ke database:', err);
  });