<template>
  
  
        <div class="title">GithubRank</div>
        <div class="search-container">
                <input v-model="value" class = 'search-input' type="text" placeholder="按名字搜索用户"/><!--输入框-->
                <div @click="change" class="search-button">搜索</div>
                <select class="country-select">
                    <option value="">国家</option>
                    <option value="中国">中国</option>
                    <option value="美国">美国</option>
                    <!-- 添加更多国家选项 -->
                </select>
        </div>
        
            <div v-for="user in filteredList" :key="user.id" class="user-card">
                <img :src="`https://avatars.githubusercontent.com/u/${user.github_id}?v=4`" alt="用户头像" href="'https://github.com/'+user.username">
                
                <a :href="`https://github.com/${user.username}`">
                  <p>{{user.username}}</p>
                </a>
                <div class="info-cards">
      <div class="info-card">
        <p>国家</p>
        <p>{{ user.nation }}</p>
      </div>
      <div class="info-card">
        <p>贡献值</p>
        <p>{{ user.contributions }}</p>
      </div>
      <div class="info-card">
        <p>关注者</p>
        <p>{{ user.followers }}</p>
      </div>
      <div class="info-card">
        <p>仓库</p>
        <p>{{ user.repos }}</p>
      </div>
      <div class="info-card">
        <p>星标</p>
        <p>{{ user.stars }}</p>
      </div>
      <div class="info-card">
        <p>问题</p>
        <p>{{ user.issues }}</p>
      </div>
      <div class="info-card">
        <p>技术水平</p>
        <p>{{ user.talent_rank }}</p>
      </div>
    </div>
              </div>
        
   
    
    <!-- <div id="userContainer"></div> -->
    
  
</template>

<script setup>
import { ref, computed } from 'vue';
import axios from 'axios';
const value =ref('');

fetchUsers();

var list = ref([
    { 
        "id": 1,
        "github_id": 0,
        "username": "dou",
        "nation": "china",
        "repos": 4,
        "followers": 0,
        "contributions": 1,
        "stars": 4,
        "issues": 3,
        "talent_rank": 0
    },
    {
        "id": 1,
        "github_id": 0,
        "username": "dou",
        "nation": "china",
        "repos": 4,
        "followers": 0,
        "contributions": 1,
        "stars": 4,
        "issues": 3,
        "talent_rank": 0
    },
    {
        "id": 1,
        "github_id": 0,
        "username": "dou",
        "nation": "china",
        "repos": 4,
        "followers": 0,
        "contributions": 1,
        "stars": 4,
        "issues": 3,
        "talent_rank": 0
    },
]);
//获取用户信息
async function fetchUsers() {
  try {
    console.log('获取用户信息');
    const response = await axios.get('http://localhost:8088/developer/find');
    list.value = response.data.map(user => ({
      ...user,
      talent_rank: calculateTalentRank(user)
    }));
    // Sort users by talent rank in descending order
    list.value.sort((a, b) => b.talent_rank - a.talent_rank);
    console.log(list.value);
  } catch (err) {
    err.value = '请求失败，请稍后再试。';
  } 
}



const filteredList = computed(() => {
  if (value.value === '') {
    
    console.log('获取用户信息');
    return list.value;
  }
  var res = list.value.filter(item =>
    item?.username?.toLowerCase().includes(value.value.toLowerCase()) ||
    item?.nation?.toLowerCase().includes(value.value.toLowerCase())
  );
  if(res.length === 0) return list.value;
  return res;
});
// 搜索方法
const change = () => {
  console.log('搜索:', value.value);
};

async function getData(){
  const response = await axios({
    url:"localhost:8088/developer/find",
    method:"get"
});
  list.value = response.data;
}

</script>

<style scoped>
        template {
            background: linear-gradient(to right, white, gray);
        }
        .gitrank{
            width: 98%;
            height: 500px;
            padding-top: 30px;
            box-sizing: border-box;
            background-color: white;
            border-radius: 5px;
            margin-top: 30px;
            margin: 1%;
        }
        .title{
            font-size: 30px;
            font-weight: 700;
            text-align: center;
        }
        .search-container{
            display: flex;
        }
        .search-input{
            border: 1px solid gray;
            outline: none;
            width: 60%;
            height: 30px;
            border-radius: 20px 0px 0px 20px;
            padding-left: 10px;
        }
        .search-button{
            width: 100px;
            height: 33px;
            line-height: 30px;
            /*border-radius:  0px 20px 20px 0px ;*/
            text-align: center;
            background: black;
            color:white;
            cursor: pointer; /*鼠标变成小手*/
            user-select: none;/*禁止用户选择复制*/
        }
        .country-select{
            width: 100px;
            height: 33px;
            line-height: 30px;
            text-align: center;
            background: black;
            color:white;
            cursor: pointer; /*鼠标变成小手*/
        }
        .language-select{
            width: 100px;
            height: 33px;
            line-height: 30px;
            border-radius:  0px 20px 20px 0px ;
            margin-bottom: 10px;
            text-align: center;
            background: black;
            color:white;
            cursor: pointer; /*鼠标变成小手*/
            user-select: none;/*禁止用户选择复制*/
        }
        .user-card {
            display: flex;
            box-sizing: border-box;
            border: 1px solid #ccc;
            width: 80%;
            height: 100px;
            border-radius: 20px;
            padding: 10px;
            margin: 5px auto;
            margin-bottom: 20px;
            text-align: center;
            background: white;
            box-shadow: rgb(181, 180, 180) 3px 3px 3px 1px;
            overflow: hidden;/*防止文字溢出 */
        }
        .user-card img {
            border-radius: 50%; /* 使头像变成圆形 */
            margin-bottom: 5px; /* 头像和用户名之间的间距 */
        }
        .user-card p{
            margin: 5px;

        }
        .info-cards {
  display: flex;
  justify-content: space-around;
  /* flex-wrap: wrap; */
  margin-top: 10px;
}

.info-card {
  /* background-color: #f9f9f9;
  border: 1px solid #ddd;
  
  
  border-radius: 5px;
  flex: 1 1 100px; /* 每个卡片的最大宽度为150px，可以根据需要调整 */
  /* box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); */ 
  padding: 10px;
  margin: 10px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 10px; /* 可以根据需要调整高度 */
  
}

.info-card p {
  margin: 0;
  font-size: 14px;
}

.info-card p:first-child {
  font-weight: bold;
  color: #333;
}
        .box{
            margin-top: auto;
            width: 100px;
            height: 100px;
            background-color: blue;
        }

</style>
