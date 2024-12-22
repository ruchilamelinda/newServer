const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const { Sequelize } = require('sequelize');
<<<<<<< HEAD
const { Users } = require('../models'); // Jangan pakai '../models/users'
=======

const User = require('../models').Users;
>>>>>>> 1ff3386cbb5f75cb2e77dc6558daa39a7cecd7f9

// Register User
exports.register = async (req, res) => {
    try {
        console.log(req.body);
        const { nama, no_Hp, email, username, password } = req.body;
        if (!nama || !no_Hp || !email || !username || !password) {
            return res.status(400).json({ error: 'All fields are required' });
        }

        // Periksa apakah email atau username sudah ada
<<<<<<< HEAD
        const existingUser = await Users.findOne({
=======
        const existingUser = await User.findOne({
>>>>>>> 1ff3386cbb5f75cb2e77dc6558daa39a7cecd7f9
            where: {
                [Sequelize.Op.or]: [
                    { email: email },
                    { username: username }
                ]
            }
        });

        if (existingUser) {
            return res.status(400).json({ error: 'Email or username already exists' });
        }

        const hashedPassword = await bcrypt.hash(password, 10);

<<<<<<< HEAD
        const newUser = await Users.create({
=======
        const newUser = await User.create({
>>>>>>> 1ff3386cbb5f75cb2e77dc6558daa39a7cecd7f9
            nama,
            no_Hp,
            email,
            username,
            password: hashedPassword,
            foto_profil: null,
        });

        return res.status(201).json({
            success: true,
            message: 'User registered successfully',
            user: newUser
        });
    } catch (error) {
        console.error('Error di endpoint register:', error); 
        return res.status(500).json({ error: 'Internal Server Error', details: error.message });
    }
};


// Login User
exports.login = async (req, res) => {
    try {
<<<<<<< HEAD
        const { email, password } = req.body;
        const user = await Users.findOne({ where: { email } });

        if (!user) return res.status(404).json({ message: 'User not found' });

        const isMatch = await bcrypt.compare(password, user.password);
        if (!isMatch) return res.status(400).json({ message: 'Invalid credentials' });

        const token = jwt.sign({ id: user.id }, process.env.JWT_SECRET, { expiresIn: '1h' });

        res.json({
=======
        const { username, password } = req.body;

        // Log data yang diterima dari frontend
        console.log("Data diterima:", req.body);

        // Validasi input
        if (!username || !password) {
            return res.status(400).json({ message: 'Username dan password harus diisi' });
        }

        // Cari user berdasarkan username
        const user = await User.findOne({ where: { username } });
        if (!user) {
            return res.status(404).json({ message: 'User tidak ditemukan' });
        }

        // Generate token JWT
        const token = jwt.sign({ id: user.id }, process.env.JWT_SECRET, { expiresIn: '1h' });

        // Kirim respons
        res.json({
            message: 'Login berhasil',
>>>>>>> 1ff3386cbb5f75cb2e77dc6558daa39a7cecd7f9
            token,
            user: {
                id: user.id,
                nama: user.nama,
                no_Hp: user.no_Hp,
                email: user.email,
                username: user.username,
<<<<<<< HEAD
                foto_profil: user.foto_profil
            }
        });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};
=======
                foto_profil: user.foto_profil,
            },
        });
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: 'Terjadi kesalahan server', error: error.message });
    }
};

>>>>>>> 1ff3386cbb5f75cb2e77dc6558daa39a7cecd7f9
