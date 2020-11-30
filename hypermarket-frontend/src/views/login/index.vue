<template>
  <div class="login-container">
    <login-header></login-header>
    <login-main></login-main>
    <login-footer></login-footer>
  </div>
</template>

<script>
import LoginHeader from "./components/LoginHeader.vue";
import LoginMain from "./components/LoginMain.vue";
import LoginFooter from "./components/LoginFooter.vue";
export default {
  components: {
    LoginHeader,
    LoginMain,
    LoginFooter
  },
  data() {
    return {};
  }
};
</script>

<style lang="scss" scoped></style>
