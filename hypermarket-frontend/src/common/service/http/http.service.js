import axios from "axios";
/**
 * http类
 * @author Jack
 * @param method 请求方式 POST/PUT/GET/DELETE
 * @param baseUrl 请求的根地址
 * @param url 请求的url
 * @param params 参数或者path路径参数
 * @param data  query参数处理
 * @return {Promise<void>}
 */
class HttpService {
  constructor() {
    axios.defaults.timeout = 30000;
    // axios.defaults.baseURL = process.env.VUE_APP_SERVER_API_PATH;
    // 请求拦截器
    axios.interceptors.request.use(configs => {
      const data = JSON.parse(localStorage.getItem("userInfo"));
      if (data) {
        configs.headers.common.authorization = data.authorization;
      }
      return configs;
    });
    // 返回拦截器
    axios.interceptors.response.use(response => {
      return response;
    });
  }

  /**
   * http请求获取方式， GET
   * @param  url 请求的url
   * @param  method 请求方式 POST/PUT/GET/DELETE
   * @param data 参数或者path路径参数
   * @param params  query参数处理
   * @return {Promise<void>}
   */
  request(method, data, url, params = {}, other) {
    let options = {};
    // 判断method类型
    if (method === "get" || method === "delete") {
      data && Object.values(data).forEach(item => (url += "/" + item));
      // query参数处理
      if (method === "delete") {
        options = { method, url, data: params, params: other };
      } else {
        params &&
          Object.keys(params).forEach(key => {
            if (!params[key]) delete params[key];
          });
        options = { method, url, data: {}, params };
      }
    } else {
      options = { method, url, data, params };
    }
    return axios(options)
      .then(response => {
        return response;
      })
      .catch(error => {
        return error;
      });
  }

  /**
   * mock模拟数据请求， GET
   * @param {string} method 请求方式 GET|POST|PUT|DELETE
   * @param {string} url 请求的url
   * @return {Promise<void>}
   */
  mock(method, url, data = {}) {
    axios.defaults.headers = {
      "Content-Type": "application/json;charset=UTF-8"
    };
    let options = {};
    if (method === "get" || method === "delete") {
      options = { method, url, data: {}, params: data };
    } else {
      options = { method, url, data };
    }
    return axios(options).then(res => {
      return res;
    });
  }
}

export const BaseHttp = new HttpService();
