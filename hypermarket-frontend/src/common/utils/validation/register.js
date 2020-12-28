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
  repwdRequired: (rule, value, callback, that) => {
    if (value === "") {
      callback(new Error(that.$t("route.rePwdRequired")));
    } else {
      callback();
    }
  },
  pwdValidationRepwd: (rule, value, callback, that) => {
    if (value !== that.registerForm.password) {
      callback(new Error(that.$t("route.pwdIsRepwd")));
    } else {
      callback();
    }
  }
};
