<template>
  <div class="detail-container">
    <div class="xm-product-box">
      <div class="container">
        <h2>小米10至尊纪念版</h2>
        <div class="con">
          <div class="left">
            <span class="separator">|</span>
            <a href="javascript:;">小米10</a>
            <span class="separator">|</span>
            <a href="javascript:;">小米10 青春版</a>
            <span class="separator">|</span>
            <a href="javascript:;">小米11</a>
          </div>
          <div class="right">
            <a href="javascript:;">概述</a>
            <span class="separator">|</span>
            <a href="javascript:;">参数</a>
            <span class="separator">|</span>
            <a href="javascript:;">F码通道</a>
            <span class="separator">|</span>
            <a href="javascript:;">咨询客服</a>
            <span class="separator">|</span>
            <a href="javascript:;">用户评价</a>
          </div>
        </div>
      </div>
    </div>
    <div class="mi-detail">
      <div class="login-notic">
        <div class="container">
          为方便您购买，请提前登录
          <router-link to="/login" class="login">
            立即登录
          </router-link>
          <i class="el-icon-close"></i>
        </div>
      </div>
      <div class="product-box">
        <div class="img-left">
          <el-carousel :interval="5000" arrow="always">
            <el-carousel-item v-for="item in 4" :key="item">
              <h3>{{ item }}</h3>
            </el-carousel-item>
          </el-carousel>
        </div>
        <div class="product-con">
          <h2>小米10至尊纪念版</h2>
          <p class="sale-desc">
            「十年献礼，巅峰美学；最高享12期免息」120X 超远变焦 / 120W 秒充科技
            / 120Hz刷新率 + 240Hz采样率 / 骁龙865旗舰处理器 / 双模5G /
            10倍混合光学变焦 / OIS光学防抖+EIS数字防抖 / 2000万超清前置相机 /
            双串蝶式石墨烯基锂离子电池 / 等效4500mAh大电量 / 120W
            有线秒充+50W无线秒充+10W无线反充 / WiFi 6 / 多功能NFC / 红外遥控
          </p>
          <p class="company-info">小米自营</p>
          <p class="price-info">5900 元</p>
          <div class="line"></div>
          <div class="address-box">
            <div class="product-address">
              <i class="el-icon-location-outline"></i>
              <div class="address-info">
                <span>重庆</span>
                <span>重庆市</span>
                <span>渝北区</span>
                <span>大竹林街道</span>
                <a href="javascript:;" class="edit">修改</a>
              </div>
              <div class="info">该地区暂时缺货</div>
            </div>
          </div>
          <div class="buy-option">
            <div class="buy-box-child">
              <div class="title">选择颜色</div>
              <ul class="clearfix">
                <li class="active"><a href="javascript:;">透明版</a></li>
                <li><a href="javascript:;">陶瓷黑</a></li>
                <li><a href="javascript:;">亮银版</a></li>
              </ul>
            </div>
            <div class="buy-box-child">
              <div class="title">选择版本</div>
              <ul class="clearfix">
                <li class="active"><a href="javascript:;">8GB+128GB</a></li>
                <li><a href="javascript:;">8GB+256GB</a></li>
                <li><a href="javascript:;">12GB+256GB</a></li>
              </ul>
            </div>
          </div>
          <div class="selected-list">
            <p>小米10至尊纪念版<span>5900元</span></p>
            <div class="total-price">5900元</div>
          </div>
          <div class="btn-box">
            <div class="sale-btn" :class="{ isStock: true }">
              <!-- <a href="javascript:;" class="btn-line-primary">到货通知</a> -->
              <a href="javascript:;" class="btn-primary">加入购物车</a>
            </div>
            <div class="favorite-btn">
              <a href="javascript:;">喜欢</a>
            </div>
          </div>
          <div class="after-sale-info">
            <span class="support">
              <i class="el-icon-circle-check"></i>
              <em>小米自营</em>
            </span>
            <span class="support">
              <i class="el-icon-circle-check"></i>
              <em>小米发货</em>
            </span>
            <span class="support">
              <i class="el-icon-circle-check"></i>
              <em>7天无理由退货</em>
            </span>
            <span class="support">
              <i class="el-icon-circle-check"></i>
              <em>运费说明</em>
            </span>
            <span class="support">
              <i class="el-icon-circle-check"></i>
              <em>企业信息</em>
            </span>
            <span class="support">
              <i class="el-icon-circle-check"></i>
              <em>30天价格保护</em>
            </span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  }
};
</script>

<style lang="scss" scoped>
.xm-product-box {
  position: sticky;
  top: 0;
  background: #fff;
  border-top: 1px solid #e0e0e0;
  border-bottom: 1px solid #e0e0e0;
  box-shadow: 0 5px 5px rgba(0, 0, 0, 0.07);
  height: 63px;
  width: 100%;
  z-index: 12;
  margin-top: 0;
  color: #616161;
  .container {
    width: 1226px;
    margin: 0 auto;
    h2 {
      font-size: 18px;
      font-weight: 400;
      line-height: 60px;
      color: #424242;
      float: left;
    }
    .left {
      float: left;
      margin-left: 5px;
      font-size: 12px;
      margin-top: 21px;
      .separator {
        margin: 0 0.5em;
        color: #424242;
      }
      a {
        color: #616161;
      }
    }
    .right {
      float: right;
      font-size: 12px;
      margin: 17px 0 0 0;
      .separator {
        margin: 0 0.7em;
        color: #e0e0e0;
      }
      a {
        color: #616161;
      }
    }
    a:hover {
      color: $textHover;
    }
  }
}
.login-notic {
  background: #f7f7f7;
  width: 100%;
  text-align: center;
  height: 48px;
  line-height: 48px;
  color: #333;
  .container {
    width: 1226px;
    margin: 0 auto;
    .login {
      color: $textHover;
      margin-left: 25px;
    }
    i {
      cursor: pointer;
      margin-left: 7px;
    }
  }
}
.product-box {
  display: flex;
  padding-top: 32px;
  width: 1226px;
  margin: 0 auto;
  .img-left {
    width: 606px;
    position: relative;
  }
  .product-con {
    flex: 1;
    margin-left: 20px;
    h2 {
      margin: 0;
      padding: 0;
      font-size: 24px;
      font-weight: 400;
      color: #212121;
    }
    .sale-desc {
      font-size: 14px;
      color: #b0b0b0;
      margin: 0;
      padding: 0;
      padding-top: 8px;
      line-height: 1.5;
    }
    .company-info {
      font-size: 14px;
      color: $colorPrimary;
      margin-top: 10px;
      margin-bottom: 0;
    }
    .price-info {
      font-size: 18px;
      line-height: 1;
      color: $colorPrimary;
      padding: 12px 0 10px;
    }
    .line {
      margin-top: 12px;
      border-bottom: 1px solid #e0e0e0;
    }
    .address-box {
      margin: 20px 0;
      .product-address {
        padding: 30px 50px;
        font-size: 14px;
        position: relative;
        background: #fafafa;
        border: 1px solid #e0e0e0;
        i {
          position: absolute;
          left: 20px;
          font-size: 20px;
          color: #999;
        }
        .address-info {
          span {
            margin-right: 14px;
          }
          .edit {
            color: $colorPrimary;
          }
        }
        .info {
          color: $colorPrimary;
        }
      }
    }
    .buy-option {
      .buy-box-child {
        margin-bottom: 30px;
        position: relative;
        .clearfix,
        .clearfix:after {
          clear: both;
        }
        .clearfix:after,
        .clearfix:before {
          content: "";
          display: block;
        }
        ul > li {
          margin-right: 12px;
          margin-top: 10px;
          line-height: 42px;
          height: 42px;
          border: 1px solid #e0e0e0;
          cursor: pointer;
          transition: all 0.2s ease;
          float: left;
          width: 292px;
          font-size: 16px;
          text-align: center;
        }
        ul > li:nth-child(2n) {
          margin-right: 0;
        }
        ul > li:hover {
          border-color: $textHover;
        }
        .active {
          border-color: $textHover;
          a {
            color: $textHover;
          }
        }
        ul > li:hover a {
          color: $textHover;
        }
      }
    }
    .selected-list {
      background: #f9f9fa;
      padding: 30px;
      margin-bottom: 30px;
      span {
        float: right;
      }
      .total-price {
        color: #ff6700;
        font-size: 24px;
        padding-top: 20px;
      }
    }
    .btn-box {
      margin: 10px 0 20px 0;
      display: flex;
      .sale-btn {
        width: 298px;
        height: 52px;
        line-height: 52px;
        font-size: 16px;
        text-align: center;
        margin-right: 10px;
        border: 1px solid $colorPrimary;
        .btn-line-primary {
          color: $colorPrimary;
        }
        .btn-primary {
          color: #fff;
        }
      }
      .isStock {
        background: $colorPrimary;
      }
      .favorite-btn {
        width: 140px;
        height: 52px;
        line-height: 52px;
        background: #b0b0b0;
        border: 1px solid #b0b0b0;
        text-align: center;
        cursor: pointer;
        font-size: 16px;
        a {
          color: #fff;
        }
      }
    }
    .after-sale-info {
      .support {
        display: inline-block;
        margin-right: 15px;
        line-height: 30px;
        margin-bottom: 10px;
        white-space: nowrap;
        color: #b0b0b0;
        i {
          font-size: 20px;
          display: inline-block;
          font-style: normal;
          vertical-align: middle;
        }
        em {
          font-style: normal;
          display: inline-block;
          margin-left: 2px;
          vertical-align: middle;
        }
      }
    }
  }
}
</style>

<style lang="scss">
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>
