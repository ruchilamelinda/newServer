const jwt = require('jsonwebtoken');

function authenticateToken(req, res, next) {
    const authHeader = req.headers['authorization'];
    const token = authHeader && authHeader.split(' ')[1]; // Ambil token dari header

    if (!token) {
        return res.status(401).json({ message: 'Token tidak ditemukan, akses ditolak!' });
    }

    // Verifikasi token
    jwt.verify(token, process.env.JWT_SECRET, (err, user) => {
        if (err) {
            return res.status(403).json({ message: 'Token tidak valid!' });
        }
        req.user = user; // Simpan payload token (ID user) ke request
        next();
    });
}

module.exports = authenticateToken;
