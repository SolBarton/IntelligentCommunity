<script setup lang="ts">
import { ref } from 'vue';
// @ts-ignore
import Topbar from '../components/Topbar.vue'
// @ts-ignore
import GoodsSidebar from '../components/GoodsSidebar.vue'
// @ts-ignore
import CategoryTree from '../components/CategoryTree.vue';
import axios from 'axios';

// 定义一个响应式变量用于存储类别详情
const categoryDetails = ref([]);

// 处理侧边栏点击事件
const handleCategoryClick = async (categoryId: number) => {
  try {
    const response = await axios.get(`http://localhost:8080/goodsCategory/getCategoryType23`, {
      params: { id: categoryId }
    });
    if (response.data.code === 200) {
      categoryDetails.value = response.data.data;
    } else {
      console.error("Error fetching category details:", response.data.msg);
    }
  } catch (error) {
    console.error("There was an error fetching the category details!", error);
  }
};

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
        <!-- <GoodsSidebar /> -->
        <GoodsSidebar :onCategoryClick="handleCategoryClick" />
        <div class="main-content">
        <!-- 展示类别详情 -->
        <div v-if="categoryDetails.length">
          <div v-for="item in categoryDetails" :key="item.id" class="category-item">
            <!-- 使用递归组件渲染顶级类别和子类别 -->
            <CategoryTree :category="item" />
            <hr class="separator" />
          </div>
        </div>
      </div>
    </div>
  </div>
  </template>

<style scoped>
#goods {
  display: flex;
  flex-direction: column;
}

.content-wrapper {
  display: flex;
}

.main-content {
  margin-left: 250px; /* 与侧边栏宽度一致 */
  padding: 1rem;
  flex: 1;
}

.category-item {
  padding: 1rem 0;
}

.separator {
  border: none;
  border-top: 1px dashed #ddd;
  margin: 1rem 0;
  width: calc(100% - 250px); /* 使用计算宽度，占满侧边栏以外的所有宽度 */
}
</style>