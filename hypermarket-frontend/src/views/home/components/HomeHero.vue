<template>
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
                    <router-link :to="'/detail/' + item.id" class="link-item">
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
          <img class="slide-item" :src="`http://49.232.11.36${item.imgUrl}`" />
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>
</template>

<script>
import { GoodsApi } from "@/api";
export default {
  name: "HomeHero",
  data() {
    return {
      groupMenus: {},
      swipers: [],
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
.home-hero {
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
}
</style>

<style lang="scss">
.swiper-view {
  .el-carousel__container {
    height: 460px;
  }
}
</style>
