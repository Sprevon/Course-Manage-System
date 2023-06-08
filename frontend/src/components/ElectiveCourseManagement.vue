<template>
  <h3>已选课程</h3>
  <div>
    <el-table stripe  :data="courses" :default-sort="{ prop: 'term', order: 'ascending' }">
      <el-table-column prop="courseID" sortable label="课程ID"></el-table-column>
      <el-table-column prop="courseName" label="课程名称"></el-table-column>
      <el-table-column prop="isCompulsory" label="是否必修"></el-table-column>
      <el-table-column prop="direction" label="方向"></el-table-column>
      <el-table-column prop="term" sortable label="学期"></el-table-column>
      <el-table-column label="操作">
        <template class="button" v-if="true" v-slot="scope">
          <el-button class="button" type="danger" @click="unselectCourse(scope.row.courseID)">退课</el-button>
        </template>
      </el-table-column>
    </el-table>


  </div>
  <h3>备选课程</h3>
  <div>
    <el-table stripe :data="coursesAll" :default-sort="{ prop: 'term', order: 'ascending' }">
      <el-table-column prop="courseID" sortable label="课程ID"></el-table-column>
      <el-table-column prop="courseName" label="课程名称"></el-table-column>
      <el-table-column prop="isCompulsory" label="是否必修"></el-table-column>
      <el-table-column prop="direction" label="方向"></el-table-column>
      <el-table-column prop="term" sortable label="学期"></el-table-column>
      <el-table-column label="操作">
        <template v-if="true" v-slot="scope">
           <el-button type="primary" @click="selectCourse(scope.row.courseID)">选课</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "axios";
import {ElMessageBox} from "element-plus";

export default {
  data() {
    return {
      courses: [], // 所有已选选修课程的数组
      coursesAll: [], // 所有所有选修课程的数组
      userID: this.$store.state.student.userID,

    };
  },
  mounted() {
    // 在组件挂载时获取课程数据
    this.fetchCourses();
    this.fetchAllCourses()
  },
  methods: {
    fetchCourses() {
      const info = {
        userID: this.$store.state.student.userID
      }
      // 使用Axios发送GET请求获取课程数据
      axios.get('http://localhost:4567/course/queryElective', {params: info})
          .then(response => {
            this.courses = response.data.map(item => ({
              courseID: item.courseID,
              courseName: item.courseName,
              isCompulsory:( item.isCompulsory === 1? '必修课': '选修课'),
              direction: (item.direction === 0? '基础课':(item.direction === 1? '专业方向1' : '专业方向2')),
              term: item.term === 1 ? '大一'
                  :(item.term === 2 ? '大二'
                      :(item.term === 3 ? '大三': '大四')),
            }));
          })
          .catch(error => {
            console.error('获取课程数据失败:', error);
          });
    },

    fetchAllCourses() {

      // 使用Axios发送GET请求获取课程数据
      axios.get('http://localhost:4567/course/queryAllElective')
          .then(response => {
            this.coursesAll = response.data.map(item => ({
              courseID: item.courseID,
              courseName: item.courseName,
              isCompulsory:( item.isCompulsory === 1? '必修课': '选修课'),
              direction: (item.direction === 0? '基础课':(item.direction === 1? '专业方向1' : '专业方向2')),
              term: item.term === 1 ? '大一'
                  :(item.term === 2 ? '大二'
                      :(item.term === 3 ? '大三': '大四')),
            }));
          })
          .catch(error => {
            console.error('获取课程数据失败:', error);
          });
    },


    selectCourse(courseID) {
      // 发送POST请求进行选课操作
      axios.post('http://localhost:4567/course/selectElective', { userID: this.userID, courseID: courseID, })
          .then(response => {
            // 处理选课成功的逻辑
            console.log('选课成功:', response.data);
            if (response.data){
              ElMessageBox.alert('选课成功', '提示', {
                confirmButtonText: '确认',
                type: 'success'
              });
              this.fetchCourses()

            }else {
              ElMessageBox.alert('已选择该课程', '错误', {
                confirmButtonText: '确定',
                type: 'error'
              });
            }

          })
          .catch(error => {
            console.error('选课失败:', error);
            ElMessageBox.alert('选课失败', '错误', {
              confirmButtonText: '确定',
              type: 'error'
            });
          });
    },

    unselectCourse(courseID) {
      // 发送POST请求进行退课操作
      axios.post('http://localhost:4567/course/unselectElective', {  userID: this.userID ,courseID: courseID})
          .then(response => {
            // 处理选课成功的逻辑
            console.log('退课成功:', response.data);
            if (response.data){
              ElMessageBox.alert('退课成功', '提示', {
                confirmButtonText: '确认',
                type: 'success'
              });
              this.fetchCourses()
            }else {
              console.error('退课失败:', error);
              ElMessageBox.alert('选课失败', '错误', {
                confirmButtonText: '确定',
                type: 'error'
              });
            }
          })
          .catch(error => {
            console.error('选课失败:', error);
            console.error('退课失败:', error);
            ElMessageBox.alert('选课失败', '错误', {
              confirmButtonText: '确定',
              type: 'error'
            });
          });
    },

    print(row){
      console.log(row)
    }
  },
};
</script>


<style>
.button{
}
</style>
