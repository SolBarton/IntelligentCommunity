<script setup lang="ts">
import { ref } from 'vue';
// @ts-ignore
import Topbar from '@/components/Topbar.vue';
// @ts-ignore
import UserSidebar from '@/components/UserSidebar.vue';

const avatar = ref(null);
const username = ref('奥里给');
const gender = ref('');
const email = ref('mazhihao@neuedu.com');
const phone = ref('18611111111');

const handleAvatarChange = (e) => {
  const file = e.target.files[0];
  if (file && file.size < 3 * 1024 * 1024) { // 限制头像大小为3MB以内
    const reader = new FileReader();
    reader.onload = (e) => {
      avatar.value = e.target.result;
    };
    reader.readAsDataURL(file);
  } else {
    alert('头像大小不能超过3MB');
  }
};

const handleSubmit = () => {
  // 提交表单的逻辑，比如发送请求到服务器
  alert('资料已更新');
};

const handleReset = () => {
  // 重置表单的逻辑
  username.value = '奥里给';
  gender.value = '';
  email.value = 'mazhihao@neuedu.com';
  phone.value = '18611111111';
  avatar.value = null;
};
</script>

<template>
  <div id="profile">
    <Topbar />
    <div class="content-wrapper">
      <UserSidebar />
      <div class="main-content">
        <h1>个人资料</h1>
        <form @submit.prevent="handleSubmit" class="profile-form">
          <div class="form-group">
            <label for="avatar">用户头像</label>
            <input type="file" id="avatar" @change="handleAvatarChange" />
            <div v-if="avatar" class="avatar-preview">
              <img :src="avatar" alt="头像预览" />
            </div>
            <p>头像大小不能超过3M</p>
          </div>
          <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" id="username" v-model="username" />
          </div>
          <div class="form-group">
            <label>性别</label>
            <label><input type="radio" value="男" v-model="gender" /> 男</label>
            <label><input type="radio" value="女" v-model="gender" /> 女</label>
          </div>
          <div class="form-group">
            <label for="email">邮箱</label>
            <input type="email" id="email" v-model="email" />
          </div>
          <div class="form-group">
            <label for="phone">手机号码</label>
            <input type="tel" id="phone" v-model="phone" />
          </div>
          <div class="form-actions">
            <button type="submit">确认修改</button>
            <button type="button" @click="handleReset">重置</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<style scoped>
#profile {
  display: flex;
  flex-direction: column;
}

.content-wrapper {
  display: flex;
  margin-top: 60px; /* 给Topbar留出60px的空间 */
}

.main-content {
  flex-grow: 1;
  padding: 20px;
  margin-left: 270px; /* 给主内容留出侧边栏的宽度 */
}

.profile-form {
  max-width: 600px;
  margin: 0 auto;
}

.form-group {
  margin-bottom: 20px;
}

.form-group label {
  display: block;
  margin-bottom: 8px;
  font-weight: bold;
}

.form-group input[type="text"],
.form-group input[type="email"],
.form-group input[type="tel"] {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.form-group input[type="file"] {
  display: block;
  margin-top: 10px;
}

.avatar-preview {
  margin-top: 10px;
}

.avatar-preview img {
  width: 100px;
  height: 100px;
  object-fit: cover;
  border-radius: 50%;
}

.form-actions {
  display: flex;
  justify-content: space-between;
}

.form-actions button {
  padding: 10px 20px;
  border: none;
  background-color: #3498db;
  color: white;
  cursor: pointer;
  border-radius: 4px;
}

.form-actions button:hover {
  background-color: #2980b9;
}
</style>
