import { CartApi } from "@/api";

export default {
  namespaced: true,
  state: {
    cartList: []
  },
  getters: {
    getCartList: ({ cartList }) => cartList,
    productCount: ({ cartList }) => {
      return cartList.reduce((sum, cart) => {
        return sum + cart.num;
      }, 0);
    },
    checkedProductCount: ({ cartList }) => {
      return cartList.reduce((sum, cart) => {
        if (cart.check) {
          sum += cart.num;
        }
        return sum;
      }, 0);
    },
    checkedPriceTotal: ({ cartList }) => {
      return cartList
        .reduce((sum, cart) => {
          if (cart.check) {
            sum += parseFloat(cart.subtotal);
          }
          return sum;
        }, 0)
        .toFixed(2);
    }
  },
  mutations: {
    updateCartList: (state, data) => {
      state.cartList = data;
    },
    addProductToCart: ({ cartList }, product) => {
      const prod = cartList.find(cart => cart.id == product.id);
      if (prod) {
        prod.check = true;
        prod.num++;
        prod.subtotal = prod.salePrice * prod.num;
      } else {
        cartList = [
          ...cartList,
          {
            ...product,
            check: true,
            num: 1,
            subtotal: prod.salePrice
          }
        ];
      }
    },
    updateAllProductChecked: ({ cartList }, checked) => {
      cartList.forEach(cart => {
        cart.check = checked;
      });
    },
    updateProductChecked: ({ cartList }, { productId, checked }) => {
      const prod = cartList.find(cart => cart.id == productId);
      prod && (prod.check = checked);
    },
    updateProductNum: ({ cartList }, { productId, count }) => {
      const prod = cartList.find(cart => cart.id == productId);
      if (prod) {
        prod.num = count;
        prod.subtotal = (prod.salePrice * count).toFixed(2);
      }
    },
    deleteProduct: ({ cartList }, productId) => {
      const index = cartList.findIndex(cart => cart.id == productId);
      index != -1 && cartList.splice(index, 1);
    }
  },
  actions: {
    getCartList: ({ commit }, userId = 0) => {
      // const res = await CartApi.getCartList();
      // commit("updateCartList", res.data);
      // return res;
      return CartApi.getCartList().then(res => {
        commit("updateCartList", res.data);
        return res;
      });
    }
  }
};
