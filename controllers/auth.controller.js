const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const { Users } = require('../models/users');

// Register User
exports.register = async (req, res) => {
    try {
        console.log(req.body);
        const { nama, no_Hp, email, username, password, foto_profil } = req.body;
        if (!nama || !no_Hp || !email || !username || !password) {
            return res.status(400).json({ error: 'All fields are required' });
        }
        const hashedPassword = await bcrypt.hash(password, 10);

        const newUser = await Users.create({
            nama,
            no_Hp,
            email,
            username,
            password: hashedPassword,
            foto_profil,
        });

        res.status(201).json({ message: 'User registered successfully', user: newUser });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};

// Login User
exports.login = async (req, res) => {
    try {
        const { email, password } = req.body;
        const user = await Users.findOne({ where: { email } });

        if (!user) return res.status(404).json({ message: 'User not found' });

        const isMatch = await bcrypt.compare(password, user.password);
        if (!isMatch) return res.status(400).json({ message: 'Invalid credentials' });

        const token = jwt.sign({ id: user.id }, process.env.JWT_SECRET, { expiresIn: '1h' });

        res.json({
            token,
            user: {
                id: user.id,
                nama: user.nama,
                no_Hp: user.no_Hp,
                email: user.email,
                username: user.username,
                foto_profil: user.foto_profil
            }
        });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};