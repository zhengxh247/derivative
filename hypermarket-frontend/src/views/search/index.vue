<template>
  <div class="search-container">
    <div class="container-main">
      <div class="breadcrumbs">
        <div class="container">
          <el-breadcrumb
            separator-class="el-icon-arrow-right"
            class="custom-breadcrumb"
          >
            <el-breadcrumb-item :to="{ path: '/' }">
              首页
            </el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/search' }">
              全部结果
            </el-breadcrumb-item>
            <el-breadcrumb-item>Redmi 10X 5G</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
      </div>
      <div class="search-filter">
        <div class="container">
          <ul>
            <li>分类:</li>
            <li>全部</li>
            <li>手机</li>
            <li>手机保护壳</li>
            <li>服务</li>
          </ul>
        </div>
      </div>
      <div class="search-result">
        <div class="container">
          <div class="order-list-box">
            <ul class="order-list">
              <li>综合</li>
              <li>新品</li>
              <li>销量</li>
              <li @click="isAsc = !isAsc">
                价格
                <i class="el-icon-top" v-if="isAsc"></i>
                <i class="el-icon-bottom" v-else></i>
              </li>
            </ul>
            <ul class="type-list">
              <li>收货地</li>
              <li>
                <el-checkbox v-model="promotion">促销</el-checkbox>
              </li>
              <li>
                <el-checkbox v-model="installment">分期</el-checkbox>
              </li>
              <li>
                <el-checkbox v-model="onlyLookGood">仅看有货</el-checkbox>
              </li>
            </ul>
          </div>
          <div class="goods-list-box">
            <div class="goods-list">
              <el-card
                class="goods-item"
                shadow="hover"
                v-for="search in searchList"
                :key="search.id"
              >
                <router-link :to="'/detail/' + search.id">
                  <img :src="search.imgUrl" />
                </router-link>
                <h2 class="title">
                  <router-link
                    :to="'/detail/' + search.id"
                    style="color: #424242;"
                  >
                    {{ search.goodName }}
                  </router-link>
                </h2>
                <p class="price">
                  {{ search.price }}元
                  <!-- <del>{{ search.price }}元 起</del> -->
                </p>
                <div class="thumbs">
                  <ul class="thumb-list">
                    <li class="active">
                      <a href="javascript:;">
                        <img :src="search.imgUrl" width="34" height="34" />
                      </a>
                    </li>
                    <li class="active">
                      <a href="javascript:;">
                        <img :src="search.imgUrl" width="34" height="34" />
                      </a>
                    </li>
                  </ul>
                </div>
              </el-card>
            </div>
          </div>
        </div>
      </div>
      <div class="search-favourite">
        <div class="mi-recommend">
          <h2 class="recommend-title">
            <span>猜你喜欢</span>
          </h2>
          <el-carousel
            trigger="click"
            indicator-position="outside"
            arrow="never"
            class="search-swiper"
          >
            <el-carousel-item v-for="(other, index) in otherList" :key="index">
              <ul class="recommend-list">
                <li v-for="item in other" :key="item.id" class="recommend-item">
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
            </el-carousel-item>
          </el-carousel>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { SearchApi } from "@/api";
export default {
  name: "search",
  data() {
    return {
      searchList: [],
      otherList: [],
      promotion: false,
      installment: false,
      onlyLookGood: false,
      isAsc: true,
      isActive: null
    };
  },
  created() {
    this.getSearchList();
    this.getOtherList();
  },
  methods: {
    getSearchList() {
      SearchApi.getSearchList().then(res => {
        this.searchList = res.data;
      });
    },
    getOtherList() {
      SearchApi.getOtherList().then(res => {
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
.breadcrumbs {
  height: 40px;
  font-size: 12px;
  background: #f5f5f5;
  .container {
    width: 1226px;
    margin: 0 auto;
    .custom-breadcrumb {
      line-height: 40px;
    }
  }
}
.search-filter {
  .container {
    width: 1226px;
    margin: 0 auto;
    padding: 18px 0;
    position: relative;
    ul {
      height: 48px;
    }
    ul > li {
      float: left;
      cursor: pointer;
      color: #424242;
      font-size: 14px;
      width: 148px;
      padding: 14px 0;
      height: 20px;
      line-height: 20px;
    }
    ul > li:hover {
      color: $textHover;
    }
    ul > li:first-child {
      color: #424242;
      cursor: default;
    }
  }
}
.search-result {
  padding: 20px 0 100px;
  background: #f5f5f5;
  .container {
    width: 1226px;
    margin: 0 auto;
    .order-list-box {
      position: relative;
      height: 30px;
      margin: 20px 0;
      .order-list {
        float: left;
        li {
          float: left;
          cursor: pointer;
          padding: 0 30px;
          border-right: 1px solid #e0e0e0;
        }
        li:hover {
          color: $textHover;
        }
        li:last-child {
          border-right: none;
        }
      }
      .type-list {
        float: right;
        li {
          float: left;
          margin-left: 30px;
        }
      }
    }
    .goods-list-box {
      width: 1226px;
      margin: 0;
      .goods-list {
        display: flex;
        flex-wrap: wrap;
        width: 1240px;
        .goods-item {
          width: 294px;
          height: 383px;
          padding-top: 47px;
          margin-right: 14px;
          margin-bottom: 14px;
          text-align: center;
          background: #fff;
          .title {
            margin: 16px auto 0;
            width: 230px;
            font-size: 14px;
            font-weight: 400;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
          }
          .price {
            margin: 0 0 15px;
            color: $colorPrimary;
            del {
              color: #b0b0b0;
            }
          }
          .thumbs {
            width: 100%;
            height: 37px;
            overflow: hidden;
            .thumb-list {
              li {
                display: inline-block;
                width: 34px;
                height: 34px;
                margin: 0 4px;
                border: 1px solid $colorPrimary;
                cursor: pointer;
              }
            }
          }
        }
      }
    }
  }
}
.search-favourite {
  background: #f5f5f5;
  .mi-recommend {
    width: 1226px;
    margin: 0 auto;
    padding: 20px 0 100px;
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
    .recommend-list {
      .recommend-item {
        float: left;
        width: 234px;
        margin-right: 14px;
        height: 300px;
        padding: 0;
        position: relative;
        overflow: hidden;
        background-color: #fff;
        font-size: 14px;
        text-align: center;
        &:last-child {
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
</style>

<style lang="scss">
.custom-breadcrumb {
  .el-breadcrumb__inner {
    color: #757575 !important;
    font-size: 12px;
  }
  .el-breadcrumb__inner a,
  .el-breadcrumb__inner.is-link {
    font-weight: 400;
  }
  .el-breadcrumb__inner.is-link:hover,
  .el-breadcrumb__inner a:hover {
    color: $textHover !important;
  }
}
.goods-item {
  .el-card__body {
    padding: 0;
  }
}
.search-swiper {
  .el-carousel__indicator.is-active button {
    border-color: $colorPrimary;
    border: 2px solid $colorPrimary;
    opacity: 1;
    background-color: rgba(0, 0, 0, 0);
  }
  .el-carousel__button {
    width: 8px;
    height: 8px;
    border-radius: 10px;
    opacity: 0.8;
  }
  .el-carousel__item:nth-child(2n),
  .el-carousel__item:nth-child(2n + 1) {
    background-color: unset;
  }
}
</style>
