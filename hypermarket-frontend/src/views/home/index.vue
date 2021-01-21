<template>
  <div class="home-container">
    <div class="home-hero-container">
      <div class="home-hero">
        <div class="swiper-container">
          <div class="site-category">
            <div class="site-category-list">
              <template v-for="(groupMenu, i) in groupMenus">
                <div class="category-item" :key="'title' + i">
                  <span>{{ groupMenu.title }}</span>
                  <i class="el-icon-arrow-right"></i>
                </div>
                <div
                  class="category-item-children"
                  :class="{ 'children-col-4': groupMenu.data.length == 4 }"
                  :key="'item' + i"
                >
                  <div class="container">
                    <ul
                      class="children-list"
                      v-for="(menu, index) in groupMenu.data"
                      :key="index"
                    >
                      <li class="link" v-for="item in menu" :key="item.id">
                        <router-link
                          :to="'/detail/' + item.id"
                          class="link-item"
                        >
                          <img
                            :src="`http://49.232.11.36${item.imgSrc}`"
                            width="40"
                            height="40"
                          />
                          <span class="text">{{ item.goodsName }}</span>
                        </router-link>
                      </li>
                    </ul>
                  </div>
                </div>
              </template>
            </div>
          </div>
          <el-carousel
            :interval="4500"
            arrow="always"
            class="hm-carousel swiper-view"
          >
            <el-carousel-item v-for="item in swipers" :key="item.id">
              <img
                class="slide-item"
                :src="`http://49.232.11.36${item.imgUrl}`"
              />
            </el-carousel-item>
          </el-carousel>
        </div>
      </div>
      <div class="home-hero-sub">
        <div class="span4">
          <ul class="home-channel-list">
            <li>
              <a href="javascript:;">
                <img
                  src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/82abdba456e8caaea5848a0cddce03db.png"
                />
                小米秒杀
              </a>
            </li>
            <li>
              <a href="javascript:;">
                <img
                  src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/806f2dfb2d27978e33fe3815d3851fa3.png"
                />
                企业团购
              </a>
            </li>
            <li>
              <a href="javascript:;">
                <img
                  src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/eded6fa3b897a058163e2485532c4f10.png"
                />
                F码通道
              </a>
            </li>
            <li>
              <a href="javascript:;">
                <img
                  src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/43a3195efa6a3cc7662efed8e7abe8bf.png"
                />
                米粉卡
              </a>
            </li>
            <li>
              <a href="javascript:;">
                <img
                  src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/f4846bca6010a0deb9f85464409862af.png"
                />
                以旧换新
              </a>
            </li>
            <li>
              <a href="javascript:;">
                <img
                  src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/9a76d7636b08e0988efb4fc384ae497b.png"
                />
                话费充值
              </a>
            </li>
          </ul>
        </div>
        <div class="span16">
          <ul class="home-promo-list">
            <li>
              <a href="javascript:;">
                <img
                  src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/e5f20a62c3d5b3d6806bd51ab6c5dd12.jpg?w=632&h=340"
                />
              </a>
            </li>
            <li>
              <a href="javascript:;">
                <img
                  src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/8a43378b96501d7e227a9018fe2668c5.jpg?w=632&h=340"
                />
              </a>
            </li>
            <li>
              <a href="javascript:;">
                <img
                  src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/793913688bfaee26b755a0b0cc8575fd.jpg?w=632&h=340"
                />
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="home-main">
      <div class="container">
        <div class="home-flashsale">
          <div class="box-hd">
            <h2 class="title">小米秒杀</h2>
          </div>
          <div class="box-bd clearfix">
            <div class="row">
              <div class="flashsale-countdown">
                <p class="round">10:00 场</p>
                <img src="../../assets/images/untitled.png" />
                <p class="desc">本场已结束</p>
                <div class="countdown clearfix">
                  <span>00</span>
                  <i>:</i>
                  <span>00</span>
                  <i>:</i>
                  <span>00</span>
                </div>
              </div>
              <div class="flashsale-list swiper-container">
                <ul class="swiper-wrapper">
                  <li>
                    123
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { GoodsApi } from "@/api";
export default {
  name: "HomeMain",
  data() {
    return {
      swipers: [],
      groupMenus: {},
      calcColumnClass: "children-col-4"
    };
  },
  created() {
    this.getSwiperList();
    this.getGroupMenuList();
  },
  methods: {
    getSwiperList() {
      GoodsApi.getSwiperList().then(res => {
        this.swipers = res.data.result;
      });
    },
    getGroupMenuList() {
      GoodsApi.getGroupMenuList().then(res => {
        this.groupMenus = res.data.result;
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.home-hero-container {
  width: 1226px;
  margin: 0 auto;
  position: relative;
  .swiper-container {
    position: relative;
    .site-category {
      position: absolute;
      z-index: 100;
      width: 234px;
      height: 460px;
      .site-category-list {
        height: 420px;
        border: 0;
        color: #fff;
        padding: 20px 0;
        background: rgba(105, 101, 101, 0.6);
        .category-item {
          position: relative;
          height: 42px;
          line-height: 42px;
          padding-left: 30px;
          i {
            position: absolute;
            top: 12px;
            right: 20px;
          }
        }
        .category-item:hover {
          cursor: pointer;
          background: $colorPrimary;
        }
        .category-item-children {
          position: absolute;
          display: none;
          left: 234px;
          top: 0;
          background: #fff;
          color: #000;
          width: auto;
          height: 458px;
          border: 1px solid #e0e0e0;
          border-left: 0;
          box-shadow: 0 8px 16px rgba(0, 0, 0, 0.18);
          .container {
            display: flex;
            .link {
              width: 265px;
              height: 76px;
              .link-item {
                display: block;
                padding: 18px 20px;
                height: 40px;
                line-height: 40px;
                img {
                  float: left;
                  vertical-align: middle;
                  margin-right: 12px;
                }
                .text {
                  float: left;
                  width: 172px;
                  white-space: nowrap;
                  text-overflow: ellipsis;
                  overflow: hidden;
                }
                .text:hover {
                  overflow: visible;
                }
              }
            }
          }
        }
        .category-item:hover + .category-item-children {
          display: block;
        }
        .category-item-children:hover {
          display: block;
        }
        .children-col-4 {
          width: 992px;
          .link {
            width: 248px !important;
          }
        }
      }
    }
    .slide-item {
      width: 1226px;
      height: 460px;
    }
  }
  .home-hero-sub {
    display: flex;
    margin-top: 14px;
    .span4 {
      width: 234px;
      .home-channel-list {
        margin: 0;
        padding: 3px;
        list-style-type: none;
        font-size: 12px;
        display: flex;
        flex-wrap: wrap;
        text-align: center;
        background: #5f5750;
        li {
          width: 70px;
          height: 82px;
          color: #fff;
          padding: 0 3px;
          a {
            display: block;
            padding-top: 18px;
            text-overflow: ellipsis;
            color: #fff;
            opacity: 0.7;
            img {
              display: block;
              width: 24px;
              height: 24px;
              margin: 0 auto 4px;
            }
          }
        }
      }
    }
    .span16 {
      width: 978px;
      margin-left: 14px;
      .home-promo-list {
        display: flex;
        li:first-child {
          margin-left: 0;
        }
        li {
          margin-left: 15px;
        }
        img {
          width: 316px;
          height: 170px;
        }
      }
    }
  }
}
.home-main {
  padding-top: 4px;
  padding-bottom: 12px;
  background: #f5f5f5;
  .container {
    width: 1226px;
    margin: 0 auto;
    .home-flashsale {
      margin-bottom: 22px;
      position: relative;
      .box-hd {
        position: relative;
        height: 58px;
        .title {
          margin: 0;
          font-size: 22px;
          font-weight: 200;
          line-height: 58px;
          color: #333;
        }
      }
      .box-bd {
        .row {
          .flashsale-countdown {
            width: 234px;
            height: 300px;
            padding-top: 39px;
            border-top-width: 1px;
            border-top-style: solid;
            background: #f1eded;
            text-align: center;
            border-top-color: #e53935;
            float: left;
            .round {
              font-size: 21px;
              color: #ef3a3b;
              padding-top: 15px;
            }
            img {
              margin: 25px auto;
            }
            .desc {
              color: rgba(0, 0, 0, 0.54);
              font-size: 15px;
            }
            .countdown {
              width: 168px;
              margin: 28px auto 0;
              span {
                width: 46px;
                height: 46px;
                background: #605751;
                color: #fff;
                font-size: 24px;
                line-height: 46px;
                float: left;
              }
              i {
                width: 15px;
                float: left;
                height: 46px;
                line-height: 46px;
                color: #605751;
                font-size: 28px;
                font-style: normal;
              }
            }
            .clearfix:after {
              clear: both;
            }
            .clearfix:after,
            .clearfix:before {
              content: " ";
              display: table;
            }
          }
          .flashsale-list {
            float: left;
            width: 978px;
            margin-left: 14px;
          }
          .swiper-container {
            position: relative;
            overflow: hidden;
            list-style: none;
            padding: 0;
            z-index: 1;
            .swiper-wrapper {
              margin: 0;
              padding: 0;
              width: 100%;
              height: 340px;
              display: flex;
              li {
                width: 234px;
                margin-right: 14px;
                border-top-width: 1px;
                border-top-style: solid;
                text-align: center;
                background: #fff;
                transition: all 0.6s;
                position: relative;
                list-style: none;
              }
              .rainbow-item-1 {
                border-top-color: #ffac13;
              }
              .rainbow-item-2 {
                border-top-color: #83c44e;
              }
              .rainbow-item-3 {
                border-top-color: #2196f3;
              }
              .rainbow-item-4 {
                border-top-color: #e53935;
              }
              .rainbow-item-5 {
                border-top-color: #00c0a5;
              }
              .rainbow-item-6 {
                border-top-color: #ffac13;
              }
              .rainbow-item-7 {
                border-top-color: #83c44e;
              }
              .rainbow-item-8 {
                border-top-color: #2196f3;
              }
              .rainbow-item-9 {
                border-top-color: #e53935;
              }
              .rainbow-item-10 {
                border-top-color: #00c0a5;
              }
              .rainbow-item-11 {
                border-top-color: #ffac13;
              }
              .rainbow-item-12 {
                border-top-color: #83c44e;
              }
              .rainbow-item-13 {
                border-top-color: #2196f3;
              }
              .rainbow-item-14 {
                border-top-color: #e53935;
              }
              .rainbow-item-15 {
                border-top-color: #00c0a5;
              }
              .rainbow-item-16 {
                border-top-color: #ffac13;
              }
              .rainbow-item-17 {
                border-top-color: #83c44e;
              }
              .rainbow-item-18 {
                border-top-color: #2196f3;
              }
              .rainbow-item-19 {
                border-top-color: #e53935;
              }
              .rainbow-item-20 {
                border-top-color: #00c0a5;
              }
              .rainbow-item-21 {
                border-top-color: #ffac13;
              }
              .rainbow-item-22 {
                border-top-color: #83c44e;
              }
              .rainbow-item-23 {
                border-top-color: #2196f3;
              }
              .rainbow-item-24 {
                border-top-color: #e53935;
              }
              .rainbow-item-25 {
                border-top-color: #00c0a5;
              }
              .rainbow-item-26 {
                border-top-color: #ffac13;
              }
              .rainbow-item-27 {
                border-top-color: #83c44e;
              }
              .rainbow-item-28 {
                border-top-color: #2196f3;
              }
            }
          }
        }
      }
      .clearfix:after {
        clear: both;
      }
      .clearfix:after,
      .clearfix:before {
        content: " ";
        display: table;
      }
    }
  }
}
</style>

<style lang="scss">
.swiper-view {
  .el-carousel__container {
    height: 460px;
  }
}
</style>
