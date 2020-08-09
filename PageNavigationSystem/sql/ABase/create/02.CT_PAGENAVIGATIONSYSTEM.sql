-- auto create by SMD
set misopt_preventing = off;
set client_encoding = UTF8;
set search_path to DB_YW;
commit;

-------------------------
-- 文章表
-------------------------

drop table if exists T_LJXX;
create table T_LJXX
(
    C_BH                  char(32)                             NOT NULL,    -- 主键
    C_XTMC                varchar(300)                         NULL,        -- 系统名称
    C_XTDZ                varchar(300)                         NULL,        -- 系统地址
    C_XTSM                varchar(300)                         NULL,        -- 系统说明
    N_HJBS                int                                  NULL,        -- 环境标识
    N_SSDQ                int                                  NULL,        -- 所属地区
    N_ZHXGFS              int                                  NULL,        -- 最后修改方式
    C_CJR                 varchar(300)                         NULL,        -- 创建人
    C_ZHXGR               varchar(300)                         NULL,        -- 最后修改人
    DT_CJSJ               timestamp(3)                         NULL,        -- 创建时间
    DT_ZHXGSJ             timestamp(3)                         NULL,        -- 最后修改时间
constraint PK_LJXX primary key( C_BH )
);

 commit; 

