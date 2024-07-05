<script setup lang="ts">
import { defineComponent } from 'vue';
import { useRouter } from 'vue-router';

interface SidebarItem {
  name: string;
  route: string;
}

interface SidebarSection {
  title: string;
  items: SidebarItem[];
}

const sections: SidebarSection[] = [
  {
    title: '会员中心',
    items: [
      { name: '个人资料', route: '/profile' },
      { name: '密码修改', route: '/change-password' },
      { name: '我的收藏', route: '/my-favorites' },
    ],
  },
  {
    title: '订单中心',
    items: [{ name: '我的订单', route: '/my-orders' }],
  },
  {
    title: '钱包管理',
    items: [
      { name: '充值', route: '/recharge' },
      { name: '转账', route: '/transfer' },
      { name: '消费记录', route: '/transaction-history' },
    ],
  },
];

const router = useRouter();

const navigateTo = (route: string) => {
  router.push(route);
};
</script>


<template>
    <div class="sidebar">
      <div v-for="(section, index) in sections" :key="index" class="sidebar-section">
        <h2 class="sidebar-section-title">{{ section.title }}</h2>
        <ul class="sidebar-items">
          <li
            v-for="(item, subIndex) in section.items"
            :key="subIndex"
            class="sidebar-item"
            @click="navigateTo(item.route)"
          >
            <router-link :to="item.route" class="sidebar-link">
              {{ item.name }}
            </router-link>
          </li>
        </ul>
      </div>
    </div>
  </template>
  

  
<style scoped>
.sidebar {
  background-color: #f4f4f4;
  width: 250px;
  padding: 20px;
  box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
  margin-top: 60px; /* 给侧边栏留出60px的空间 */
  position: fixed; /* 固定侧边栏位置 */
  top: 0;
  left: 0;
  height: 100vh;
  overflow-y: auto;
}

  
  .sidebar-section {
    margin-bottom: 20px;
  }
  
  .sidebar-section-title {
    font-size: 18px;
    font-weight: bold;
    color: #333;
    margin-bottom: 10px;
  }
  
  .sidebar-items {
    list-style-type: none;
    padding: 0;
    margin: 0;
  }
  
  .sidebar-item {
    margin-bottom: 10px;
  }
  
  .sidebar-link {
    text-decoration: none;
    color: #555;
    font-size: 16px;
  }
  
  .sidebar-link:hover {
    color: #007bff;
    text-decoration: underline;
  }
  </style>
  