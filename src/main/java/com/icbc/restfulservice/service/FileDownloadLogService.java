package com.icbc.restfulservice.service;

import com.icbc.restfulservice.dao.FileDownloadLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileDownloadLogService {
    @Autowired
    private FileDownloadLogDao fileDownloadLogDao;

    public void doLog(String aduser,String ipaddress,String filename){
        fileDownloadLogDao.doFileDownloadLog(aduser,ipaddress,filename,System.currentTimeMillis());
    }

}
