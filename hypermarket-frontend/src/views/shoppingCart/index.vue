<template>
  <div class="cart-container">
    <div class="site-header">
      <div class="container">
        <div class="header-logo">
          <img src="../../assets/images/handlogo.png" />
        </div>
        <div class="header-title">
          <h2>我的购物车</h2>
          <p>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</p>
        </div>
        <div class="topbar-info">
          <router-link to="/login" class="link">登录</router-link>
          <span>|</span>
          <router-link to="/register" class="link">注册</router-link>
        </div>
      </div>
    </div>
    <div class="mi-cart"></div>
  </div>
</template>

<script>
export default {
  name: "ShoppingCart"
};
</script>

<style lang="scss" scoped>
.site-header {
  font-size: 12px;
  border-bottom: 2px solid $colorPrimary;
  height: 100px;
  background: #fff;
  color: #b0b0b0;
  .container {
    width: 1226px;
    margin: 0 auto;
    display: flex;
    position: relative;
    .header-logo {
      width: 93px;
      margin-top: 20px;
    }
    .header-title {
      margin-top: 20px;
      display: flex;
      h2 {
        line-height: 48px;
        font-size: 28px;
        font-weight: 400;
        color: #424242;
      }
      p {
        height: 20px;
        line-height: 20px;
        margin-top: 20px;
        margin-left: 15px;
        color: #757575;
      }
    }
    .topbar-info {
      height: 40px;
      line-height: 40px;
      margin-top: 30px;
      position: absolute;
      right: 0;
      .link {
        padding: 0 5px;
        color: #757575;
      }
    }
  }
}
</style>
