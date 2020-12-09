// 验证手机号码
export const phoneValidation = function(rule, value, callback) {
  const reg = /^(?:(?:\+|00)86)?1(?:(?:3[\d])|(?:4[5-7|9])|(?:5[0-3|5-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\d])|(?:9[1|8|9]))\d{8}$/;
  if (!reg.test(value)) {
    callback(new Error("请正确输入手机号"));
  } else {
    callback();
  }
};
// 验证密码强度
export const pwdValidationIntensity = function(rule, value, callback) {
  const reg = /^\S*(?=\S{8,})(?=\S*[a-zA-Z])(?=\S*[!@#$%^&*?. ])\S*$/;
  if (!reg.test(value)) {
    callback(new Error("密码至少8位且包含字母和特殊字符"));
  } else {
    callback();
  }
};
