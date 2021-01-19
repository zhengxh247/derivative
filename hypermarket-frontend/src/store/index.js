import Vue from "vue";
import Vuex from "vuex";
import cart from "./modules/cart.js";
import product from "./modules/products.js";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: {
    cart,
    product
  }
});
