<template>
  <div class="home-hero-sub">
    <div class="span4">
      <ul class="home-channel-list">
        <li>
          <a href="javascript:;">
            <img
              src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/82abdba456e8caaea5848a0cddce03db.png"
            />
            小米秒杀
          </a>
        </li>
        <li>
          <a href="javascript:;">
            <img
              src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/806f2dfb2d27978e33fe3815d3851fa3.png"
            />
            企业团购
          </a>
        </li>
        <li>
          <a href="javascript:;">
            <img
              src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/eded6fa3b897a058163e2485532c4f10.png"
            />
            F码通道
          </a>
        </li>
        <li>
          <a href="javascript:;">
            <img
              src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/43a3195efa6a3cc7662efed8e7abe8bf.png"
            />
            米粉卡
          </a>
        </li>
        <li>
          <a href="javascript:;">
            <img
              src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/f4846bca6010a0deb9f85464409862af.png"
            />
            以旧换新
          </a>
        </li>
        <li>
          <a href="javascript:;">
            <img
              src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/9a76d7636b08e0988efb4fc384ae497b.png"
            />
            话费充值
          </a>
        </li>
      </ul>
    </div>
    <div class="span16">
      <ul class="home-promo-list">
        <li>
          <a href="javascript:;">
            <img
              src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/e5f20a62c3d5b3d6806bd51ab6c5dd12.jpg?w=632&h=340"
            />
          </a>
        </li>
        <li>
          <a href="javascript:;">
            <img
              src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/8a43378b96501d7e227a9018fe2668c5.jpg?w=632&h=340"
            />
          </a>
        </li>
        <li>
          <a href="javascript:;">
            <img
              src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/793913688bfaee26b755a0b0cc8575fd.jpg?w=632&h=340"
            />
          </a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeHeroSub"
};
</script>

<style lang="scss" scoped>
.home-hero-sub {
  display: flex;
  margin-top: 14px;
  margin-bottom: 26px;
  .span4 {
    width: 234px;
    .home-channel-list {
      margin: 0;
      padding: 3px;
      list-style-type: none;
      font-size: 12px;
      display: flex;
      flex-wrap: wrap;
      text-align: center;
      background: #5f5750;
      li {
        width: 70px;
        height: 82px;
        color: #fff;
        padding: 0 3px;
        a {
          display: block;
          padding-top: 18px;
          text-overflow: ellipsis;
          color: #fff;
          opacity: 0.7;
          img {
            display: block;
            width: 24px;
            height: 24px;
            margin: 0 auto 4px;
          }
        }
      }
    }
  }
  .span16 {
    width: 978px;
    margin-left: 14px;
    .home-promo-list {
      display: flex;
      li:first-child {
        margin-left: 0;
      }
      li {
        margin-left: 15px;
      }
      img {
        width: 316px;
        height: 170px;
      }
    }
  }
}
</style>
