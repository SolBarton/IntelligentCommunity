import { createRouter, createWebHistory } from 'vue-router'
import Goods from '@/pages/Goods.vue'
import Login from '@/pages/Login.vue'
const routes = [
  { path: '/', component: Goods },
  { path: '/login', component: Login }
]

// new Router 变成 createRouter
const router = createRouter({
  // mode: 'history' 配置已经被一个更灵活的 history 配置所取代
  // 必填。否则报错：Uncaught Error: Provide the "history" option when calling "createRouter()"
  history: createWebHistory(),
  routes
})

export default router
