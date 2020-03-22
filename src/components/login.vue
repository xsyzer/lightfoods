<template>
  <div>
    <div>
      <span>账号:</span><input v-model="username">
    </div>
    <div>
      <span>密码:</span><input v-model="password">
    </div>
    <div>
      <input value="登录" type="button" v-on:click="login()">
    </div>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      username:'',
      password:''
    }
  },
  methods:{
    login:function () {
      let parent=this;
      this.$http({
        url:'/api/login',
        method:'post',
        data:{
          username:this.username,
          password:this.password
        }
      }).then(function (resp) {
          if (resp.data==101) {
            parent.$router.push({path: '/manage'})
          }else {
            let message="";
            switch (resp.data) {
              case -101:message="用户不存在";break;
              case -102:message="用户密码错误";break;
              case -103:message="用户被冻结";break;
              case -104:message="用户异常";break;
              default:break;
            }
            alert(message);
          }
      });
    }
  }
}
</script>

<style scoped>

</style>
