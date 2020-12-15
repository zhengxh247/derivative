import { BaseHttp as $http } from "@/common/service";
import { config } from "@/config";
const base = "goods";
export const GoodsApi = {
  getHeaderMenuList() {
    return $http.request("get", {}, `${config.api}/${base}/getAll`);
  },
  getViewList() {
    return $http.request("get", {}, `${config.api}/${base}/getView`);
  }
};
