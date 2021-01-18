import { BaseHttp as $http } from "@/common/service";
import { config } from "@/config";
const base = "goods";
export const SearchApi = {
  getSearchList() {
    return $http.mock("get", "/api/search");
  },
  getOtherList() {
    return $http.mock("get", "/api/search/other");
  }
};
