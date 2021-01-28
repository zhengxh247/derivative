<template>
  <div class="home-flashsale">
    <div class="box-hd">
      <h2 class="title">小米秒杀</h2>
    </div>
    <div class="box-bd clearfix">
      <div class="row">
        <div class="flashsale-countdown">
          <p class="round">10:00 场</p>
          <img src="../../../assets/images/untitled.png" />
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
          <el-carousel
            trigger="click"
            :autoplay="false"
            :loop="false"
            arrow="always"
            ref="carousel"
            indicator-position="none"
          >
            <el-carousel-item
              v-for="(Flashsale, i) in FlashsaleList"
              :key="i"
              name="i"
            >
              <ul class="swiper-wrapper">
                <li
                  :class="'rainbow-item-' + item.index"
                  v-for="item in Flashsale"
                  :key="item.id"
                >
                  <a href="javascript:;" class="item">
                    <div class="content">
                      <div class="thumb">
                        <img :src="item.imgUrl" />
                      </div>
                      <h3 class="title">{{ item.goodName }}</h3>
                      <p class="desc">{{ item.desc }}</p>
                      <p class="price">
                        <span>{{ item.price }}元 </span>
                        <del>{{ item.originalPrice }}元</del>
                      </p>
                    </div>
                  </a>
                </li>
              </ul>
            </el-carousel-item>
          </el-carousel>
        </div>
        <div class="swiper-carousel">
          <span
            class="swiper-flashsale-prev"
            :class="{ 'swiper-button-disabled': carouselIndex == 0 }"
            @click="carouselPrev"
          >
            <i class="el-icon-arrow-left"></i>
          </span>
          <span
            class="swiper-flashsale-next"
            :class="{ 'swiper-button-disabled': carouselIndex == 6 }"
            @click="carouselNext"
          >
            <i class="el-icon-arrow-right"></i>
          </span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { GoodsApi } from "@/api";
export default {
  name: "HomeFlashsale",
  data() {
    return {
      FlashsaleList: [],
      carouselIndex: 0
    };
  },
  created() {
    this.getFlashsaleList();
  },
  methods: {
    getFlashsaleList() {
      GoodsApi.getFlashsaleList().then(res => {
        this.FlashsaleList = res.data;
      });
    },
    carouselPrev() {
      this.carouselIndex--;
      if (this.carouselIndex < 0) {
        this.carouselIndex = 0;
      }
      this.$refs.carousel.setActiveItem(this.carouselIndex);
    },
    carouselNext() {
      this.carouselIndex++;
      if (this.carouselIndex > 6) {
        this.carouselIndex = 6;
      }
      this.$refs.carousel.setActiveItem(this.carouselIndex);
    }
  }
};
</script>

<style lang="scss" scoped>
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
          display: block;
          li {
            width: 234px;
            margin-right: 14px;
            border-top-width: 1px;
            border-top-style: solid;
            text-align: center;
            float: left;
            background: #fff;
            transition: all 0.6s;
            position: relative;
            list-style: none;
            .item {
              display: block;
              height: 300px;
              padding-top: 39px;
              position: relative;
              .thumb {
                width: 160px;
                margin: 0 auto 22px;
                img {
                  width: 160px;
                  height: 160px;
                }
              }
              .title {
                margin: 0 20px 3px;
                font-size: 14px;
                font-weight: 400;
                text-overflow: ellipsis;
                color: #212121;
                overflow: hidden;
                white-space: nowrap;
              }
              .desc {
                height: 18px;
                margin: 0 20px 12px;
                font-size: 12px;
                text-overflow: ellipsis;
                color: #b0b0b0;
                overflow: hidden;
                white-space: nowrap;
              }
              .price {
                margin: 0;
                font-size: 14px;
                color: #ff6709;
                del {
                  color: #b0b0b0;
                }
              }
            }
          }
          li:last-child {
            margin-right: 0;
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
      .swiper-carousel {
        position: absolute;
        right: 0;
        top: 24px;
        .swiper-flashsale-prev,
        .swiper-flashsale-next {
          display: inline-block;
          width: 24px;
          height: 16px;
          padding: 3px 5px;
          margin-left: -1px;
          border: 1px solid #e0e0e0;
          font-size: 16px;
          line-height: 16px;
          transition: color 0.5s;
          color: #b0b0b0;
          text-align: center;
          cursor: pointer;
          i {
            font-weight: 600;
          }
          &:hover {
            color: $colorPrimary;
          }
        }
        .swiper-button-disabled {
          color: #e0e0e0;
          cursor: default;
          pointer-events: none;
        }
      }
    }
    .row:after,
    .row:before {
      content: " ";
      display: table;
    }
    .row:after {
      clear: both;
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
</style>

<style lang="scss">
.flashsale-list {
  .el-carousel__container {
    height: 340px;
    .el-carousel__arrow {
      display: none;
    }
  }
}
</style>
