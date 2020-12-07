<template>
  <div class="login_banner_panel">
    <div class="login-body">
      <div class="nav_tabs_panel">
        <div class="nav-tabs">
          <span
            class="navtab-link"
            :class="{ active: isCurrent }"
            @click="chooseLoginType('account')"
          >
            帐号登录
          </span>
          <span class="line"></span>
          <span
            class="navtab-link"
            :class="{ active: !isCurrent }"
            @click="chooseLoginType('code')"
          >
            扫码登录
          </span>
        </div>
        <div class="tabs-content" v-show="isCurrent">
          <div class="login" v-show="isLogin">
            <el-form :model="loginForm" ref="loginform">
              <el-form-item>
                <el-input
                  v-model="loginForm.username"
                  placeholder="邮箱/手机号码/小米ID"
                >
                </el-input>
              </el-form-item>
              <el-form-item>
                <el-input v-model="loginForm.password" placeholder="密码">
                </el-input>
              </el-form-item>
              <el-form-item>
                <el-button class="login-button" @click="handleLogin">
                  登录
                </el-button>
              </el-form-item>
            </el-form>
            <span
              class="login-type-link"
              @click="changeLoginOrRegStatus('register')"
            >
              手机短信登录/注册
            </span>
            <div class="reverse">
              <router-link to="/register" class="btn">立即注册</router-link>
              <span class="interval">|</span>
              <span>忘记密码?</span>
            </div>
          </div>
          <div class="register" v-show="!isLogin">
            <el-form :model="registerForm" ref="loginform">
              <el-form-item>
                <el-input v-model="registerForm.phone" placeholder="手机号码">
                  <template slot="prepend">+86</template>
                </el-input>
              </el-form-item>
              <el-form-item>
                <el-input
                  v-model="registerForm.password"
                  placeholder="短信验证码"
                >
                  <template slot="append">获取验证码</template>
                </el-input>
              </el-form-item>
              <el-form-item>
                <el-button class="login-button" @click="handleLoginRegister">
                  立即登录/注册
                </el-button>
              </el-form-item>
            </el-form>
            <span
              class="login-type-link"
              @click="changeLoginOrRegStatus('login')"
            >
              用户号密码登录
            </span>
            <div class="reverse">
              <span>收取不到验证码?</span>
            </div>
          </div>
          <div class="other_login_type">
            <i class="iconfont icon-logo-qq"></i>
            <i class="iconfont icon-yduixinlangweibo"></i>
            <i class="iconfont icon-zhifubao"></i>
            <i class="iconfont icon-logo-wechat"></i>
          </div>
        </div>
        <div class="tabs-content-code" v-show="!isCurrent">
          <div class="code">
            <span>隐形二维码</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { LoginApi } from "@/api";
export default {
  name: "LoginMain",
  data() {
    return {
      activeName: "first",
      isCurrent: true,
      isLogin: true,
      loginForm: {
        username: "",
        password: ""
      },
      registerForm: {
        username: "",
        password: "",
        rePassword: "",
        phone: "",
        email: ""
      }
    };
  },
  methods: {
    /**
     * 切换登录方式
     * @author Jack
     * @param type 类型
     */
    chooseLoginType(type) {
      type === "account" ? (this.isCurrent = true) : (this.isCurrent = false);
    },
    /**
     * 切换登录或注册登录
     * @author Jack
     * @param type 类型
     */
    changeLoginOrRegStatus(type) {
      type === "login" ? (this.isLogin = true) : (this.isLogin = false);
    },
    /**
     * 登录
     * @author Jack
     * @param 无
     */
    handleLogin() {
      LoginApi.login(this.loginForm).then(res => {
        if (res.data.code === 200) {
          this.$router.push("/");
        }
      });
    },
    /**
     * 注册和登录
     * @author Jack
     * @param 无
     */
    handleLoginRegister() {
      console.log("注册和登录");
    }
  }
};
</script>

<style lang="scss" scoped>
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
    .other_login_type {
      height: 30px;
      text-align: center;
      cursor: pointer;
      padding-top: 143px;
      i {
        font-size: 32px;
        margin: 0 17px;
      }
      .icon-logo-qq {
        color: #0288d1;
      }
      .icon-yduixinlangweibo {
        color: #d32f2f;
      }
      .icon-zhifubao {
        color: #0ae;
      }
      .icon-logo-wechat {
        color: #00d20d;
      }
    }
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
    cursor: pointer;
    margin-bottom: 30px;
  }
  .reverse {
    color: #999;
    display: block;
    text-align: center;
    font-size: 14px;
    .btn,
    span {
      cursor: pointer;
    }
    .btn:hover,
    span:hover {
      color: $textHover;
    }
    .interval {
      padding: 0 5px;
    }
  }
  .tabs-content-code {
    width: 348px;
    margin: 0 auto;
    display: flex;
    justify-content: center;
    .code {
      width: 260px;
      height: 260px;
      position: relative;
      background: #dddddd;
      span {
        color: #757575;
        font-size: 12px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
      }
    }
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
    border: 1px solid #e0e0e0;
  }
  & .el-input.is-active .el-input__inner,
  .el-input__inner:focus {
    border-color: #e0e0e0;
  }
  & .el-button:active {
    border-color: $colorHover;
  }
  & .el-input-group__append,
  .el-input-group__prepend {
    background-color: #ffffff;
  }
  & .el-input-group__prepend {
    color: #333333;
  }
  & .el-input-group__append {
    cursor: pointer;
    color: #003ab5;
  }
}
</style>
