<template>
  <div>
    <t-head-menu theme="light" v-model="menu1Value" @change="changeHandler">
      <template #logo>
        <img width="110" src="../assets/logo.png" alt="logo" />
      </template>
      <t-menu-item value="item1" @click="push1">技术讨论</t-menu-item>
      <t-menu-item value="item2" @click="push2">面经分享</t-menu-item>
      <t-menu-item value="item3" @click="push3">个人主页</t-menu-item>
      <!-- <t-menu-item value="item4" :disabled="true">禁用菜单</t-menu-item> -->
      <template #operations>
        <a href="javascript:;"
          ><icon class="t-menu__operations-icon" name="search"
        /></a>
        <a href="javascript:;"
          ><icon class="t-menu__operations-icon" name="mail"
        /></a>
        <a href="javascript:;"
          ><icon class="t-menu__operations-icon" name="user"
        /></a>
        <a href="javascript:;"
          ><icon class="t-menu__operations-icon" name="ellipsis"
        /></a>
      </template>
    </t-head-menu>
    <hr />
    <hr />
    <router-view></router-view>
  </div>
</template>

<script>
import { Icon } from "tdesign-icons-vue";

export default {
  name: "homepage",
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
      this.$router.push({ name: "PersonalCenter" });
    },
  },
};
</script>

<style>
body {
  background-color: #f0f5f5;
}
</style>
