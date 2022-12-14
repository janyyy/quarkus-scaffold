/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 130007
 Source Host           : localhost:5432
 Source Catalog        : xxl-job
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130007
 File Encoding         : 65001

 Date: 22/06/2022 16:45:17
*/


-- ----------------------------
-- Sequence structure for xxl_job_group_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_group_id_seq";
CREATE SEQUENCE "public"."xxl_job_group_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_group_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_group_id_seq1";
CREATE SEQUENCE "public"."xxl_job_group_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_group_id_seq2
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_group_id_seq2";
CREATE SEQUENCE "public"."xxl_job_group_id_seq2"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_group_id_seq3
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_group_id_seq3";
CREATE SEQUENCE "public"."xxl_job_group_id_seq3"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_info_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_info_id_seq";
CREATE SEQUENCE "public"."xxl_job_info_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_info_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_info_id_seq1";
CREATE SEQUENCE "public"."xxl_job_info_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_info_id_seq2
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_info_id_seq2";
CREATE SEQUENCE "public"."xxl_job_info_id_seq2"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_info_id_seq3
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_info_id_seq3";
CREATE SEQUENCE "public"."xxl_job_info_id_seq3"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_log_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_log_id_seq";
CREATE SEQUENCE "public"."xxl_job_log_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_log_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_log_id_seq1";
CREATE SEQUENCE "public"."xxl_job_log_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_log_id_seq2
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_log_id_seq2";
CREATE SEQUENCE "public"."xxl_job_log_id_seq2"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_log_id_seq3
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_log_id_seq3";
CREATE SEQUENCE "public"."xxl_job_log_id_seq3"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_log_report_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_log_report_id_seq";
CREATE SEQUENCE "public"."xxl_job_log_report_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_log_report_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_log_report_id_seq1";
CREATE SEQUENCE "public"."xxl_job_log_report_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_log_report_id_seq2
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_log_report_id_seq2";
CREATE SEQUENCE "public"."xxl_job_log_report_id_seq2"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_log_report_id_seq3
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_log_report_id_seq3";
CREATE SEQUENCE "public"."xxl_job_log_report_id_seq3"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_logglue_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_logglue_id_seq";
CREATE SEQUENCE "public"."xxl_job_logglue_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_logglue_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_logglue_id_seq1";
CREATE SEQUENCE "public"."xxl_job_logglue_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_logglue_id_seq2
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_logglue_id_seq2";
CREATE SEQUENCE "public"."xxl_job_logglue_id_seq2"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_logglue_id_seq3
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_logglue_id_seq3";
CREATE SEQUENCE "public"."xxl_job_logglue_id_seq3"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_qrtz_trigger_group_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_qrtz_trigger_group_id_seq";
CREATE SEQUENCE "public"."xxl_job_qrtz_trigger_group_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_qrtz_trigger_info_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_qrtz_trigger_info_id_seq";
CREATE SEQUENCE "public"."xxl_job_qrtz_trigger_info_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_qrtz_trigger_log_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_qrtz_trigger_log_id_seq";
CREATE SEQUENCE "public"."xxl_job_qrtz_trigger_log_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_registry_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_registry_id_seq";
CREATE SEQUENCE "public"."xxl_job_registry_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_registry_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_registry_id_seq1";
CREATE SEQUENCE "public"."xxl_job_registry_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_registry_id_seq2
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_registry_id_seq2";
CREATE SEQUENCE "public"."xxl_job_registry_id_seq2"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_registry_id_seq3
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_registry_id_seq3";
CREATE SEQUENCE "public"."xxl_job_registry_id_seq3"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_user_id_seq";
CREATE SEQUENCE "public"."xxl_job_user_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_user_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_user_id_seq1";
CREATE SEQUENCE "public"."xxl_job_user_id_seq1"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_user_id_seq2
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_user_id_seq2";
CREATE SEQUENCE "public"."xxl_job_user_id_seq2"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for xxl_job_user_id_seq3
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."xxl_job_user_id_seq3";
CREATE SEQUENCE "public"."xxl_job_user_id_seq3"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Table structure for xxl_job_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_group";
CREATE TABLE "public"."xxl_job_group"
(
    "id"           int4                                       NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
),
    "app_name"     varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
    "title"        varchar(12) COLLATE "pg_catalog"."default" NOT NULL,
    "address_type" int2                                       NOT NULL,
    "address_list" text COLLATE "pg_catalog"."default",
    "update_time"  timestamp(6)
)
;
COMMENT
ON COLUMN "public"."xxl_job_group"."app_name" IS '?????????AppName';
COMMENT
ON COLUMN "public"."xxl_job_group"."title" IS '???????????????';
COMMENT
ON COLUMN "public"."xxl_job_group"."address_type" IS '????????????????????????0=???????????????1=????????????';
COMMENT
ON COLUMN "public"."xxl_job_group"."address_list" IS '?????????????????????????????????????????????';

-- ----------------------------
-- Records of xxl_job_group
-- ----------------------------
INSERT INTO "public"."xxl_job_group"
VALUES (1, 'janyyyy-job-executor', 'janyyyy-job', 0, 'http://172.20.119.173:9999/', '2022-06-22 16:42:47.23');

-- ----------------------------
-- Table structure for xxl_job_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_info";
CREATE TABLE "public"."xxl_job_info"
(
    "id"                        int4                                        NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
),
    "job_group"                 int4                                        NOT NULL,
    "job_desc"                  varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "add_time"                  timestamp(6),
    "update_time"               timestamp(6),
    "author"                    varchar(64) COLLATE "pg_catalog"."default",
    "alarm_email"               varchar(255) COLLATE "pg_catalog"."default",
    "schedule_type"             varchar(50) COLLATE "pg_catalog"."default"  NOT NULL,
    "schedule_conf"             varchar(128) COLLATE "pg_catalog"."default",
    "misfire_strategy"          varchar(50) COLLATE "pg_catalog"."default"  NOT NULL,
    "executor_route_strategy"   varchar(50) COLLATE "pg_catalog"."default",
    "executor_handler"          varchar(255) COLLATE "pg_catalog"."default",
    "executor_param"            varchar(512) COLLATE "pg_catalog"."default",
    "executor_block_strategy"   varchar(50) COLLATE "pg_catalog"."default",
    "executor_timeout"          int4                                        NOT NULL,
    "executor_fail_retry_count" int4                                        NOT NULL,
    "glue_type"                 varchar(50) COLLATE "pg_catalog"."default"  NOT NULL,
    "glue_source"               text COLLATE "pg_catalog"."default",
    "glue_remark"               varchar(128) COLLATE "pg_catalog"."default",
    "glue_updatetime"           timestamp(6),
    "child_jobid"               varchar(255) COLLATE "pg_catalog"."default",
    "trigger_status"            int2                                        NOT NULL,
    "trigger_last_time"         int8                                        NOT NULL,
    "trigger_next_time"         int8                                        NOT NULL
)
;
COMMENT
ON COLUMN "public"."xxl_job_info"."job_group" IS '???????????????ID';
COMMENT
ON COLUMN "public"."xxl_job_info"."author" IS '??????';
COMMENT
ON COLUMN "public"."xxl_job_info"."alarm_email" IS '????????????';
COMMENT
ON COLUMN "public"."xxl_job_info"."schedule_type" IS '????????????';
COMMENT
ON COLUMN "public"."xxl_job_info"."schedule_conf" IS '?????????????????????????????????????????????';
COMMENT
ON COLUMN "public"."xxl_job_info"."misfire_strategy" IS '??????????????????';
COMMENT
ON COLUMN "public"."xxl_job_info"."executor_route_strategy" IS '?????????????????????';
COMMENT
ON COLUMN "public"."xxl_job_info"."executor_handler" IS '???????????????handler';
COMMENT
ON COLUMN "public"."xxl_job_info"."executor_param" IS '?????????????????????';
COMMENT
ON COLUMN "public"."xxl_job_info"."executor_block_strategy" IS '??????????????????';
COMMENT
ON COLUMN "public"."xxl_job_info"."executor_timeout" IS '????????????????????????????????????';
COMMENT
ON COLUMN "public"."xxl_job_info"."executor_fail_retry_count" IS '??????????????????';
COMMENT
ON COLUMN "public"."xxl_job_info"."glue_type" IS 'GLUE??????';
COMMENT
ON COLUMN "public"."xxl_job_info"."glue_source" IS 'GLUE?????????';
COMMENT
ON COLUMN "public"."xxl_job_info"."glue_remark" IS 'GLUE??????';
COMMENT
ON COLUMN "public"."xxl_job_info"."glue_updatetime" IS 'GLUE????????????';
COMMENT
ON COLUMN "public"."xxl_job_info"."child_jobid" IS '?????????ID?????????????????????';
COMMENT
ON COLUMN "public"."xxl_job_info"."trigger_status" IS '???????????????0-?????????1-??????';
COMMENT
ON COLUMN "public"."xxl_job_info"."trigger_last_time" IS '??????????????????';
COMMENT
ON COLUMN "public"."xxl_job_info"."trigger_next_time" IS '??????????????????';

-- ----------------------------
-- Records of xxl_job_info
-- ----------------------------
INSERT INTO "public"."xxl_job_info"
VALUES (1, 1, '??????????????????', '2018-11-03 22:21:31', '2022-06-07 16:14:31.22', 'Jan',
        '597907730@qq.com,jan@sengiexpress.com,DAVID@SENGIEXPRESS.COM,itdepartment@sengi.cn', 'CRON', '0 0 0 * * ?',
        'DO_NOTHING', 'FAILOVER', 'deleteParcelReceiveTaskInfoJobHandler', '-1', 'SERIAL_EXECUTION', 0, 3, 'BEAN', '',
        'GLUE???????????????', '2018-11-03 22:21:31', '', 1, 1655827200000, 1655913600000);

-- ----------------------------
-- Table structure for xxl_job_lock
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_lock";
CREATE TABLE "public"."xxl_job_lock"
(
    "lock_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL
)
;
COMMENT
ON COLUMN "public"."xxl_job_lock"."lock_name" IS '?????????';

-- ----------------------------
-- Records of xxl_job_lock
-- ----------------------------
INSERT INTO "public"."xxl_job_lock"
VALUES ('schedule_lock');

-- ----------------------------
-- Table structure for xxl_job_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_log";
CREATE TABLE "public"."xxl_job_log"
(
    "id"                        int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
    "job_group"                 int4 NOT NULL,
    "job_id"                    int4 NOT NULL,
    "executor_address"          varchar(255) COLLATE "pg_catalog"."default",
    "executor_handler"          varchar(255) COLLATE "pg_catalog"."default",
    "executor_param"            varchar(512) COLLATE "pg_catalog"."default",
    "executor_sharding_param"   varchar(20) COLLATE "pg_catalog"."default",
    "executor_fail_retry_count" int4 NOT NULL DEFAULT 0,
    "trigger_time"              timestamp(6),
    "trigger_code"              int4 NOT NULL,
    "trigger_msg"               text COLLATE "pg_catalog"."default",
    "handle_time"               timestamp(6),
    "handle_code"               int4 NOT NULL,
    "handle_msg"                text COLLATE "pg_catalog"."default",
    "alarm_status"              int2 NOT NULL DEFAULT 0
)
;
COMMENT
ON COLUMN "public"."xxl_job_log"."job_group" IS '???????????????ID';
COMMENT
ON COLUMN "public"."xxl_job_log"."job_id" IS '???????????????ID';
COMMENT
ON COLUMN "public"."xxl_job_log"."executor_address" IS '???????????????????????????????????????';
COMMENT
ON COLUMN "public"."xxl_job_log"."executor_handler" IS '???????????????handler';
COMMENT
ON COLUMN "public"."xxl_job_log"."executor_param" IS '?????????????????????';
COMMENT
ON COLUMN "public"."xxl_job_log"."executor_sharding_param" IS '??????????????????????????????????????? 1/2';
COMMENT
ON COLUMN "public"."xxl_job_log"."executor_fail_retry_count" IS '??????????????????';
COMMENT
ON COLUMN "public"."xxl_job_log"."trigger_time" IS '??????-??????';
COMMENT
ON COLUMN "public"."xxl_job_log"."trigger_code" IS '??????-??????';
COMMENT
ON COLUMN "public"."xxl_job_log"."trigger_msg" IS '??????-??????';
COMMENT
ON COLUMN "public"."xxl_job_log"."handle_time" IS '??????-??????';
COMMENT
ON COLUMN "public"."xxl_job_log"."handle_code" IS '??????-??????';
COMMENT
ON COLUMN "public"."xxl_job_log"."handle_msg" IS '??????-??????';
COMMENT
ON COLUMN "public"."xxl_job_log"."alarm_status" IS '???????????????0-?????????1-???????????????2-???????????????3-????????????';

-- ----------------------------
-- Records of xxl_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for xxl_job_log_report
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_log_report";
CREATE TABLE "public"."xxl_job_log_report"
(
    "id"            int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
),
    "trigger_day"   timestamp(6),
    "running_count" int4 NOT NULL,
    "suc_count"     int4 NOT NULL,
    "fail_count"    int4 NOT NULL,
    "update_time"   timestamp(6)
)
;
COMMENT
ON COLUMN "public"."xxl_job_log_report"."trigger_day" IS '??????-??????';
COMMENT
ON COLUMN "public"."xxl_job_log_report"."running_count" IS '?????????-????????????';
COMMENT
ON COLUMN "public"."xxl_job_log_report"."suc_count" IS '????????????-????????????';
COMMENT
ON COLUMN "public"."xxl_job_log_report"."fail_count" IS '????????????-????????????';

-- ----------------------------
-- Records of xxl_job_log_report
-- ----------------------------

-- ----------------------------
-- Table structure for xxl_job_logglue
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_logglue";
CREATE TABLE "public"."xxl_job_logglue"
(
    "id"          int4                                        NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
),
    "job_id"      int4                                        NOT NULL,
    "glue_type"   varchar(50) COLLATE "pg_catalog"."default",
    "glue_source" text COLLATE "pg_catalog"."default",
    "glue_remark" varchar(128) COLLATE "pg_catalog"."default" NOT NULL,
    "add_time"    timestamp(6),
    "update_time" timestamp(6)
)
;
COMMENT
ON COLUMN "public"."xxl_job_logglue"."job_id" IS '???????????????ID';
COMMENT
ON COLUMN "public"."xxl_job_logglue"."glue_type" IS 'GLUE??????';
COMMENT
ON COLUMN "public"."xxl_job_logglue"."glue_source" IS 'GLUE?????????';
COMMENT
ON COLUMN "public"."xxl_job_logglue"."glue_remark" IS 'GLUE??????';

-- ----------------------------
-- Records of xxl_job_logglue
-- ----------------------------

-- ----------------------------
-- Table structure for xxl_job_registry
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_registry";
CREATE TABLE "public"."xxl_job_registry"
(
    "id"             int4                                        NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
),
    "registry_group" varchar(50) COLLATE "pg_catalog"."default"  NOT NULL,
    "registry_key"   varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "registry_value" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "update_time"    timestamp(6)
)
;

-- ----------------------------
-- Records of xxl_job_registry
-- ----------------------------

-- ----------------------------
-- Table structure for xxl_job_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."xxl_job_user";
CREATE TABLE "public"."xxl_job_user"
(
    "id"         int4                                       NOT NULL GENERATED BY DEFAULT AS IDENTITY (
        INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
),
    "username"   varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
    "password"   varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
    "role"       int2                                       NOT NULL,
    "permission" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT
ON COLUMN "public"."xxl_job_user"."username" IS '??????';
COMMENT
ON COLUMN "public"."xxl_job_user"."password" IS '??????';
COMMENT
ON COLUMN "public"."xxl_job_user"."role" IS '?????????0-???????????????1-?????????';
COMMENT
ON COLUMN "public"."xxl_job_user"."permission" IS '??????????????????ID???????????????????????????';

-- ----------------------------
-- Records of xxl_job_user
-- ----------------------------
INSERT INTO "public"."xxl_job_user"
VALUES (1, 'admin', '31f85f90027df519c6c66903465a8c8f', 1, NULL);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."xxl_job_group_id_seq"', 4, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_group_id_seq1"
    OWNED BY "public"."xxl_job_group"."id";
SELECT setval('"public"."xxl_job_group_id_seq1"', 4, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_group_id_seq2"
    OWNED BY "public"."xxl_job_group"."id";
SELECT setval('"public"."xxl_job_group_id_seq2"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_group_id_seq3"
    OWNED BY "public"."xxl_job_group"."id";
SELECT setval('"public"."xxl_job_group_id_seq3"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."xxl_job_info_id_seq"', 4, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_info_id_seq1"
    OWNED BY "public"."xxl_job_info"."id";
SELECT setval('"public"."xxl_job_info_id_seq1"', 4, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_info_id_seq2"
    OWNED BY "public"."xxl_job_info"."id";
SELECT setval('"public"."xxl_job_info_id_seq2"', 39, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_info_id_seq3"
    OWNED BY "public"."xxl_job_info"."id";
SELECT setval('"public"."xxl_job_info_id_seq3"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."xxl_job_log_id_seq"', 4, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_log_id_seq1"
    OWNED BY "public"."xxl_job_log"."id";
SELECT setval('"public"."xxl_job_log_id_seq1"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_log_id_seq2"
    OWNED BY "public"."xxl_job_log"."id";
SELECT setval('"public"."xxl_job_log_id_seq2"', 396, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_log_id_seq3"
    OWNED BY "public"."xxl_job_log"."id";
SELECT setval('"public"."xxl_job_log_id_seq3"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."xxl_job_log_report_id_seq"', 4, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_log_report_id_seq1"
    OWNED BY "public"."xxl_job_log_report"."id";
SELECT setval('"public"."xxl_job_log_report_id_seq1"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_log_report_id_seq2"
    OWNED BY "public"."xxl_job_log_report"."id";
SELECT setval('"public"."xxl_job_log_report_id_seq2"', 224, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_log_report_id_seq3"
    OWNED BY "public"."xxl_job_log_report"."id";
SELECT setval('"public"."xxl_job_log_report_id_seq3"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."xxl_job_logglue_id_seq"', 4, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_logglue_id_seq1"
    OWNED BY "public"."xxl_job_logglue"."id";
SELECT setval('"public"."xxl_job_logglue_id_seq1"', 4, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_logglue_id_seq2"
    OWNED BY "public"."xxl_job_logglue"."id";
SELECT setval('"public"."xxl_job_logglue_id_seq2"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_logglue_id_seq3"
    OWNED BY "public"."xxl_job_logglue"."id";
SELECT setval('"public"."xxl_job_logglue_id_seq3"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."xxl_job_qrtz_trigger_group_id_seq"', 4, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."xxl_job_qrtz_trigger_info_id_seq"', 4, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."xxl_job_qrtz_trigger_log_id_seq"', 4, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."xxl_job_registry_id_seq"', 4, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_registry_id_seq1"
    OWNED BY "public"."xxl_job_registry"."id";
SELECT setval('"public"."xxl_job_registry_id_seq1"', 4, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_registry_id_seq2"
    OWNED BY "public"."xxl_job_registry"."id";
SELECT setval('"public"."xxl_job_registry_id_seq2"', 123, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_registry_id_seq3"
    OWNED BY "public"."xxl_job_registry"."id";
SELECT setval('"public"."xxl_job_registry_id_seq3"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."xxl_job_user_id_seq"', 4, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_user_id_seq1"
    OWNED BY "public"."xxl_job_user"."id";
SELECT setval('"public"."xxl_job_user_id_seq1"', 5, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_user_id_seq2"
    OWNED BY "public"."xxl_job_user"."id";
SELECT setval('"public"."xxl_job_user_id_seq2"', 3, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."xxl_job_user_id_seq3"
    OWNED BY "public"."xxl_job_user"."id";
SELECT setval('"public"."xxl_job_user_id_seq3"', 2, false);

-- ----------------------------
-- Primary Key structure for table xxl_job_group
-- ----------------------------
ALTER TABLE "public"."xxl_job_group"
    ADD CONSTRAINT "xxl_job_group_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table xxl_job_info
-- ----------------------------
ALTER TABLE "public"."xxl_job_info"
    ADD CONSTRAINT "xxl_job_info_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table xxl_job_lock
-- ----------------------------
ALTER TABLE "public"."xxl_job_lock"
    ADD CONSTRAINT "xxl_job_lock_pkey" PRIMARY KEY ("lock_name");

-- ----------------------------
-- Indexes structure for table xxl_job_log
-- ----------------------------
CREATE INDEX "I_handle_code" ON "public"."xxl_job_log" USING btree (
    "handle_code" "pg_catalog"."int4_ops" ASC NULLS LAST
    );
CREATE INDEX "I_trigger_time" ON "public"."xxl_job_log" USING btree (
    "trigger_time" "pg_catalog"."timestamp_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table xxl_job_log
-- ----------------------------
ALTER TABLE "public"."xxl_job_log"
    ADD CONSTRAINT "xxl_job_log_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table xxl_job_log_report
-- ----------------------------
CREATE INDEX "i_trigger_day" ON "public"."xxl_job_log_report" USING btree (
    "trigger_day" "pg_catalog"."timestamp_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table xxl_job_log_report
-- ----------------------------
ALTER TABLE "public"."xxl_job_log_report"
    ADD CONSTRAINT "xxl_job_log_report_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table xxl_job_logglue
-- ----------------------------
ALTER TABLE "public"."xxl_job_logglue"
    ADD CONSTRAINT "xxl_job_logglue_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table xxl_job_registry
-- ----------------------------
CREATE INDEX "i_g_k_v" ON "public"."xxl_job_registry" USING btree (
    "registry_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
    "registry_key" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
    "registry_value" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table xxl_job_registry
-- ----------------------------
ALTER TABLE "public"."xxl_job_registry"
    ADD CONSTRAINT "xxl_job_registry_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table xxl_job_user
-- ----------------------------
CREATE INDEX "i_username" ON "public"."xxl_job_user" USING btree (
    "username" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table xxl_job_user
-- ----------------------------
ALTER TABLE "public"."xxl_job_user"
    ADD CONSTRAINT "xxl_job_user_pkey" PRIMARY KEY ("id");
