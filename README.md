# studentCourses
SprintBoot,H2,JPA, studetn-course-mapping tables, many-to-many relationship
it is a working copy and it is not complete. 
currently working on the get details of a single student


drop table courses;
create table courses (id integer not null auto_increment, name varchar(25), desc varchar(25), primary key(id));

drop table STUDENTENTITY ;

create table studententity (id integer not null auto_increment, first_name varchar(25), last_name varchar(25), address varchar(25), primary key(id));


drop table MAP_COURSE_STUDENT ;

create table map_course_student (id int not null auto_increment, course_id int, student_id int, 
created_date datetime, updated_date datetime, created_by varchar(50), updated_by varchar(50)) ;

ALTER table map_course_student ALTER COLUMN created_date SET DEFAULT getdate();
ALTER table map_course_student ALTER COLUMN updated_date SET DEFAULT getdate();

insert into courses(id, name, desc) VALUES('1', 'cse', 'cse course');
insert into courses(id, name, desc) VALUES('2', 'ece', 'ece course');
insert into courses(id, name, desc) VALUES('3', 'eee', 'eee course');

insert into studententity(id, first_name, last_name, address) VALUES('1', 'harish', 'konduru', 'hyd');

insert into map_course_student(id, course_id, student_id, created_date, created_by) VALUES('1', '1', '1', '12-04-2018', 'harish');


GET http://localhost:8080/getStudent/1
