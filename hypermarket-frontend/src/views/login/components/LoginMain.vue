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
            {{ $t("route.signIn") }}
          </span>
          <span class="line"></span>
          <span
            class="navtab-link"
            :class="{ active: !isCurrent }"
            @click="chooseLoginType('code')"
          >
            {{ $t("route.scanQrCode") }}
          </span>
        </div>
        <div class="tabs-content" v-show="isCurrent">
          <div class="login" v-show="isLogin">
            <el-form
              :model="loginForm"
              :rules="rules"
              ref="loginForm"
              hide-required-asterisk
            >
              <el-form-item prop="phone">
                <el-input
                  v-model="loginForm.phone"
                  :placeholder="$t('route.email_Phone_ID')"
                >
                </el-input>
              </el-form-item>
              <el-form-item prop="password">
                <el-input
                  type="password"
                  v-model="loginForm.password"
                  :placeholder="$t('route.loginPwd')"
                >
                </el-input>
              </el-form-item>
              <el-form-item>
                <el-button class="login-button" @click="handleLogin">
                  {{ $t("route.loginBtn") }}
                </el-button>
              </el-form-item>
            </el-form>
            <span
              class="login-type-link"
              @click="changeLoginOrRegStatus('register')"
            >
              {{ $t("route.loginMode") }}
            </span>
            <div class="reverse">
              <router-link to="/register" class="btn">
                {{ $t("route.registering") }}
              </router-link>
              <span class="interval">|</span>
              <span>{{ $t("route.forgotPassword") }}?</span>
            </div>
          </div>
          <div class="register" v-show="!isLogin">
            <el-form :model="registerForm" :rules="rules" ref="registerForm">
              <el-form-item prop="phone">
                <el-input v-model="registerForm.phone" placeholder="手机号码">
                  <template slot="prepend">+86</template>
                </el-input>
              </el-form-item>
              <el-form-item prop="authCode">
                <el-input
                  v-model="registerForm.authCode"
                  placeholder="短信验证码"
                  maxlength="6"
                >
                  <el-button
                    slot="append"
                    :loading="loading"
                    :disabled="btnDisabled"
                    class="clear-active"
                    :class="{ clearColor: btnDisabled }"
                    @click="getAuthCode"
                  >
                    {{ authCodeText }}
                  </el-button>
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
import { phoneValidation } from "@/common/utils";
import Message from "@/common/tool";
export default {
  name: "LoginMain",
  data() {
    const phoneRequired = (rule, value, callback) => {
      if (value === "") {
        callback(new Error(this.$t("route.phoneRequired")));
      } else {
        callback();
      }
    };
    return {
      activeName: "first",
      isCurrent: true,
      isLogin: true,
      loading: false,
      btnDisabled: false,
      authCodeText: "获取验证码",
      time: 60,
      loginForm: {
        phone: "",
        password: ""
      },
      registerForm: {
        phone: "",
        authCode: ""
      },
      rules: {
        phone: [
          {
            required: true,
            validator: phoneRequired,
            trigger: "blur"
          },
          {
            validator: phoneValidation,
            trigger: "blur"
          }
        ],
        password: [
          {
            required: true,
            message: this.$t("route.pwdRequired"),
            trigger: "blur"
          }
        ],
        authCode: [
          {
            required: true,
            message: "请输入验证码",
            trigger: "blur"
          }
        ]
      }
    };
  },
  watch: {
    "$i18n.locale": function() {
      this.$refs["loginForm"].fields.forEach(item => {
        if (item.validateState === "error") {
          this.$refs["loginForm"].validateField(item.labelFor);
        }
      });
    }
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
      this.$refs["loginForm"].validate(valid => {
        if (valid) {
          const data = {
            username: this.loginForm.phone,
            password: this.loginForm.password
          };
          LoginApi.login(data).then(res => {
            if (res.data.code === 200) {
              Message(res.data.message, "success");
              this.$refs["loginForm"].resetFields();
              this.$router.push("/");
            } else {
              Message(res.data.message, "error");
            }
          });
        } else {
          return false;
        }
      });
    },
    /**
     * 获取验证码
     * @author Jack
     * @param 无
     */
    getAuthCode() {
      if (!this.registerForm.phone) {
        Message("请先输入手机号", "error");
        return false;
      }
      this.loading = true;
      let onOff = true;
      const param = {
        mobile: this.registerForm.phone
      };
      const timer = setInterval(_ => {
        if (this.time === 60 && onOff) {
          LoginApi.getAuthCode(param).then(res => {
            if (!res.status === 200) {
              Message("验证码发送失败", "error");
            }
          });
          onOff = false;
        } else if (!this.time) {
          this.authCodeText = "获取验证码";
          this.time = 60;
          this.btnDisabled = false;
          clearInterval(timer);
        } else {
          this.loading = false;
          this.btnDisabled = true;
          this.authCodeText = `${--this.time}s重新发送`;
        }
      }, 1000);
    },
    /**
     * 注册和登录
     * @author Jack
     * @param 无
     */
    handleLoginRegister() {
      this.$refs["registerForm"].validate(valid => {
        if (valid) {
          const data = {
            mobilePhone: this.registerForm.phone,
            smsCode: this.registerForm.authCode
          };
          LoginApi.authCodeLogin(data).then(res => {
            if (res.data.code === 200) {
              Message(res.data.message, "success");
              this.$refs["registerForm"].resetFields();
              this.$router.push("/");
            } else {
              Message(res.data.message, "error");
            }
          });
        } else {
          return false;
        }
      });
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
    .register {
      .clear-active:active {
        border-color: transparent;
      }
      .clearColor {
        color: #999;
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
    color: #003ab5;
  }
  & .el-form-item__error {
    top: -18px;
    bottom: auto;
    left: auto;
    right: 0;
  }
}
</style>
