<script>
import axios from "axios";

export default {
  data(){
    return{
      tableData: [],
      userID: this.$store.state.student.userID,
    };
  },
  created() {
    const info = {
      userID: this.userID
    }

    axios.get('http://localhost:4567/course/query',{params : info})
        .then(response =>{
          this.tableData = response.data.map(item => ({
            courseID: item.courseID,
            courseName: item.courseName,
            isCompulsory:( item.isCompulsory === 1? '必修课': '选修课'),
            direction: (item.direction === 0? '基础课':(item.direction === 1? '专业方向1' : '专业方向2')),
            term: item.term === 1 ? '大一'
                :(item.term === 2 ? '大二'
                    :(item.term === 3 ? '大三': '大四')),
          }));

        })
        .catch(error =>{
          console.error(error);
        })


  }

}
</script>

<template>
<div>
  <el-table :data="this.tableData"  :default-sort="{ prop: 'term', order: 'ascending' }"  stripe>
    <el-table-column prop="courseID" sortable label="课程ID"></el-table-column>
    <el-table-column prop="courseName" label="课程名"></el-table-column>
    <el-table-column prop="isCompulsory" label="是否必修"></el-table-column>
    <el-table-column prop="direction"  label="课程类型"></el-table-column>
    <el-table-column prop="term" sortable label="学期"></el-table-column>
  </el-table>

</div>
</template>

<style scoped>

</style>