<script setup>
import {ref} from "vue";
import MessageWellList from "@/components/item/MessageWellList.vue";
import PushMsgWellContainer from "@/components/item/PushMsgWellContainer.vue";
import PublishMsgWellSvg from "@/components/icons/PublishMsgWellSvg.vue";

</script>

<template>
  <div class="flex flex-col">
    <div class="flex flex-row">
      <a href="/register">注册</a>
      <a href="/login">登录</a>
    </div>
    <MessageWellList/>
    <PushMsgWellContainer/>
    <PublishMsgWellSvg/>
  </div>
</template>

<style scoped>

</style>