<template>
  <div>
    <div>
      <guide />
    </div>
    <div class="content">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import { Icon } from "tdesign-icons-vue";
import guide from "./guide.vue";
export default {
  name: "PersonalCenter",
  components: {
    Icon,
    guide,
  },
  data() {
    return {
      visible: false,
    };
  },
  methods: {},
};
</script>

<style scoped>
/* .Centerguide {
  top: 85px;
  left: 0px;
  height: 90%;
  margin-right: 30px;
}*/
.content {
  position: absolute;
  margin-top: 10px;
  right: 10px;
  top: 64px;
  height: calc(100% - 84px);
  /* height: 1000px; */
  width: calc(100% - 262px);
  /* background-color: pink; */
  background-color: #fff;
  justify-content: center;
}
</style>