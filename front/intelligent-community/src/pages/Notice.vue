<script setup lang="ts">
import { ref, onMounted } from 'vue';
import axios from 'axios';
//@ts-ignore
import Topbar from '@/components/Topbar.vue';
//@ts-ignore
import ServiceSidebar from '@/components/ServiceSidebar.vue';

const notices = ref([]);
const total = ref(0);
const perPage = ref(10);
const currentPage = ref(1);
const totalPages = ref(1);

const fetchNotices = async (page = currentPage.value) => {
  try {
    const { data } = await axios.get(`http://localhost:8080/getNoticeById`, {
      params: {
        id: (page - 1) * perPage.value
      }
    });

    notices.value = data.notices;
    total.value = data.total;
    totalPages.value = Math.ceil(total.value / perPage.value);
  } catch (error) {
    console.error('获取公告数据失败:', error);
  }
};

const prevPage = () => {
  if (currentPage.value > 1) {
    currentPage.value--;
    fetchNotices();
  }
};

const nextPage = () => {
  if (currentPage.value < totalPages.value) {
    currentPage.value++;
    fetchNotices();
  }
};

onMounted(() => {
  fetchNotices();
});
</script>


<template>
    <div>
      <Topbar />
      <ServiceSidebar />
  
      <div class="notice-container">
        <br></br>
        <h2>通知公告</h2>
        <div class="table-wrapper">
          <table>
            <thead>
              <tr>
                <th>公告标题</th>
                <th>发布时间</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="notice in notices" :key="notice.id">
                <td>{{ notice.title }}</td>
                <td>{{ notice.date }}</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="pagination">
          <span>共 {{ total }} 条</span>
          <select v-model="perPage" @change="fetchNotices(1)">
            <option v-for="option in [10, 20, 30]" :key="option" :value="option">{{ option }} 条/页</option>
          </select>
          <button @click="prevPage" :disabled="currentPage === 1">前往</button>
          <input v-model="currentPage" @keyup.enter="fetchNotices" type="number" min="1" :max="totalPages" />
          <button @click="nextPage" :disabled="currentPage === totalPages">后页</button>
        </div>
      </div>
    </div>
  </template>
  

  
  <style scoped>
  .notice-container {
    margin-left: 220px;
    padding: 20px;
    display: flex;
    flex-direction: column; /* 让内容区域内部使用列方向布局 */
    height: calc(100vh - 60px); /* 保证内容区域高度为视口高度减去顶部 60px */
    overflow: hidden; /* 隐藏超出部分 */
  }
  
  .table-wrapper {
    flex-grow: 1; /* 使表格区域撑满剩余空间 */
    overflow-y: auto; /* 如果内容超过区域，显示垂直滚动条 */
  }
  
  table {
    width: 100%;
    border-collapse: collapse;
  }
  
  th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }
  
  .pagination {
    display: flex;
    align-items: center;
    gap: 10px;
    margin-top: 10px;
  }
  
  .pagination input {
    width: 50px;
  }
  </style>
  