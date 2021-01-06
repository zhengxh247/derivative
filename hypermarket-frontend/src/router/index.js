import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);
// 解决不能跳转路由到自身。专业术语：避免到当前位置的冗余导航
const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err);
};

const routes = [
  {
    path: "/",
    component: () => import(/* webpackChunkName: "home" */ "../layout"),
    children: [
      {
        path: "/",
        name: "Home",
        component: () => import(/* webpackChunkName: "home" */ "../views/home")
      },
      {
        path: "/detail/:id",
        component: () =>
          import(/* webpackChunkName: "home" */ "../views/goodsDetail")
      },
      {
        path: "/search",
        component: () =>
          import(/* webpackChunkName: "home" */ "../views/search")
      }
    ]
  },
  {
    path: "/login",
    name: "Login",
    component: () => import(/* webpackChunkName: "login" */ "../views/login")
  },
  {
    path: "/register",
    name: "Register",
    component: () =>
      import(/* webpackChunkName: "register" */ "../views/register")
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
