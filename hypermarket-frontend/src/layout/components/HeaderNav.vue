<template>
  <div class="header">
    <div class="topbar-banner-Wrapper" v-show="$route.path == '/'">
      <a href="javascript:;"></a>
    </div>
    <div class="site-topbar">
      <div class="container">
        <div class="topbar-nav">
          <a href="javasctipt:;">小米商城</a>
          <span class="sep">|</span>
          <a href="javasctipt:;">MIUI</a>
          <span class="sep">|</span>
          <a href="javasctipt:;">IoT</a>
          <span class="sep">|</span>
          <a href="javasctipt:;">云服务</a>
          <span class="sep">|</span>
          <a href="javasctipt:;">天星数科</a>
          <span class="sep">|</span>
          <a href="javasctipt:;">有品</a>
          <span class="sep">|</span>
          <a href="javasctipt:;">小爱开放平台</a>
          <span class="sep">|</span>
          <a href="javasctipt:;">企业团购</a>
          <span class="sep">|</span>
          <a href="javasctipt:;">资质证照</a>
          <span class="sep">|</span>
          <a href="javasctipt:;">协议规则</a>
          <span class="sep">|</span>
          <a href="javasctipt:;">下载app</a>
          <span class="sep">|</span>
          <a href="javasctipt:;">智能生活</a>
          <span class="sep">|</span>
          <a href="javasctipt:;">Select Location</a>
        </div>
        <div class="topbar-cart">
          <router-link
            to="/cart"
            class="cart-mini"
            :class="{ 'cart-filled': cartList.length > 0 }"
          >
            <i class="iconfont icon-gouwuche"></i>
            <span>购物车（{{ cartList.length }}）</span>
          </router-link>
          <div class="cart-menu">
            <div class="menu-content">
              <ul
                class="cart-list"
                :style="{ height: cartList.length > 5 ? '445.5px' : 'auto' }"
                :class="{ isScroll: cartList.length > 5 }"
                v-if="cartList.length > 0"
              >
                <li v-for="cart in cartList" :key="cart.id">
                  <div class="cart-item">
                    <a href="javscript:;" class="thumb">
                      <img
                        src="//cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1591872099.9894566.jpg"
                        width="60"
                        height="60"
                      />
                    </a>
                    <a href="javscript:;" class="name">
                      {{ cart.goodName }}
                    </a>
                    <span class="price">
                      {{ cart.salePrice }}元 × {{ cart.num }}
                    </span>
                    <i
                      class="el-icon-close btn-del"
                      @click="deleteProduct(cart.id)"
                    >
                    </i>
                  </div>
                </li>
              </ul>
              <div class="cart-total clearfix" v-if="cartList.length > 0">
                <span class="total">
                  共
                  <em>{{ productCount }}</em>
                  件商品
                  <span class="price">
                    <em>{{ checkedPriceTotal }}</em>
                    元
                  </span>
                </span>
                <router-link to="/cart" class="btn-cart">
                  去购物车结算
                </router-link>
              </div>
              <div class="msg-empty" v-else>
                购物车中还没有商品，赶紧选购吧！
              </div>
            </div>
          </div>
        </div>
        <div class="topbar-info">
          <router-link to="/login" class="link">登录</router-link>
          <span class="sep">|</span>
          <router-link to="/register" class="link">注册</router-link>
          <span class="sep">|</span>
          <span class="message">消息通知</span>
        </div>
      </div>
    </div>
    <div class="site-header">
      <div class="container">
        <div class="header-logo">
          <router-link to="/" class="logo"></router-link>
        </div>
        <div class="doodle">
          <a href="javascript:;" class="link-block"></a>
        </div>
        <div class="header-nav">
          <div class="nav-item">
            <template v-for="(menu, i) in menus">
              <span class="title" :key="'title' + i">{{ menu.title }}</span>
              <div class="item-children" :key="'item' + i">
                <ul class="item-container">
                  <li v-for="(item, index) in menu.data" :key="item.id">
                    <router-link :to="'/detail/' + item.id">
                      <div class="figure" :class="{ clear: index === 0 }">
                        <img
                          :src="`http://49.232.11.36${item.imgSrc}`"
                          :alt="item.goodsName"
                        />
                      </div>
                      <div class="title">{{ item.goodsName }}</div>
                      <div class="price">{{ item.price }}元</div>
                    </router-link>
                  </li>
                </ul>
              </div>
            </template>
            <span>服务</span>
            <span>社区</span>
          </div>
        </div>
        <div class="header-search">
          <el-input v-model="search" placeholder="Redmi K30 Pro 变焦版">
            <el-button
              slot="append"
              icon="el-icon-search"
              @click="
                $router.push({ path: '/search', query: { keyWord: search } })
              "
            >
            </el-button>
          </el-input>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { GoodsApi } from "@/api";
import { mapGetters, mapMutations } from "vuex";
export default {
  name: "HeaderNav",
  data() {
    return {
      search: "",
      menus: []
    };
  },
  computed: {
    ...mapGetters("cart", ["checkedPriceTotal", "productCount"]),
    cartList() {
      return this.$store.getters["cart/getCartList"];
    }
  },
  created() {
    !this.cartList.length && this.getCartList();
    this.getHeaderMenuList();
  },
  methods: {
    ...mapMutations("cart", ["deleteProduct"]),
    async getCartList() {
      await this.$store.dispatch("cart/getCartList");
    },
    getHeaderMenuList() {
      GoodsApi.getHeaderMenuList().then(res => {
        this.menus = res.data.result;
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.topbar-banner-Wrapper {
  width: 100%;
  height: 120px;
  position: relative;
  a {
    position: absolute;
    top: 0;
    width: 100%;
    height: 120px;
    background-image: url(https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/bb3c06a430689ba2357dd7d1fbfa6bab.jpg?w=5120&h=240);
    background-repeat: no-repeat;
    background-position: 50%;
    background-size: auto 120px;
    text-indent: -9999px;
  }
}
.site-topbar {
  height: 40px;
  line-height: 40px;
  font-size: 12px;
  color: #b0b0b0;
  background: #333;
  .container {
    width: 1226px;
    margin: 0 auto;
    height: 40px;
    .topbar-nav {
      float: left;
      a:hover {
        color: #fff;
      }
      .sep {
        margin: 0.3em;
        color: #424242;
      }
    }
    .topbar-info {
      float: right;
      .link {
        padding: 0 5px;
        cursor: pointer;
      }
      .message {
        padding: 0 10px;
        cursor: pointer;
      }
      .link:hover,
      .message:hover {
        color: #fff;
      }
      .sep {
        color: #424242;
      }
    }
    .topbar-cart {
      position: relative;
      float: right;
      width: 120px;
      margin-left: 15px;
      .cart-mini {
        background: #424242;
        text-align: center;
        display: block;
        i {
          font-size: 15px;
        }
      }
      .cart-filled {
        background: $colorPrimary;
        color: #fff;
      }
      .cart-menu {
        display: none;
        position: absolute;
        width: 316px;
        height: auto;
        right: 0;
        top: 40px;
        z-index: 30;
        background: #fff;
        box-shadow: -5px 5px 10px -4px rgba(0, 0, 0, 0.15),
          5px 5px 10px -4px rgba(0, 0, 0, 0.15);
        .menu-content {
          padding: 20px 0 0;
          .cart-list {
            li {
              position: relative;
              height: 80px;
              padding: 0 20px;
              .cart-item {
                position: relative;
                height: 60px;
                padding: 10px 0;
                border-top: 1px solid #e0e0e0;
                line-height: 20px;
                .thumb {
                  float: left;
                }
                .name {
                  float: left;
                  width: 95px;
                  height: 40px;
                  line-height: 20px;
                  margin: 10px 0;
                  color: #424242;
                  overflow: hidden;
                  &:hover {
                    color: $textHover;
                    cursor: pointer;
                  }
                }
                .price {
                  float: right;
                  margin: 20px 20px 0 5px;
                }
                .btn-del {
                  position: absolute;
                  top: 35px;
                  right: 0;
                  font-size: 12px;
                  opacity: 0;
                  &:hover {
                    color: #000;
                    cursor: pointer;
                  }
                }
              }
              &:first-child .cart-item {
                border-top: 0;
              }
              &:hover .cart-item .btn-del {
                opacity: 1;
              }
            }
          }
          .isScroll {
            overflow: hidden scroll;
          }
          .cart-total {
            padding: 15px 20px;
            background: #fafafa;
            .total {
              float: left;
              width: 135px;
              color: #757575;
              line-height: normal;
              em {
                font-style: normal;
              }
              .price {
                display: block;
                font-weight: 400;
                color: #ff6700;
                em {
                  font-size: 24px;
                  line-height: 1;
                }
              }
            }
            .btn-cart {
              float: right;
              width: 130px;
              padding: 0;
              font-size: 14px;
              line-height: 40px;
              text-align: center;
              color: #f5f5f5;
              background: #ff6700;
            }
          }
          .clearfix:after,
          .clearfix:before {
            content: "";
            display: table;
          }
          .clearfix:after {
            clear: both;
          }
          .msg-empty {
            padding: 10px 0 20px;
            margin: 0 20px 20px;
            text-align: center;
          }
        }
      }
      .cart-mini:hover {
        color: $colorHover;
        cursor: pointer;
        background: #fff;
      }
    }
    .topbar-cart:hover .cart-menu {
      display: block;
    }
    .topbar-cart:hover .cart-mini {
      color: $colorHover;
      background: #fff;
    }
  }
}
.site-header {
  height: 100px;
  position: relative;
  .container {
    width: 1226px;
    margin: 0 auto;
    height: 100px;
    .header-logo {
      float: left;
      width: 62px;
      margin-top: 22px;
      .logo {
        display: block;
        width: 55px;
        height: 55px;
        overflow: hidden;
        background-color: $colorPrimary;
      }
    }
    .link-block {
      position: absolute;
      left: auto;
      top: 0;
      width: 165px;
      height: 100px;
      background-repeat: no-repeat;
      background-position: 50%;
      text-indent: -9999em;
      background-image: url(https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/1e455ea5dca7763e88f7a4bfface056d.jpg?w=165&h=55);
    }
    .header-nav {
      float: left;
      width: 678px;
      margin-left: 172px;
      .nav-item {
        padding-top: 8px;
        span {
          height: 88px;
          line-height: 88px;
          font-size: 16px;
          cursor: pointer;
          padding: 26px 10px 38px;
        }
        span:hover {
          color: $textHover;
        }
        .title:hover + .item-children {
          display: block;
        }
        .item-children {
          display: none;
          margin-top: 4px;
          position: absolute;
          background: #fff;
          left: 0;
          z-index: 101;
          width: 100%;
          border-top: 1px solid #e0e0e0;
          box-shadow: 0px 5px 8px -5px rgba(128, 128, 128, 0.5);
          box-sizing: border-box;
          .item-container {
            width: 1226px;
            height: 200px;
            margin: 0 auto;
            li {
              width: auto;
              height: auto;
              font-size: 12px;
              float: left;
              text-align: center;
              padding-top: 32px;
              .figure {
                width: 205px;
                border-left: 1px solid #e0e0e0;
              }
              .clear {
                border: 0;
              }
              .title {
                color: #757575;
              }
              .price {
                color: $colorPrimary;
              }
            }
          }
        }
        .item-children:hover {
          display: block;
        }
      }
    }
    .header-search {
      float: right;
      width: 296px;
      margin-top: 25px;
    }
  }
}
</style>

<style lang="scss">
.header-search {
  .el-input__inner {
    height: 48px;
    line-height: 48px;
  }
}
</style>
