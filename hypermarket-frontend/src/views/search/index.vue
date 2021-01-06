<template>
  <div class="search-container">
    <div class="container-main">
      <div class="breadcrumbs">
        <div class="container">
          <el-breadcrumb
            separator-class="el-icon-arrow-right"
            class="custom-breadcrumb"
          >
            <el-breadcrumb-item :to="{ path: '/' }">
              首页
            </el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/search' }">
              全部结果
            </el-breadcrumb-item>
            <el-breadcrumb-item>Redmi 10X 5G</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
      </div>
      <div class="search-filter">
        <div class="container">
          <ul>
            <li>分类:</li>
            <li>全部</li>
            <li>手机</li>
            <li>手机保护壳</li>
            <li>服务</li>
          </ul>
        </div>
      </div>
      <div class="search-result">
        <div class="container">
          <div class="order-list-box">
            <ul class="order-list">
              <li>综合</li>
              <li>新品</li>
              <li>销量</li>
              <li>价格</li>
            </ul>
            <ul class="type-list">
              <li>收货地</li>
              <li>促销</li>
              <li>分期</li>
              <li>仅看有货</li>
            </ul>
          </div>
          <div class="goods-list-box">
            <div class="goods-list">
              <el-card
                class="goods-item"
                shadow="hover"
                v-for="item in 9"
                :key="item"
              >
                <img src="" />
                <h2>123</h2>
              </el-card>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "search"
};
</script>

<style lang="scss" scoped>
.breadcrumbs {
  height: 40px;
  font-size: 12px;
  background: #f5f5f5;
  .container {
    width: 1226px;
    margin: 0 auto;
    .custom-breadcrumb {
      line-height: 40px;
    }
  }
}
.search-filter {
  .container {
    width: 1226px;
    margin: 0 auto;
    padding: 18px 0;
    position: relative;
    ul {
      height: 48px;
    }
    ul > li {
      float: left;
      color: #424242;
      font-size: 14px;
      width: 148px;
      padding: 14px 0;
      height: 20px;
      line-height: 20px;
    }
  }
}
.search-result {
  padding: 20px 0 100px;
  background: #f5f5f5;
  .container {
    width: 1226px;
    margin: 0 auto;
    .order-list-box {
      position: relative;
      height: 30px;
      margin: 20px 0;
      .order-list {
        float: left;
        li {
          float: left;
          padding: 0 30px;
        }
      }
      .type-list {
        float: right;
        li {
          float: left;
          margin-left: 30px;
        }
      }
    }
    .goods-list-box {
      width: 1226px;
      margin: 0;
      .goods-list {
        display: flex;
        flex-wrap: wrap;
        width: 1240px;
        .goods-item {
          width: 294px;
          height: 383px;
          margin-right: 14px;
          margin-bottom: 14px;
        }
      }
    }
  }
}
</style>

<style lang="scss">
.custom-breadcrumb {
  .el-breadcrumb__inner {
    color: #757575 !important;
    font-size: 12px;
  }
  .el-breadcrumb__inner a,
  .el-breadcrumb__inner.is-link {
    font-weight: 400;
  }
  .el-breadcrumb__inner.is-link:hover,
  .el-breadcrumb__inner a:hover {
    color: $textHover !important;
  }
}
</style>
