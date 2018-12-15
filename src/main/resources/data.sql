insert into course(id,name,created_date,last_updated_date)
 values(10001L,'hibernate',sysdate(),sysdate());
insert into course(id,name,created_date,last_updated_date)
values(10002L,'spring',sysdate(),sysdate());
insert into course(id,name,created_date,last_updated_date)
values(10003L,'spring-boot',sysdate(),sysdate());


insert into passport(id,number) values(40001,'E12345');
insert into passport(id,number) values(40002,'E14563');
insert into passport(id,number) values(40003,'E4324121');

insert into student(id,name,passport_id) values(20001,'Mohit',40001);
insert into student(id,name,passport_id) values(20002,'Ram',40002);
insert into student(id,name,passport_id) values(20003,'Shyam',40003);



insert into review(id,rating,description,course_id) values(50001,'5','Good',10001L);
insert into review(id,rating,description,course_id) values(50002,'7','Better',10001L);
insert into review(id,rating,description,course_id) values(50003,'8','Best',10003L);

insert into student_course(student_id,course_id) values(20001,10001L);
insert into student_course(student_id,course_id) values(20002,10001L);
insert into student_course(student_id,course_id) values(20003,10003L);
