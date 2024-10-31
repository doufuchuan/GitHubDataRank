const express = require('express');
const { sequelize } = require('./models');
const developerRoutes = require('./routes/developerRoutes');
const talentRankRoutes = require('./routes/talentRankRoutes');

const app = express();
app.use(express.json());

// Routes
app.use('/developers', developerRoutes);
app.use('/talentRank', talentRankRoutes);

// Database connection and server start
sequelize.sync().then(() => {
  console.log('Database connected');
  app.listen(3000, () => {
    console.log('Server is running on http://localhost:3000');
  });
}).catch((error) => {
  console.error('Unable to connect to the database:', error);
});

