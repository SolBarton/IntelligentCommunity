<script setup lang="ts">
// @ts-ignore
import Topbar from '../components/Topbar.vue'
import { ref } from 'vue';

// 定义响应式变量
const phone = ref('');
const password = ref('');
const confirmPassword = ref('');
const verificationCode = ref('');

// 注册处理函数
const register = () => {
  console.log('手机号:', phone.value);
  console.log('密码:', password.value);
  console.log('确认密码:', confirmPassword.value);
  console.log('验证码:', verificationCode.value);
  // 这里可以添加实际的注册逻辑
};
</script>

<template>
    <Topbar />
    <div class="register-container">
      <div class="register-box">
        <h1 class="register-title">注册</h1>
        <form class="register-form">
          <div class="form-group">
            <label for="phone">手机号</label>
            <input type="text" id="phone" v-model="phone" placeholder="请输入手机号" />
          </div>
          <div class="form-group">
            <label for="password">密码</label>
            <input type="password" id="password" v-model="password" placeholder="请输入密码" />
          </div>
          <div class="form-group">
            <label for="confirmPassword">确认密码</label>
            <input type="password" id="confirmPassword" v-model="confirmPassword" placeholder="请再次输入密码" />
          </div>
          <div class="form-group">
            <label for="verificationCode">验证码</label>
            <input type="text" id="verificationCode" v-model="verificationCode" placeholder="请输入验证码" />
            <button type="button" class="get-code-button">获取验证码</button>
          </div>
          <button type="button" class="register-button" @click="register">注册</button>
          <div class="register-links">
            <a href="#" class="to-login"><router-link to="/login">已有账号？去登录</router-link></a>
          </div>
        </form>
      </div>
    </div>
  </template>
  

  
  <style scoped>
  /* 使用 flex 布局来居中容器 */
  .register-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh; /* 使容器占满整个视口高度 */
    background-color: #f0f2f5; /* 添加一个背景色以便观察效果 */
    padding: 10px; /* 在小屏幕上添加一些内边距 */
  }
  
  /* 设置表单的宽度为百分比，并限制最大宽度 */
  .register-box {
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 100%; /* 占满整个容器的宽度 */
    max-width: 400px; /* 限制表单的最大宽度 */
    box-sizing: border-box; /* 确保 padding 不会影响总宽度 */
  }
  
  /* 设置标题样式 */
  .register-title {
    text-align: center;
    margin-bottom: 20px;
    font-size: 24px;
    color: #333;
  }
  
  /* 表单布局 */
  .register-form {
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
  
  /* 验证码按钮样式 */
  .get-code-button {
    margin-top: 10px;
    padding: 8px 12px;
    background-color: #007bff;
    border: none;
    border-radius: 5px;
    color: white;
    cursor: pointer;
    transition: background-color 0.3s;
  }
  
  .get-code-button:hover {
    background-color: #0056b3;
  }
  
  /* 注册按钮样式 */
  .register-button {
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
  
  .register-button:hover {
    background-color: #0056b3;
  }
  
  /* 链接样式 */
  .register-links {
    display: flex;
    justify-content: center;
    margin-top: 15px;
  }
  
  .register-links a {
    color: #007bff;
    text-decoration: none;
  }
  
  .register-links a:hover {
    text-decoration: underline;
  }
  
  /* 添加媒体查询以适应更大屏幕 */
  @media (min-width: 768px) {
    .register-box {
      padding: 30px;
      max-width: 500px;
    }
  
    .register-title {
      font-size: 28px;
    }
  
    .form-group input {
      padding: 15px;
      font-size: 16px;
    }
  
    .register-button {
      padding: 15px;
      font-size: 18px;
    }
  }
  </style>
  