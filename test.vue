<template>
  <div>
    <button @click="getmessage">admin</button>
  </div>
</template>

<script>
export default {
  name: "test",
  methode: {
    getmessage() {
      //请求前缀在端口号后写
      axios.get("http://localhost:8080/api/admin").then(
        (response) => {
          console.log("成功", response.data);
        },
        (error) => {
          console.log("失败", error.message);
        }
      );
    },
    getregister() {
      axios.get("http://localhost:8080/demo/register").then(
        (response) => {
          console.log("成功", response.data);
        },
        (error) => {
          console.log("失败", error.message);
        }
      );
    },
  },
};
</script>

<style>
</style>