import './assets/main.css'

// 引入createApp用于创建应用
import { createApp } from 'vue'
// 引入App根组件
import App from './App.vue'
// @ts-ignore
import Goods from './pages/Goods.vue'

createApp(App).mount('#app')
createApp(Goods).mount('#goods')