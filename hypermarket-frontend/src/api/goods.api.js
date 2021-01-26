import { BaseHttp as $http } from "@/common/service";
import { config } from "@/config";
const base = "goods";
export const GoodsApi = {
  getHeaderMenuList() {
    return $http.request("get", {}, `${config.api}/${base}/getAll`);
  },
  getSwiperList() {
    return $http.request("get", {}, `${config.api}/${base}/getView`);
  },
  getGroupMenuList() {
    return $http.request("get", {}, `${config.api}/${base}/getGroupAll`);
  },
  getFlashsaleList() {
    return $http.mock("get", "/api/home/flashsale");
  },
  getPhoneList() {
    return $http.mock("get", "/api/home/phone");
  }
};
