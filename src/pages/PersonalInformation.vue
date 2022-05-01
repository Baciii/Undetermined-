<template>
  <div>
    <div class="demo-avatar">
      <div class="demo-avatar-block">
        <t-avatar size="100px">W</t-avatar>
      </div>
    </div>
    <t-loading></t-loading>
    <div class="tdesign-demo-block-column" style="width: 80%">
      <t-tag-input
        :value="tags1"
        label="擅长领域: "
        clearable
        @change="onChange"
      />
    </div>
  </div>
</template>

<script>
export default {
  name: "PersonalInformation",
  data() {
    return {
      tags1: ["Vue", "React"],
      inputValue: "",
    };
  },
  methods: {
    onChange(val, context) {
      console.log(val, context);
      this.tags1 = val;
    },
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
</style>