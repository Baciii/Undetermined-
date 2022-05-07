<template>
  <div class="top">
    <t-head-menu
      theme="light"
      v-model="menu1Value"
      @change="changeHandler"
      class="header"
    >
      <template #logo>
        <img width="80px" src="../assets/logo.png" alt="logo" />
      </template>
      <t-menu-item value="item4" @click="push1">技术讨论</t-menu-item>
      <t-menu-item value="item2" @click="push2">面经分享</t-menu-item>
      <t-menu-item value="item5" @click="push5">资料共享</t-menu-item>
      <t-menu-item value="item3" @click="push3" :disabled="true"
        >内推咨询</t-menu-item
      >
      <t-menu-item value="item1" @click="push4">个人主页</t-menu-item>
      <!-- <t-menu-item value="item4" :disabled="true">禁用菜单</t-menu-item> -->
      <template #operations>
        <a href="https://github.com/Baciii/Undetermined-" target="_blank"
          ><icon class="t-menu__operations-icon" name="logo-github-filled"
        /></a>
        <a href="javascript:;" @click="nofinish"
          ><icon class="t-menu__operations-icon" name="search"
        /></a>
        <a href="javascript:;" @click="nofinish"
          ><icon class="t-menu__operations-icon" name="usergroup-add"
        /></a>
        <a href="javascript:;" @click="push4" value="item1"
          ><icon class="t-menu__operations-icon" name="user"
        /></a>
        <a href="javascript:;" @click="nofinish"
          ><icon class="t-menu__operations-icon" name="ellipsis"
        /></a>
      </template>
    </t-head-menu>
  </div>
</template>

<script>
import { Icon } from "tdesign-icons-vue";

export default {
  name: "top",
  components: {
    Icon,
  },
  data() {
    return {
      menu1Value: "item1",
    };
  },
  methods: {
    changeHandler(active) {
      console.log("change", active);
    },
    push1() {
      this.$router.push({ name: "Technology" });
    },
    push2() {
      this.$router.push({ name: "Experience" });
    },
    push3() {
      this.$router.push({ name: "Recommend" });
    },
    push4() {
      this.$router.push({ name: "PersonalInformation" });
    },
    push5() {
      this.$router.push({ name: "Share" });
    },
    nofinish() {
      alert("别催了，在写了在写了");
    },
  },
};
</script>

<style scoped>
.top {
  /* position: fixed; */
  /* position: absolute; */
  /* position: sticky; */
  /* position: sticky; */
  position: fixed;
  width: 100%;
  top: -0.1px;
  z-index: 999;
}
</style>