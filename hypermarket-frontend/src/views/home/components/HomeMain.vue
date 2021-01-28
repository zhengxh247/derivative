<template>
  <div class="home-main">
    <div class="container">
      <home-flashsale></home-flashsale>
      <home-banner-box :imgUrl="phoneImgUrl"></home-banner-box>
      <home-brick-box :phoneList="phoneList" boxType="phone" title="手机">
        <template #hdMore>
          <a href="javascript:;" class="more-link">
            查看全部
            <i class="el-icon-arrow-right"></i>
          </a>
        </template>
        <template #leftContent>
          <li>
            <a href="javascript:;">
              <el-card shadow="hover">
                <img
                  src="//cdn.cnbj1.fds.api.mi-img.com/mi-mall/cb1bd61ad71c45a4f67f09b075463944.jpeg"
                  width="234"
                  height="614"
                />
              </el-card>
            </a>
          </li>
        </template>
      </home-brick-box>
      <home-banner-box :imgUrl="TVImgUrl"></home-banner-box>
      <home-brick-box :phoneList="phoneList" boxType="tv" title="家电">
        <template #hdMore>
          <ul class="tab-list">
            <li :class="{ 'tab-active': isHot }" @mouseenter="isHot = true">
              热门
            </li>
            <li :class="{ 'tab-active': !isHot }" @mouseenter="isHot = false">
              电视影音
            </li>
          </ul>
        </template>
        <template #leftContent>
          <li class="brick-item-m">
            <a href="javascript:;">
              <el-card shadow="hover">
                <img
                  src="//cdn.cnbj1.fds.api.mi-img.com/mi-mall/116fc43816b87192be4e67cf762e8da5.jpeg"
                  width="234"
                  height="300"
                />
              </el-card>
            </a>
          </li>
          <li class="brick-item-m">
            <a href="javascript:;">
              <el-card shadow="hover">
                <img
                  src="//cdn.cnbj1.fds.api.mi-img.com/mi-mall/7e03c0fe4af4d613603f22aaa8e0ea00.jpg"
                  width="234"
                  height="300"
                />
              </el-card>
            </a>
          </li>
        </template>
        <template #bdMore>
          <li class="more">
            <el-card shadow="hover">
              <a href="javascript:;" class="more-link">
                <div class="figure-more">
                  <i class="el-icon-right"></i>
                </div>
                <div class="title">
                  浏览更多
                  <small>电视影音</small>
                </div>
              </a>
            </el-card>
          </li>
        </template>
      </home-brick-box>
    </div>
  </div>
</template>

<script>
import { GoodsApi } from "@/api";
import HomeFlashsale from "./HomeFlashsale.vue";
import HomeBannerBox from "./HomeBannerBox.vue";
import HomeBrickBox from "./HomeBrickBox.vue";
export default {
  name: "HomeMain",
  components: {
    HomeFlashsale,
    HomeBannerBox,
    HomeBrickBox
  },
  data() {
    return {
      phoneImgUrl:
        "//cdn.cnbj1.fds.api.mi-img.com/mi-mall/a59db7dac2804ee2b5c7be1b02b3770e.jpg",
      TVImgUrl:
        "//cdn.cnbj1.fds.api.mi-img.com/mi-mall/41d16e66381cfeda7b6b39ab67678d5e.jpg",
      phoneList: [],
      isHot: true
    };
  },
  created() {
    this.getPhoneList();
  },
  methods: {
    getPhoneList() {
      GoodsApi.getPhoneList().then(res => {
        this.phoneList = res.data;
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.home-main {
  padding-top: 4px;
  padding-bottom: 12px;
  background: #f5f5f5;
  .container {
    width: 1226px;
    margin: 0 auto;
    .home-brick-box {
      margin-bottom: 8px;
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
        .more {
          position: absolute;
          top: 0;
          right: 0;
          .more-link {
            font-size: 16px;
            line-height: 58px;
            color: #424242;
          }
          .more-link:hover {
            color: $colorPrimary;
          }
          .tab-list {
            margin: 0;
            padding: 16px 0 0;
            list-style-type: none;
            font-size: 16px;
            li {
              display: inline-block;
              margin: 0 0 0 30px;
              cursor: pointer;
            }
            li:hover,
            .tab-active {
              color: #ff6700;
              border-bottom: 2px solid #ff6700;
            }
          }
        }
      }
      .box-bd {
        .row {
          .span4 {
            width: 234px;
            float: left;
            .brick-promo-list {
              height: 614px;
              .brick-item-m {
                margin-bottom: 14px;
              }
            }
          }
          .span16 {
            width: 978px;
            float: left;
            .brick-list {
              width: 992px;
              height: 614px;
              .brick-item {
                position: relative;
                float: left;
                width: 234px;
                height: 300px;
                margin-left: 14px;
                margin-bottom: 14px;
                background: #fff;
                .figure-img {
                  width: 160px;
                  height: 160px;
                  padding-top: 20px;
                  margin: 0 auto 18px;
                }
                .title {
                  margin: 0 10px 2px;
                  font-size: 14px;
                  font-weight: 400;
                  color: #333;
                  text-align: center;
                  text-overflow: ellipsis;
                  white-space: nowrap;
                  overflow: hidden;
                }
                .desc {
                  margin: 0 10px 10px;
                  height: 18px;
                  font-size: 12px;
                  color: #b0b0b0;
                  text-align: center;
                  text-overflow: ellipsis;
                  white-space: nowrap;
                  overflow: hidden;
                }
                .price {
                  text-align: center;
                  color: #ff6700;
                  margin: 0 10px 14px;
                }
              }
              .brick-item-s:nth-child(8) {
                height: 93px;
                .figure-img {
                  position: absolute;
                  right: 20px;
                  top: 32px;
                  width: 80px;
                  height: 80px;
                  margin: 0;
                  padding: 0;
                  img {
                    width: 80px;
                    height: 80px;
                  }
                }
                .title {
                  margin: -10px 110px 5px 30px;
                  font-size: 14px;
                  font-weight: 400;
                  text-align: left;
                  text-overflow: unset;
                  white-space: unset;
                  overflow: unset;
                }
                .price {
                  margin: 0 110px 0 30px;
                  font-size: 12px;
                  color: #ff6700;
                  text-align: left;
                }
              }
              .more {
                position: relative;
                z-index: 1;
                float: left;
                width: 234px;
                height: 93px;
                margin-top: 50px;
                margin-left: 14px;
                margin-bottom: 14px;
                background: #fff;
                // .more-link {
                //   .figure-more {
                //     position: absolute;
                //     right: 35px;
                //     top: 48px;
                //     width: 40px;
                //     height: 40px;
                //     color: #ff6700;
                //     border: 2px solid #ff6700;
                //     border-radius: 50%;
                //     i {
                //       font-size: 40px;
                //       line-height: 40px;
                //     }
                //   }
                //   .title {
                //     display: block;
                //     margin: 0 110px 0 30px;
                //     font-size: 18px;
                //     color: #333;
                //     small {
                //       display: block;
                //       font-size: 12px;
                //       color: #757575;
                //     }
                //   }
                // }
              }
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
    }
  }
}
</style>
