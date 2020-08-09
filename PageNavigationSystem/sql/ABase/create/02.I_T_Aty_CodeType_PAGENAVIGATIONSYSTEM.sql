-- auto create by SMD
set misopt_preventing = off;
set client_encoding = UTF8;
set search_path to db_aty;
commit;

truncate table T_Aty_CodeType;
commit;

insert into T_Aty_CodeType (C_ID, C_Name, N_Valid, N_SFKWH ) values ('10001'                            ,'环境标识'                             ,1         ,1         );

insert into T_Aty_CodeType (C_ID, C_Name, N_Valid, N_SFKWH ) values ('10002'                            ,'所属地区'                             ,1         ,1         );



