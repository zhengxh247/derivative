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
                <el-checkbox
                  v-model="isAllCheck"
                  @change="updateAllProductChecked"
                >
                  全选
                </el-checkbox>
              </div>
              <div class="col-img"></div>
              <div class="col-name">商品名称</div>
              <div class="col-price">单价</div>
              <div class="col-num">数量</div>
              <div class="col-total">小计</div>
              <div class="col-action">操作</div>
            </div>
            <div class="list-body">
              <div class="list-item" v-for="cart in cartList" :key="cart.id">
                <div class="item-box">
                  <div class="col col-check">
                    <el-checkbox
                      v-model="cart.check"
                      @change="
                        updateProductChecked({
                          productId: cart.id,
                          checked: $event
                        })
                      "
                    >
                    </el-checkbox>
                  </div>
                  <div class="col-img">
                    <img :src="cart.imgUrl" />
                  </div>
                  <div class="col col-name">
                    <h3>{{ cart.goodName }}</h3>
                  </div>
                  <div class="col col-price">{{ cart.salePrice }}元</div>
                  <div class="col col-num">
                    <el-input-number
                      v-model="cart.num"
                      size="small"
                      :min="1"
                      :max="5"
                      @change="
                        updateProductNum({
                          productId: cart.id,
                          count: $event
                        })
                      "
                    >
                    </el-input-number>
                  </div>
                  <div class="col col-total">{{ cart.subtotal }}元</div>
                  <div class="col col-action">
                    <i
                      class="el-icon-close close"
                      @click="deleteProduct(cart.id)"
                    >
                    </i>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="cart-bar">
            <div class="section-left">
              <a href="javascript:;" class="back-shopping">继续购物</a>
              <span class="cart-total">
                共
                <i>{{ productCount }}</i>
                件商品，已选择
                <i>{{ checkedProductCount }}</i>
                件
              </span>
            </div>
            <span class="total-price">
              合计:
              <em>{{ checkedPriceTotal }}</em>
              元
              <a href="javascript:;" class="btn-primary">去结算</a>
            </span>
            <div class="no-select-tip"></div>
          </div>
          <div class="cart-recommend"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapMutations } from "vuex";
export default {
  name: "ShoppingCart",
  data() {
    return {
      cartList: []
    };
  },
  computed: {
    ...mapGetters("cart", [
      "productCount",
      "checkedProductCount",
      "checkedPriceTotal"
    ]),
    isAllCheck: {
      get() {
        return this.cartList.every(cart => cart.check);
      },
      set(value) {
        this.updateAllProductChecked(value);
      }
    }
  },
  created() {
    this.getCartList();
  },
  methods: {
    async getCartList() {
      const rs = await this.$store.dispatch("cart/getCartList");
      this.cartList = rs.data;
    },
    ...mapMutations("cart", [
      "deleteProduct",
      "updateAllProductChecked",
      "updateProductChecked",
      "updateProductNum"
    ])
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
        color: #424242;
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
          .close {
            cursor: pointer;
            &:hover {
              color: #fff;
              background-color: #e53935;
              border-radius: 50%;
            }
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
    .cart-bar {
      height: 50px;
      background: #fff;
      margin-top: 20px;
      position: sticky;
      bottom: 0;
      z-index: 100;
      .section-left {
        float: left;
        .back-shopping {
          line-height: 50px;
          margin-left: 32px;
          &:hover {
            color: $textHover;
            transition: color 0.3s;
          }
        }
        .cart-total {
          margin-left: 16px;
          padding-left: 16px;
          border-left: 1px solid #eee;
          color: #757575;
          i {
            font-style: normal;
            color: $colorPrimary;
          }
        }
      }
      .total-price {
        color: #ff6700;
        float: right;
        em {
          font-style: normal;
          font-size: 30px;
        }
        .btn-primary {
          display: inline-block;
          background: $colorPrimary;
          border-color: $colorPrimary;
          color: #fff;
          text-align: center;
          width: 200px;
          height: 48px;
          line-height: 48px;
          font-size: 18px;
          margin-left: 50px;
          vertical-align: top;
          &:hover {
            background: #f25807;
            border-color: #f25807;
          }
        }
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
