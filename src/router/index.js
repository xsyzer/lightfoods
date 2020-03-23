import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import Manage from '../components/Manage'
import Index from "../components/index";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/manage',
      name: 'Manage',
      component: Manage
    }
  ]
})
