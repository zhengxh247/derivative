import { BaseHttp as $http } from "@/common/service";
import { config } from "@/config";
const base = "goods";
export const CartApi = {
  getCartList() {
    return $http.mock("get", "/api/cart");
  },
  getOtherList() {
    return $http.mock("get", "/api/cart/other");
  }
};
