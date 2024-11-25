<script setup>

import {onMounted, ref} from "vue";
import axios from "axios";

const datas = ref([])
onMounted(() => {
  getMessageWell()
})


function getMessageWell() {
  axios.get("http://localhost:8080/well/get").then((res) => {
    console.log(res.status)
    console.log(res.data)
    if (res.data.code === 0) {
      datas.value = res.data.data
      // datas.value.push(...res.data.data)
    }
  }).catch((err) => {
    console.log(err)
  })
}

</script>

<template>
  <div class="w-full grid grid-cols-3 gap-4">
    <div v-for="(item,index) in datas" :key="index" class="bg-red-50 rounded-lg h-40 p-2">
      <span>{{ item.content }}</span>
    </div>
  </div>
</template>

<style scoped>

</style>