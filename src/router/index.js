import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/login'
import manage from '@/components/manage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/manage',
      name: 'manage',
      component: manage
    }
  ]
})
