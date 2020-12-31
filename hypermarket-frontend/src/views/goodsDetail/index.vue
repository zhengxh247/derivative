<template>
  <div class="detail-container">
    <div class="xm-product-box">
      <div class="container">
        <h2>小米10至尊纪念版</h2>
        <div class="con">
          <div class="left">
            <span class="separator">|</span>
            <a href="javascript:;">小米10</a>
            <span class="separator">|</span>
            <a href="javascript:;">小米10 青春版</a>
            <span class="separator">|</span>
            <a href="javascript:;">小米11</a>
          </div>
          <div class="right">
            <a href="javascript:;">概述</a>
            <span class="separator">|</span>
            <a href="javascript:;">参数</a>
            <span class="separator">|</span>
            <a href="javascript:;">F码通道</a>
            <span class="separator">|</span>
            <a href="javascript:;">咨询客服</a>
            <span class="separator">|</span>
            <a href="javascript:;">用户评价</a>
          </div>
        </div>
      </div>
    </div>
    <div class="mi-detail">
      <div class="login-notic">
        <div class="container">
          为方便您购买，请提前登录
          <router-link to="/login" class="login">
            立即登录
          </router-link>
          <i class="el-icon-close"></i>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  }
};
</script>

<style lang="scss" scoped>
.xm-product-box {
  position: relative;
  background: #fff;
  border-top: 1px solid #e0e0e0;
  border-bottom: 1px solid #e0e0e0;
  box-shadow: 0 5px 5px rgba(0, 0, 0, 0.07);
  height: 63px;
  width: 100%;
  margin-top: 0;
  color: #616161;
  .container {
    width: 1226px;
    margin: 0 auto;
    h2 {
      font-size: 18px;
      font-weight: 400;
      line-height: 60px;
      color: #424242;
      float: left;
    }
    .left {
      float: left;
      margin-left: 5px;
      font-size: 12px;
      margin-top: 21px;
      .separator {
        margin: 0 0.5em;
        color: #424242;
      }
      a {
        color: #616161;
      }
    }
    .right {
      float: right;
      font-size: 12px;
      margin: 17px 0 0 0;
      .separator {
        margin: 0 0.7em;
        color: #e0e0e0;
      }
      a {
        color: #616161;
      }
    }
    a:hover {
      color: $textHover;
    }
  }
}
.login-notic {
  background: #f7f7f7;
  width: 100%;
  text-align: center;
  height: 48px;
  line-height: 48px;
  color: #333;
  .container {
    width: 1226px;
    margin: 0 auto;
    .login {
      color: $textHover;
      margin-left: 25px;
    }
    i {
      cursor: pointer;
      margin-left: 7px;
    }
  }
}
</style>
