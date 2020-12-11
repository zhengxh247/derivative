<template>
  <div class="home-container">
    <div class="header">
      <div class="topbar-banner-Wrapper">
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
            <div class="cart-mini">
              <!-- <i class="iconfont icon-gouwuche"></i> -->
              <span>购物车(0)</span>
            </div>
            <div class="cart-menu">
              some value
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
            <a href="javascript:;" class="logo"></a>
          </div>
          <div class="doodle">
            <a href="javascript:;" class="link-block"></a>
          </div>
          <div class="header-nav">
            <div class="nav-item">
              <span class="title">小米手机</span>
              <div class="item-children">
                <div class="item-container">小米手机</div>
              </div>
              <span class="title">Redmi 红米</span>
              <div class="item-children">
                <div class="item-container"></div>
              </div>
              <span class="title">电视</span>
              <div class="item-children">
                <div class="item-container">电视</div>
              </div>
              <span class="title">笔记本</span>
              <div class="item-children">
                <div class="item-container"></div>
              </div>
              <span class="title">家电</span>
              <div class="item-children">
                <div class="item-container"></div>
              </div>
              <span class="title">路由器</span>
              <div class="item-children">
                <div class="item-container"></div>
              </div>
              <span class="title">智能硬件</span>
              <div class="item-children">
                <div class="item-container"></div>
              </div>
              <span>服务</span>
              <span>社区</span>
            </div>
          </div>
          <div class="header-search">
            <el-input v-model="search" placeholder="Redmi K30 Pro 变焦版">
              <el-button slot="append" icon="el-icon-search"></el-button>
            </el-input>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      search: ""
    };
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
      }
      .cart-menu {
        display: none;
        position: absolute;
        width: 316px;
        height: 100px;
        text-align: center;
        right: 0;
        top: 40px;
        z-index: 1;
        background: #fff;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.15);
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
        padding-top: 5px;
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
          position: absolute;
          left: 0;
          width: 100%;
          border-top: 1px solid #e0e0e0;
          box-shadow: 0px 5px 8px -5px rgba(128, 128, 128, 0.5);
          box-sizing: border-box;
          .item-container {
            width: 1226px;
            height: 200px;
            margin: 0 auto;
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
