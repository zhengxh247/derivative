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
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home"
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
    .sep {
      margin: 0.3em;
      color: #424242;
    }
  }
}
</style>
