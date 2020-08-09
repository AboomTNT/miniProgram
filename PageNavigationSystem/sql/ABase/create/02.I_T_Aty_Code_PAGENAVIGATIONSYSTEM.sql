-- auto create by SMD
set misopt_preventing = off;
set client_encoding = UTF8;
set search_path to db_aty;
commit;

truncate table T_Aty_Code;
commit;

insert into T_Aty_Code (C_PID, C_Code, C_Name, N_KWH, C_LevelInfo, N_Valid, N_Order, C_Dmjp ) values ('10001'                            ,'0'                                ,'dev'                              ,1         ,NULL,1         ,1         ,NULL);

insert into T_Aty_Code (C_PID, C_Code, C_Name, N_KWH, C_LevelInfo, N_Valid, N_Order, C_Dmjp ) values ('10001'                            ,'1'                                ,'feature'                          ,1         ,NULL,1         ,2         ,NULL);

insert into T_Aty_Code (C_PID, C_Code, C_Name, N_KWH, C_LevelInfo, N_Valid, N_Order, C_Dmjp ) values ('10001'                            ,'2'                                ,'release'                          ,1         ,NULL,1         ,3         ,NULL);

insert into T_Aty_Code (C_PID, C_Code, C_Name, N_KWH, C_LevelInfo, N_Valid, N_Order, C_Dmjp ) values ('10002'                            ,'0'                                ,'北京'                               ,1         ,NULL,1         ,1         ,NULL);

insert into T_Aty_Code (C_PID, C_Code, C_Name, N_KWH, C_LevelInfo, N_Valid, N_Order, C_Dmjp ) values ('10002'                            ,'1'                                ,'广州'                               ,1         ,NULL,1         ,2         ,NULL);

insert into T_Aty_Code (C_PID, C_Code, C_Name, N_KWH, C_LevelInfo, N_Valid, N_Order, C_Dmjp ) values ('10002'                            ,'2'                                ,'成都'                               ,1         ,NULL,1         ,3         ,NULL);

insert into T_Aty_Code (C_PID, C_Code, C_Name, N_KWH, C_LevelInfo, N_Valid, N_Order, C_Dmjp ) values ('10002'                            ,'3'                                ,'南京'                               ,1         ,NULL,1         ,4         ,NULL);



