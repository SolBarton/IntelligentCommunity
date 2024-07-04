<script setup lang="ts">
// @ts-ignore
import Topbar from '../components/Topbar.vue'
import axios from 'axios';


import { ref } from 'vue';

// 定义响应式变量
const phone = ref('');
const password = ref('');

// 登录处理函数
const login = () => {
  console.log('手机号:', phone.value);
  console.log('密码:', password.value);
  // 这里可以添加实际的登录逻辑
};
</script>

<template>
    <Topbar />
    <div class="login-container">
    <div class="login-box">
      <h1 class="login-title">登录</h1>
      <form class="login-form">
        <div class="form-group">
          <label for="phone">手机号</label>
          <input type="text" id="phone" v-model="phone" placeholder="请输入手机号" />
        </div>
        <div class="form-group">
          <label for="password">密码</label>
          <input type="password" id="password" v-model="password" placeholder="请输入密码" />
        </div>
        <button type="button" class="login-button" @click="login">登录</button>
        <div class="login-links">
          <a href="#" class="forgot-password">忘记密码?</a>
          <a href="#" class="register">立即注册</a>
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped>
/* 使用 flex 布局来居中容器 */
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh; /* 使容器占满整个视口高度 */
  background-color: #f0f2f5; /* 添加一个背景色以便观察效果 */
  padding: 10px; /* 在小屏幕上添加一些内边距 */
}

/* 设置表单的宽度为百分比，并限制最大宽度 */
.login-box {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  width: 100%; /* 占满整个容器的宽度 */
  max-width: 400px; /* 限制表单的最大宽度 */
  box-sizing: border-box; /* 确保 padding 不会影响总宽度 */
}

/* 设置标题样式 */
.login-title {
  text-align: center;
  margin-bottom: 20px;
  font-size: 24px;
  color: #333;
}

/* 表单布局 */
.login-form {
  display: flex;
  flex-direction: column;
}

/* 表单组样式 */
.form-group {
  margin-bottom: 15px;
}

/* 标签样式 */
.form-group label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

/* 输入框样式 */
.form-group input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-sizing: border-box;
}

/* 按钮样式 */
.login-button {
  padding: 10px;
  margin-top: 20px;
  background-color: #007bff;
  border: none;
  border-radius: 5px;
  color: white;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.login-button:hover {
  background-color: #0056b3;
}

/* 链接样式 */
.login-links {
  display: flex;
  justify-content: space-between;
  margin-top: 15px;
}

.login-links a {
  color: #007bff;
  text-decoration: none;
}

.login-links a:hover {
  text-decoration: underline;
}

.forgot-password {
  margin-right: auto;
}

.register {
  margin-left: auto;
}

/* 添加媒体查询以适应更大屏幕 */
@media (min-width: 768px) {
  .login-box {
    padding: 30px;
    max-width: 500px;
  }

  .login-title {
    font-size: 28px;
  }

  .form-group input {
    padding: 15px;
    font-size: 16px;
  }

  .login-button {
    padding: 15px;
    font-size: 18px;
  }
}
</style>