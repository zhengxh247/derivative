import { BaseHttp as $http } from "@/common/service";
import { config } from "@/config";
const base = "authentication";

export const LoginApi = {
  login(data) {
    return $http.request("post", data, `${config.api}/${base}/login`);
  },
  getAuthCode(param) {
    return $http.request("get", {}, `${config.api}/code/sms`, param);
  },
  authCodeLogin(data) {
    return $http.request("post", data, `${config.api}/${base}/mobile`);
  }
};
