package com.icbc.restfulservice.service;

import com.icbc.restfulservice.dao.FileUploadLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadLogService {
    @Autowired
    private FileUploadLogDao fileUploadLogDao;

    public void doLog(String aduser,String ipaddress,String filecontext,String randomcode){
        fileUploadLogDao.doFileUploadLog(aduser,ipaddress,filecontext,System.currentTimeMillis(),randomcode);
    }
}
