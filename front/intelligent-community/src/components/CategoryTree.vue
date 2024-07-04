<template>
    <div>
      <div class="category-main">{{ category.categoryName }}</div>
      <ul v-if="category.children && category.children.length" class="category-children">
        <li v-for="child in category.children" :key="child.id">
          <CategoryTree :category="child" />
        </li>
      </ul>
    </div>
  </template>
  
  <script setup lang="ts">
  import { defineProps } from 'vue';
  
  const props = defineProps({
    category: {
      type: Object,
      required: true,
    },
  });
  </script>
  
  <style scoped>
  .category-main {
    font-weight: bold;
    font-size: 1.2rem;
    margin-bottom: 0.5rem;
  }
  
  .category-children {
    list-style: none;
    padding-left: 1rem;
    display: flex; /* 使用 flex 布局 */
    flex-wrap: wrap; /* 允许换行 */
    gap: 10px; /* 控制三级类别之间的间距 */
  }
  
  .category-children li {
    font-size: 1rem;
    color: #555;
    flex: 1 1 auto; /* 每个子项占据一定的宽度 */
  }
  </style>
  