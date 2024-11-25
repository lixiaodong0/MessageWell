<script setup>
import {ref} from "vue";
import axios from "axios";
import router from "@/router.js";

const inputAccount = ref("")
const inputPassword = ref("")

function onLogin() {
  if (inputAccount == null || inputAccount.value.toString().trim().length <= 0) {
    alert("请输入账户")
    return
  }
  if (inputPassword == null || inputPassword.value.toString().trim().length <= 0) {
    alert("请输入密码")
    return
  }
  console.log("onLogin:")
  console.log("inputAccount:" + inputAccount.value)
  console.log("inputPassword:" + inputPassword.value)
  axios.post("http://localhost:8080/user/login", {
    account: inputAccount.value,
    password: inputPassword.value,
  }).then((res) => {
    console.log(res.status)
    console.log(res.data)
    if (res.data.code === 0) {
      toHome()
    }
  }).catch((err) => {
    console.log(err)
  })
}

function toHome() {
  router.push({
    path: "/"
  })
}

function onToRegister() {
  router.push({
    path: "/register"
  })
}
</script>

<template>
  <div class="w-full h-dvh flex flex-col items-center justify-center">
    <div class="w-1/4 flex flex-col">
      <h1 class="text-black font-bold text-2xl">账户登录</h1>
      <input type="text" v-model="inputAccount" class="mt-4 h-10 p-2 focus:outline outline-2 outline-blue-500 rounded"
             placeholder="请输入用户名"/>
      <input type="password" v-model="inputPassword"
             class="mt-2 h-10 p-2 focus:outline outline-2 outline-blue-500 rounded" placeholder="请输入密码"/>
      <button class="mt-4 bg-blue-500 rounded h-10 text-white" @click="onLogin">登录</button>
      <p class="mt-4 text-center">
        还没有账户，去<span class="text-blue-500" @click="onToRegister">注册</span>
      </p>
    </div>
  </div>
</template>

<style scoped>

</style>