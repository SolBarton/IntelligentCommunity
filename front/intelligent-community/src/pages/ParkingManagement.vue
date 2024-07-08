<script setup lang="ts">
import { ref, onMounted } from 'vue';
import axios from 'axios';
//@ts-ignore
import Topbar from '@/components/Topbar.vue';
//@ts-ignore
import ServiceSidebar from '@/components/ServiceSidebar.vue';

const userId = '123456'; // 用户 ID，根据实际情况获取

const parkings = ref([]);
const isModalOpen = ref(false);
const currentParkingId = ref<string | null>(null);
const newPlateNumber = ref('');

const fetchParkingSpaces = async () => {
  try {
    const response = await axios.get('https://cddc78c2-8dd3-40c2-9b65-ec654670d306.mock.pstmn.io/getParkingSpace');
    const parkingData = response.data.data; // 注意这里的 `data.data`

    parkings.value = parkingData.map((parking: any) => ({
      id: parking.id,
      name: parking.name,
      status: parking.status === 1 ? '启用中' : '禁用',
      statusClass: parking.status === 1 ? 'status-active' : 'status-inactive',
      type: parking.type === 1 ? '地下车库' : '地上车位',
      plateNumbers: [] // 初始化车牌号列表
    }));

    fetchParkingStatusByUser();
  } catch (error) {
    console.error('获取车位数据失败:', error);
  }
};

const fetchParkingStatusByUser = async () => {
  try {
    const { data } = await axios.post('http://localhost:8080/getParkingStatusByUser', {
      userid: userId
    });

    data.forEach((status: any) => {
      const parking = parkings.value.find(p => p.id === status.id);
      if (parking) {
        parking.plateNumbers = status.number ? status.number.split(',') : [];
      }
    });
  } catch (error) {
    console.error('获取用户车位状态失败:', error);
  }
};

const openAddCarModal = (parkingId: string) => {
  currentParkingId.value = parkingId;
  isModalOpen.value = true;
};

const closeModal = () => {
  isModalOpen.value = false;
  newPlateNumber.value = '';
  currentParkingId.value = null;
};

const addCarToParking = async () => {
  if (!newPlateNumber.value) {
    alert('请输入车牌号码');
    return;
  }

  try {
    await axios.post('http://localhost:8080/putParkingByUser', {
      userid: userId,
      parkingId: currentParkingId.value,
      name: newPlateNumber.value
    });

    // 更新车位信息
    fetchParkingSpaces();
    closeModal();
  } catch (error) {
    console.error('添加车牌号失败:', error);
  }
};

onMounted(() => {
  fetchParkingSpaces();
});
</script>


<template>
    <div>
      <Topbar />
      <ServiceSidebar />
      
      <div class="parking-container">
        <br></br>
        <h2>车位管理</h2>
        <div class="parking-list">
          <div 
            v-for="parking in parkings" 
            :key="parking.id" 
            class="parking-card"
          >
            <h3>{{ parking.name }}</h3>
            <p>
              <span>车位状态：</span>
              <span :class="parking.statusClass">{{ parking.status }}</span>
            </p>
            <p>
              <span>车位类型：</span>
              <span>{{ parking.type }}</span>
            </p>
            <p>
              <span>已绑定车牌号：</span>
              <span>{{ parking.plateNumbers.length > 0 ? parking.plateNumbers.join(', ') : '暂无' }}</span>
            </p>
            <button @click="openAddCarModal(parking.id)">+ 添加车辆</button>
          </div>
        </div>
  
        <!-- 添加车牌号 Modal -->
        <div v-if="isModalOpen" class="modal">
          <div class="modal-content">
            <h3>添加车牌号码</h3>
            <input v-model="newPlateNumber" placeholder="请输入车牌号码" />
            <button @click="addCarToParking">确定</button>
            <button @click="closeModal">取消</button>
          </div>
        </div>
      </div>
    </div>
  </template>
  

  
  <style scoped>
  .parking-container {
    margin-left: 220px;
    padding: 20px;
  }
  
  .parking-list {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
  }
  
  .parking-card {
    background: #fff;
    padding: 15px;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    width: calc(33% - 20px);
  }
  
  .parking-card h3 {
    margin: 0 0 10px;
    font-size: 1.2em;
  }
  
  .parking-card p {
    margin: 5px 0;
  }
  
  .status-active {
    color: green;
  }
  
  .status-inactive {
    color: red;
  }
  
  button {
    background: #008cff;
    color: white;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
    border-radius: 3px;
  }
  
  button:hover {
    background: #005bb5;
  }
  
  .modal {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
  }
  
  .modal-content {
    background: #fff;
    padding: 20px;
    border-radius: 5px;
    width: 300px;
    text-align: center;
  }
  
  .modal-content h3 {
    margin: 0 0 15px;
  }
  
  .modal-content input {
    width: 100%;
    padding: 8px;
    margin-bottom: 15px;
    border: 1px solid #ddd;
    border-radius: 3px;
  }
  </style>
  