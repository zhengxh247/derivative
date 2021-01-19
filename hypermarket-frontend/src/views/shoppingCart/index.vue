<template>
  <div class="cart-container">
    <div class="site-header">
      <div class="container">
        <div class="header-logo">
          <router-link to="/">
            <img src="../../assets/images/handlogo.png" />
          </router-link>
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
          <div class="cart-wrap" v-if="cartList.length > 0">
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
                      @click="deleteHandle(cart.id)"
                    >
                    </i>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="cart-bar" v-if="cartList.length > 0">
            <div class="bar-box">
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
                <a
                  href="javascript:;"
                  class="btn-primary"
                  :class="{ disabled: isCheck }"
                >
                  去结算
                </a>
              </span>
              <div
                class="no-select-tip"
                v-show="isCheck && cartList.length > 0"
              >
                请勾选需要结算的商品
                <i class="arrow arrow-a"></i>
                <i class="arrow arrow-b"></i>
              </div>
            </div>
          </div>
          <div class="empty-cart-wrap" v-else>
            <div class="empty-cart-top">
              <h2 class="login-tip is-login">您的购物车还是空的！</h2>
              <p class="login-desc">登录后将显示您之前加入的商品</p>
              <a href="javascript:;" class="btn btn-login">立即登录</a>
              <a href="javascript:;" class="btn btn-shoping">马上去购物</a>
            </div>
          </div>
          <div class="cart-recommend">
            <h2 class="recommend-title">
              <span>买购物车中商品的人还买了</span>
            </h2>
            <div class="recommend-bd">
              <ul class="recommend-list">
                <li
                  v-for="item in otherList"
                  :key="item.id"
                  class="recommend-item"
                >
                  <router-link :to="'/detail/' + item.id">
                    <img :src="item.imgUrl" />
                    <div class="recommend-name">{{ item.goodName }}</div>
                    <div class="recommend-price">{{ item.price }}元</div>
                    <div class="recommend-tips">{{ item.comment }}万人好评</div>
                  </router-link>
                  <div class="recommend-action">
                    <span class="add-cart" @click="addCartHandle(item.id)">
                      加入购物车
                    </span>
                  </div>
                  <div class="recommend-notice">
                    <span
                      class="add-success"
                      :class="{ 'success-active': isActive == item.id }"
                    >
                      成功加入购物车
                    </span>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <footer-nav></footer-nav>
  </div>
</template>

<script>
import { mapGetters, mapMutations } from "vuex";
import { CartApi } from "@/api";
import FooterNav from "@/layout/components/FooterNav.vue";
export default {
  name: "ShoppingCart",
  data() {
    return {
      otherList: [],
      isActive: null
    };
  },
  components: {
    FooterNav
  },
  computed: {
    ...mapGetters("cart", [
      "productCount",
      "checkedProductCount",
      "checkedPriceTotal"
    ]),
    isAllCheck: {
      get() {
        if (this.cartList.length == 0) {
          return false;
        } else {
          return this.cartList.every(cart => cart.check);
        }
      },
      set(value) {
        this.updateAllProductChecked(value);
      }
    },
    isCheck: {
      get() {
        return this.cartList.every(cart => !cart.check);
      }
    },
    cartList() {
      return this.$store.getters["cart/getCartList"];
    }
  },
  created() {
    this.getOtherList();
  },
  methods: {
    ...mapMutations("cart", [
      "deleteProduct",
      "updateAllProductChecked",
      "updateProductChecked",
      "updateProductNum"
    ]),
    deleteHandle(id) {
      this.$confirm("确定删除吗", {
        cancelButtonText: "取消",
        confirmButtonText: "确定",
        center: true,
        customClass: "cart-confirm"
      })
        .then(() => {
          this.deleteProduct(id);
        })
        .catch(() => {});
    },
    getOtherList() {
      CartApi.getOtherList().then(res => {
        this.otherList = res.data;
      });
    },
    addCartHandle(id) {
      this.isActive = id;
      const timer = setTimeout(_ => {
        this.isActive = null;
        clearTimeout(timer);
      }, 1000);
    }
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
      .link:hover {
        color: $textHover;
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
      .bar-box {
        position: relative;
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
          .disabled {
            background: #e0e0e0 !important;
            border-color: #e0e0e0 !important;
            color: #b0b0b0 !important;
            cursor: default !important;
          }
        }
        .no-select-tip {
          width: 200px;
          height: 48px;
          line-height: 48px;
          position: absolute;
          top: -58px;
          right: 0;
          background-color: #fff;
          border: 1px solid #ff6700;
          color: #ff6700;
          text-align: center;
          .arrow {
            display: block;
            width: 0;
            height: 0;
            border-style: solid;
            overflow: hidden;
            position: absolute;
            left: 50%;
          }
          .arrow-a {
            bottom: -8px;
            margin-left: -10px;
            border-width: 8px 10px 0;
            border-color: #ff6700 rgba(0, 0, 0, 0) rgba(0, 0, 0, 0);
          }
          .arrow-b {
            bottom: -7px;
            margin-left: -8px;
            border-width: 7px 8px 0;
            border-color: #fff rgba(0, 0, 0, 0) rgba(0, 0, 0, 0);
          }
        }
      }
    }
    .empty-cart-top {
      height: 273px;
      margin: 65px 0 130px;
      padding-left: 558px;
      background: url(../../assets/images/cart-empty.png) no-repeat 124px 0;
      color: #b0b0b0;
      .login-tip {
        padding: 70px 0 0 0;
        font-size: 36px;
      }
      .login-desc {
        margin: 7px 0 0 0;
        font-size: 20px;
        color: #b0b0b0;
      }
      .btn {
        display: inline-block;
        text-align: center;
        width: 170px;
        height: 48px;
        border: 1px solid #b0b0b0;
        line-height: 48px;
        margin-top: 20px;
      }
      .btn-login {
        background: $colorPrimary;
        border-color: $colorPrimary;
        color: #fff;
        margin-right: 10px;
      }
      .btn-shoping {
        background-color: #f5f5f5;
        border-color: $colorPrimary;
        color: $colorPrimary;
      }
    }
    .cart-recommend {
      margin: 60px 0 0;
      .recommend-title {
        position: relative;
        margin: 0;
        height: 50px;
        font-size: 30px;
        font-weight: 400;
        color: #757575;
        border-top: 1px solid #e0e0e0;
        span {
          position: absolute;
          top: -20px;
          left: 372px;
          height: 40px;
          width: 482px;
          line-height: 40px;
          text-align: center;
          display: block;
          background-color: #f5f5f5;
        }
      }
      .recommend-bd {
        .recommend-list {
          display: flex;
          flex-wrap: wrap;
          .recommend-item {
            width: 234px;
            margin-right: 14px;
            margin-bottom: 14px;
            height: 300px;
            padding: 0;
            position: relative;
            overflow: hidden;
            background-color: #fff;
            font-size: 14px;
            text-align: center;
            &:nth-child(5n) {
              margin-right: 0;
            }
            img {
              display: block;
              margin: 40px auto 20px;
            }
            .recommend-name {
              margin: 0 10px 10px;
              height: 18px;
              text-overflow: ellipsis;
              white-space: nowrap;
              overflow: hidden;
              color: #333;
            }
            .recommend-price {
              margin-bottom: 10px;
              color: $colorPrimary;
            }
            .recommend-tips {
              color: #757575;
            }
            .recommend-action {
              position: absolute;
              left: 0;
              bottom: 16px;
              width: 100%;
              .add-cart {
                opacity: 0;
                background: #fff;
                color: $colorPrimary;
                width: 120px;
                height: 28px;
                font-size: 12px;
                line-height: 28px;
                display: inline-block;
                border: 1px solid $colorPrimary;
                cursor: pointer;
                &:hover {
                  background: $textHover;
                  color: #fff;
                }
              }
            }
            &:hover .recommend-action .add-cart {
              opacity: 1;
            }
            .recommend-notice {
              position: absolute;
              top: 0;
              left: 0;
              z-index: 5;
              width: 100%;
              .add-success {
                opacity: 0;
                background: #83c44e;
                border-color: #83c44e;
                color: #fff;
                display: block;
                width: 100%;
                height: 38px;
                line-height: 38px;
                font-size: 14px;
              }
              .success-active {
                opacity: 1 !important;
              }
            }
          }
        }
      }
    }
    .clearfix {
      clear: both;
    }
    .clearfix:after,
    .clearfix:before {
      content: " ";
      display: table;
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
.cart-confirm {
  width: 500px;
  padding-bottom: 0;
  .el-message-box__headerbtn:focus .el-message-box__close,
  .el-message-box__headerbtn:hover .el-message-box__close {
    color: #fff;
    background-color: #e53935;
    border-radius: 50%;
  }
  .el-message-box__content {
    padding: 20px 27px 30px 27px;
  }
  .el-message-box__message p {
    font-size: 18px;
    line-height: 36px;
    color: #424242;
  }
  .el-message-box__btns {
    height: 40px;
    padding: 20px 0;
    border-top: 1px solid #e0e0e0;
    text-align: center;
    background-color: #f5f5f5;
    .el-button {
      width: 160px;
      height: 40px;
      background: #b0b0b0;
      border-color: #b0b0b0;
      color: #fff;
      font-size: 14px;
      border-radius: 0;
      &:hover {
        background-color: #757575;
        border-color: #757575;
        color: #fff;
      }
    }
    .el-button--primary {
      background: #ff6700;
      border-color: #ff6700;
      color: #fff;
      &:hover {
        background-color: #f25807;
        border-color: #f25807;
        color: #fff;
      }
    }
    .el-button + .el-button {
      margin-left: 14px;
    }
  }
}
</style>
