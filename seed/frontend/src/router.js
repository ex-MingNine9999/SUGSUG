import Vue from "vue";
import Router from "vue-router";
import Components from "./pages/Components.vue";
import Presentation from "./pages/Presentation.vue";
import MainNavbar from "./layout/MainNavbar.vue";
import MainFooter from "./layout/MainFooter.vue";
import About from "./pages/example-pages/AboutUs.vue";
import CorpPage from "./pages/example-pages/CorpPage.vue";
import BlogPosts from "./pages/example-pages/BlogPosts.vue";
import ContactUs from "./pages/example-pages/ContactUs.vue";
import LandingPage from "./pages/example-pages/LandingPage.vue";
import LoginPage from "./pages/example-pages/LoginPage.vue";
import PricingPage from "./pages/example-pages/PricingPage.vue";
import CorpListPage from "./pages/example-pages/CorpListPage.vue";
import ProductPage from "./pages/example-pages/ProductPage.vue";
import ProfilePage from "./pages/example-pages/ProfilePage.vue";
import SignUpPage from "./pages/example-pages/SignUpPage.vue";
import SignUpPage_fixed from "./pages/SignUpPage_fixed.vue"
import Sections from "./pages/Sections.vue";
import trendPage from "./pages/example-pages/trend.vue"

Vue.use(Router);

const router = new Router({
  routes: [
    {
      path: "/",
      redirect: "/presentation"
    },
    {
      path: "/components",
      name: "components",
      components: {default: Components, header: MainNavbar, footer: MainFooter},
      props: {
        footer: {backgroundColor: 'black'},
        header: {colorOnScroll: 65}
      }
    },
    {
      path: "/presentation",
      name: "presentation",
      components: {default: Presentation, header: MainNavbar, footer: MainFooter},
      props: {header: {colorOnScroll: 500}}
    },
    {
      path: "/about",
      name: "about",
      components: {default: About, header: MainNavbar, footer: MainFooter},
      props: {header: {colorOnScroll: 450}}
    },
    {
      path: "/contact",
      name: "contact",
      components: {default: ContactUs, header: MainNavbar, footer: MainFooter},
      props: {footer: {type: 'default'}}
    },
    {
      path: "/login",
      name: "login",
      components: {default: LoginPage, header: MainNavbar},
      props: {header: {colorOnScroll: 450}}
    },
    {
      path: "/landing",
      name: "landing",
      components: {default: LandingPage, header: MainNavbar, footer: MainFooter},
      props: {footer: {type: 'default'}, header: {colorOnScroll: 450}}
    },
    {
      path: "/pricing",
      name: "pricing",
      components: {default: PricingPage, header: MainNavbar, footer: MainFooter},
      props: {header: {colorOnScroll: 450}}
    },
    {
      path: "/corp/:corpId",
      name: "corperation",
      components: {default: CorpPage, header: MainNavbar, footer: MainFooter},
      props: {header: {colorOnScroll: 450}}
    },
    {
      path: "/trend",
      name: "trend",
      components: {default: trendPage, header: MainNavbar, footer: MainFooter},
      props: {header: {colorOnScroll: 450}}
    },
    {
      path: "/blog-posts",
      name: "blog-posts",
      components: {default: BlogPosts, header: MainNavbar},
      props: {header: {colorOnScroll: 450}}
    },
    {
      path: "/corperations",
      name: "corperations",
      components: {default: CorpListPage, header: MainNavbar, footer: MainFooter},
      props: {header: {colorOnScroll: 450}}
    },
    {
        path: "/product/:productId",
        name: "product",
        components: {default: ProductPage, header: MainNavbar},
        props: {header: {colorOnScroll: 450}}
    },
    {
      path: "/profile",
      name: "profile",
      components: {default: ProfilePage, header: MainNavbar, footer: MainFooter},
      props: {header: {colorOnScroll: 450}}
    },
    {
      path: "/signup",
      name: "signup",
      components: {default: SignUpPage_fixed, header: MainNavbar},
      props: {header: {colorOnScroll: 450}}
    },
    {
      path: "/sections",
      name: "sections",
      components: {default: Sections, header: MainNavbar, footer: MainFooter},
      props: {
        footer: {backgroundColor: 'gray'},
        header: {colorOnScroll: 0}
      }
    }
  ],
  scrollBehavior: (to, from, savedPosition) => {
    if (to.hash) {
      return {selector: to.hash}
    } else {
      return { x: 0, y: 0 }
    }
  },
});

export default router;
