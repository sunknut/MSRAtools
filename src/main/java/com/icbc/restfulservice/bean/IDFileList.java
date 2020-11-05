package com.icbc.restfulservice.bean;

import com.icbc.restfulservice.config.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
@Component
public class IDFileList {
    public static HashMap<String,MsraId> idFileList = new HashMap<String,MsraId>();

    @Autowired
    ServerInfo serverInfo;

    public static void addIdFileToList(MsraId msraid){
        idFileList.put(msraid.getHostname(),msraid);
    }

    public static void removeIdFileFromList(MsraId msraid){
        idFileList.remove(msraid.getHostname());
    }

    public static MsraId getIdFileByHostname(String hostname){
        return idFileList.get(hostname);
    }

    public ArrayList<ResultBean> getResultList(){
        ArrayList<ResultBean> list  = new ArrayList<>();
        for (MsraId msraId : idFileList.values()) {
            ResultBean resultBean = new ResultBean();
            resultBean.setHostname(msraId.getHostname());
            resultBean.setAduser(msraId.getAdUser());
            resultBean.setRandomCode(msraId.getRandomCode());
            resultBean.setIp(msraId.getIp());
            String url = "http://"+ serverInfo.getServerIp()+":"+serverInfo.getPort()+"/msra/downloadid?hostname="+resultBean.getHostname();
            resultBean.setDownloadUrl(url);
            list.add(resultBean);
        }
        System.out.println(list.size()+"res");
        System.out.println(idFileList.size()+"resmap");
        return list;
    }


}
