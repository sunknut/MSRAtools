package com.icbc.restfulservice.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Mapper
@Repository
public interface FileDownloadLogDao {

    @Insert("INSERT INTO file_download_log(aduser,ipaddress,time,dl_file_name) VALUES(#{aduser},#{ipaddress},#{time},#{dlFileName})")
    void doFileDownloadLog(@Param("aduser") String aduser,@Param("ipaddress") String ipaddress,@Param("dlFileName") String dlFilename,@Param("time") long time);
}
