<template>
  <div class="sidebar">
    <ul>
      <li v-for="category in categories" :key="category.id" @click="handleCategoryClick(category.id)">
        {{ category.categoryName }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'GoodsSidebar',
  props: {
    onCategoryClick: {
      type: Function,
      required: true,
    }
  },
  data() {
    return {
      categories: []
    };
  },
  mounted() {
    this.fetchCategories();
  },
  methods: {
    async fetchCategories() {
      try {
        const response = await axios.get('http://localhost:8080/goodsCategory/getCategoryType1');
        if (response.data.code === 200) {
          this.categories = response.data.data; // 从data字段中提取数据
        } else {
          console.error("Error fetching categories:", response.data.msg);
        }
      } catch (error) {
        console.error("There was an error fetching the categories!", error);
      }
    },
    handleCategoryClick(categoryId) {
      this.onCategoryClick(categoryId); // 调用传入的点击处理函数
    }
  }
}
</script>

<style scoped>
.sidebar {
  width: 250px;
  background-color: #f0f0f0; /* 淡灰色背景 */
  padding: 1rem;
  position: fixed;
  top: 60px; /* 使侧边栏位于顶栏下方 */
  left: 0;
  bottom: 0;
  overflow-y: auto;
  box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
  z-index: 500; /* 确保侧边栏位于顶栏下方 */
}

.sidebar ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.sidebar li {
  margin-bottom: 1rem;
  font-size: 1.1rem;
  color: #333; /* 深灰色字体 */
}

.sidebar li:hover {
  cursor: pointer;
  color: #007bff; /* 悬停时变成蓝色 */
}
</style>
