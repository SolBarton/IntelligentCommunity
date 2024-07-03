<script setup lang="ts">
// @ts-ignore
import Topbar from '../components/Topbar.vue'
// @ts-ignore
import GoodsSidebar from '../components/GoodsSidebar.vue'

// export default {
//   name: 'Goods',
//   components: {
//     Topbar,
//     GoodsSidebar
//   }
// }
</script>

<template>
    <div id="goods">
      <Topbar />
      <div class="content-wrapper">
        <GoodsSidebar />
        <div class="main-content">
        <h1>这里是主页</h1>
          <!-- 这里放其他内容，比如路由视图 -->
          <router-view />
        </div>
      </div>
    </div>
  </template>

<style>
#goods {
  display: flex;
  flex-direction: column;
}

.content-wrapper {
  display: flex;
  margin-top: 160px; /* 留出顶栏高度的空间，具体高度视顶栏而定 */
}

.main-content {
  flex-grow: 1;
  padding: 1rem;
  margin-left: 250px; /* 留出侧边栏的宽度 */
}
</style>