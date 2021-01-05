# SpringMVC_CrudApp

Steps to create this project--->

1) Create a Maven Web Application in the Eclipse Editor

2) Add all the maven dependencies needed in the project in --> pom.xml File

3) In Spring MVC, The DispatcherServlet needs to be declared and mapped for processing 
   all requests --> PatientCRUDServiceInitializer.java

4) Spring MVC Bean Configuration using Java-based Spring configuration--> PatientCRUDMvcConfig.java

5) JPA Entity (POJO class) --> Patient.java

6) Spring MVC Controller Class --> PatientController.java (The controller class  will take care of client requests and uses service classes
to perform database specific operations and then returns the view pages.)

7) Spring Service Layer --> PatientServiceImpl.java (This service class communicates with DAO layer and gets data and finally applies business processing logic 
on those data and sends to the controller layer which then pass to the presentation layer for displaying on view.)

8) Spring DAO Layer --> PatientDAOImpl.java

9) Build and Run an application
