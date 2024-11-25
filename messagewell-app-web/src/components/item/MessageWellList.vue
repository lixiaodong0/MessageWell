<script setup>

import {ref} from "vue";

let data = ref([
  {
    content: "呵呵哈哈哈"
  },
  {
    content: "生成的入口 HTML 文件（可能会在 SSR 中被处理）"
  },
  {
    content: "生成的带有 hash 值的文件（JS、CSS 以及其他文件类型，如图片）"
  },
  {
    content: "拷贝的 公共文件"
  },
  {
    content: "使用这些grid-cols-*实用程序创建具有n 个大小相等的列的网格。"
  },
  {
    content: "要使 HTML 元素变成一个网格容器，可以将 display 属性设置为 grid 或 inline-grid"
  },
  {
    content: "网格容器内放置着由列和行内组成的网格元素。"
  },
  {
    content: "grid-template-columns 属性"
  },
  {
    content: "对更高级的使用场景，被部署的资源和公共文件可能想要分为不同的路径，例如使用不同缓存策略的场景。 一个用户可能以三种不同的路径部署下列文件"
  }
])

</script>

<template>
  <div class="w-full grid grid-cols-3 gap-4">
    <div v-for="item in data" class="bg-red-50 rounded-lg h-40 p-2">
      <span>{{ item.content }}</span>
    </div>
  </div>
</template>

<style scoped>

</style>