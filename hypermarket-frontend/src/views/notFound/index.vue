<template>
  <div class="notFound-container">
    <div class="container">
      <img src="../../assets/images/404.jpg" />
      <p class="sorry">咦~页面不见了~</p>
      <router-link to="/" href="javascript:;" class="goto">
        返回首页 mi.com
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "NotFound"
};
</script>

<style lang="scss" scoped>
.notFound-container {
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  width: 100%;
  height: 100vh;
  img {
    height: 400px;
  }
  .sorry {
    font-size: 45px;
    line-height: 68px;
    margin: 45px 0;
  }
  .goto {
    font-size: 30px;
    line-height: 68px;
    color: #0b72a4;
    margin: 30px 0;
  }
}
</style>
