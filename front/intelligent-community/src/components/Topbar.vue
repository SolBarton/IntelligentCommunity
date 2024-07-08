<template>
  <nav class="navbar">
    <ul>
      <li><router-link to="/"><a>首页</a></router-link></li>
      <li><router-link to="/notice"><a>社区服务</a></router-link></li>
      <li><router-link to="/orders"><a>我的订单</a></router-link></li>
      <li><router-link to="/login"><a>个人中心</a></router-link></li>
      <li><router-link to="/"><a>商品</a></router-link></li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: 'Topbar'
}
</script>

<style scoped>
.navbar {
  width: 100%;
  background-color: #007bff; /* 蓝色背景 */
  display: flex;
  justify-content: center; /* 居中对齐 */
  align-items: center;
  padding: 1rem 0;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 1000; /* 确保顶栏在最前 */
}

.navbar ul {
  list-style: none;
  display: flex;
  margin: 0;
  padding: 0;
}

.navbar li {
  margin: 0 1.5rem; /* 增加间距 */
}

.navbar a {
  color: #ffffff; /* 白色字体 */
  text-decoration: none;
  font-size: 1.2rem;
  font-weight: bold; /* 粗体 */
  transition: color 0.3s ease; /* 平滑过渡效果 */
}

.navbar a:hover {
  color: #f0f0f0; /* 悬停时变浅一点的白色 */
  text-decoration: underline;
}
</style>
