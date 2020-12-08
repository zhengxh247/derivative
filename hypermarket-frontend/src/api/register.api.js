import { BaseHttp as $http } from "@/common/service";
import { config } from "@/config";
const base = "user";

export const RegisterApi = {
  register(data) {
    return $http.request("post", data, `${config.api}/${base}/register`);
  }
};
