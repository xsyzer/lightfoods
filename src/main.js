// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import vmodal from 'vue-js-modal'
import 'jquery/dist/jquery'
import  'bootstrap/dist/css/bootstrap.css'

Vue.config.productionTip = false
Vue.prototype.$http=axios

Vue.use(vmodal, {
  // dialog: true,
  dynamic: true, injectModalsContainer: true, dynamicDefaults: { clickToClose: false }
})
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
