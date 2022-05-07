<template>
  <div class="main">
    <div class="maininf">
      <!-- 头像 -->
      <div class="demo-avatar head-portrait">
        <div class="demo-avatar-block">
          <t-avatar size="100px"
            ><img src="../../img/1.jpg" alt="" class="touxiang"
          /></t-avatar>
        </div>
      </div>
      <span class="nickname" :style="{ opacity }">xpの旨意</span>
      <div
        class="item tdesign-demo-block-row tdesign-demo-block-column changeinf"
      >
        <t-button
          theme="primary"
          shape="round"
          variant="base"
          @click="changeinf"
          >修改个人信息</t-button
        >
      </div>
      <div
        class="item tdesign-demo-block-row tdesign-demo-block-column setting"
      >
        <t-button theme="primary" shape="round" variant="base">设置</t-button>
      </div>
    </div>
    <!-- 标签数量超出时，换行显示 -->
    <div class="tdesign-demo-block-column Tip" style="width: 98%">
      <t-tag-input
        v-model="tags"
        label="个人标签: "
        excess-tags-display-type="break-line"
        clearable
        class="PersonalTip"
      />
    </div>
    <div class="tdesign-demo-block-column synopsis">
      <t-textarea
        v-model="synopsis"
        placeholder="介绍一下你自己吧："
        name="description"
        :autosize="{ minRows: 3, maxRows: 5 }"
      />
    </div>
    <!-- <t-loading></t-loading> -->
  </div>
</template>

<script>
import { Icon } from "tdesign-icons-vue";
export default {
  name: "PersonalInformation",
  data() {
    return {
      tags1: ["Vue", "React"],
      inputValue: "",
      opacity: 1,
      tags: ["Vue", "React"],
      synopsis: "",
    };
  },
  components: {
    Icon,
  },
  methods: {
    onChange(val, context) {
      console.log(val, context);
      this.tags1 = val;
    },
    changeinf() {
      this.$router.push({ name: "ChangeInf" });
    },
  },
  mounted() {
    setInterval(() => {
      this.opacity -= 0.01;
      if (this.opacity <= 0) {
        this.opacity = 1;
      }
    }, 16);
  },
};
</script>

<style lang="less" scoped>
.demo-avatar {
  .demo-avatar-block:first-child {
    margin-bottom: 40px;
  }
  .t-avatar {
    margin-right: 40px;
  }
}
.head-portrait {
  position: absolute;
  left: 60px;
  top: 30px;
}
.setting {
  display: inline-block;
  position: absolute;
  top: 50px;
  right: 30px;
}
.nickname {
  position: absolute;
  display: inline-block;
  font-size: large;
  color: darkred;
  left: 180px;
  top: 60px;
  width: 150px;
  height: 50px;
  line-height: 50px;
  padding-left: 5px;
  padding-right: 5px;
  text-align: center;
  // border: 1px solid;
  // background-color: rgba(189, 140, 172);
  border-radius: 25px;
}
.main {
  display: flex;
  height: 100px;
  width: 100%;
  justify-content: center;
  flex-wrap: wrap;
}
.maininf {
  border-bottom: 1.5px solid pink;
  width: 98%;
  height: 150px;
  margin-top: 10px;
}
.changeinf {
  display: inline-block;
  position: absolute;
  top: 50px;
  right: 100px;
}
.touxiang {
  width: 250px;
  height: 250px;
}
.Tip {
  margin-top: 10px;
}
.synopsis {
  margin-top: 10px;
  width: 98%;
}
</style>