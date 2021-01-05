<template>
  <div class="site-footer">
    <div class="container">
      <ul class="list-service">
        <li><em>预约维修服务</em></li>
        <li><em>7天无理由退货</em></li>
        <li><em>15天免费换货</em></li>
        <li><em>满99元包邮</em></li>
        <li><em>520余家售后网点</em></li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "FooterNav"
};
</script>

<style lang="scss" scoped>
.site-footer {
  .container {
    width: 1226px;
    margin: 0 auto;
    padding: 27px 0;
    .list-service {
      height: 25px;
      li {
        float: left;
        width: 19.8%;
        height: 25px;
        font-size: 16px;
        line-height: 25px;
        border-left: 1px solid #e0e0e0;
        text-align: center;
        color: #616161;
        em {
          font-style: normal;
        }
      }
      li:first-child {
        border-left: 0;
      }
    }
  }
}
</style>
