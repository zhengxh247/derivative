<template>
  <div class="hello">
    <div>{{ msg }}</div>
    <el-button type="primary">测试按钮</el-button>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  props: {
    msg: String
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss"></style>
