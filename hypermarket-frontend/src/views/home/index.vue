<template>
  <div class="home-container">
    <div class="home-hero-container">
      <home-hero></home-hero>
      <home-hero-sub></home-hero-sub>
    </div>
    <home-main></home-main>
  </div>
</template>

<script>
import HomeHero from "./components/HomeHero.vue";
import HomeHeroSub from "./components/HomeHeroSub.vue";
import HomeMain from "./components/HomeMain.vue";
export default {
  name: "Home",
  components: {
    HomeHero,
    HomeHeroSub,
    HomeMain
  }
};
</script>

<style lang="scss" scoped>
.home-hero-container {
  width: 1226px;
  margin: 0 auto;
  position: relative;
}
</style>
