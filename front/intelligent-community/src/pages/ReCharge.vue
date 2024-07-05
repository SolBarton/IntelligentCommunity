<script setup lang="ts">
import { ref } from 'vue';
// @ts-ignore
import Topbar from '@/components/Topbar.vue';
// @ts-ignore
import UserSidebar from '@/components/UserSidebar.vue';

const balance = ref('80,064.42');
const rechargeAmount = ref('');
const paymentMethod = ref('微信支付');

const handleSubmit = () => {
  // 处理充值逻辑，比如发送请求到服务器
  alert(`充值金额：${rechargeAmount.value}，支付方式：${paymentMethod.value}`);
};

const handleReset = () => {
  rechargeAmount.value = '';
  paymentMethod.value = '微信支付';
};
</script>

<template>
  <div id="recharge">
    <Topbar />
    <div class="content-wrapper">
      <UserSidebar />
      <div class="main-content">
        <h1>钱包充值</h1>
        <div class="balance">钱包余额: {{ balance }}</div>
        <form @submit.prevent="handleSubmit" class="recharge-form">
          <div class="form-group">
            <label for="recharge-amount">充值金额</label>
            <input
              type="number"
              id="recharge-amount"
              v-model="rechargeAmount"
              placeholder="请输入充值金额"
              required
            />
          </div>
          <div class="form-group">
            <label for="payment-method">支付方式</label>
            <select id="payment-method" v-model="paymentMethod" required>
              <option value="微信支付">微信支付</option>
              <option value="支付宝支付">支付宝支付</option>
            </select>
          </div>
          <div class="form-actions">
            <button type="submit">充值</button>
            <button type="button" @click="handleReset">重置</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<style scoped>
#recharge {
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

.balance {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 20px;
}

.recharge-form {
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

.form-group input[type="number"],
.form-group select {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
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
