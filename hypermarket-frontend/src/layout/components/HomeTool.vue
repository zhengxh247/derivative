<template>
  <div class="home-tool-bar">
    <a href="javascript:;" class="item">
      <div class="icon">
        <img
          src="https://i8.mifile.cn/b2c-mimall-media/98a23aae70f25798192693f21c4d4039.png"
        />
      </div>
      <span>手机APP</span>
    </a>
    <a href="javascript:;" class="item">
      <div class="icon">
        <img
          src="https://i8.mifile.cn/b2c-mimall-media/55cad219421bee03a801775e7309b920.png"
        />
      </div>
      <span>个人中心</span>
    </a>
    <a href="javascript:;" class="item">
      <div class="icon">
        <img
          src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/12eb0965ab33dc8e05870911b90f3f13.png"
        />
      </div>
      <span>售后服务</span>
    </a>
    <a href="javascript:;" class="item">
      <div class="icon">
        <img
          src="https://i8.mifile.cn/b2c-mimall-media/4f036ae4d45002b2a6fb6756cedebf02.png"
        />
      </div>
      <span>人工客服</span>
    </a>
    <a href="javascript:;" class="item">
      <div class="icon">
        <img
          src="https://i8.mifile.cn/b2c-mimall-media/d7db56d1d850113f016c95e289e36efa.png"
        />
      </div>
      <span>购物车</span>
    </a>
    <a href="javascript:;" class="item backtop">
      <div class="icon">
        <img src="//i1.mifile.cn/f/i/2018/home/totop.png" />
      </div>
      <span>回顶部</span>
    </a>
  </div>
</template>

<script>
export default {
  name: "HomeTool"
};
</script>

<style lang="scss" scoped>
.home-tool-bar {
  position: fixed;
  bottom: 70px;
  right: 0;
  z-index: 102;
  .item {
    position: relative;
    display: block;
    width: 82px;
    height: 90px;
    margin-top: -1px;
    background-color: #fff;
    border: 1px solid #f5f5f5;
    text-align: center;
    .icon {
      width: 30px;
      height: 30px;
      margin: 0 auto 8px;
      padding-top: 18px;
      img {
        width: 30px;
        height: 30px;
      }
    }
  }
  .item:hover {
    color: $textHover;
  }
  .backtop {
    visibility: hidden;
    margin-top: 14px;
  }
}
</style>
