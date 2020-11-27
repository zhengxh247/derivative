<template>
  <div class="login-container">
    <div class="login-header">
      <div class="header-logo"></div>
    </div>
    <div class="login_banner_panel">
      <div class="login-body">
        <div class="nav_tabs_panel">
          <div class="nav-tabs">
            <span
              class="navtab-link"
              :class="{ active: isCurrent }"
              @click="chooseNow"
            >
              帐号登录
            </span>
            <span class="line"></span>
            <span
              class="navtab-link"
              :class="{ active: !isCurrent }"
              @click="chooseNow"
            >
              扫码登录
            </span>
          </div>
          <div class="tabs-content">
            <el-form :model="form" ref="loginform">
              <el-form-item>
                <el-input
                  v-model="form.name"
                  placeholder="邮箱/手机号码/小米ID"
                >
                </el-input>
              </el-form-item>
              <el-form-item>
                <el-input v-model="form.name" placeholder="密码"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button class="login-button">登录</el-button>
              </el-form-item>
            </el-form>
            <span class="login-type-link">手机短信登录/注册</span>
            <div class="reverse">
              <span>立即注册</span>
              <span class="interval">|</span>
              <span>忘记密码?</span>
            </div>
            <div class="other_login_type">
              <i></i>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="login-footer">
      <div class="nf-link-area ">
        <ul>
          <li><span>简体</span>|</li>
          <li><span>繁体</span>|</li>
          <li><span>English</span>|</li>
          <li><span>常见问题</span>|</li>
          <li><span>隐私政策</span></li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeName: "first",
      isCurrent: true,
      form: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    chooseNow() {
      this.isCurrent = !this.isCurrent;
    }
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
  width: 100%;
  height: 588px;
  min-width: 700px;
  background: url("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/72644d9b8031286de3cc74e151aefd90.jpg")
    no-repeat;
  background-position: top center;
}
.login-body {
  position: relative;
  height: 588px;
  width: 1130px;
  margin: 0 auto;
}
.nav_tabs_panel {
  position: absolute;
  width: 410px;
  min-height: 556px;
  top: 32px;
  right: 0px;
  background: #fff;

  .nav-tabs {
    padding: 27px 0 24px;
    text-align: center;
    font-size: 24px;
    .navtab-link {
      color: #666;
      cursor: pointer;
    }
    .navtab-link:hover,
    .active {
      color: #f56600;
    }
    .line {
      width: 1px;
      height: 24px;
      margin: 0 42px 0 35px;
      border: 1px solid #e0e0e0;
      background: #e0e0e0;
    }
  }
  .tabs-content {
    width: 348px;
    margin: 0 auto;
  }
  .login-button {
    width: 100%;
    height: 50px;
    line-height: 50px;
    margin-top: 10px;
    padding: 0;
    color: #fff;
    background-color: #ff6700;
  }
  .login-type-link {
    margin-top: -5px;
    display: block;
    font-size: 14px;
    text-align: center;
    color: #ff6700;
  }
  .reverse {
    color: #999;
    display: block;
    text-align: center;
    font-size: 14px;
    .interval {
      padding: 0 5px;
    }
  }
}
.login-footer {
  background: #fff;
  height: 80px;
  margin-top: 100px;
  color: #757575;
  text-align: center;
  font-size: 14px;
  font-family: Helvetica, arial, "MI Lan Pro", "Hiragino Sans GB", "PingFang SC",
    "Microsoft YaHei", "微軟正黑體", "儷黑 Pro", sans-serif;
  & ul > li {
    display: inline-block;
  }
  & ul > li > span {
    padding: 0 10px;
  }
}
</style>

<style lang="scss">
.tabs-content {
  & .el-form-item {
    margin-bottom: 14px;
  }
  & .el-input__inner {
    height: 48px;
  }
  & .el-button:active {
    border-color: #ff6700;
  }
}
</style>
