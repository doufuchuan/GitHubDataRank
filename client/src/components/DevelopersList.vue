<template>
    <div>
      <input v-model="searchQuery" placeholder="搜索开发者" />
      <select v-model="selectedNation">
        <option value="">所有国家/地区</option>
        <option value="China">中国</option>
        <!-- 添加其他国家/地区选项 -->
      </select>
      <table>
        <thead>
          <tr>
            <th>开发者姓名</th>
            <th>技术能力评级</th>
            <th>所属国家/地区</th>
            <th>领域</th>
            <th>置信度</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="developer in filteredDevelopers" :key="developer.id">
            <td>{{ developer.name }}</td>
            <td>{{ developer.talent_rank }}</td>
            <td>{{ developer.nation || 'N/A' }}</td>
            <td>{{ developer.field }}</td>
            <td>{{ developer.confidence }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        searchQuery: '',
        selectedNation: '',
        developers: [],
      };
    },
    computed: {
      filteredDevelopers() {
        return this.developers.filter(developer => {
          const nameMatches = developer.name.toLowerCase().includes(this.searchQuery.toLowerCase());
          const nationMatches = this.selectedNation === '' || developer.nation === this.selectedNation;
          return nameMatches && nationMatches;
        });
      },
    },
    async created() {
      const response = await axios.get('/api/developers');
      this.developers = response.data;
    },
  };
  </script>