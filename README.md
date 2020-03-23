# Basic Spring-Crud-Operation-with-mySql

# Data base CRUD operation using mysql

1. Download mysql workbench server for Mac and setup
2. Download mysql workbench set schema and password


# in project in resources application.prop

spring.datasource.url = jdbc:mysql://localhost:3306/customer
spring.datasource.username = root
spring.datasource.password = 12345678

// ## Hibernate Properties
// #The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

// # Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update

logging.level.org.hibernate.stat=debug
// # Show all queries
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.type=trace



Create database customer

# For Reference

https://www.youtube.com/watch?v=voA01jXkXtk

https://www.javaguides.net/2018/09/spring-boot-2-jpa-mysql-crud-example.html

# Here a GitHub project import and run that project. 
https://github.com/RameshMF/spring-boot2-jpa-crud-example
