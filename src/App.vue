<template>
  <div>
    <router-view></router-view>
  </div>
</template>

<script>
// import HelloWorld from "./components/HelloWorld.vue";
import login from "./components/login.vue";
import homepage from "./components/homepage.vue";
import Vue from "vue";

export default {
  name: "App",
  components: {
    login,
    homepage,
  },
  beforeCreate() {
    Vue.prototype.$bus = this;
  },
};
</script>

<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
</style>
