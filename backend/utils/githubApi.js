const axios = require('axios');

exports.fetchDeveloperData = async (username) => {
  try {
    const response = await axios.get(`https://api.github.com/users/${username}`);
    return response.data;
  } catch (error) {
    throw new Error('Failed to fetch data from GitHub');
  }
};
