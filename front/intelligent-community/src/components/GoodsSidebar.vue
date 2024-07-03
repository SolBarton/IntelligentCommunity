<template>
    <div class="sidebar">
      <ul>
        <li v-for="category in categories" :key="category.id">
          {{ category.category_name }}
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'GoodsSidebar',
    data() {
      return {
        categories: []
      };
    },
    mounted() {
      this.fetchCategories();
    },
    methods: {
      fetchCategories() {
        axios.get('https://3f663d48-32d5-4c29-ba1c-93276107f271.mock.pstmn.io/findAll')
          .then(response => {
            this.categories = response.data;
          })
          .catch(error => {
            console.error("There was an error fetching the categories!", error);
          });
      }
    }
  }
  </script>
  
  <style scoped>
  .sidebar {
    width: 250px;
    margin-top: 60px;
    background-color: #f0f0f0; /* 淡灰色背景 */
    padding: 1rem;
    position: fixed;
    top: 0;
    left: 0;
    height: 100%;
    overflow-y: auto;
    box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
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
  