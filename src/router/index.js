import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import AdminManage from '../components/admin/Manage'
import Index from "../components/index"

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
      path: '/adminManage',
      name: 'AdminManage',
      component: AdminManage
    }
  ]
})
