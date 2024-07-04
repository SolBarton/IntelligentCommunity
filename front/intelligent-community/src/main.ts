import './assets/main.css'

// 引入createApp用于创建应用
import { createApp } from 'vue'
// 引入App根组件
import App from './App.vue'
// @ts-ignore
import Goods from './pages/Goods.vue'
// @ts-ignore
import Login from './pages/Login.vue'
import router from './router'

createApp(App)
.use(router)
.mount('#app')
createApp(Goods).mount('#goods')
createApp(Goods).mount("#login")