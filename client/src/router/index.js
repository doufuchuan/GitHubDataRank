
import { createRouter, createWebHashHistory } from 'vue-router';


const routes = [
  {
    path: '/',
    name: 'index',
    component: ()=>import('../views/Rank.vue')
  },
];

const router = new createRouter({
    history: createWebHashHistory(),
    routes,
});

export default router;