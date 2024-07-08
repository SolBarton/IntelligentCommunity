<script setup lang="ts">
import { useRouter } from 'vue-router';

// 路由跳转函数
const router = useRouter();
const navigateTo = (path: string) => {
  router.push(path);
};
</script>

<template>
  <div class="sidebar">
    <div class="sidebar-item" @click="navigateTo('/notice')">
      <span class="icon">📢</span>
      <span class="text">通知公告</span>
    </div>
    <div class="sidebar-item" @click="navigateTo('/parking-management')">
      <span class="icon">🚗</span>
      <span class="text">车位管理</span>
    </div>
    <div class="sidebar-item" @click="navigateTo('/visitor-log')">
      <span class="icon">➡️</span>
      <span class="text">访客登记</span>
    </div>
    <div class="sidebar-item" @click="navigateTo('/report-repair')">
      <span class="icon">⚙️</span>
      <span class="text">报事报修</span>
    </div>
    <div class="sidebar-item" @click="navigateTo('/property-fees')">
      <span class="icon">💳</span>
      <span class="text">物业费缴纳</span>
    </div>
  </div>
</template>

<style scoped>
.sidebar {
  width: 200px;
  background-color: #f5f5f5;
  padding: 20px;
  border-right: 1px solid #ddd;
  position: fixed; /* 固定在页面左侧 */
  top: 60px;      /* 距离顶部 60px */
  left: 0;        /* 靠左对齐 */
  height: calc(100% - 60px); /* 高度减去 60px */
}

.sidebar-item {
  display: flex;
  align-items: center;
  padding: 10px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.sidebar-item:hover {
  background-color: #e0e0e0;
}

.icon {
  font-size: 24px;
  margin-right: 10px;
}

.text {
  font-size: 16px;
}

.sidebar-item.active .text {
  color: #3498db;
}
</style>
