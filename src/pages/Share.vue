<template>
  <div class="main">
    <ShareGuide />
    <div class="content">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import { Icon } from "tdesign-icons-vue";
import ShareGuide from "./ShareGuide.vue";
export default {
  name: "Share",
  components: {
    Icon,
    ShareGuide,
  },
};
</script>

<style scoped>
.box {
  height: calc(100% - 84px);
}
.content {
  position: absolute;
  margin-top: 10px;
  right: 10px;
  top: 64px;
  /* height: calc(100% - 84px); */
  height: 1000px;
  width: calc(100% - 262px);
  /* background-color: pink; */
  background-color: #fff;
  justify-content: center;
}
</style>