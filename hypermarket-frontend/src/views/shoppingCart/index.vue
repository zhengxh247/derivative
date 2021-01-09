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
    <div class="mi-cart">
      <div class="container">
        <div class="cart-container">
          <div class="cart-wrap">
            <div class="list-head">
              <div class="col-check">
                <el-checkbox v-model="isAllCheck">全选</el-checkbox>
              </div>
              <div class="col-img"></div>
              <div class="col-name">商品名称</div>
              <div class="col-price">单价</div>
              <div class="col-num">数量</div>
              <div class="col-total">小计</div>
              <div class="col-action">操作</div>
            </div>
            <div class="list-body">
              <div class="list-item">
                <div class="item-box">
                  <div class="col col-check">
                    <el-checkbox v-model="check"></el-checkbox>
                  </div>
                  <div class="col-img">
                    <img
                      src="//cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1568104854.08717848.jpg"
                      width="80"
                      height="80"
                    />
                  </div>
                  <div class="col col-name">
                    <h3>米家金属签字笔 金色</h3>
                  </div>
                  <div class="col col-price">24.9元</div>
                  <div class="col col-num">
                    <el-input-number v-model="num" size="small">
                    </el-input-number>
                  </div>
                  <div class="col col-total">24.9元</div>
                  <div class="col col-action">
                    <i class="el-icon-close"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="cart-recommend"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ShoppingCart",
  data() {
    return {
      isAllCheck: false,
      check: false,
      num: 1
    };
  }
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
      margin-top: 25px;
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
.mi-cart {
  padding: 38px 0;
  background: #f5f5f5;
  .container {
    width: 1226px;
    margin: 0 auto;
    .cart-wrap {
      background-color: #fff;
      .list-head {
        height: 70px;
        line-height: 70px;
        font-size: 14px;
        padding-right: 26px;
        color: #424242;
        display: flex;
      }
      .list-body {
        .item-box {
          padding: 15px 26px 15px 0;
          border-top: 1px solid #e0e0e0;
          display: flex;
          .col {
            height: 84px;
            line-height: 84px;
          }
          .col-total {
            color: $colorPrimary;
          }
        }
      }
      .col-check {
        width: 110px;
        margin-left: 24px;
      }
      .col-img {
        width: 120px;
      }
      .col-name {
        width: 380px;
        h3 {
          font-size: 18px;
          font-weight: 400;
        }
      }
      .col-price {
        width: 140px;
        padding-right: 18px;
        text-align: center;
      }
      .col-num {
        width: 150px;
        text-align: center;
      }
      .col-total {
        width: 120px;
        padding-right: 81px;
        text-align: right;
      }
      .col-action {
        width: 80px;
        text-align: center;
      }
    }
  }
}
</style>

<style lang="scss">
.col-check {
  .el-checkbox__inner {
    width: 18px;
    height: 18px;
  }
  .el-checkbox__inner::after {
    height: 9px;
    left: 5px;
    top: 2px;
    width: 4px;
  }
  .el-checkbox__input.is-checked .el-checkbox__inner,
  .el-checkbox__input.is-indeterminate .el-checkbox__inner {
    background-color: $colorPrimary;
    border-color: $colorPrimary !important;
  }
  .el-checkbox__inner:hover {
    border-color: #dedfe6;
  }
  .el-checkbox__input.is-focus .el-checkbox__inner {
    border-color: #dedfe6;
  }
  .el-checkbox__input.is-checked + .el-checkbox__label {
    color: #606266;
  }
}
.col-num {
  .el-input-number__decrease:hover:not(.is-disabled)
    ~ .el-input
    .el-input__inner:not(.is-disabled),
  .el-input-number__increase:hover:not(.is-disabled)
    ~ .el-input
    .el-input__inner:not(.is-disabled) {
    border-color: #dcdfe6;
  }
  .el-input-number__decrease,
  .el-input-number__increase {
    background: #fff;
  }
  .el-input-number__decrease:hover,
  .el-input-number__increase:hover {
    color: #606266;
    background: #e0e0e0;
  }
  .el-input-number__decrease {
    border-right: 0;
  }
  .el-input-number__increase {
    border-left: 0;
  }
}
</style>
