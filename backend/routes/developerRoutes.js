const express = require('express');
const developerController = require('../controllers/developerController');

const router = express.Router();

router.get('/', developerController.getDevelopers);

module.exports = router;
