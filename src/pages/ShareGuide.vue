<template>
  <div class="box">
    <t-menu
      theme="light"
      defaultValue=""
      style="margin-left: 10px; margin-top: 10px"
      expandMutex:true
      :defaultExpanded="expanded"
      :collapsed="collapsed"
    >
      <t-submenu title="学科知识" value="3">
        <template #icon>
          <icon name="app" />
        </template>
        <t-menu-item value="3-1">高数</t-menu-item>
        <t-menu-item value="3-2">现代</t-menu-item>
        <t-menu-item value="3-3">概率论</t-menu-item>
      </t-submenu>

      <t-submenu title="专业方向" value="4">
        <template #icon>
          <icon name="star" />
        </template>
        <t-menu-item value="4-1">计算机</t-menu-item>
        <t-menu-item value="4-2">设计</t-menu-item>
        <t-menu-item value="4-3">机械</t-menu-item>
      </t-submenu>
      <t-submenu title="编程语言" value="5">
        <template #icon>
          <icon name="laptop" />
        </template>
        <t-menu-item value="5-1">JavaScript</t-menu-item>
        <t-menu-item value="5-2">C</t-menu-item>
        <t-menu-item value="5-3">C++</t-menu-item>
        <t-menu-item value="5-4">Java</t-menu-item>
        <t-menu-item value="5-5">Golang</t-menu-item>
        <t-menu-item value="5-6">Python</t-menu-item>
        <t-menu-item value="5-7">TypeScript</t-menu-item>
      </t-submenu>
      <t-menu-item value="edit1">
        <template #icon>
          <icon name="edit-1" />
        </template>
        资源编辑
      </t-menu-item>
      <template #operations>
        <icon
          class="t-menu__operations-icon"
          name="view-list"
          @click.native="changeCollapsed"
        />
      </template>
    </t-menu>
  </div>
</template>

<script>
import { Icon } from "tdesign-icons-vue";
export default {
  name: "ShareGuide",
  components: {
    Icon,
  },
  data() {
    return {
      expanded: ["2", "3"],
      disabled: true,
      collapsed: false,
    };
  },
  methods: {
    changeCollapsed() {
      this.collapsed = !this.collapsed;
    },
  },
};
</script>

<style>
.box {
  position: fixed;
  height: calc(100% - 84px);
  top: 64px;
}
</style>