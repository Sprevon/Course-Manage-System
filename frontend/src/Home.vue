<template>
  <div>
    <div class="welcome">
      <h1><a href="/login" style="text-decoration: none; color: inherit;">欢迎  {{majorName}}  专业  {{ name }}  同学来到教务系统!</a></h1>
    </div>
    <el-header class="header">
      <el-menu class="nav" mode="horizontal">

        <el-menu-item index="1" type="primary" @click="query_course">培养计划</el-menu-item>
        <el-menu-item index="2" type="primary" @click="add_course">选课管理</el-menu-item>
        <el-menu-item index="3" @click="delete_course_by_major">方向管理</el-menu-item>

      </el-menu>
    </el-header>

    <query-course v-if="query"></query-course>
    <elective-course-management v-if="electiveCourse"></elective-course-management>
    <direction-management v-if="direction"></direction-management>
  </div>
</template>

<script>
import { ElHeader, ElMenu, ElMenuItem } from 'element-plus';
import QueryCourse from "@/components/QueryCourse.vue";
import AddCourse from "@/components/ElectiveCourseManagement.vue";
import DeleteCourseByMajor from "@/components/DirectionManagement.vue";
import ElectiveCourseManagement from "@/components/ElectiveCourseManagement.vue";
import DirectionManagement from "@/components/DirectionManagement.vue";

export default {
  components: {
    DirectionManagement,
    ElectiveCourseManagement,
    ElHeader,
    ElMenu,
    ElMenuItem,
    QueryCourse
  },
  data() {
    return {
      majorName: this.$store.state.student.majorName,
      name: this.$store.state.student.name,
      query: true,
      electiveCourse: false,
      direction: false,

    };
  },
  methods: {
    query_course() {
      this.query = true;
      this.electiveCourse = false;
      this.direction = false;
    },
    add_course() {
      this.query = false;
      this.electiveCourse = true;
      this.direction = false;
    },
    delete_course_by_major() {
      this.query = false;
      this.electiveCourse = false;
      this.direction = true;
    },
  },
};
</script>

<style scoped>
/* Add your component styles here */
</style>
