export default {
  phoneRequired: (rule, value, callback, that) => {
    if (value === "") {
      callback(new Error(that.$t("route.phoneRequired")));
    } else {
      callback();
    }
  },
  pwdRequired: (rule, value, callback, that) => {
    if (value === "") {
      callback(new Error(that.$t("route.pwdRequired")));
    } else {
      callback();
    }
  },
  verCodeRequired: (rule, value, callback, that) => {
    if (value === "") {
      callback(new Error(that.$t("route.verCodeRequired")));
    } else {
      callback();
    }
  }
};
