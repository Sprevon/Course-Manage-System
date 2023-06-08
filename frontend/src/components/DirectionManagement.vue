<template>
  <div>
    <el-card
        v-for="(card, index) in cards"
        :key="index"
        :body-style="{ padding: '20px' }"
        :bordered="selectedCard === card"
        :class="{ selected: selectedCard === card }"
        @click.native="selectDirection(card)"
        class="card"
    >
      <div style="display: flex; justify-content: space-between; align-items: center;">
        <h3>{{ card.title }} {{selectedCard === card?'(已选择)':''}}</h3>
      </div>
      <el-table :data="card.data" style="width: 100%">
        <el-table-column prop="courseID" sortable label="课程ID"></el-table-column>
        <el-table-column prop="courseName" label="课程名"></el-table-column>
        <el-table-column prop="isCompulsory" label="是否必修"></el-table-column>
        <el-table-column prop="direction"  label="课程类型"></el-table-column>
        <el-table-column prop="term" sortable label="学期"></el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
import axios from "axios";
import {ElMessageBox} from "element-plus";

export default {
  data() {
    return {

      cards: [
        {
          title: '专业方向1',
          data: [],
          labels: '选择方向1',
          direction: 1,
        },
        {
          title: '专业方向2',
          data: [],
          labels: '选择方向2',
          direction: 2,

        }
      ],
      selectedCard: null
    }
  },



  methods: {
    selectDirection(card) {
      axios.post('http://localhost:4567/course/chooseDirection', { userID: this.$store.state.student.userID, direction: card.direction })
          .then(response => {
            // 处理选方向成功的逻辑
            console.log('选方向成功:', response.data);
            this.selectedCard = card;
            if (response.data){
              ElMessageBox.alert('选方向成功', '提示', {
                confirmButtonText: '确认',
                type: 'success'
              });

            }else {
              ElMessageBox.alert('已选择该方向', '错误', {
                confirmButtonText: '确定',
                type: 'error'
              });
            }

          })
          .catch(error => {
            console.error('选方向失败:', error);
            ElMessageBox.alert('选方向失败', '错误', {
              confirmButtonText: '确定',
              type: 'error'
            });
          });
    },
  },



  created() {
    const direction1 = {
      majorName: this.$store.state.student.majorName,
      direction: 1,
    };

    const direction2 = {
      majorName: this.$store.state.student.majorName,
      direction: 2,
    };

    axios.get('http://localhost:4567/course/getDirection',{params : direction1})
        .then(response =>{
          this.cards[0].title = response.data;
        })
        .catch(error =>{
          console.error(error);
        });

    axios.get('http://localhost:4567/course/getDirection',{params : direction2})
        .then(response =>{
          this.cards[1].title = response.data;
        })
        .catch(error =>{
          console.error(error);
        });

    axios.get('http://localhost:4567/course/getDirectionCourse',{params : direction1})
        .then(response =>{
          console.log(response.data)
          this.cards[0].data = response.data.map(item => ({
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
        });

    axios.get('http://localhost:4567/course/getDirectionCourse',{params : direction2})
        .then(response =>{
          console.log(response.data)
          this.cards[1].data = response.data.map(item => ({
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
        });


    if (this.$store.state.student.direction === 1){
      this.selectedCard = this.cards[0];
    }else if (this.$store.state.student.direction === 2){
      this.selectedCard = this.cards[1];
    }


  }
}
</script>

<style>
.card{

}

.selected{
  color: #409EFF;
}


</style>