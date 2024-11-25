<script setup>
import {ref} from "vue";
import axios from "axios";
import router from "@/router.js";

const inputAccount = ref("")
const inputPassword = ref("")
const inputConfirmPassword = ref("")

function onRegister() {
  console.log("[onRegister]inputAccount:" + inputAccount.value)
  console.log("[onRegister]inputPassword:" + inputPassword.value)
  console.log("[onRegister]inputConfirmPassword:" + inputConfirmPassword.value)
  if (inputAccount.value.toString().trim().length <= 0) {
    alert("请输入账户")
    return
  }
  const pw1 = inputPassword.value.toString().trim()
  if (pw1 <= 0) {
    alert("请输入密码")
    return
  }
  let pw2 = inputConfirmPassword.value.toString().trim()
  if (pw1 !== pw2) {
    alert("两次密码不一致，请确认后再输入")
    return
  }
  axios.post("http://localhost:8080/user/register", {
    account: inputAccount.value,
    password: pw1,
  }).then((res) => {
    console.log(res.status)
    console.log(res.data)
    if (res.data.code === 0) {
      onToLogin()
    }
  }).catch((err) => {
    console.log(err)
  })
}

function onToLogin(account) {
  console.log("[onRegister]onToLogin:" + onToLogin)
  router.push({
    path: "/login"
  })
}
</script>

<template>
  <div class="w-full h-dvh flex flex-col items-center justify-center">
    <div class="w-1/4 flex flex-col">
      <h1 class="text-black font-bold text-2xl">账户注册</h1>
      <input type="text" v-model="inputAccount" class="mt-4 h-10 p-2 focus:outline outline-2 outline-blue-500 rounded"
             placeholder="请输入用户名"/>
      <input type="password" v-model="inputPassword"
             class="mt-2 h-10 p-2 focus:outline outline-2 outline-blue-500 rounded" placeholder="请输入密码"/>
      <input type="password" v-model="inputConfirmPassword"
             class="mt-2 h-10 p-2 focus:outline outline-2 outline-blue-500 rounded" placeholder="请再次确认密码"/>
      <button class="mt-4 bg-blue-500 rounded h-10 text-white" @click="onRegister">注册</button>
      <p class="mt-4 text-center">
        已有账户，去<span class="text-blue-500" @click="onToLogin">登录</span>
      </p>
    </div>
  </div>
</template>

<style scoped>

</style>