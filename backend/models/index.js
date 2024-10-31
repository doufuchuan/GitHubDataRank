const { Sequelize } = require('sequelize');
const config = require('../config/config');

const sequelize = new Sequelize(config.development);

const Developer = require('./Developer')(sequelize);
const Project = require('./Project')(sequelize);
const Contribution = require('./Contribution')(sequelize);

// Define relationships
Developer.hasMany(Contribution, { foreignKey: 'developer_id' });
Project.hasMany(Contribution, { foreignKey: 'project_id' });
Contribution.belongsTo(Developer, { foreignKey: 'developer_id' });
Contribution.belongsTo(Project, { foreignKey: 'project_id' });

module.exports = { sequelize, Developer, Project, Contribution };
