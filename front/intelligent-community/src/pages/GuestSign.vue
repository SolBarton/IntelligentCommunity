<script setup lang="ts">
import { ref, onMounted } from 'vue';
import axios from 'axios';
//@ts-ignore
import Topbar from '@/components/Topbar.vue';
//@ts-ignore
import ServiceSidebar from '@/components/ServiceSidebar.vue';

const userId = '123456'; // 用户 ID，根据实际情况获取

const form = ref({
  type: '',
  time: '',
});

const guestLogs = ref([]);

const fetchGuestLogs = async () => {
  try {
    const response = await axios.get('http://localhost:8080/getGuestLog');
    guestLogs.value = response.data.data;
  } catch (error) {
    console.error('获取访客记录失败:', error);
  }
};

const handleSubmit = async () => {
  if (!form.value.type || !form.value.time) {
    alert('请填写完整信息');
    return;
  }

  try {
    const response = await axios.post('http://localhost:8080/commitGuest', {
      id: userId,
      type: form.value.type,
      time: form.value.time,
    });
    if (response.data.code === 200) {
      alert('提交成功');
      fetchGuestLogs();
    } else {
      alert(response.data.error);
    }
  } catch (error) {
    console.error('提交失败:', error);
  }
};

onMounted(() => {
  fetchGuestLogs();
});
</script>

<template>
  <div>
    <Topbar />
    <ServiceSidebar />

    <div class="guest-container">
      <br></br>
      <h2>访客登记</h2>
      <el-form :model="form" label-width="120px" class="form">
        <el-form-item label="来访目的" required>
          <el-radio-group v-model="form.type">
            <el-radio label="中介看房">中介看房</el-radio>
            <el-radio label="搬家旅行">搬家旅行</el-radio>
            <el-radio label="送货上门">送货上门</el-radio>
            <el-radio label="朋友来访">朋友来访</el-radio>
            <el-radio label="家政服务">家政服务</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="来访时间" required>
          <el-date-picker v-model="form.time" type="date" placeholder="请选择时间"></el-date-picker>
        </el-form-item>
        <br></br>
        <el-form-item>
          <button type="primary" @click="handleSubmit">提交</button>
        </el-form-item>
      </el-form>

      <el-table :data="guestLogs" style="width: 100%; margin-top: 20px">
        <el-table-column prop="id" label="访客id" width="80"></el-table-column>
        <el-table-column prop="type" label="来访目的"></el-table-column>
        <el-table-column prop="time" label="来访时间"></el-table-column>
        <el-table-column prop="status" label="来访状态"></el-table-column>
        <el-table-column prop="createdAt" label="创建时间"></el-table-column>
      </el-table>
    </div>
  </div>
</template>

<style scoped>
.guest-container {
  margin-left: 220px;
  padding: 20px;
}

.form {
  margin-top: 20px;
}

.notice {
  margin: 10px 0;
  color: #ff0000;
}

.highlight {
  font-weight: bold;
}

.el-table {
  margin-top: 20px;
}

.status-pending {
  color: #ff0000;
}

.status-completed {
  color: #00cc00;
}

.radio-group {
  display: flex;
  flex-wrap: wrap;
}

.radio-box {
  border: 1px solid #dcdfe6;
  border-radius: 5px;
  padding: 10px;
  margin-right: 10px;
  margin-bottom: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
}

.radio-box:hover {
  border-color: #409eff;
}

.radio-box .el-radio__input.is-checked + .el-radio__label {
  color: #409eff;
  font-weight: bold;
}

.el-radio {
  margin: 0;
}

.el-date-picker {
  width: 100%;
}

button {
    background: #008cff;
    color: white;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
    border-radius: 3px;
  }
</style>
