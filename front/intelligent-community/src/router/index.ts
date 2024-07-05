import { createRouter, createWebHistory } from 'vue-router'
import Goods from '@/pages/Goods.vue'
import Login from '@/pages/Login.vue'
import Register from '@/pages/Register.vue'
import ForgetPassword from '@/pages/ForgetPassword.vue'
import UserProfile from '@/pages/UserProfile.vue'
import ChangePassword from '@/pages/ChangePassword.vue'
import ReCharge from '@/pages/ReCharge.vue'
const routes = [
  { path: '/', component: Goods },
  { path: '/login', component: Login },
  { path: '/register', component: Register },
  { path: '/forget-password', component: ForgetPassword },
  { path: '/profile', component: UserProfile },
  { path: '/change-password', component: ChangePassword },
  { path: '/recharge', component: ReCharge },
]

// new Router 变成 createRouter
const router = createRouter({
  // mode: 'history' 配置已经被一个更灵活的 history 配置所取代
  // 必填。否则报错：Uncaught Error: Provide the "history" option when calling "createRouter()"
  history: createWebHistory(),
  routes
})

export default router
