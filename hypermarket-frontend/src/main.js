import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import "./plugins/element.js";
import "../public/styles/index.scss";
import "@/assets/iconfont/iconfont.css";
import i18n from "@/lang";

require("./mock");

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  i18n,
  render: h => h(App)
}).$mount("#app");
