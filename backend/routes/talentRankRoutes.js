const express = require('express');
const talentRankController = require('../controllers/talentRankController');

const router = express.Router();

router.post('/update', talentRankController.updateTalentRank);

module.exports = router;
