<template>
  <div class="login-container">
    <el-form class="login-form" :model="form" ref="loginForm">
      <el-form-item label="用户名">
        <el-input v-model="form.username" placeholder="输入你的用户名"></el-input>
      </el-form-item>

      <el-form-item label="密码">
        <el-input type="password" v-model="form.password" placeholder="输入你的密码"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="login">登录</el-button>
        <el-button type="info">
          <a href="/" style="text-decoration: none; color: inherit">取消</a>
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";
import { ElMessageBox } from 'element-plus';


export default {
  data() {
    return {
      form: {
        username: '',
        password: ''
      },

      dataSet:{
        username: "zhangsan",
        password: "123",
      }

    };
  },
  methods: {
    login() {
      axios.post('http://localhost:4567/login',this.form)
          .then(response => {
            if (response.data === "Login success"){
              ElMessageBox.alert('登录成功', '提示', {
                confirmButtonText: '确认',
                type: 'success'
              }).then(() => {
                this.queryAndSave()
              });
            }else {
              ElMessageBox.alert('登录失败，请检查用户名和密码', '错误', {
                confirmButtonText: '确定',
                type: 'error'
              });
            }

          })
          .catch(error => {
            console.error(error);
            // 处理登录失败的逻辑
          });
    },

    queryAndSave(){
      const params = { username: this.form.username};

      axios.get('http://localhost:4567/login/getByID', {params}).then(response => {
        // 获取到数据后，将其存储到localStorage中
        this.$store.dispatch('setStudent',response.data);
        // 跳转到主页面
        this.$router.push('/');
      }).catch(error => {
        console.error(error);
      });
    }

  }
};
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.login-form {
  width: 300px;
}
</style>
