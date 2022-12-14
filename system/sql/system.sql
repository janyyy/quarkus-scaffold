/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 130007
 Source Host           : localhost:5432
 Source Catalog        : sengi-dev
 Source Schema         : system

 Target Server Type    : PostgreSQL
 Target Server Version : 130007
 File Encoding         : 65001

 Date: 22/06/2022 16:39:42
 this is PostgreSQL data file
*/


-- ----------------------------
-- Sequence structure for sys_config_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_config_id_seq";
CREATE SEQUENCE "system"."sys_config_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_config_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_config_id_seq1";
CREATE SEQUENCE "system"."sys_config_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_dept_dept_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_dept_dept_id_seq";
CREATE SEQUENCE "system"."sys_dept_dept_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_dept_dept_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_dept_dept_id_seq1";
CREATE SEQUENCE "system"."sys_dept_dept_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_dict_detail_detail_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_dict_detail_detail_id_seq";
CREATE SEQUENCE "system"."sys_dict_detail_detail_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_dict_detail_detail_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_dict_detail_detail_id_seq1";
CREATE SEQUENCE "system"."sys_dict_detail_detail_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_dict_dict_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_dict_dict_id_seq";
CREATE SEQUENCE "system"."sys_dict_dict_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_dict_dict_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_dict_dict_id_seq1";
CREATE SEQUENCE "system"."sys_dict_dict_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_job_job_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_job_job_id_seq";
CREATE SEQUENCE "system"."sys_job_job_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_job_job_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_job_job_id_seq1";
CREATE SEQUENCE "system"."sys_job_job_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_log_log_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_log_log_id_seq";
CREATE SEQUENCE "system"."sys_log_log_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_log_log_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_log_log_id_seq1";
CREATE SEQUENCE "system"."sys_log_log_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_menu_menu_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_menu_menu_id_seq";
CREATE SEQUENCE "system"."sys_menu_menu_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_menu_menu_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_menu_menu_id_seq1";
CREATE SEQUENCE "system"."sys_menu_menu_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_role_role_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_role_role_id_seq";
CREATE SEQUENCE "system"."sys_role_role_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_role_role_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_role_role_id_seq1";
CREATE SEQUENCE "system"."sys_role_role_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_roles_menus_menu_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_roles_menus_menu_id_seq";
CREATE SEQUENCE "system"."sys_roles_menus_menu_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_roles_menus_menu_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_roles_menus_menu_id_seq1";
CREATE SEQUENCE "system"."sys_roles_menus_menu_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_user_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_user_user_id_seq";
CREATE SEQUENCE "system"."sys_user_user_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_user_user_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_user_user_id_seq1";
CREATE SEQUENCE "system"."sys_user_user_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_users_roles_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_users_roles_user_id_seq";
CREATE SEQUENCE "system"."sys_users_roles_user_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sys_users_roles_user_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."sys_users_roles_user_id_seq1";
CREATE SEQUENCE "system"."sys_users_roles_user_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tool_email_config_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."tool_email_config_id_seq";
CREATE SEQUENCE "system"."tool_email_config_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tool_email_config_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."tool_email_config_id_seq1";
CREATE SEQUENCE "system"."tool_email_config_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tool_qiniu_config_config_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."tool_qiniu_config_config_id_seq";
CREATE SEQUENCE "system"."tool_qiniu_config_config_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tool_qiniu_config_config_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."tool_qiniu_config_config_id_seq1";
CREATE SEQUENCE "system"."tool_qiniu_config_config_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tool_qiniu_content_content_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."tool_qiniu_content_content_id_seq";
CREATE SEQUENCE "system"."tool_qiniu_content_content_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tool_qiniu_content_content_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "system"."tool_qiniu_content_content_id_seq1";
CREATE SEQUENCE "system"."tool_qiniu_content_content_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS "system"."sys_config";
CREATE TABLE "system"."sys_config"
(
    "id"          int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "params"      json,
    "uuid"        varchar(64) COLLATE "pg_catalog"."default",
    "description" varchar(255) COLLATE "pg_catalog"."default",
    "create_time" timestamp(3),
    "create_by"   varchar(255) COLLATE "pg_catalog"."default",
    "update_by"   varchar(255) COLLATE "pg_catalog"."default",
    "update_time" timestamp(3)
)
;
COMMENT
ON COLUMN "system"."sys_config"."id" IS '??????';
COMMENT
ON COLUMN "system"."sys_config"."params" IS '??????';
COMMENT
ON COLUMN "system"."sys_config"."uuid" IS 'UUID';
COMMENT
ON COLUMN "system"."sys_config"."description" IS '??????';
COMMENT
ON COLUMN "system"."sys_config"."create_time" IS '????????????';
COMMENT
ON COLUMN "system"."sys_config"."create_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_config"."update_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_config"."update_time" IS '????????????';
COMMENT
ON TABLE "system"."sys_config" IS '?????????????????????';

-- ----------------------------
-- Records of sys_config
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS "system"."sys_dept";
CREATE TABLE "system"."sys_dept"
(
    "dept_id"     int8                                        NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "pid"         int8,
    "sub_count"   int4,
    "name"        varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "dept_sort"   int4,
    "enabled"     bool                                        NOT NULL,
    "create_by"   varchar(255) COLLATE "pg_catalog"."default",
    "update_by"   varchar(255) COLLATE "pg_catalog"."default",
    "create_time" timestamp(3),
    "update_time" timestamp(3)
)
;
COMMENT
ON COLUMN "system"."sys_dept"."dept_id" IS 'ID';
COMMENT
ON COLUMN "system"."sys_dept"."pid" IS '????????????';
COMMENT
ON COLUMN "system"."sys_dept"."sub_count" IS '???????????????';
COMMENT
ON COLUMN "system"."sys_dept"."name" IS '??????';
COMMENT
ON COLUMN "system"."sys_dept"."dept_sort" IS '??????';
COMMENT
ON COLUMN "system"."sys_dept"."enabled" IS '??????';
COMMENT
ON COLUMN "system"."sys_dept"."create_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_dept"."update_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_dept"."create_time" IS '????????????';
COMMENT
ON COLUMN "system"."sys_dept"."update_time" IS '????????????';
COMMENT
ON TABLE "system"."sys_dept" IS '??????';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO "system"."sys_dept"
VALUES (2, 7, 1, '?????????', 1, 't', NULL, 'admin', NULL, '2021-12-17 15:00:23.74');
INSERT INTO "system"."sys_dept"
VALUES (3, 7, 0, '?????????', 2, 't', 'admin', 'admin', '2021-12-17 15:00:53.852', '2021-12-17 15:02:49.254');
INSERT INTO "system"."sys_dept"
VALUES (4, 7, 0, '?????????', 3, 't', 'admin', 'admin', '2021-12-17 15:01:29.289', '2021-12-17 15:02:59.156');
INSERT INTO "system"."sys_dept"
VALUES (5, 7, 0, '?????????', 3, 't', 'admin', NULL, '2021-12-17 15:03:19.776', '2021-12-17 15:03:19.776');
INSERT INTO "system"."sys_dept"
VALUES (1, 8, 0, '?????????', 1, 't', 'admin', 'admin', '2021-12-17 15:00:34.46', '2021-12-17 15:07:03.635');
INSERT INTO "system"."sys_dept"
VALUES (6, 8, 0, '?????????', 2, 't', 'admin', NULL, '2021-12-17 15:07:59.27', '2021-12-17 15:07:59.27');
INSERT INTO "system"."sys_dept"
VALUES (7, NULL, 3, '??????', 0, 't', NULL, 'admin', NULL, '2022-06-22 16:37:28.73');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS "system"."sys_dict";
CREATE TABLE "system"."sys_dict"
(
    "dict_id"     int8                                        NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "name"        varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "description" varchar(255) COLLATE "pg_catalog"."default",
    "create_by"   varchar(255) COLLATE "pg_catalog"."default",
    "update_by"   varchar(255) COLLATE "pg_catalog"."default",
    "create_time" timestamp(3),
    "update_time" timestamp(3)
)
;
COMMENT
ON COLUMN "system"."sys_dict"."dict_id" IS 'ID';
COMMENT
ON COLUMN "system"."sys_dict"."name" IS '????????????';
COMMENT
ON COLUMN "system"."sys_dict"."description" IS '??????';
COMMENT
ON COLUMN "system"."sys_dict"."create_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_dict"."update_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_dict"."create_time" IS '????????????';
COMMENT
ON COLUMN "system"."sys_dict"."update_time" IS '????????????';
COMMENT
ON TABLE "system"."sys_dict" IS '????????????';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO "system"."sys_dict"
VALUES (1, 'user_status', '????????????', 'admin', 'admin', '2019-10-27 20:31:36', '2019-10-27 20:31:36');
INSERT INTO "system"."sys_dict"
VALUES (4, 'dept_status', '????????????', 'admin', 'admin', '2019-10-27 20:31:36', '2019-10-27 20:31:36');
INSERT INTO "system"."sys_dict"
VALUES (5, 'job_status', '????????????', 'admin', 'admin', '2019-10-27 20:31:36', '2019-10-27 20:31:36');

-- ----------------------------
-- Table structure for sys_dict_detail
-- ----------------------------
DROP TABLE IF EXISTS "system"."sys_dict_detail";
CREATE TABLE "system"."sys_dict_detail"
(
    "detail_id"   int8                                        NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "dict_id"     int8,
    "label"       varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "value"       varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "dict_sort"   int4,
    "create_by"   varchar(255) COLLATE "pg_catalog"."default",
    "update_by"   varchar(255) COLLATE "pg_catalog"."default",
    "create_time" timestamp(3),
    "update_time" timestamp(3)
)
;
COMMENT
ON COLUMN "system"."sys_dict_detail"."detail_id" IS 'ID';
COMMENT
ON COLUMN "system"."sys_dict_detail"."dict_id" IS '??????id';
COMMENT
ON COLUMN "system"."sys_dict_detail"."label" IS '????????????';
COMMENT
ON COLUMN "system"."sys_dict_detail"."value" IS '?????????';
COMMENT
ON COLUMN "system"."sys_dict_detail"."dict_sort" IS '??????';
COMMENT
ON COLUMN "system"."sys_dict_detail"."create_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_dict_detail"."update_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_dict_detail"."create_time" IS '????????????';
COMMENT
ON COLUMN "system"."sys_dict_detail"."update_time" IS '????????????';
COMMENT
ON TABLE "system"."sys_dict_detail" IS '??????????????????';

-- ----------------------------
-- Records of sys_dict_detail
-- ----------------------------
INSERT INTO "system"."sys_dict_detail"
VALUES (1, 1, '??????', 'true', 1, 'admin', 'admin', '2019-10-27 20:31:36', '2019-10-27 20:31:36');
INSERT INTO "system"."sys_dict_detail"
VALUES (4, 4, '??????', 'false', 2, 'admin', 'admin', '2019-10-27 20:31:36', '2019-10-27 20:31:36');
INSERT INTO "system"."sys_dict_detail"
VALUES (6, 5, '??????', 'false', 2, 'admin', 'admin', '2019-10-27 20:31:36', '2019-10-27 20:31:36');
INSERT INTO "system"."sys_dict_detail"
VALUES (5, 5, '??????', 'true', 1, 'admin', 'admin', '2019-10-27 20:31:36', '2019-10-27 20:31:36');
INSERT INTO "system"."sys_dict_detail"
VALUES (3, 4, '??????', 'true', 1, 'admin', 'admin', '2019-10-27 20:31:36', '2019-10-27 20:31:36');
INSERT INTO "system"."sys_dict_detail"
VALUES (2, 1, '??????', 'false', 2, 'admin', 'admin', '2019-10-27 20:31:36', '2019-10-27 20:31:36');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS "system"."sys_job";
CREATE TABLE "system"."sys_job"
(
    "job_id"      int8                                        NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "name"        varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "enabled"     bool                                        NOT NULL,
    "job_sort"    int4,
    "create_by"   varchar(255) COLLATE "pg_catalog"."default",
    "update_by"   varchar(255) COLLATE "pg_catalog"."default",
    "create_time" timestamp(3),
    "update_time" timestamp(3)
)
;
COMMENT
ON COLUMN "system"."sys_job"."job_id" IS 'ID';
COMMENT
ON COLUMN "system"."sys_job"."name" IS '????????????';
COMMENT
ON COLUMN "system"."sys_job"."enabled" IS '????????????';
COMMENT
ON COLUMN "system"."sys_job"."job_sort" IS '??????';
COMMENT
ON COLUMN "system"."sys_job"."create_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_job"."update_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_job"."create_time" IS '????????????';
COMMENT
ON COLUMN "system"."sys_job"."update_time" IS '????????????';
COMMENT
ON TABLE "system"."sys_job" IS '??????';

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO "system"."sys_job"
VALUES (2, '????????????', 't', 1, NULL, 'admin', '2021-12-10 10:26:37.82', '2021-12-17 15:01:52.383');
INSERT INTO "system"."sys_job"
VALUES (8, '??????', 't', 2, 'admin', 'admin', '2021-12-13 11:21:18.118', '2021-12-17 15:01:58.444');
INSERT INTO "system"."sys_job"
VALUES (9, '??????', 't', 3, 'admin', NULL, '2021-12-17 15:02:04.237', '2021-12-17 15:02:04.237');
INSERT INTO "system"."sys_job"
VALUES (10, '??????', 't', 4, 'admin', NULL, '2021-12-17 15:02:09.732', '2021-12-17 15:02:09.732');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS "system"."sys_log";
CREATE TABLE "system"."sys_log"
(
    "log_id"           int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "description"      varchar(255) COLLATE "pg_catalog"."default",
    "log_type"         varchar(255) COLLATE "pg_catalog"."default",
    "method"           varchar(255) COLLATE "pg_catalog"."default",
    "params"           text COLLATE "pg_catalog"."default",
    "request_ip"       varchar(255) COLLATE "pg_catalog"."default",
    "time"             int8,
    "username"         varchar(255) COLLATE "pg_catalog"."default",
    "address"          varchar(255) COLLATE "pg_catalog"."default",
    "browser"          varchar(255) COLLATE "pg_catalog"."default",
    "exception_detail" text COLLATE "pg_catalog"."default",
    "create_time"      timestamp(3)
)
;
COMMENT
ON COLUMN "system"."sys_log"."log_id" IS 'ID';
COMMENT
ON TABLE "system"."sys_log" IS '????????????';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO "system"."sys_log"
VALUES (1, '??????????????????', 'INFO', 'com.yujianyou.resource.DictResource.deleteAll()', '[7,8,9,10,11]', '192.168.10.25',
        38,
        'admin', '??????IP|??????IP', 'Chrome 102', NULL, '2022-06-22 16:36:41.663');
INSERT INTO "system"."sys_log"
VALUES (2, '??????????????????', 'INFO', 'com.yujianyou.resource.UserResource.deleteAll()', '[16,17,18,19,20,21,11,12,13,14]',
        '192.168.10.25', 20, 'admin', '??????IP|??????IP', 'Chrome 102', NULL, '2022-06-22 16:36:57.514');
INSERT INTO "system"."sys_log"
VALUES (3, '??????????????????', 'INFO', 'com.yujianyou.resource.UserResource.deleteAll()', '[2,4,9,10]', '192.168.10.25', 10,
        'admin', '??????IP|??????IP', 'Chrome 102', NULL, '2022-06-22 16:37:01.653');
INSERT INTO "system"."sys_log"
VALUES (4, '??????????????????', 'INFO', 'com.yujianyou.resource.RoleResource.deleteAll()', '[2,3,6,7]', '192.168.10.25', 47,
        'admin', '??????IP|??????IP', 'Chrome 102', NULL, '2022-06-22 16:37:15.214');
INSERT INTO "system"."sys_log"
VALUES (5, '????????????', 'INFO', 'com.yujianyou.resource.MenuResource.deleteAll()', '[26,20]', '192.168.10.25', 25,
        'admin',
        '??????IP|??????IP', 'Chrome 102', NULL, '2022-06-22 16:37:20.972');
INSERT INTO "system"."sys_log"
VALUES (6, '??????????????????', 'INFO', 'com.yujianyou.resource.DeptResource.update()',
        '{"id":7,"subCount":3,"name":"??????","deptSort":0,"enabled":true}', '192.168.10.25', 12, 'admin',
        '??????IP|??????IP',
        'Chrome 102', NULL, '2022-06-22 16:37:28.74');
INSERT INTO "system"."sys_log"
VALUES (7, '??????????????????', 'INFO', 'com.yujianyou.resource.UserResource.add()',
        '{"id":2,"roles":[{"id":1}],"jobs":[{"id":2}],"dept":{"id":2},"username":"11","nickName":"11","gender":"???","phone":"13800138000","email":"13800138000@qq.com","password":"e10adc3949ba59abbe56e057f20f883e","isAdmin":false,"enabled":true,"createBy":"admin","createTime":1655887108536,"updateTime":1655887108536}',
        '192.168.10.25', 11, 'admin', '??????IP|??????IP', 'Chrome 102', NULL, '2022-06-22 16:38:28.544');
INSERT INTO "system"."sys_log"
VALUES (8, '????????????', 'INFO', 'com.yujianyou.resource.UserResource.resetPass()', '{}', '192.168.10.25', 7, 'admin',
        '??????IP|??????IP', 'Chrome 102', NULL, '2022-06-22 16:38:32.064');
INSERT INTO "system"."sys_log"
VALUES (9, '??????????????????', 'INFO', 'com.yujianyou.resource.UserResource.update()',
        '{"id":2,"roles":[{"id":1}],"jobs":[{"id":2}],"dept":{"id":2,"pid":7,"subCount":1,"name":"?????????","deptSort":1,"enabled":true,"updateBy":"admin","updateTime":1639724423740},"username":"11","nickName":"11","gender":"???","phone":"13800138000","email":"13800138000@qq.com","password":"e10adc3949ba59abbe56e057f20f883e","isAdmin":false,"enabled":true,"createBy":"admin","createTime":1655887108536,"updateTime":1655887108536}',
        '192.168.10.25', 11, 'admin', '??????IP|??????IP', 'Chrome 102', NULL, '2022-06-22 16:39:05.028');
INSERT INTO "system"."sys_log"
VALUES (10, '??????????????????', 'INFO', 'com.yujianyou.resource.UserResource.deleteAll()', '[2]', '192.168.10.25', 7,
        'admin',
        '??????IP|??????IP', 'Chrome 102', NULL, '2022-06-22 16:39:07.882');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS "system"."sys_menu";
CREATE TABLE "system"."sys_menu"
(
    "menu_id"     int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "pid"         int8,
    "sub_count"   int4,
    "type"        int4,
    "title"       varchar(255) COLLATE "pg_catalog"."default",
    "name"        varchar(255) COLLATE "pg_catalog"."default",
    "component"   varchar(255) COLLATE "pg_catalog"."default",
    "menu_sort"   int4,
    "icon"        varchar(255) COLLATE "pg_catalog"."default",
    "path"        varchar(255) COLLATE "pg_catalog"."default",
    "i_frame"     bool,
    "cache"       bool,
    "hidden"      bool,
    "permission"  varchar(255) COLLATE "pg_catalog"."default",
    "create_by"   varchar(255) COLLATE "pg_catalog"."default",
    "update_by"   varchar(255) COLLATE "pg_catalog"."default",
    "create_time" timestamp(3),
    "update_time" timestamp(3)
)
;
COMMENT
ON COLUMN "system"."sys_menu"."menu_id" IS 'ID';
COMMENT
ON COLUMN "system"."sys_menu"."pid" IS '????????????ID';
COMMENT
ON COLUMN "system"."sys_menu"."sub_count" IS '???????????????';
COMMENT
ON COLUMN "system"."sys_menu"."type" IS '????????????';
COMMENT
ON COLUMN "system"."sys_menu"."title" IS '????????????';
COMMENT
ON COLUMN "system"."sys_menu"."name" IS '????????????';
COMMENT
ON COLUMN "system"."sys_menu"."component" IS '??????';
COMMENT
ON COLUMN "system"."sys_menu"."menu_sort" IS '??????';
COMMENT
ON COLUMN "system"."sys_menu"."icon" IS '??????';
COMMENT
ON COLUMN "system"."sys_menu"."path" IS '????????????';
COMMENT
ON COLUMN "system"."sys_menu"."i_frame" IS '????????????';
COMMENT
ON COLUMN "system"."sys_menu"."cache" IS '??????';
COMMENT
ON COLUMN "system"."sys_menu"."hidden" IS '??????';
COMMENT
ON COLUMN "system"."sys_menu"."permission" IS '??????';
COMMENT
ON COLUMN "system"."sys_menu"."create_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_menu"."update_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_menu"."create_time" IS '????????????';
COMMENT
ON COLUMN "system"."sys_menu"."update_time" IS '????????????';
COMMENT
ON TABLE "system"."sys_menu" IS '????????????';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO "system"."sys_menu"
VALUES (19, 16, 0, 2, '????????????', NULL, NULL, NULL, NULL, NULL, 'f', 'f', 'f', 'menus:del', NULL, NULL, NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (17, 16, 0, 2, '????????????', NULL, NULL, NULL, NULL, NULL, 'f', 'f', 'f', 'menus:add', NULL, NULL, NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (8, 2, 0, 2, '??????', NULL, NULL, 3, NULL, NULL, 'f', 'f', 'f', 'flight:del', NULL, NULL, NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (6, 2, 0, 2, '??????', NULL, NULL, 1, NULL, NULL, 'f', 'f', 'f', 'flight:add', NULL, NULL, NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (9, 2, 0, 2, '????????????', NULL, NULL, 4, NULL, NULL, 'f', 'f', 'f', 'flight:downloadTemplate', NULL, NULL, NULL,
        NULL);
INSERT INTO "system"."sys_menu"
VALUES (11, 3, 0, 2, '????????????', NULL, NULL, 1, NULL, NULL, 'f', 'f', 'f', 'parcelReceiveInfo:downloadReceiveFiles',
        NULL,
        NULL, NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (12, 4, 0, 2, '????????????', NULL, NULL, 1, NULL, NULL, 'f', 'f', 'f', 'flight:downloadTemplate', NULL, NULL, NULL,
        NULL);
INSERT INTO "system"."sys_menu"
VALUES (14, 5, 0, 2, '??????', NULL, NULL, 1, NULL, NULL, 'f', 'f', 'f', 'asyncTaskInfo:del', NULL, NULL, NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (15, 2, 0, 2, '????????????', NULL, NULL, 5, NULL, NULL, 'f', 'f', 'f', 'flight:forecastPush', NULL, NULL, NULL,
        NULL);
INSERT INTO "system"."sys_menu"
VALUES (18, 16, 0, 2, '????????????', NULL, NULL, NULL, NULL, NULL, 'f', 'f', 'f', 'menus:edit', NULL, NULL, NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (41, 23, 0, 2, '????????????', NULL, NULL, 3, NULL, NULL, 'f', 'f', 'f', 'dept:del', NULL, NULL,
        '2021-12-09 16:13:44.841', '2021-12-09 16:13:44.841');
INSERT INTO "system"."sys_menu"
VALUES (23, 1, 3, 1, '????????????', 'Dept', 'system/dept/index', 4, 'dept', 'dept', 'f', 'f', 'f', 'dept:list', NULL, NULL,
        NULL, '2021-12-09 16:13:44.872');
INSERT INTO "system"."sys_menu"
VALUES (5, 20, 1, 1, '????????????', 'AsyncTaskInfo', 'business/asyncTaskInfo/index', 4, 'taskFeedback', 'asyncTask', 'f',
        'f',
        'f', 'asyncTaskInfo:list', 'admin', 'admin', '2021-12-06 14:47:04', '2021-12-16 17:37:25.295');
INSERT INTO "system"."sys_menu"
VALUES (46, 4, 0, 2, '??????????????????', NULL, NULL, 3, NULL, NULL, 'f', 'f', 'f', 'bulkParcelInfo:del', 'admin', NULL,
        '2021-12-21 09:51:11.811', '2021-12-21 09:51:11.811');
INSERT INTO "system"."sys_menu"
VALUES (1, NULL, 6, 0, '????????????', NULL, NULL, 1, 'system', 'system', 'f', 'f', 'f', NULL, 'admin', 'admin',
        '2021-12-06 14:40:13', '2021-12-06 14:40:15');
INSERT INTO "system"."sys_menu"
VALUES (4, 20, 3, 1, 'VE????????????', 'BulkParcelInfo', 'business/bulkParcelInfo/index', 3, 'orderForm', 'bulk', 'f', 'f',
        'f',
        'bulkParcelInfo:list', 'admin', 'admin', '2021-12-06 14:47:04', '2021-12-21 09:51:11.82');
INSERT INTO "system"."sys_menu"
VALUES (27, 22, 0, 2, '????????????', NULL, NULL, 1, NULL, NULL, 'f', 'f', 'f', 'roles:add', NULL, NULL, NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (51, 50, 0, 2, '??????????????????', NULL, NULL, 1, NULL, NULL, 'f', 'f', 'f', 'parcelItem:edit', 'admin', NULL,
        '2022-02-23 14:57:57.342', '2022-02-23 14:57:57.342');
INSERT INTO "system"."sys_menu"
VALUES (28, 22, 0, 2, '????????????', NULL, NULL, 2, NULL, NULL, 'f', 'f', 'f', 'roles:edit', NULL, NULL, NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (7, 2, 1, 2, '??????', NULL, NULL, 2, NULL, NULL, 'f', 'f', 'f', 'flight:edit', NULL, NULL, NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (16, 1, 3, 1, '????????????', 'Menu', 'system/menu/index', 3, 'menu', 'menu', 'f', 'f', 'f', 'menus:list', NULL,
        NULL,
        NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (29, 22, 0, 2, '????????????', NULL, NULL, 3, NULL, NULL, 'f', 'f', 'f', 'roles:del', NULL, NULL, NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (22, 1, 3, 1, '????????????', 'Role', 'system/role/index', 2, 'role', 'role', 'f', 'f', 'f', 'roles:list', NULL,
        NULL,
        NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (30, 21, 0, 2, '????????????', NULL, NULL, 1, NULL, NULL, 'f', 'f', 'f', 'user:add', NULL, NULL, NULL, NULL);
INSERT INTO "system"."sys_menu"
VALUES (31, 21, 0, 2, '????????????', NULL, NULL, 2, NULL, NULL, 'f', 'f', 'f', 'user:edit', NULL, NULL,
        '2021-12-09 16:09:35.012', '2021-12-09 16:09:35.012');
INSERT INTO "system"."sys_menu"
VALUES (32, 21, 0, 2, '????????????', NULL, NULL, 3, NULL, NULL, 'f', 'f', 'f', '????????????', NULL, NULL,
        '2021-12-09 16:10:09.346',
        '2021-12-09 16:10:09.346');
INSERT INTO "system"."sys_menu"
VALUES (21, 1, 3, 1, '????????????', 'User', 'system/user/index', 1, 'peoples', 'user', 'f', 'f', 'f', 'user:list', NULL,
        NULL,
        NULL, '2021-12-09 16:10:09.372');
INSERT INTO "system"."sys_menu"
VALUES (33, 25, 0, 2, '????????????', NULL, NULL, 1, NULL, NULL, 'f', 'f', 'f', 'dict:add', NULL, NULL,
        '2021-12-09 16:11:14.261', '2021-12-09 16:11:14.261');
INSERT INTO "system"."sys_menu"
VALUES (10, 2, 0, 2, '????????????', NULL, NULL, 5, NULL, NULL, 'f', 'f', 'f', 'flight:importFlightInfo', NULL, 'admin',
        NULL,
        '2021-12-13 17:51:10.975');
INSERT INTO "system"."sys_menu"
VALUES (34, 25, 0, 2, '????????????', NULL, NULL, 2, NULL, NULL, 'f', 'f', 'f', 'dict:edit', NULL, NULL,
        '2021-12-09 16:11:28.463', '2021-12-09 16:11:28.463');
INSERT INTO "system"."sys_menu"
VALUES (13, 4, 0, 2, '????????????', NULL, NULL, 2, NULL, NULL, 'f', 'f', 'f', 'bulkParcelInfo:importBulkParcelInfo', NULL,
        'admin', NULL, '2021-12-13 17:51:38.874');
INSERT INTO "system"."sys_menu"
VALUES (35, 25, 0, 2, '????????????', NULL, NULL, 3, NULL, NULL, 'f', 'f', 'f', 'dict:del', NULL, NULL,
        '2021-12-09 16:11:46.716', '2021-12-09 16:11:46.716');
INSERT INTO "system"."sys_menu"
VALUES (25, 1, 3, 1, '????????????', 'Dict', 'system/dict/index', 6, 'dictionary', 'dict', 'f', 'f', 'f', 'dict:list', NULL,
        NULL, NULL, '2021-12-09 16:11:46.74');
INSERT INTO "system"."sys_menu"
VALUES (36, 24, 0, 2, '????????????', NULL, NULL, 1, NULL, NULL, 'f', 'f', 'f', 'job:add', NULL, NULL,
        '2021-12-09 16:12:09.763', '2021-12-09 16:12:09.763');
INSERT INTO "system"."sys_menu"
VALUES (37, 24, 0, 2, '????????????', NULL, NULL, 2, NULL, NULL, 'f', 'f', 'f', 'job:edit', NULL, NULL,
        '2021-12-09 16:12:27.314', '2021-12-09 16:12:27.314');
INSERT INTO "system"."sys_menu"
VALUES (3, 20, 1, 1, 'POD??????', 'ParcelReceiveInfo', 'business/parcelReceiveInfo/index', 2, 'pod', 'pod', 'f', 'f', 'f',
        'parcelReceiveInfo:list', 'admin', 'admin', '2021-12-06 14:43:57', '2021-12-16 17:37:08.339');
INSERT INTO "system"."sys_menu"
VALUES (38, 24, 0, 2, '????????????', NULL, NULL, 3, NULL, NULL, 'f', 'f', 'f', 'job:del', NULL, NULL,
        '2021-12-09 16:12:44.034', '2021-12-09 16:12:44.034');
INSERT INTO "system"."sys_menu"
VALUES (24, 1, 3, 1, '????????????', 'Job', 'system/job/index', 5, 'Steve-Jobs', 'job', 'f', 'f', 'f', 'job:list', NULL,
        NULL,
        NULL, '2021-12-09 16:12:44.064');
INSERT INTO "system"."sys_menu"
VALUES (39, 23, 0, 2, '????????????', NULL, NULL, 1, NULL, NULL, 'f', 'f', 'f', 'dept:add', NULL, NULL,
        '2021-12-09 16:13:14.495', '2021-12-09 16:13:14.495');
INSERT INTO "system"."sys_menu"
VALUES (45, 20, 1, 1, '??????????????????', 'Tracking', 'business/tracking/index', 5, 'guiji', 'tracking', 'f', 'f', 'f',
        'trajectoryInfo:list', 'admin', 'admin', '2021-12-13 16:53:51.952', '2022-01-04 18:45:06.23');
INSERT INTO "system"."sys_menu"
VALUES (40, 23, 0, 2, '????????????', NULL, NULL, 2, NULL, NULL, 'f', 'f', 'f', 'dept:edit', NULL, NULL,
        '2021-12-09 16:13:29.601', '2021-12-09 16:13:29.601');
INSERT INTO "system"."sys_menu"
VALUES (47, 45, 0, 2, '??????????????????', NULL, NULL, 1, NULL, NULL, 'f', 'f', 'f', 'trajectoryInfo:export', 'admin',
        'admin',
        '2021-12-30 19:18:11.807', '2022-01-04 18:45:13.217');
INSERT INTO "system"."sys_menu"
VALUES (49, 48, 0, 2, '??????????????????', NULL, NULL, 1, NULL, NULL, 'f', 'f', 'f', 'parcel:export', 'admin', NULL,
        '2022-02-22 15:11:19.986', '2022-02-22 15:11:19.986');
INSERT INTO "system"."sys_menu"
VALUES (53, 50, 0, 2, '????????????', NULL, NULL, 2, NULL, NULL, 'f', 'f', 'f', 'parcelItem:batchUpdate', 'admin', NULL,
        '2022-02-28 17:34:58.045', '2022-02-28 17:34:58.045');
INSERT INTO "system"."sys_menu"
VALUES (48, 20, 1, 1, '??????????????????', 'Parcel', 'business/customerParcel/index', 6, 'parcelInfo', 'parcel', 'f', 'f',
        'f',
        'parcel:list', 'admin', 'admin', '2022-02-22 15:10:10.997', '2022-03-09 10:27:41.121');
INSERT INTO "system"."sys_menu"
VALUES (50, 20, 2, 1, '??????????????????', 'ParcelItem', 'business/parcelItem/index', 7, 'hscode', 'parcelItem', 'f', 'f',
        'f',
        'parcelItem:list', 'admin', 'admin', '2022-02-23 14:57:30.686', '2022-03-09 10:28:10.591');
INSERT INTO "system"."sys_menu"
VALUES (52, 20, 0, 1, '??????????????????', 'WarehouseE2', 'business/warehouseE2/index', 8, 'jiaoyan', 'warehouseE2', 'f',
        'f', 'f',
        'warehouseE2:list', 'admin', 'admin', '2022-02-28 16:44:13.254', '2022-03-09 10:28:43.809');
INSERT INTO "system"."sys_menu"
VALUES (54, 2, 0, 2, '????????????', NULL, NULL, 7, NULL, NULL, 'f', 'f', 'f', 'flight:qgMaintain', 'admin', NULL,
        '2022-03-14 16:54:24.426', '2022-03-14 16:54:24.426');
INSERT INTO "system"."sys_menu"
VALUES (2, 20, 7, 1, '????????????', 'Flight', 'business/flight/index', 1, 'airInfo', 'flight', 'f', 'f', 'f',
        'flight:list',
        'admin', 'admin', '2021-12-06 14:43:57', '2022-03-14 16:54:24.457');
INSERT INTO "system"."sys_menu"
VALUES (56, 55, 0, 2, '????????????????????????', NULL, NULL, 1, NULL, NULL, 'f', 'f', 'f', 'cainiaoReturnedPurchase:add',
        'admin',
        NULL, '2022-03-16 15:13:04.136', '2022-03-16 15:13:04.136');
INSERT INTO "system"."sys_menu"
VALUES (57, 55, 0, 2, '????????????????????????', NULL, NULL, 2, NULL, NULL, 'f', 'f', 'f', 'cainiaoReturnedPurchase:edit',
        'admin',
        NULL, '2022-03-16 15:13:30.397', '2022-03-16 15:13:30.397');
INSERT INTO "system"."sys_menu"
VALUES (58, 55, 0, 2, '??????????????????????????????', NULL, NULL, 3, NULL, NULL, 'f', 'f', 'f', 'cainiaoReturnedPurchase:del',
        'admin',
        NULL, '2022-03-16 15:14:00.153', '2022-03-16 15:14:00.153');
INSERT INTO "system"."sys_menu"
VALUES (59, 55, 0, 2, '??????????????????????????????', NULL, NULL, 4, NULL, NULL, 'f', 'f', 'f', 'cainiaoReturnedPurchase:push',
        'admin',
        'admin', '2022-03-16 15:14:26.246', '2022-03-16 15:15:34.506');
INSERT INTO "system"."sys_menu"
VALUES (60, 55, 0, 2, '??????????????????????????????', NULL, NULL, 5, NULL, NULL, 'f', 'f', 'f',
        'cainiaoReturnedPurchase:export', 'admin',
        'admin', '2022-03-16 15:14:51.861', '2022-03-16 15:15:41.656');
INSERT INTO "system"."sys_menu"
VALUES (61, 55, 0, 2, '????????????????????????', NULL, NULL, 6, NULL, NULL, 'f', 'f', 'f', 'cainiaoReturnedPurchase:import',
        'admin',
        'admin', '2022-03-16 15:15:23.866', '2022-03-16 15:15:49.234');
INSERT INTO "system"."sys_menu"
VALUES (62, 55, 0, 2, '????????????????????????????????????', NULL, NULL, 7, NULL, NULL, 'f', 'f', 'f', 'flight:downloadTemplate',
        'admin',
        NULL, '2022-03-16 15:16:30.729', '2022-03-16 15:16:30.729');
INSERT INTO "system"."sys_menu"
VALUES (55, 20, 7, 1, '????????????????????????', 'CainiaoReturnedPurchase', 'business/cainiaoReturnedPurchase/index', 9,
        'tuihuo',
        'cainiaoReturnedPurchase', 'f', 'f', 'f', 'cainiaoReturnedPurchase:list', 'admin', 'admin',
        '2022-03-15 11:13:58.747', '2022-03-16 15:16:30.757');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "system"."sys_role";
CREATE TABLE "system"."sys_role"
(
    "role_id"     int8                                        NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "name"        varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "level"       int4,
    "description" varchar(255) COLLATE "pg_catalog"."default",
    "data_scope"  varchar(255) COLLATE "pg_catalog"."default",
    "create_by"   varchar(255) COLLATE "pg_catalog"."default",
    "update_by"   varchar(255) COLLATE "pg_catalog"."default",
    "create_time" timestamp(3),
    "update_time" timestamp(3)
)
;
COMMENT
ON COLUMN "system"."sys_role"."role_id" IS 'ID';
COMMENT
ON COLUMN "system"."sys_role"."name" IS '??????';
COMMENT
ON COLUMN "system"."sys_role"."level" IS '????????????';
COMMENT
ON COLUMN "system"."sys_role"."description" IS '??????';
COMMENT
ON COLUMN "system"."sys_role"."data_scope" IS '????????????';
COMMENT
ON COLUMN "system"."sys_role"."create_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_role"."update_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_role"."create_time" IS '????????????';
COMMENT
ON COLUMN "system"."sys_role"."update_time" IS '????????????';
COMMENT
ON TABLE "system"."sys_role" IS '?????????';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO "system"."sys_role"
VALUES (1, '???????????????', 1, '-', '??????', NULL, 'admin', '2018-11-23 11:04:37', '2020-08-06 16:10:24');

-- ----------------------------
-- Table structure for sys_roles_depts
-- ----------------------------
DROP TABLE IF EXISTS "system"."sys_roles_depts";
CREATE TABLE "system"."sys_roles_depts"
(
    "role_id" int8 NOT NULL,
    "dept_id" int8 NOT NULL
)
;
COMMENT
ON TABLE "system"."sys_roles_depts" IS '??????????????????';

-- ----------------------------
-- Records of sys_roles_depts
-- ----------------------------
INSERT INTO "system"."sys_roles_depts"
VALUES (1, 2);

-- ----------------------------
-- Table structure for sys_roles_menus
-- ----------------------------
DROP TABLE IF EXISTS "system"."sys_roles_menus";
CREATE TABLE "system"."sys_roles_menus"
(
    "menu_id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "role_id" int8 NOT NULL
)
;
COMMENT
ON COLUMN "system"."sys_roles_menus"."menu_id" IS '??????ID';
COMMENT
ON COLUMN "system"."sys_roles_menus"."role_id" IS '??????ID';
COMMENT
ON TABLE "system"."sys_roles_menus" IS '??????????????????';

-- ----------------------------
-- Records of sys_roles_menus
-- ----------------------------
INSERT INTO "system"."sys_roles_menus"
VALUES (1, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (2, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (3, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (4, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (5, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (6, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (7, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (8, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (9, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (10, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (11, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (12, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (13, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (14, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (15, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (16, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (17, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (18, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (19, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (21, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (22, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (23, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (24, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (25, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (27, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (28, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (29, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (30, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (31, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (32, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (33, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (34, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (35, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (36, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (37, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (38, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (39, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (40, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (41, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (45, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (46, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (47, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (48, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (49, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (50, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (51, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (52, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (53, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (54, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (55, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (56, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (57, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (58, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (59, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (60, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (61, 1);
INSERT INTO "system"."sys_roles_menus"
VALUES (62, 1);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "system"."sys_user";
CREATE TABLE "system"."sys_user"
(
    "user_id"        int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "dept_id"        int8,
    "username"       varchar(255) COLLATE "pg_catalog"."default",
    "nick_name"      varchar(255) COLLATE "pg_catalog"."default",
    "gender"         varchar(2) COLLATE "pg_catalog"."default",
    "phone"          varchar(255) COLLATE "pg_catalog"."default",
    "email"          varchar(255) COLLATE "pg_catalog"."default",
    "avatar_name"    varchar(255) COLLATE "pg_catalog"."default",
    "avatar_path"    varchar(255) COLLATE "pg_catalog"."default",
    "password"       varchar(255) COLLATE "pg_catalog"."default",
    "is_admin"       bool,
    "enabled"        bool,
    "create_by"      varchar(255) COLLATE "pg_catalog"."default",
    "update_by"      varchar(255) COLLATE "pg_catalog"."default",
    "pwd_reset_time" timestamp(3),
    "create_time"    timestamp(3),
    "update_time"    timestamp(3)
)
;
COMMENT
ON COLUMN "system"."sys_user"."user_id" IS 'ID';
COMMENT
ON COLUMN "system"."sys_user"."dept_id" IS '????????????';
COMMENT
ON COLUMN "system"."sys_user"."username" IS '?????????';
COMMENT
ON COLUMN "system"."sys_user"."nick_name" IS '??????';
COMMENT
ON COLUMN "system"."sys_user"."gender" IS '??????';
COMMENT
ON COLUMN "system"."sys_user"."phone" IS '????????????';
COMMENT
ON COLUMN "system"."sys_user"."email" IS '??????';
COMMENT
ON COLUMN "system"."sys_user"."avatar_name" IS '????????????';
COMMENT
ON COLUMN "system"."sys_user"."avatar_path" IS '??????????????????';
COMMENT
ON COLUMN "system"."sys_user"."password" IS '??????';
COMMENT
ON COLUMN "system"."sys_user"."is_admin" IS '?????????admin??????';
COMMENT
ON COLUMN "system"."sys_user"."enabled" IS '?????????1?????????0??????';
COMMENT
ON COLUMN "system"."sys_user"."create_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_user"."update_by" IS '?????????';
COMMENT
ON COLUMN "system"."sys_user"."pwd_reset_time" IS '?????????????????????';
COMMENT
ON COLUMN "system"."sys_user"."create_time" IS '????????????';
COMMENT
ON COLUMN "system"."sys_user"."update_time" IS '????????????';
COMMENT
ON TABLE "system"."sys_user" IS '????????????';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO "system"."sys_user"
VALUES (1, 2, 'admin', '?????????', '???', '13711998905', '201507802@qq.com', NULL, NULL,
        'e10adc3949ba59abbe56e057f20f883e',
        't', 't', NULL, 'admin', '2020-05-03 16:38:31', '2018-08-23 09:11:56', '2021-12-10 17:27:25.15');

-- ----------------------------
-- Table structure for sys_users_jobs
-- ----------------------------
DROP TABLE IF EXISTS "system"."sys_users_jobs";
CREATE TABLE "system"."sys_users_jobs"
(
    "user_id" int8 NOT NULL,
    "job_id"  int8 NOT NULL
)
;
COMMENT
ON COLUMN "system"."sys_users_jobs"."user_id" IS '??????ID';
COMMENT
ON COLUMN "system"."sys_users_jobs"."job_id" IS '??????ID';

-- ----------------------------
-- Records of sys_users_jobs
-- ----------------------------
INSERT INTO "system"."sys_users_jobs"
VALUES (1, 2);
INSERT INTO "system"."sys_users_jobs"
VALUES (3, 10);

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS "system"."sys_users_roles";
CREATE TABLE "system"."sys_users_roles"
(
    "user_id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "role_id" int8 NOT NULL
)
;
COMMENT
ON COLUMN "system"."sys_users_roles"."user_id" IS '??????ID';
COMMENT
ON COLUMN "system"."sys_users_roles"."role_id" IS '??????ID';
COMMENT
ON TABLE "system"."sys_users_roles" IS '??????????????????';

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
INSERT INTO "system"."sys_users_roles"
VALUES (1, 1);

-- ----------------------------
-- Table structure for tool_email_config
-- ----------------------------
DROP TABLE IF EXISTS "system"."tool_email_config";
CREATE TABLE "system"."tool_email_config"
(
    "id"          int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "from_user"   varchar(255) COLLATE "pg_catalog"."default",
    "host"        varchar(255) COLLATE "pg_catalog"."default",
    "pass"        varchar(255) COLLATE "pg_catalog"."default",
    "port"        varchar(255) COLLATE "pg_catalog"."default",
    "user"        varchar(255) COLLATE "pg_catalog"."default",
    "create_by"   varchar(64) COLLATE "pg_catalog"."default",
    "update_by"   varchar(64) COLLATE "pg_catalog"."default",
    "create_time" timestamp(3),
    "update_time" timestamp(3)
)
;
COMMENT
ON COLUMN "system"."tool_email_config"."id" IS '??????';
COMMENT
ON COLUMN "system"."tool_email_config"."from_user" IS '?????????';
COMMENT
ON COLUMN "system"."tool_email_config"."host" IS '???????????????SMTP??????';
COMMENT
ON COLUMN "system"."tool_email_config"."pass" IS '??????';
COMMENT
ON COLUMN "system"."tool_email_config"."port" IS '??????';
COMMENT
ON COLUMN "system"."tool_email_config"."user" IS '??????????????????';
COMMENT
ON COLUMN "system"."tool_email_config"."create_by" IS '?????????';
COMMENT
ON COLUMN "system"."tool_email_config"."update_by" IS '?????????';
COMMENT
ON COLUMN "system"."tool_email_config"."create_time" IS '????????????';
COMMENT
ON COLUMN "system"."tool_email_config"."update_time" IS '????????????';
COMMENT
ON TABLE "system"."tool_email_config" IS '????????????';

-- ----------------------------
-- Records of tool_email_config
-- ----------------------------

-- ----------------------------
-- Table structure for tool_qiniu_config
-- ----------------------------
DROP TABLE IF EXISTS "system"."tool_qiniu_config";
CREATE TABLE "system"."tool_qiniu_config"
(
    "config_id"  int8                                        NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "access_key" text COLLATE "pg_catalog"."default",
    "bucket"     varchar(255) COLLATE "pg_catalog"."default",
    "host"       varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "secret_key" text COLLATE "pg_catalog"."default",
    "type"       varchar(255) COLLATE "pg_catalog"."default",
    "zone"       varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT
ON COLUMN "system"."tool_qiniu_config"."config_id" IS 'ID';
COMMENT
ON COLUMN "system"."tool_qiniu_config"."access_key" IS 'accessKey';
COMMENT
ON COLUMN "system"."tool_qiniu_config"."bucket" IS 'Bucket ?????????';
COMMENT
ON COLUMN "system"."tool_qiniu_config"."host" IS '????????????';
COMMENT
ON COLUMN "system"."tool_qiniu_config"."secret_key" IS 'secretKey';
COMMENT
ON COLUMN "system"."tool_qiniu_config"."type" IS '????????????';
COMMENT
ON COLUMN "system"."tool_qiniu_config"."zone" IS '??????';
COMMENT
ON TABLE "system"."tool_qiniu_config" IS '???????????????';

-- ----------------------------
-- Records of tool_qiniu_config
-- ----------------------------

-- ----------------------------
-- Table structure for tool_qiniu_content
-- ----------------------------
DROP TABLE IF EXISTS "system"."tool_qiniu_content";
CREATE TABLE "system"."tool_qiniu_content"
(
    "content_id"  int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "bucket"      varchar(255) COLLATE "pg_catalog"."default",
    "name"        varchar(255) COLLATE "pg_catalog"."default",
    "size"        varchar(255) COLLATE "pg_catalog"."default",
    "type"        varchar(255) COLLATE "pg_catalog"."default",
    "url"         varchar(255) COLLATE "pg_catalog"."default",
    "suffix"      varchar(255) COLLATE "pg_catalog"."default",
    "update_time" timestamp(3)
)
;
COMMENT
ON COLUMN "system"."tool_qiniu_content"."content_id" IS 'ID';
COMMENT
ON COLUMN "system"."tool_qiniu_content"."bucket" IS 'Bucket ?????????';
COMMENT
ON COLUMN "system"."tool_qiniu_content"."name" IS '????????????';
COMMENT
ON COLUMN "system"."tool_qiniu_content"."size" IS '????????????';
COMMENT
ON COLUMN "system"."tool_qiniu_content"."type" IS '??????????????????????????????';
COMMENT
ON COLUMN "system"."tool_qiniu_content"."url" IS '??????url';
COMMENT
ON COLUMN "system"."tool_qiniu_content"."suffix" IS '????????????';
COMMENT
ON COLUMN "system"."tool_qiniu_content"."update_time" IS '????????????????????????';
COMMENT
ON TABLE "system"."tool_qiniu_content" IS '?????????????????????';

-- ----------------------------
-- Records of tool_qiniu_content
-- ----------------------------

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_config_id_seq"
    OWNED BY "system"."sys_config"."id";
SELECT setval('"system"."sys_config_id_seq"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_config_id_seq1"
    OWNED BY "system"."sys_config"."id";
SELECT setval('"system"."sys_config_id_seq1"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_dept_dept_id_seq"
    OWNED BY "system"."sys_dept"."dept_id";
SELECT setval('"system"."sys_dept_dept_id_seq"', 35, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_dept_dept_id_seq1"
    OWNED BY "system"."sys_dept"."dept_id";
SELECT setval('"system"."sys_dept_dept_id_seq1"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_dict_detail_detail_id_seq"
    OWNED BY "system"."sys_dict_detail"."detail_id";
SELECT setval('"system"."sys_dict_detail_detail_id_seq"', 69, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_dict_detail_detail_id_seq1"
    OWNED BY "system"."sys_dict_detail"."detail_id";
SELECT setval('"system"."sys_dict_detail_detail_id_seq1"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_dict_dict_id_seq"
    OWNED BY "system"."sys_dict"."dict_id";
SELECT setval('"system"."sys_dict_dict_id_seq"', 45, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_dict_dict_id_seq1"
    OWNED BY "system"."sys_dict"."dict_id";
SELECT setval('"system"."sys_dict_dict_id_seq1"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_job_job_id_seq"
    OWNED BY "system"."sys_job"."job_id";
SELECT setval('"system"."sys_job_job_id_seq"', 43, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_job_job_id_seq1"
    OWNED BY "system"."sys_job"."job_id";
SELECT setval('"system"."sys_job_job_id_seq1"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_log_log_id_seq"
    OWNED BY "system"."sys_log"."log_id";
SELECT setval('"system"."sys_log_log_id_seq"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_log_log_id_seq1"
    OWNED BY "system"."sys_log"."log_id";
SELECT setval('"system"."sys_log_log_id_seq1"', 11, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_menu_menu_id_seq"
    OWNED BY "system"."sys_menu"."menu_id";
SELECT setval('"system"."sys_menu_menu_id_seq"', 93, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_menu_menu_id_seq1"
    OWNED BY "system"."sys_menu"."menu_id";
SELECT setval('"system"."sys_menu_menu_id_seq1"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_role_role_id_seq"
    OWNED BY "system"."sys_role"."role_id";
SELECT setval('"system"."sys_role_role_id_seq"', 40, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_role_role_id_seq1"
    OWNED BY "system"."sys_role"."role_id";
SELECT setval('"system"."sys_role_role_id_seq1"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_roles_menus_menu_id_seq"
    OWNED BY "system"."sys_roles_menus"."menu_id";
SELECT setval('"system"."sys_roles_menus_menu_id_seq"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_roles_menus_menu_id_seq1"
    OWNED BY "system"."sys_roles_menus"."menu_id";
SELECT setval('"system"."sys_roles_menus_menu_id_seq1"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_user_user_id_seq"
    OWNED BY "system"."sys_user"."user_id";
SELECT setval('"system"."sys_user_user_id_seq"', 55, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_user_user_id_seq1"
    OWNED BY "system"."sys_user"."user_id";
SELECT setval('"system"."sys_user_user_id_seq1"', 3, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_users_roles_user_id_seq"
    OWNED BY "system"."sys_users_roles"."user_id";
SELECT setval('"system"."sys_users_roles_user_id_seq"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."sys_users_roles_user_id_seq1"
    OWNED BY "system"."sys_users_roles"."user_id";
SELECT setval('"system"."sys_users_roles_user_id_seq1"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."tool_email_config_id_seq"
    OWNED BY "system"."tool_email_config"."id";
SELECT setval('"system"."tool_email_config_id_seq"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."tool_email_config_id_seq1"
    OWNED BY "system"."tool_email_config"."id";
SELECT setval('"system"."tool_email_config_id_seq1"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."tool_qiniu_config_config_id_seq"
    OWNED BY "system"."tool_qiniu_config"."config_id";
SELECT setval('"system"."tool_qiniu_config_config_id_seq"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."tool_qiniu_config_config_id_seq1"
    OWNED BY "system"."tool_qiniu_config"."config_id";
SELECT setval('"system"."tool_qiniu_config_config_id_seq1"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."tool_qiniu_content_content_id_seq"
    OWNED BY "system"."tool_qiniu_content"."content_id";
SELECT setval('"system"."tool_qiniu_content_content_id_seq"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "system"."tool_qiniu_content_content_id_seq1"
    OWNED BY "system"."tool_qiniu_content"."content_id";
SELECT setval('"system"."tool_qiniu_content_content_id_seq1"', 2, false);

-- ----------------------------
-- Primary Key structure for table sys_config
-- ----------------------------
ALTER TABLE "system"."sys_config"
    ADD CONSTRAINT "sys_config_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_dept
-- ----------------------------
ALTER TABLE "system"."sys_dept"
    ADD CONSTRAINT "sys_dept_pkey" PRIMARY KEY ("dept_id");

-- ----------------------------
-- Primary Key structure for table sys_dict
-- ----------------------------
ALTER TABLE "system"."sys_dict"
    ADD CONSTRAINT "sys_dict_pkey" PRIMARY KEY ("dict_id");

-- ----------------------------
-- Primary Key structure for table sys_dict_detail
-- ----------------------------
ALTER TABLE "system"."sys_dict_detail"
    ADD CONSTRAINT "sys_dict_detail_pkey" PRIMARY KEY ("detail_id");

-- ----------------------------
-- Primary Key structure for table sys_job
-- ----------------------------
ALTER TABLE "system"."sys_job"
    ADD CONSTRAINT "sys_job_pkey" PRIMARY KEY ("job_id");

-- ----------------------------
-- Primary Key structure for table sys_log
-- ----------------------------
ALTER TABLE "system"."sys_log"
    ADD CONSTRAINT "sys_log_pkey" PRIMARY KEY ("log_id");

-- ----------------------------
-- Primary Key structure for table sys_menu
-- ----------------------------
ALTER TABLE "system"."sys_menu"
    ADD CONSTRAINT "sys_menu_pkey" PRIMARY KEY ("menu_id");

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE "system"."sys_role"
    ADD CONSTRAINT "sys_role_pkey" PRIMARY KEY ("role_id");

-- ----------------------------
-- Primary Key structure for table sys_roles_depts
-- ----------------------------
ALTER TABLE "system"."sys_roles_depts"
    ADD CONSTRAINT "sys_roles_depts_pkey" PRIMARY KEY ("role_id", "dept_id");

-- ----------------------------
-- Primary Key structure for table sys_roles_menus
-- ----------------------------
ALTER TABLE "system"."sys_roles_menus"
    ADD CONSTRAINT "sys_roles_menus_pkey" PRIMARY KEY ("menu_id", "role_id");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "system"."sys_user"
    ADD CONSTRAINT "sys_user_pkey" PRIMARY KEY ("user_id");

-- ----------------------------
-- Primary Key structure for table sys_users_jobs
-- ----------------------------
ALTER TABLE "system"."sys_users_jobs"
    ADD CONSTRAINT "sys_users_jobs_pkey" PRIMARY KEY ("user_id", "job_id");

-- ----------------------------
-- Primary Key structure for table sys_users_roles
-- ----------------------------
ALTER TABLE "system"."sys_users_roles"
    ADD CONSTRAINT "sys_users_roles_pkey" PRIMARY KEY ("user_id", "role_id");

-- ----------------------------
-- Primary Key structure for table tool_email_config
-- ----------------------------
ALTER TABLE "system"."tool_email_config"
    ADD CONSTRAINT "tool_email_config_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tool_qiniu_config
-- ----------------------------
ALTER TABLE "system"."tool_qiniu_config"
    ADD CONSTRAINT "tool_qiniu_config_pkey" PRIMARY KEY ("config_id");

-- ----------------------------
-- Indexes structure for table tool_qiniu_content
-- ----------------------------
CREATE INDEX "uniq_name" ON "system"."tool_qiniu_content" USING btree (
    "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table tool_qiniu_content
-- ----------------------------
ALTER TABLE "system"."tool_qiniu_content"
    ADD CONSTRAINT "tool_qiniu_content_pkey" PRIMARY KEY ("content_id");
