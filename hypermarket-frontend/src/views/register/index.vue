<template>
  <div class="register-container">
    <div class="wrapper">
      <div class="wrap">
        <div class="layout">
          <div class="logo">
            <a href="javascript:;" class="hand-logo"></a>
          </div>
          <div class="title-item">
            注册剁手账号
          </div>
          <div class="regbox">
            <el-form :model="registerForm" ref="loginform">
              <el-form-item label="手机号码">
                <el-input v-model="registerForm.phone">
                  <template slot="prepend">+86</template>
                </el-input>
              </el-form-item>
              <el-form-item label="密码">
                <el-input v-model="registerForm.password"></el-input>
              </el-form-item>
              <el-form-item label="确认密码">
                <el-input v-model="registerForm.repassword"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button class="res-button">立即注册</el-button>
              </el-form-item>
            </el-form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Register",
  data() {
    return {
      registerForm: {
        phone: "",
        password: "",
        repassword: ""
      }
    };
  }
};
</script>

<style lang="scss" scoped>
.register-container {
  width: 100%;
  height: 100vh;
  min-height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #f9f9f9;
  .wrapper {
    width: 854px;
    margin: 0 auto;
    .layout {
      background: #fff;
      min-height: 400px;
      .logo {
        padding-bottom: 40px;
        .hand-logo {
          width: 61px;
          height: 59px;
          margin: 0 auto;
          display: block;
          background: url("../../assets/images/handlogo.png") no-repeat;
        }
      }
      .title-item {
        text-align: center;
        color: #333;
        font-size: 30px;
      }
      .regbox {
        width: 332px;
        padding: 30px 0;
        margin: 0 auto;
        .res-button {
          width: 100%;
          height: 50px;
          line-height: 50px;
          margin-top: 10px;
          padding: 0;
          color: #fff;
          background-color: #ff6700;
        }
      }
    }
  }
}
</style>

<style lang="scss">
.regbox {
  .el-form-item {
    margin-bottom: 0;
  }
}
</style>
