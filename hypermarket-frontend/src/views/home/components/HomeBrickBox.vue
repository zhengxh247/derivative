<template>
  <div class="home-brick-box">
    <div class="box-hd">
      <h2 class="title">{{ title }}</h2>
      <div class="more">
        <slot name="hdMore"></slot>
      </div>
    </div>
    <div class="box-bd">
      <div class="row">
        <div class="span4">
          <ul class="brick-promo-list">
            <slot name="leftContent"></slot>
          </ul>
        </div>
        <div class="span16">
          <ul class="brick-list">
            <li
              v-for="(phone, index) in phoneList"
              :key="phone.id"
              class="brick-item"
              :class="{ 'brick-item-s': boxType == 'tv' }"
            >
              <el-card shadow="hover">
                <a href="javascript:;">
                  <div class="figure-img">
                    <img :src="phone.imgUrl" />
                  </div>
                  <h3 class="title">{{ phone.goodName }}</h3>
                  <p class="desc" v-if="index != 7">
                    {{ phone.desc }}
                  </p>
                  <p class="price">
                    <span class="num">{{ phone.price }}元</span>
                    <span>起</span>
                  </p>
                </a>
              </el-card>
            </li>
            <slot name="bdMore"></slot>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeBrickBox",
  props: {
    title: {
      type: String,
      required: true
    },
    phoneList: {
      type: Array,
      required: true,
      default: () => {
        return [];
      }
    },
    boxType: {
      type: String,
      required: true
    }
  }
};
</script>

<style lang="scss" scoped>
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
            .more-link {
              .figure-more {
                position: absolute;
                right: 35px;
                top: 48px;
                width: 40px;
                height: 40px;
                color: #ff6700;
                border: 2px solid #ff6700;
                border-radius: 50%;
                i {
                  font-size: 40px;
                  line-height: 40px;
                }
              }
              .title {
                display: block;
                margin: 0 110px 0 30px;
                font-size: 18px;
                color: #333;
                small {
                  display: block;
                  font-size: 12px;
                  color: #757575;
                }
              }
            }
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
</style>

<style lang="scss">
.home-brick-box {
  .brick-promo-list {
    .el-card__body {
      height: 614px;
    }
    .brick-item-m {
      .el-card__body {
        height: 300px;
      }
    }
  }
  .brick-list {
    .el-card__body {
      height: 300px;
    }
    .brick-item-s:nth-child(8),
    .more {
      .el-card__body {
        height: 93px;
        padding-top: 50px;
      }
    }
  }
  .el-card {
    border: 0;
    .el-card__body {
      padding: 0;
    }
  }
}
</style>
