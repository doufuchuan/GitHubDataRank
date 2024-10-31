const { DataTypes } = require('sequelize');

module.exports = (sequelize) => {
  return sequelize.define('Contribution', {
    commits: { type: DataTypes.INTEGER, defaultValue: 0 }
  });
};
