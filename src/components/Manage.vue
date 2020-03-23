<template>
  <div>
    <input type="button" value="显示修改模态框" v-on:click="showUpdateModal()">
    <!--向修改模态框传参-->
    <update-modal :user="updateUser" :query="search"></update-modal>
  </div>
</template>

<script>
import UpdateModal from "./modal/UpdateModal";

export default {
  name: 'Manage',
  components:{UpdateModal},//依赖项
  data () {
    return{
        user:{
          username:'admin',
          password:'123456'
        },
      updateUser:{}
    }
  },
  methods:{
    showUpdateModal:function () {
      this.updateUser=JSON.parse(JSON.stringify(this.user));
      this.$modal.show("update-modal");
    },
    search:function () {
      alert("刷新页面");
    }
  }
}
</script>

<style scoped>

</style>
