/*
Navicat Oracle Data Transfer
Oracle Client Version : 12.1.0.2.0

Source Server         : localhost_oracle_test
Source Server Version : 120200
Source Host           : localhost:1521
Source Schema         : TEST

Target Server Type    : ORACLE
Target Server Version : 120200
File Encoding         : 65001

Date: 2019-09-06 12:27:16
*/


-- ----------------------------
-- Table structure for DI_ZHCB
-- ----------------------------
DROP TABLE "TEST"."DI_ZHCB";
CREATE TABLE "TEST"."DI_ZHCB" (
"ID" NUMBER(15) NOT NULL ,
"PARENT_ID" NUMBER(15) NULL ,
"NAME" VARCHAR2(30 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST"."DI_ZHCB" IS '综合词表';
COMMENT ON COLUMN "TEST"."DI_ZHCB"."ID" IS '主键';
COMMENT ON COLUMN "TEST"."DI_ZHCB"."PARENT_ID" IS '父节点';
COMMENT ON COLUMN "TEST"."DI_ZHCB"."NAME" IS '名称';

-- ----------------------------
-- Table structure for MA_MENU
-- ----------------------------
DROP TABLE "TEST"."MA_MENU";
CREATE TABLE "TEST"."MA_MENU" (
"BSM" NVARCHAR2(38) NOT NULL ,
"PATH" NVARCHAR2(100) NULL ,
"TITLE" NVARCHAR2(50) NOT NULL ,
"PARENT_BSM" NVARCHAR2(50) NULL ,
"ORDER_NO" NUMBER(4) NULL ,
"CREATE_TIME" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST"."MA_MENU" IS '菜单表';
COMMENT ON COLUMN "TEST"."MA_MENU"."BSM" IS '主键';
COMMENT ON COLUMN "TEST"."MA_MENU"."PATH" IS '路径';
COMMENT ON COLUMN "TEST"."MA_MENU"."TITLE" IS '标题';
COMMENT ON COLUMN "TEST"."MA_MENU"."PARENT_BSM" IS '父BSM';
COMMENT ON COLUMN "TEST"."MA_MENU"."ORDER_NO" IS '排序';
COMMENT ON COLUMN "TEST"."MA_MENU"."CREATE_TIME" IS '创建时间';

-- ----------------------------
-- Table structure for MA_ROLE
-- ----------------------------
DROP TABLE "TEST"."MA_ROLE";
CREATE TABLE "TEST"."MA_ROLE" (
"BSM" VARCHAR2(38 BYTE) DEFAULT lower(sys_guid())  NOT NULL ,
"NAME" VARCHAR2(200 BYTE) NULL ,
"FLAG" VARCHAR2(5 BYTE) NOT NULL ,
"ROLE_NO" VARCHAR2(20 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST"."MA_ROLE" IS '角色表';
COMMENT ON COLUMN "TEST"."MA_ROLE"."NAME" IS '名称';
COMMENT ON COLUMN "TEST"."MA_ROLE"."FLAG" IS '标识';
COMMENT ON COLUMN "TEST"."MA_ROLE"."ROLE_NO" IS '角色英文名';

-- ----------------------------
-- Table structure for MA_ROLE_MENU
-- ----------------------------
DROP TABLE "TEST"."MA_ROLE_MENU";
CREATE TABLE "TEST"."MA_ROLE_MENU" (
"BSM" VARCHAR2(60 BYTE) NOT NULL ,
"MENU_BSM" VARCHAR2(38 BYTE) NOT NULL ,
"ROLE_BSM" VARCHAR2(60 BYTE) NOT NULL ,
"CREATE_TIME" DATE NOT NULL ,
"UPDATE_TIME" DATE NOT NULL ,
"DELETE_FLAG" VARCHAR2(1 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST"."MA_ROLE_MENU" IS '角色菜单关联表';
COMMENT ON COLUMN "TEST"."MA_ROLE_MENU"."MENU_BSM" IS '菜单主键';
COMMENT ON COLUMN "TEST"."MA_ROLE_MENU"."ROLE_BSM" IS '角色主键';
COMMENT ON COLUMN "TEST"."MA_ROLE_MENU"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "TEST"."MA_ROLE_MENU"."UPDATE_TIME" IS '更新时间';
COMMENT ON COLUMN "TEST"."MA_ROLE_MENU"."DELETE_FLAG" IS '删除标志';

-- ----------------------------
-- Table structure for MA_USER
-- ----------------------------
DROP TABLE "TEST"."MA_USER";
CREATE TABLE "TEST"."MA_USER" (
"BSM" VARCHAR2(50 BYTE) DEFAULT lower(sys_guid())  NOT NULL ,
"USERNAME" VARCHAR2(50 BYTE) NOT NULL ,
"PASSWORD" VARCHAR2(200 BYTE) NOT NULL ,
"FLAG" VARCHAR2(1 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST"."MA_USER" IS '用户表';
COMMENT ON COLUMN "TEST"."MA_USER"."BSM" IS '主键';
COMMENT ON COLUMN "TEST"."MA_USER"."USERNAME" IS '用户名';
COMMENT ON COLUMN "TEST"."MA_USER"."PASSWORD" IS '密码';
COMMENT ON COLUMN "TEST"."MA_USER"."FLAG" IS '标识';

-- ----------------------------
-- Table structure for MA_USER_ROLE
-- ----------------------------
DROP TABLE "TEST"."MA_USER_ROLE";
CREATE TABLE "TEST"."MA_USER_ROLE" (
"BSM" VARCHAR2(38 BYTE) DEFAULT lower(sys_guid())  NOT NULL ,
"ROLE_BSM" VARCHAR2(20 BYTE) NOT NULL ,
"UER_BSM" VARCHAR2(200 BYTE) NOT NULL ,
"FLAG" VARCHAR2(1 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST"."MA_USER_ROLE" IS '用户角色表';
COMMENT ON COLUMN "TEST"."MA_USER_ROLE"."ROLE_BSM" IS '角色BSM';
COMMENT ON COLUMN "TEST"."MA_USER_ROLE"."UER_BSM" IS '用户BSM';
COMMENT ON COLUMN "TEST"."MA_USER_ROLE"."FLAG" IS '标记';

-- ----------------------------
-- Checks structure for table DI_ZHCB
-- ----------------------------
ALTER TABLE "TEST"."DI_ZHCB" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEST"."DI_ZHCB" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Indexes structure for table MA_MENU
-- ----------------------------

-- ----------------------------
-- Checks structure for table MA_MENU
-- ----------------------------
ALTER TABLE "TEST"."MA_MENU" ADD CHECK ("BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_MENU" ADD CHECK ("TITLE" IS NOT NULL);
ALTER TABLE "TEST"."MA_MENU" ADD CHECK ("BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_MENU" ADD CHECK ("TITLE" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table MA_MENU
-- ----------------------------
ALTER TABLE "TEST"."MA_MENU" ADD PRIMARY KEY ("BSM");

-- ----------------------------
-- Indexes structure for table MA_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table MA_ROLE
-- ----------------------------
ALTER TABLE "TEST"."MA_ROLE" ADD CHECK ("BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE" ADD CHECK ("FLAG" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE" ADD CHECK ("BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE" ADD CHECK ("FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table MA_ROLE
-- ----------------------------
ALTER TABLE "TEST"."MA_ROLE" ADD PRIMARY KEY ("BSM");

-- ----------------------------
-- Indexes structure for table MA_ROLE_MENU
-- ----------------------------

-- ----------------------------
-- Checks structure for table MA_ROLE_MENU
-- ----------------------------
ALTER TABLE "TEST"."MA_ROLE_MENU" ADD CHECK ("BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE_MENU" ADD CHECK ("MENU_BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE_MENU" ADD CHECK ("ROLE_BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE_MENU" ADD CHECK ("CREATE_TIME" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE_MENU" ADD CHECK ("UPDATE_TIME" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE_MENU" ADD CHECK ("DELETE_FLAG" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE_MENU" ADD CHECK ("BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE_MENU" ADD CHECK ("MENU_BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE_MENU" ADD CHECK ("ROLE_BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE_MENU" ADD CHECK ("CREATE_TIME" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE_MENU" ADD CHECK ("UPDATE_TIME" IS NOT NULL);
ALTER TABLE "TEST"."MA_ROLE_MENU" ADD CHECK ("DELETE_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table MA_ROLE_MENU
-- ----------------------------
ALTER TABLE "TEST"."MA_ROLE_MENU" ADD PRIMARY KEY ("BSM");

-- ----------------------------
-- Indexes structure for table MA_USER
-- ----------------------------

-- ----------------------------
-- Checks structure for table MA_USER
-- ----------------------------
ALTER TABLE "TEST"."MA_USER" ADD CHECK ("BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_USER" ADD CHECK ("USERNAME" IS NOT NULL);
ALTER TABLE "TEST"."MA_USER" ADD CHECK ("PASSWORD" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table MA_USER
-- ----------------------------
ALTER TABLE "TEST"."MA_USER" ADD PRIMARY KEY ("BSM");

-- ----------------------------
-- Indexes structure for table MA_USER_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table MA_USER_ROLE
-- ----------------------------
ALTER TABLE "TEST"."MA_USER_ROLE" ADD CHECK ("BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_USER_ROLE" ADD CHECK ("ROLE_BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_USER_ROLE" ADD CHECK ("BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_USER_ROLE" ADD CHECK ("ROLE_BSM" IS NOT NULL);
ALTER TABLE "TEST"."MA_USER_ROLE" ADD CHECK ("FLAG" IS NOT NULL);
ALTER TABLE "TEST"."MA_USER_ROLE" ADD CHECK ("UER_BSM" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table MA_USER_ROLE
-- ----------------------------
ALTER TABLE "TEST"."MA_USER_ROLE" ADD PRIMARY KEY ("BSM");
