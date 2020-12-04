import { BaseHttp as $http } from "@/common/service";
import { config } from "@/config";
const base = "authentication";

export const LoginApi = {
  login(data) {
    return $http.request("post", data, `${config.api}/${base}/login`);
  }
};
