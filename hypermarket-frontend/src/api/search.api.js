import { BaseHttp as $http } from "@/common/service";
import { config } from "@/config";
const base = "goods";
export const SearchApi = {
  getSearchList(params = {}) {
    return $http.request("get", {}, `${config.api}/${base}/select`, params);
  },
  getOtherList() {
    return $http.mock("get", "/api/search/other");
  }
};
