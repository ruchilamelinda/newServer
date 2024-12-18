'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class Users extends Model {
    
    static associate(models) {
    Users.hasMany(models.Penyewaan, { foreignKey: 'id_users' });
    Users.hasMany(models.Favorit, { foreignKey: 'id_users' });
    Users.hasMany(models.LaporanMasalah, { foreignKey: 'id_users' });
    Users.hasMany(models.Notifikasi, { foreignKey: 'id_users' });
    Users.hasMany(models.Ulasan, { foreignKey: 'id_users' });
    }
  }
  Users.init({
    id_users: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    nama: DataTypes.STRING,
    no_Hp: DataTypes.STRING,
    email: DataTypes.STRING,
    username: DataTypes.STRING,
    password: DataTypes.STRING,
    foto_profil: DataTypes.STRING,
  }, {
    sequelize,
    modelName: 'Users',
    timestamps: true,
  });
  return Users;
};