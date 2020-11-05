package com.icbc.restfulservice.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Mapper
@Repository
public interface FileUploadLogDao {
    @Insert("INSERT INTO file_upload_log(aduser,ipaddress,time,file_context,randomcode) VALUES(#{aduser},#{ipaddress},#{time},#{filecontext},#{randomcode})")
    void doFileUploadLog(@Param("aduser") String aduser, @Param("ipaddress") String ipaddress, @Param("filecontext") String filecontext, @Param("time") long time,@Param("randomcode")String randomcode);
}
