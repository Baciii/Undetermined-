<template>
  <div>
    <div class="head">
      <top />
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
import { Icon } from "tdesign-icons-vue";
import top from "../pages/top.vue";

export default {
  name: "homepage",
  components: {
    Icon,
    top,
  },
};
</script>

<style>
body {
  background-color: #f0f5f5;
}
</style>
