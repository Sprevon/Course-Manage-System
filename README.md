培养计划管理系统
============================

编程环境
-----------
前端：Vue3 + Element-ui + Axios    
后端：SpringBoot + Mybaits-Plus  
数据库：Mysql  


目录结构描述
--------------
│  list.txt  
│  README.md //说明文件  
│    
├─backend  
│  │  .gitignore    
│  │  HELP.md  
│  │  pom.xml  
│  │    
│  ├─doc  
│  │  ├─docker  
│  │  │      Dockerfile  
│  │  │        
│  │  ├─images  
│  │  │      CourseSystem.png  
│  │  │      培养计划管理系统E-R.jpg  
│  │  │      培养计划管理系统软件结构图.jpg  
│  │  │        
│  │  └─sql  //创建数据表  
│  │          CreateCMTable.sql  
│  │          CreateCourseTable.sql  
│  │          CreateDCTable.sql  
│  │          CreateMajorTable.sql   
│  │          CreateMDTable.sql  
│  │          CreateSchema.sql  
│  │          CreateStudentTable.sql  
│  │            
│  ├─src  
│  │  ├─main  
│  │  │  ├─java  
│  │  │  │  └─classes  
│  │  │  │      └─java  
│  │  │  │          └─coursesystem  
│  │  │  │              │  CourseSystemApplication.java  
│  │  │  │              │    
│  │  │  │              ├─config   
│  │  │  │              │      WebMvcConfig.java        //配置拦截器和跨域访问  
│  │  │  │              │        
│  │  │  │              ├─controller   
│  │  │  │              │      CourseController.java    //课程管理接口   
│  │  │  │              │      LoginController.java //登录接口   
│  │  │  │              │         
│  │  │  │              ├─entity    
│  │  │  │              │  │  Course.java               //课程实体  
│  │  │  │              │  │  DC.java               //专业方向对应课程实体   
│  │  │  │              │  │  LoginRequest.java     //登录信息承接实体   
│  │  │  │              │  │  Major.java            //专业实体    
│  │  │  │              │  │  MC.java           //所有选课记录实体    
│  │  │  │              │  │  Student.java          //学生实体       
│  │  │  │              │  │        
│  │  │  │              │  └─HTTP                                             
│  │  │  │              │          HTTPDirection.java     //选方向信息承接实体          
│  │  │  │              │          HTTPElectiveCourse.java   //选修课选择信息承接实体     
│  │  │  │              │               
│  │  │  │              ├─interceptor                                
│  │  │  │              │      AdminCheckInterceptor.java    //拦截器     
│  │  │  │              │      LoginInterceptor.java    
│  │  │  │              │           
│  │  │  │              ├─mapper   //数据库映射       
│  │  │  │              │      CourseMapper.java       
│  │  │  │              │      DCMapper.java          
│  │  │  │              │      MajorMapper.java       
│  │  │  │              │      MCMapper.java       
│  │  │  │              │      MDMapper.java        
│  │  │  │              │      StudentMapper.java      
│  │  │  │              │          
│  │  │  │              └─service                                             
│  │  │  │                      DataChangeService.java      //提供数据修改方法    
│  │  │  │                      DataCheckService.java       //提供数据确认方法   
│  │  │  │                      DataQueryService.java       //提供数据查询方法   
│  │  │  │                         
│  │  │  └─resources                     
│  │  │      │  application.properties    
│  │  │      │        
│  │  │      └─static              
│  │  │              index.html    
│  │  │                 
│  │  └─test                         
│  └─target     
├─frontend   
│   │  .gitignore    
│   │  index.html    
│   │  package-lock.json   
│   │  package.json   
│   │  README.md   
│   │  src.png   
│   │  vite.config.js  
│   │        
│   ├─.idea          
│   ├─.vscode    
│   ├─node_modules  
│   ├─public   
│   │      favicon.ico   
│   ├─src                          
│   │   │  App.vue      //启动程序   
│   │   │  Home.vue      //主页面   
│   │   │  Login.vue      //登录界面   
│   │   │  main.js      //主函数   
│   │   │         
│   │   ├─assets    
│   │   │      base.css   
│   │   │      logo.svg     
│   │   │      main.css    
│   │   │         
│   │   └─components    
│   │           DirectionManagement.vue     //选方向组件    
│   │           ElectiveCourseManagement.vue        //选修课选择组件   
└─  └─          QueryCourse.vue     //培养计划展示组件   



结构图
----------
![image](/backend/doc/images/%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F%E8%BD%AF%E4%BB%B6%E7%BB%93%E6%9E%84%E5%9B%BE.jpg)


前端类图
------------
![image](/frontend/src.png)


后端类图
------------
![image](/backend/doc/images/CourseSystem.png)


E-R图
------------
![image](/backend/doc/images/%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9FE-R.jpg)














  

