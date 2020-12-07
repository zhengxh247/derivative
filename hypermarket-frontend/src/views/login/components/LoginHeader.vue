<template>
  <div class="login-header">
    <div class="header-logo">
      <a href="https://www.mi.com/index.html" target="_blank">
        小米官网
      </a>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginHeader"
};
</script>

<style lang="scss" scoped>
.login-header {
  width: 1130px;
  margin: 0 auto;
}
.header-logo {
  width: 200px;
  height: 98px;
  background: url("../../../assets/images/logo.png") no-repeat;
  a {
    display: block;
    height: 98px;
    text-indent: -9999em;
  }
}
</style>
