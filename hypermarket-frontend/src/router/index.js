import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

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
