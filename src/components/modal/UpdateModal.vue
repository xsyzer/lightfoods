<template>
  <modal name="update-modal" :draggable="false" :clickToClose="false" :width="800" :height="202">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" aria-label="Close" v-on:click="closeModal()"><span aria-hidden="true">&times;</span></button>
      <h4 class="modal-title">修改模态框</h4>
    </div>
    <div class="modal-body">
      <div>
        用户名<input type="text" v-model="user.username" readonly>
      </div>
      <div>
        密码<input type="text" v-model="user.password">
      </div>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal" v-on:click="closeModal()">Close</button>
      <button type="button" class="btn btn-primary" v-on:click="save()">Save changes</button>
    </div>
  </modal>
</template>
<script>
  export default {
    name:'UpdateModal',
    props:['user','query'],//传递的参数,可以是function
    methods:{
      closeModal:function () {
          this.$modal.hide("update-modal");
      },
      save:function () {
          //保存成功后，要调用父类的查询方法刷新页面
          this.query();//调用父类传过来的刷新方法
      }
    }
  }
</script>

