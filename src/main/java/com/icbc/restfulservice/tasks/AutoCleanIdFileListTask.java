package com.icbc.restfulservice.tasks;

import com.icbc.restfulservice.bean.IDFileList;
import com.icbc.restfulservice.bean.MsraId;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
@Component
public class AutoCleanIdFileListTask{
    @Scheduled(fixedDelay = 3600000)
    public void doClean() {
        long ntime = new Timestamp(System.currentTimeMillis()).getTime();
        long interval = 15*60*1000;
        for(MsraId msraid :IDFileList.idFileList.values()){
            if(msraid ==null){
                continue;
            }else {
                long stime = msraid.getTimeStamp().getTime();
                long diff = ntime -stime;
                if(diff>interval){
                    IDFileList.removeIdFileFromList(msraid);
                }else {
                    continue;
                }
            }

        }
    }
    //@Scheduled(fixedDelay = 20000)
    public void testTask(){
        System.out.println("测试任务");
    }
}
