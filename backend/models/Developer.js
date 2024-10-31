const { DataTypes } = require('sequelize');

module.exports = (sequelize) => {
  return sequelize.define('Developer', {
    github_id: { type: DataTypes.STRING, allowNull: false, unique: true },
    username: { type: DataTypes.STRING, allowNull: false },
    country: { type: DataTypes.STRING },
    talent_rank: { type: DataTypes.FLOAT, defaultValue: 0 },
    domain: { type: DataTypes.STRING },
    confidence: { type: DataTypes.FLOAT, defaultValue: 1 }
  });
};
