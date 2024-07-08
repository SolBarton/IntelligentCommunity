<script setup lang="ts">
</script>

<template>
  <router-view></router-view>
</template>

<style scoped>
#app {
  display: flex;
  min-height: 100vh; /* 设置最小高度为视口高度，保证侧边栏和主内容区域撑满屏幕 */
}

.main-content {
  margin-left: 220px; /* 与侧边栏的宽度一致 */
  padding: 20px;
  flex-grow: 1; /* 使内容区域占据剩余空间 */
  display: flex;
  flex-direction: column; /* 让内容区域内部使用列方向布局 */
}
</style>
