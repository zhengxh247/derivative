<template>
  <div class="home-hero-container">
    <div class="home-hero">
      <div class="swiper-container">
        <div class="site-category">
          <div class="site-category-list">
            <div class="category-item">
              <span>电子 电器</span>
              <i class="el-icon-arrow-right"></i>
            </div>
            <div class="category-item-children" :class="[calcColumnClass]">
              <div class="container">
                <ul class="children-list">
                  <li class="link">手机</li>
                  <li class="link">手机</li>
                  <li class="link">手机</li>
                  <li class="link">手机</li>
                </ul>
                <ul class="children-list">
                  <li class="link">手机</li>
                  <li class="link">手机</li>
                  <li class="link">手机</li>
                  <li class="link">手机</li>
                </ul>
                <ul class="children-list">
                  <li class="link">手机</li>
                  <li class="link">手机</li>
                  <li class="link">手机</li>
                  <li class="link">手机</li>
                </ul>
                <ul class="children-list">
                  <li class="link">手机</li>
                  <li class="link">手机</li>
                  <li class="link">手机</li>
                  <li class="link">手机</li>
                </ul>
              </div>
            </div>
            <div class="category-item">
              <span>旅游 出行</span>
              <i class="el-icon-arrow-right"></i>
            </div>
            <div class="category-item-children">
              <div class="container">
                <ul class="children-list">
                  <li class="link">电视</li>
                  <li class="link">电视</li>
                  <li class="link">电视</li>
                  <li class="link">电视</li>
                </ul>
              </div>
            </div>
            <div class="category-item">
              <span>外设 硬件</span>
              <i class="el-icon-arrow-right"></i>
            </div>
            <div class="category-item-children">
              <div class="container">
                <ul class="children-list">
                  <li class="link">笔记本</li>
                  <li class="link">笔记本</li>
                  <li class="link">笔记本</li>
                  <li class="link">笔记本</li>
                </ul>
              </div>
            </div>
            <div class="category-item">
              <span>日常 生活</span>
              <i class="el-icon-arrow-right"></i>
            </div>
            <div class="category-item-children">
              <div class="container">
                <ul class="children-list">
                  <li class="link">家电</li>
                  <li class="link">家电</li>
                  <li class="link">家电</li>
                  <li class="link">家电</li>
                </ul>
              </div>
            </div>
            <div class="category-item">
              <span>儿童 玩具</span>
              <i class="el-icon-arrow-right"></i>
            </div>
            <div class="category-item-children">
              <div class="container">
                <ul class="children-list">
                  <li class="link">出行</li>
                  <li class="link">出行</li>
                  <li class="link">出行</li>
                  <li class="link">出行</li>
                </ul>
              </div>
            </div>
            <div class="category-item">
              <span>智能 路由器</span>
              <i class="el-icon-arrow-right"></i>
            </div>
            <div class="category-item-children">
              <div class="container">
                <ul class="children-list">
                  <li class="link">智能</li>
                  <li class="link">智能</li>
                  <li class="link">智能</li>
                  <li class="link">智能</li>
                </ul>
              </div>
            </div>
            <div class="category-item">
              <span>电源 配件</span>
              <i class="el-icon-arrow-right"></i>
            </div>
            <div class="category-item-children">
              <div class="container">
                <ul class="children-list">
                  <li class="link">电源</li>
                  <li class="link">电源</li>
                  <li class="link">电源</li>
                  <li class="link">电源</li>
                </ul>
              </div>
            </div>
            <div class="category-item">
              <span>健康 儿童</span>
              <i class="el-icon-arrow-right"></i>
            </div>
            <div class="category-item-children">
              <div class="container">
                <ul class="children-list">
                  <li class="link">健康</li>
                  <li class="link">健康</li>
                  <li class="link">健康</li>
                  <li class="link">健康</li>
                </ul>
              </div>
            </div>
            <div class="category-item">
              <span>耳机 音箱</span>
              <i class="el-icon-arrow-right"></i>
            </div>
            <div class="category-item-children">
              <div class="container">
                <ul class="children-list">
                  <li class="link">耳机</li>
                  <li class="link">耳机</li>
                  <li class="link">耳机</li>
                  <li class="link">耳机</li>
                </ul>
              </div>
            </div>
            <div class="category-item">
              <span>生活 箱包</span>
              <i class="el-icon-arrow-right"></i>
            </div>
            <div class="category-item-children">
              <div class="container">
                <ul class="children-list">
                  <li class="link">生活</li>
                  <li class="link">生活</li>
                  <li class="link">生活</li>
                  <li class="link">生活</li>
                </ul>
              </div>
            </div>
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
          <li>小米秒杀</li>
          <li>企业团购</li>
          <li>F码通道</li>
          <li>米粉卡</li>
          <li>以旧换新</li>
          <li>话费充值</li>
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
        this.swipers = res.data;
      });
    },
    getGroupMenuList() {
      GoodsApi.getGroupMenuList().then(res => {
        this.groupMenus = res.data;
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
          opacity: 0.7;
          padding: 0 3px;
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
</style>

<style lang="scss">
.swiper-view {
  .el-carousel__container {
    height: 460px;
  }
}
</style>
