create table pms_project(
    no int not null,
    title varchar(255) not null,
    content text not null,
    sdt date not null,
    edt date not null,
    owner int not null
    );


alter table pms_project
add constraint pms_project_pk primary key(no);

alter table pms_project
modify column no int not null auto_increment;

alter table pms_project
add constraint pms_project_fk foreign key(owner) references pms_member(no);

create table pms_member_project(
    member_no int not null,
    project_no int not null);

alter table pms_member_project
add constraint pms_member_project_fk1 foreign key(member_no) references pms_member(no),
add constraint pms_member_project_fk2 foreign key(project_no) references pms_project(no);

alter table pms_member_project
add constraint pms_member_project_pk primary key(member_no, project_no);



create table pms_task(
    no int not null,
    content text not null,
    deadline date not null,
    owner int not null,
    project_no int not null,
    status int default 0
    );
alter table pms_task
add constraint pms_task_pk primary key(no);

alter table pms_task
modify column no int not null auto_increment;
alter table pms_task
add constraint pms_task_fk3 foreign key(owner, project_no) references pms_member_project(member_no, project_no);

alter table pms_task
add constraint pms_task_fk foreign key(owner) references pms_member(no);



alter table pms_task
add constraint pms_task_fk2 foreign key(project_no) references pms_project(no);



create table pms_board(
    no int not null,
    title varchar(255) not null,
    content text not null,
    writer int not null,
    cdt datetime default now(),
    vw_cnt int default 0
    );

alter table pms_board
add constraint pms_board_pk primary key(no);

alter table pms_board
modify column no int not null auto_increment;

alter table pms_board
add constraint pms_board_fk foreign key(writer) references pms_member(no);









