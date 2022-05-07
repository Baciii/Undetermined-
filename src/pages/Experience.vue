<template>
  <div class="main">
    <div class="screen">
      <div class="search">
        <div><span>搜索</span> <icon name="search" /></div>
        <div
          class="tdesign-demo-block-column"
          style="max-width: 500px; margin-left: 15px"
        >
          <t-input />
        </div>
      </div>
      <div class="search" style="margin-top: 10px">
        <div><span>筛选</span> <icon name="tips" /></div>
        <div class="tdesign-demo-block-column" style="margin-left: 15px">
          <div>
            <!-- 方式三：组件内置全选功能，使用 `options` 定义选项。选中值: -->
            <!-- {{ value3.join(", ") }} -->
          </div>
          <t-checkbox-group
            v-model="value3"
            :options="options2"
            @change="onChange3"
          />
        </div>
      </div>
      <div class="search">
        <div><span>来源</span> <icon name="cloud-upload" /></div>
        <div class="tdesign-demo-block-column" style="margin-left: 15px">
          <div class="tdesign-demo-block-row">
            <div class="item">
              <t-button theme="primary" shape="round" variant="base"
                >官方</t-button
              >
            </div>
            <div class="item" style="margin-left: 10px">
              <t-button theme="primary" shape="round" variant="base"
                >个人用户</t-button
              >
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="content">
      <ul style="width: 90%">
        <li>
          <t-comment
            avatar="https://tdesign.gtimg.com/site/avatar.jpg"
            author="湘萍"
            datetime="今天16:38"
            content="我是湘萍湘萍是我啦啦啦"
            class="comment"
          >
            <template #actions>
              <span key="thumbUp">
                <icon name="thumb-up" />
                <span class="action-text">6</span>
              </span>
              <span key="chat">
                <icon name="chat" />
                <span class="action-text">回复</span>
              </span>
            </template>
          </t-comment>
        </li>
        <li>
          <t-comment
            avatar="https://tdesign.gtimg.com/site/avatar.jpg"
            author="湘萍"
            datetime="今天16:38"
            content="我是湘萍湘萍是我啦啦啦"
            class="comment"
          >
            <template #actions>
              <span key="thumbUp">
                <icon name="thumb-up" />
                <span class="action-text">6</span>
              </span>
              <span key="chat">
                <icon name="chat" />
                <span class="action-text">回复</span>
              </span>
            </template>
          </t-comment>
        </li>
        <li>
          <t-comment
            avatar="https://tdesign.gtimg.com/site/avatar.jpg"
            author="湘萍"
            datetime="今天16:38"
            content="我是湘萍湘萍是我啦啦啦"
            class="comment"
          >
            <template #actions>
              <span key="thumbUp">
                <icon name="thumb-up" />
                <span class="action-text">6</span>
              </span>
              <span key="chat">
                <icon name="chat" />
                <span class="action-text">回复</span>
              </span>
            </template>
          </t-comment>
        </li>
        <li>
          <t-comment
            avatar="https://tdesign.gtimg.com/site/avatar.jpg"
            author="湘萍"
            datetime="今天16:38"
            content="我是湘萍湘萍是我啦啦啦"
            class="comment"
          >
            <template #actions>
              <span key="thumbUp">
                <icon name="thumb-up" />
                <span class="action-text">6</span>
              </span>
              <span key="chat">
                <icon name="chat" />
                <span class="action-text">回复</span>
              </span>
            </template>
          </t-comment>
        </li>
      </ul>
      <div class="page">
        <t-pagination
          v-model="current"
          :total="100"
          :page-size.sync="pageSize"
          :totalContent="false"
        />
      </div>
    </div>
  </div>
</template>

<script>
import { Icon } from "tdesign-icons-vue";
export default {
  name: "Experience",
  data() {
    return {
      current: 12,
      pageSize: 5,
      value3: ["开发", "测试", "运维"],
      options2: [
        { label: "全选", checkAll: true },
        { value: "开发", label: "开发" },
        // eslint-disable-next-line @typescript-eslint/no-unused-vars
        { value: "测试", label: (h) => <div>测试</div> },
        { value: "运维", label: "运维" },
      ],
    };
  },
  components: {
    Icon,
  },
  computed: {
    checkAll() {
      return this.options1.length === this.value1.length;
    },
    indeterminate() {
      return !!(
        this.options1.length > this.value1.length && this.value1.length
      );
    },
  },
  methods: {
    handleSelectAll(checked) {
      this.value1 = checked ? ["开发", "测试", "运维"] : [];
    },
  },
};
</script>

<style scoped>
.main {
  display: flex;
  flex-wrap: wrap;
  width: 100%;
  height: 1000px;
  justify-content: center;
  align-content: flex-start;
}
li {
  list-style: none;
}
.comment {
  width: 98%;
  margin: 15px auto 30px;
}
.screen {
  width: 98%;
  margin-top: 80px;
  background-color: #fff;
  height: 200px;
  border-bottom: 1.5px solid pink;
}
.action-text {
  display: inline-block;
  margin-left: 6px;
  line-height: 15px;
}
.content {
  display: flex;
  width: 98%;
  height: 100%;
  margin-top: 15px;
  background-color: #fff;
  border-top: 1.5px solid pink;
  flex-direction: column;
  /* justify-content: center; */
  align-items: center;
}
.test {
  width: 200px;
  height: 200px;
  background-color: pink;
}
.screen {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
.search {
  margin-left: 20px;
  height: 30px;
}
.search div {
  display: inline-block;
}
</style>