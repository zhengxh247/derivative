<template>
  <div class="home-container">
    <home-header></home-header>
    <home-main></home-main>
    <home-tool></home-tool>
  </div>
</template>

<script>
import HomeHeader from "./components/HomeHeader.vue";
import HomeMain from "./components/HomeMain.vue";
import HomeTool from "./components/HomeTool.vue";
export default {
  name: "Home",
  components: {
    HomeHeader,
    HomeMain,
    HomeTool
  }
};
</script>
