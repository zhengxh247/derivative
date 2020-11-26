<template>
  <div class="login-container">
    <div class="login-header">
      <div class="header-logo"></div>
    </div>
    <div class="login_banner_panel"></div>
    <div class="login-form">
      <div class="nav_tabs_panel">
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="用户管理" name="first"></el-tab-pane>
          <el-tab-pane label="配置管理" name="second"></el-tab-pane>
        </el-tabs>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeName: "first"
    };
  },
  methods: {
    handleClick() {}
  }
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
  background: url(https://account.xiaomi.com/static/res/7f6f2f5/account-static/respassport/acc-2014/img/mistore_logo.png)
    no-repeat;
}
.login_banner_panel {
  position: absolute;
  width: 100%;
  height: 588px;
  background: url("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/72644d9b8031286de3cc74e151aefd90.jpg")
    no-repeat;
  background-position: top center;
}
.login-form {
  position: absolute;
  width: 410px;
  min-height: 556px;
  top: 130px;
  right: 395px;
  background: #ffffff;
}
</style>
