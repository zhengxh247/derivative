<template>
  <div class="login-footer">
    <div class="nf-link-area">
      <ul>
        <li>
          <span
            @click="changeLocaleType('zh-CN')"
            :class="{ select: $i18n.locale == 'zh-CN' }"
          >
            简体
          </span>
          |
        </li>
        <li>
          <span
            @click="changeLocaleType('zh-TW')"
            :class="{ select: $i18n.locale == 'zh-TW' }"
          >
            繁体
          </span>
          |
        </li>
        <li>
          <span
            @click="changeLocaleType('en')"
            :class="{ select: $i18n.locale == 'en' }"
          >
            English
          </span>
          |
        </li>
        <li><span>常见问题</span>|</li>
        <li><span>隐私政策</span></li>
      </ul>
    </div>
    <p class="nf-intro">
      作者声明：此网站只作为技术练习，如需购买小米商品，请到
      <a href="https://www.mi.com/index.html" target="_blank">
        小米官网
      </a>
      进行购买！
    </p>
  </div>
</template>

<script>
export default {
  name: "LoginFooter",
  methods: {
    changeLocaleType(type) {
      this.$i18n.locale = type;
      localStorage.setItem("localeType", type);
    }
  }
};
</script>

<style lang="scss" scoped>
.login-footer {
  background: #fff;
  height: 80px;
  margin-top: 100px;
  color: #757575;
  text-align: center;
  font-size: 14px;
  font-family: Helvetica, arial, "MI Lan Pro", "Hiragino Sans GB", "PingFang SC",
    "Microsoft YaHei", "微軟正黑體", "儷黑 Pro", sans-serif;
  & ul > li {
    display: inline-block;
  }
  & ul > li > span {
    padding: 0 10px;
    cursor: pointer;
  }
  & ul > li > span:hover {
    color: $textHover;
  }
  .select {
    color: $textHover;
  }
  .nf-intro {
    padding: 10px;
    a,
    a:link,
    a:visited,
    a:hover,
    a:active {
      color: $colorPrimary;
    }
  }
}
</style>
