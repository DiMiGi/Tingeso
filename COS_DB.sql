/*==============================================================*/
/* DBMS name:      SAP SQL Anywhere 16                          */
/* Created on:     02-05-2017 16:06:15                          */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_MENUS_SELLS_ON_DATES') then
    alter table MENUS
       delete foreign key FK_MENUS_SELLS_ON_DATES
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MENUS_HA_HAS_1_FOODS') then
    alter table MENUS_HAS_FOODS
       delete foreign key FK_MENUS_HA_HAS_1_FOODS
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MENUS_HA_HAVE_MENUS') then
    alter table MENUS_HAS_FOODS
       delete foreign key FK_MENUS_HA_HAVE_MENUS
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ORDERS_ASKS_FOR_USERS') then
    alter table ORDERS
       delete foreign key FK_ORDERS_ASKS_FOR_USERS
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ORDERS_H_NEEDS_ORDERS') then
    alter table ORDERS_HAS_MENUS
       delete foreign key FK_ORDERS_H_NEEDS_ORDERS
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ORDERS_H_NEEDS_1_MENUS') then
    alter table ORDERS_HAS_MENUS
       delete foreign key FK_ORDERS_H_NEEDS_1_MENUS
end if;

drop index if exists DATES.DATES_PK;

drop table if exists DATES;

drop index if exists FOODS.FOODS_PK;

drop table if exists FOODS;

drop index if exists MENUS.SELLS_ON_FK;

drop index if exists MENUS.MENUS_PK;

drop table if exists MENUS;

drop index if exists MENUS_HAS_FOODS.HAS_FK;

drop index if exists MENUS_HAS_FOODS.HAS_1_FK;

drop index if exists MENUS_HAS_FOODS.MENUS_HAS_FOODS_PK;

drop table if exists MENUS_HAS_FOODS;

drop index if exists ORDERS.ASKS_FOR_FK;

drop index if exists ORDERS.ORDERS_PK;

drop table if exists ORDERS;

drop index if exists ORDERS_HAS_MENUS.NEEDS_1_FK;

drop index if exists ORDERS_HAS_MENUS.NEEDS_FK;

drop index if exists ORDERS_HAS_MENUS.ORDERS_HAS_MENUS_PK;

drop table if exists ORDERS_HAS_MENUS;

drop index if exists USERS.USERS_PK;

drop table if exists USERS;

/*==============================================================*/
/* Table: DATES                                                 */
/*==============================================================*/
create table DATES 
(
   ID_DATE              integer                        not null,
   DATE_DAY             varchar(12)                    null,
   REAL_DATE            date                           null,
   constraint PK_DATES primary key clustered (ID_DATE)
);

/*==============================================================*/
/* Index: DATES_PK                                              */
/*==============================================================*/
create unique clustered index DATES_PK on DATES (
ID_DATE ASC
);

/*==============================================================*/
/* Table: FOODS                                                 */
/*==============================================================*/
create table FOODS 
(
   ID_FOOD              integer                        not null,
   FOOD_NAME            varchar(50)                    null,
   FOOD_AVAILABILITY    smallint                       null,
   FOOD_DESCRIPTION     char(200)                      null,
   constraint PK_FOODS primary key clustered (ID_FOOD)
);

/*==============================================================*/
/* Index: FOODS_PK                                              */
/*==============================================================*/
create unique clustered index FOODS_PK on FOODS (
ID_FOOD ASC
);

/*==============================================================*/
/* Table: MENUS                                                 */
/*==============================================================*/
create table MENUS 
(
   ID_MENU              integer                        not null,
   ID_DATE              integer                        null,
   MENU_PRICE           integer                        null,
   MENU_AVAILABILITY    smallint                       null,
   constraint PK_MENUS primary key clustered (ID_MENU)
);

/*==============================================================*/
/* Index: MENUS_PK                                              */
/*==============================================================*/
create unique clustered index MENUS_PK on MENUS (
ID_MENU ASC
);

/*==============================================================*/
/* Index: SELLS_ON_FK                                           */
/*==============================================================*/
create index SELLS_ON_FK on MENUS (
ID_DATE ASC
);

/*==============================================================*/
/* Table: MENUS_HAS_FOODS                                       */
/*==============================================================*/
create table MENUS_HAS_FOODS 
(
   ID_MENU              integer                        not null,
   ID_FOOD              integer                        not null,
   constraint PK_MENUS_HAS_FOODS primary key clustered (ID_MENU, ID_FOOD)
);

/*==============================================================*/
/* Index: MENUS_HAS_FOODS_PK                                    */
/*==============================================================*/
create unique clustered index MENUS_HAS_FOODS_PK on MENUS_HAS_FOODS (
ID_MENU ASC,
ID_FOOD ASC
);

/*==============================================================*/
/* Index: HAS_1_FK                                              */
/*==============================================================*/
create index HAS_1_FK on MENUS_HAS_FOODS (
ID_FOOD ASC
);

/*==============================================================*/
/* Index: HAS_FK                                                */
/*==============================================================*/
create index HAS_FK on MENUS_HAS_FOODS (
ID_MENU ASC
);

/*==============================================================*/
/* Table: ORDERS                                                */
/*==============================================================*/
create table ORDERS 
(
   ID_ORDER             integer                        not null,
   ID_USER              integer                        null,
   ORDER_ADRESS         varchar(50)                    null,
   ORDER_MANAGER        varchar(50)                    null,
   constraint PK_ORDERS primary key clustered (ID_ORDER)
);

/*==============================================================*/
/* Index: ORDERS_PK                                             */
/*==============================================================*/
create unique clustered index ORDERS_PK on ORDERS (
ID_ORDER ASC
);

/*==============================================================*/
/* Index: ASKS_FOR_FK                                           */
/*==============================================================*/
create index ASKS_FOR_FK on ORDERS (
ID_USER ASC
);

/*==============================================================*/
/* Table: ORDERS_HAS_MENUS                                      */
/*==============================================================*/
create table ORDERS_HAS_MENUS 
(
   ID_MENU              integer                        not null,
   ID_ORDER             integer                        not null,
   constraint PK_ORDERS_HAS_MENUS primary key clustered (ID_MENU, ID_ORDER)
);

/*==============================================================*/
/* Index: ORDERS_HAS_MENUS_PK                                   */
/*==============================================================*/
create unique clustered index ORDERS_HAS_MENUS_PK on ORDERS_HAS_MENUS (
ID_MENU ASC,
ID_ORDER ASC
);

/*==============================================================*/
/* Index: NEEDS_FK                                              */
/*==============================================================*/
create index NEEDS_FK on ORDERS_HAS_MENUS (
ID_ORDER ASC
);

/*==============================================================*/
/* Index: NEEDS_1_FK                                            */
/*==============================================================*/
create index NEEDS_1_FK on ORDERS_HAS_MENUS (
ID_MENU ASC
);

/*==============================================================*/
/* Table: USERS                                                 */
/*==============================================================*/
create table USERS 
(
   ID_USER              integer                        not null,
   USER_NAME            varchar(50)                    null,
   USER_ADRESS          varchar(50)                    null,
   USER_MAIL            varchar(50)                    null,
   USER_PHONE           varchar(13)                    null,
   USER_RUN             varchar(13)                    null,
   USER_PASSWORD        varchar(50)                    null,
   constraint PK_USERS primary key clustered (ID_USER)
);

/*==============================================================*/
/* Index: USERS_PK                                              */
/*==============================================================*/
create unique clustered index USERS_PK on USERS (
ID_USER ASC
);

alter table MENUS
   add constraint FK_MENUS_SELLS_ON_DATES foreign key (ID_DATE)
      references DATES (ID_DATE)
      on update restrict
      on delete restrict;

alter table MENUS_HAS_FOODS
   add constraint FK_MENUS_HA_HAS_1_FOODS foreign key (ID_FOOD)
      references FOODS (ID_FOOD)
      on update restrict
      on delete restrict;

alter table MENUS_HAS_FOODS
   add constraint FK_MENUS_HA_HAVE_MENUS foreign key (ID_MENU)
      references MENUS (ID_MENU)
      on update restrict
      on delete restrict;

alter table ORDERS
   add constraint FK_ORDERS_ASKS_FOR_USERS foreign key (ID_USER)
      references USERS (ID_USER)
      on update restrict
      on delete restrict;

alter table ORDERS_HAS_MENUS
   add constraint FK_ORDERS_H_NEEDS_ORDERS foreign key (ID_ORDER)
      references ORDERS (ID_ORDER)
      on update restrict
      on delete restrict;

alter table ORDERS_HAS_MENUS
   add constraint FK_ORDERS_H_NEEDS_1_MENUS foreign key (ID_MENU)
      references MENUS (ID_MENU)
      on update restrict
      on delete restrict;

