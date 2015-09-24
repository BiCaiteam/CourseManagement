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
   �꼶                   char varying(8)      null,
   רҵ                   varchar(20)          null,
   רҵ����                 int                  null,
   �γ�����                 varchar(50)          null,
   ѡ������                 varchar(20)          null,
   ѧ��                   float                null,
   ѧʱ                   int                  null,
   ʵ��ѧʱ                 int                  null,
   �ϻ�ѧʱ                 int                  null,
   ��������                 varchar(30)          null,
   �ον�ʦ                 varchar(12)          null,
   ��ע                   varchar(50)          null
)
go

