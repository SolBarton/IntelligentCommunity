<script setup lang="ts">
import { ref } from 'vue';
const step = ref(1);
const phone = ref('');
const verificationCode = ref('');
const newPassword = ref('');
const confirmNewPassword = ref('');

const goToNextStep = () => {
  // 这里可以添加验证手机号和验证码的逻辑
  step.value = 2;
};

const resetPassword = () => {
  if (newPassword.value !== confirmNewPassword.value) {
    alert('两次输入的密码不一致，请重新输入');
    return;
  }
  console.log('手机号:', phone.value);
  console.log('验证码:', verificationCode.value);
  console.log('新密码:', newPassword.value);
  // 这里可以添加实际的重置密码逻辑
};
</script>

<template>
    <div class="forgot-password-container">
      <div class="forgot-password-box">
        <h1 class="forgot-password-title">{{ step === 1 ? '找回密码' : '重置密码' }}</h1>
        
        <!-- 第一步：输入手机号和验证码 -->
        <form v-if="step === 1" class="forgot-password-form">
          <div class="form-group">
            <label for="phone">手机号</label>
            <input type="text" id="phone" v-model="phone" placeholder="请输入手机号" />
          </div>
          <div class="form-group">
            <label for="verificationCode">验证码</label>
            <input type="text" id="verificationCode" v-model="verificationCode" placeholder="请输入验证码" />
            <button type="button" class="get-code-button">获取验证码</button>
          </div>
          <button type="button" class="next-button" @click="goToNextStep">下一步</button>
        </form>
  
        <!-- 第二步：输入新密码 -->
        <form v-else class="forgot-password-form">
          <div class="form-group">
            <label for="newPassword">新密码</label>
            <input type="password" id="newPassword" v-model="newPassword" placeholder="请输入新密码" />
          </div>
          <div class="form-group">
            <label for="confirmNewPassword">确认新密码</label>
            <input type="password" id="confirmNewPassword" v-model="confirmNewPassword" placeholder="请再次输入新密码" />
          </div>
          <button type="button" class="reset-button" @click="resetPassword">重置密码</button>
        </form>
      </div>
    </div>
  </template>
  

  
  <style scoped>
  .forgot-password-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f0f2f5;
    padding: 10px;
  }
  
  .forgot-password-box {
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 400px;
    box-sizing: border-box;
  }
  
  .forgot-password-title {
    text-align: center;
    margin-bottom: 20px;
    font-size: 24px;
    color: #333;
  }
  
  .forgot-password-form {
    display: flex;
    flex-direction: column;
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  .form-group label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
  }
  
  .form-group input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
  }
  
  .get-code-button,
  .next-button,
  .reset-button {
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
  
  .get-code-button:hover,
  .next-button:hover,
  .reset-button:hover {
    background-color: #0056b3;
  }
  </style>
  