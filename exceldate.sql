/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     2015/9/24 22:37:55                           */
/*==============================================================*/


if exists (select 1
            from  sysobjects
           where  id = object_id('exceldate')
            and   type = 'U')
   drop table exceldate
go

/*==============================================================*/
/* Table: exceldate                                             */
/*==============================================================*/
create table exceldate (
   年级                   char varying(8)      null,
   专业                   varchar(20)          null,
   专业人数                 int                  null,
   课程名称                 varchar(50)          null,
   选修类型                 varchar(20)          null,
   学分                   float                null,
   学时                   int                  null,
   实验学时                 int                  null,
   上机学时                 int                  null,
   起讫周序                 varchar(30)          null,
   任课教师                 varchar(12)          null,
   备注                   varchar(50)          null
)
go

