const { Developer } = require('../models');

exports.getDevelopers = async (req, res) => {
  try {
    const developers = await Developer.findAll();
    res.json(developers);
  } catch (error) {
    res.status(500).json({ error: 'Failed to retrieve developers' });
  }
};
