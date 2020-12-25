import Vue from "vue";
import VueI18n from "vue-i18n";
// element-ui built-in lang
import elementEnLocale from "element-ui/lib/locale/lang/en";
import elementZhCNLocale from "element-ui/lib/locale/lang/zh-CN";
import elementZhTWLocale from "element-ui/lib/locale/lang/zh-TW";
// User defined lang
import enLocale from "./en";
import zhCNLocale from "./zh-CN";
import zhTWLocale from "./zh-TW";

Vue.use(VueI18n);

const messages = {
  en: {
    ...enLocale,
    ...elementEnLocale
  },
  "zh-CN": {
    ...zhCNLocale,
    ...elementZhCNLocale
  },
  "zh-TW": {
    ...zhTWLocale,
    ...elementZhTWLocale
  }
};

const i18n = new VueI18n({
  locale: localStorage.getItem("localeType") || "zh-CN",
  messages
});

export default i18n;
