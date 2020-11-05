package com.icbc.restfulservice.controller;

import com.icbc.restfulservice.bean.IDFileList;
import com.icbc.restfulservice.bean.MsraId;
import com.icbc.restfulservice.service.FileDownloadLogService;
import com.icbc.restfulservice.service.FileUploadLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;


@RestController
@RequestMapping("/msra")
@CrossOrigin
public class GetFileController {
    @Autowired
    IDFileList idFileList;
    @Autowired
    FileUploadLogService fileUploadLogService;
    @Autowired
    FileDownloadLogService fileDownloadLogService;


    @GetMapping(path = "/downloadid")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(@RequestParam (value = "hostname")String hostname,HttpServletRequest request){
        String ip = request.getRemoteAddr();
        MsraId msraId = new MsraId();
        String txt;
        MsraId idfile = IDFileList.getIdFileByHostname(hostname);
        if (idfile !=null){
            msraId.setAdUser(idfile.getAdUser());
            msraId.setXmlContext(idfile.getXmlContext());
            msraId.setHostname(idfile.getHostname());
            msraId.setPassword(idfile.getPassword());
            msraId.setTimeStamp(idfile.getTimeStamp());
            IDFileList.removeIdFileFromList(idfile);
            txt = msraId.getXmlContext();
            try{
                fileDownloadLogService.doLog(msraId.getAdUser(),ip,msraId.getHostname()+msraId.getAdUser());
            }catch (Exception e){
                e.printStackTrace();
            }
            HttpHeaders headers=new HttpHeaders();
            headers.add("Content-Disposition","attachment;filename=" + msraId.getHostname()+"_"+msraId.getAdUser()+".msrcIncident");
            headers.add ( "Cache-Control","no-cache,no-store,must-revalidate" );
            headers.add ( "Pragma","no-cache" );
            headers.add ( "Expires","0" );
            ResponseEntity<byte[]> response=new ResponseEntity(txt.getBytes(StandardCharsets.UTF_8),headers,HttpStatus.OK);
            return response;
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(path = "/getFileList",produces = "application/json")
    public ResponseEntity getFileList(){
        return new ResponseEntity(idFileList.getResultList(), HttpStatus.OK);
    }


    @PostMapping(path = "/uploadmsra",consumes = "application/x-www-form-urlencoded")
    public ResponseEntity UploadMsra(@RequestParam(value = "msraxml") String msraXml,
                               @RequestParam(value = "aduser")String adUser,
                               @RequestParam(value = "hostname") String hostname,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "randomcode")String randomCode,  HttpServletRequest request){

        String ip = request.getRemoteAddr();
        MsraId msraid = new MsraId();
        msraid.setXmlContext(msraXml);
        msraid.setAdUser(adUser);
        msraid.setPassword(password);
        msraid.setHostname(hostname);
        msraid.setTimeStamp(new Timestamp(System.currentTimeMillis()));
        msraid.setRandomCode(randomCode);
        msraid.setIp(ip);
        IDFileList.addIdFileToList(msraid);
        try{
            fileUploadLogService.doLog(adUser,ip,msraXml,randomCode);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.OK);

    }


}



