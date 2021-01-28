<template>
  <div class="home-banner-box">
    <a href="javascript:;">
      <img :src="imgUrl" width="1226" height="120" />
    </a>
  </div>
</template>

<script>
export default {
  name: "HomeBannerBox",
  props: {
    imgUrl: {
      type: String,
      required: true
    }
  }
};
</script>

<style lang="scss" scoped>
.home-banner-box {
  height: 120px;
  margin: 22px 0;
  overflow: hidden;
}
</style>
