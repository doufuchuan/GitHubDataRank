const { Developer, Project, Contribution } = require('../models');

exports.calculateTalentRanks = async () => {
  const developers = await Developer.findAll();
  const projects = await Project.findAll();

  // 示例算法：根据项目星标和贡献度计算 TalentRank
  for (const developer of developers) {
    let rank = 0;
    const contributions = await Contribution.findAll({ where: { developer_id: developer.id } });
    
    contributions.forEach(contribution => {
      const project = projects.find(p => p.id === contribution.project_id);
      rank += contribution.commits * project.stars;
    });

    await Developer.update({ talent_rank: rank }, { where: { id: developer.id } });
  }
};
