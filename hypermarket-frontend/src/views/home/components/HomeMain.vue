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
  }
}
</style>
