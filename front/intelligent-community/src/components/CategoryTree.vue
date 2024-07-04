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
  }
  
  .category-children li {
    font-size: 1rem;
    color: #555;
  }
  </style>
  