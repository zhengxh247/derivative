<template>
  <div>
    <header-nav></header-nav>
    <transition name="fade" mode="out-in">
      <router-view></router-view>
    </transition>
    <footer-nav></footer-nav>
    <home-tool></home-tool>
  </div>
</template>

<script>
import HeaderNav from "./components/HeaderNav.vue";
import HomeTool from "./components/HomeTool.vue";
import FooterNav from "./components/FooterNav.vue";
export default {
  name: "Home",
  components: {
    HeaderNav,
    HomeTool,
    FooterNav
  }
};
</script>
