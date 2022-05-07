<template>
  <!-- 232 64 -->
  <div>
    <t-dialog
      header="退出登录"
      body="您确定退出登录吗？"
      :visible.sync="visible"
      @confirm="onConfirm"
      :onConfirm="onConfirmAnother"
      :onCancel="onCancel"
      :onEscKeydown="onKeydownEsc"
      :onCloseBtnClick="onClickCloseBtn"
      :onOverlayClick="onClickOverlay"
      :onClose="close"
    ></t-dialog>
    <div class="box">
      <t-menu
        theme="light"
        defaultValue="2-1"
        style="margin-left: 10px; margin-top: 10px"
        :expanded="expanded2"
        @expand="expanded2 = $event"
        :collapsed="collapsed2"
      >
        <t-menu-item value="user-circle" @click="inf">
          <template #icon>
            <icon name="user-circle" />
          </template>
          个人中心
        </t-menu-item>

        <t-menu-item value="resource">
          <template #icon>
            <icon name="star-filled" />
          </template>
          收藏列表
        </t-menu-item>

        <t-menu-item value="root">
          <template #icon>
            <icon name="root-list" />
          </template>
          我的问答
        </t-menu-item>

        <t-submenu title="浏览历史" value="1">
          <template #icon>
            <icon name="chart-pie" />
          </template>
          <t-menu-item value="1-1">技术讨论</t-menu-item>
          <t-menu-item value="1-2">面经分享</t-menu-item>
        </t-submenu>

        <t-menu-item value="user-add">
          <template #icon>
            <icon name="user-add" />
          </template>
          我的好友
        </t-menu-item>

        <t-menu-item value="heart-filled">
          <template #icon>
            <icon name="heart-filled" />
          </template>
          感兴趣的
        </t-menu-item>

        <t-menu-item value="folder-add">
          <template #icon>
            <icon name="folder-add" />
          </template>
          资源分享
        </t-menu-item>

        <t-menu-item value="poweroff" @click="visible = true">
          <template #icon>
            <icon name="poweroff" />
          </template>
          退出登录
        </t-menu-item>

        <template #operations>
          <icon
            class="t-menu__operations-icon"
            name="view-list"
            @click.native="changeCollapsed2"
          />
        </template>
      </t-menu>
    </div>
  </div>
</template>

<script>
import { Icon } from "tdesign-icons-vue";

export default {
  components: {
    Icon,
  },
  data() {
    return {
      expanded: ["2", "3"],
      expanded2: ["2"],
      disabled: true,
      collapsed: false,
      collapsed2: false,
      visible: false,
    };
  },
  methods: {
    changeCollapsed() {
      this.collapsed = !this.collapsed;
    },
    changeCollapsed2() {
      this.collapsed2 = !this.collapsed2;
    },
    inf() {
      this.$router.push({ name: "PersonalInformation" });
    },
    onConfirm(context) {
      console.log(
        "@confirm与onConfirm任选一种方式即可，其他几个事件类似",
        context
      );
      this.visible = false;
    },
    onConfirmAnother(context) {
      console.log("退出登录", context);
    },
    close(context) {
      console.log("关闭弹窗，点击关闭按钮、按下ESC、点击蒙层等触发", context);
    },
    onCancel(context) {
      console.log("点击了取消按钮", context);
    },
    onKeydownEsc(context) {
      console.log("按下了ESC", context);
    },
    onClickCloseBtn(context) {
      console.log("点击了关闭按钮", context);
    },
    onClickOverlay(context) {
      console.log("点击了蒙层", context);
    },
  },
};
</script>

<style>
.box {
  position: absolute;
  height: calc(100% - 84px);
}
.off {
  z-index: 100;
}
</style>