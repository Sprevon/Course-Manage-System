<template>

<router-view></router-view>

  <div class="floating-button">
    <el-button type="info">
      <a href="https://gitcode.net/weixin_70183870/coursemanagementsystem" target="_blank"  style="text-decoration: none; color: inherit">
        查看源码
      </a>
    </el-button>
  </div>


</template>


<script>

</script>

<style scoped>
.floating-button {
  position: fixed;
  bottom: 20px;
  right: 20px;
  z-index: 9999;
}
</style>
