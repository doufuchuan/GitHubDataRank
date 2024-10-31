const talentRankService = require('../services/talentRankService');

exports.updateTalentRank = async (req, res) => {
  try {
    await talentRankService.calculateTalentRanks();
    res.json({ message: 'TalentRanks updated' });
  } catch (error) {
    res.status(500).json({ error: 'Failed to update TalentRanks' });
  }
};
