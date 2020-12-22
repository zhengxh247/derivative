<template>
  <div class="home-tool-bar">
    <a href="javascript:;" class="item">
      <div>icon</div>
      <span>手机APP</span>
    </a>
    <a href="javascript:;" class="item">
      <div>icon</div>
      <span>个人中心</span>
    </a>
    <a href="javascript:;" class="item">
      <div>icon</div>
      <span>售后服务</span>
    </a>
    <a href="javascript:;" class="item">
      <div>icon</div>
      <span>人工服务</span>
    </a>
    <a href="javascript:;" class="item">
      <div>icon</div>
      <span>购物车</span>
    </a>
    <a href="javascript:;" class="item backtop">
      <div>icon</div>
      <span>返回顶部</span>
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
  .item {
    position: relative;
    display: block;
    width: 82px;
    height: 90px;
    margin-top: -1px;
    background-color: #fff;
    border: 1px solid #f5f5f5;
    text-align: center;
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
