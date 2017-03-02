package com.blossom.web.service.impl;

import com.blossom.web.dao.ILogDao;
import com.blossom.web.model.LogModel;
import com.blossom.web.service.ILogService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Blossom
 * @Description
 * @time 2017/3/2 11:21
 */
@Service("logService")
public class LogServiceImpl implements ILogService{

    @Autowired
    private ILogDao logDaoImpl;

    /**
     * @param pJson
     * @description 添加log服务
     * @author Blossom
     * @DateTime 2017/3/2 11:20
     */
    @Override
    public JSONObject insertLogInfo(JSONObject pJson) {
        JSONObject resultJSON = new JSONObject();
        try {
            LogModel log = new LogModel();
            String uuid = null;
//            if (!JsonUtils.checkJSONKey(pJson, "uuid")) {
                uuid = pJson.getString("uuid");
//            }
            log.setId(uuid);
            String url = null;
//            if (!JsonUtils.checkJSONKey(pJson, "url")) {
                url = pJson.getString("url");
//            }
            log.setHttpUrl(url);
            String httpMethod = null;
//            if (!JsonUtils.checkJSONKey(pJson, "httpMethod")) {
                httpMethod = pJson.getString("httpMethod");
//            }
            log.setHttpMethod(httpMethod);
            String broswer = pJson.getString("broswer");
//            if (!JsonUtils.checkJSONKey(pJson, "broswer")) {
                broswer = pJson.getString("broswer");
//            }
            log.setBroswer(broswer);
            String description = pJson.getString("description");
//            if (!JsonUtils.checkJSONKey(pJson, "description")) {
                description = pJson.getString("description");
//            }
            log.setDescription(description);
            String exceptionCode = null;
//            if (!JsonUtils.checkJSONKey(pJson, "exceptionCode")) {
                exceptionCode = pJson.getString("exceptionCode");
//            }
            log.setExceptionCode(exceptionCode);
            String exceptionDetail = null;
//            if (!JsonUtils.checkJSONKey(pJson, "exceptionDetail")) {
                exceptionDetail = pJson.getString("exceptionDetail");
//            }
            log.setExceptionDetail(exceptionDetail);
            String type = null;
//            if (!JsonUtils.checkJSONKey(pJson, "type")) {
                type = pJson.getString("type");
//            }
            log.setLogType(Integer.parseInt(type));
            String method = null;
//            if (!JsonUtils.checkJSONKey(pJson, "method")) {
                method = pJson.getString("method");
//            }
            log.setMethod(method);
            String params = null;
//            if (!JsonUtils.checkJSONKey(pJson, "params")) {
                params = pJson.getString("params");
//            }
            log.setParams(params);
            String createBy = null;
//            if (!JsonUtils.checkJSONKey(pJson, "createBy")) {
                createBy = pJson.getString("createBy");
//            }
            log.setUserName(createBy);
            String createDate = null;
//            if (!JsonUtils.checkJSONKey(pJson, "createDate")) {
                createDate = pJson.getString("createDate");
//            }
            log.setCreateDate(createDate);
            String requestIp = null;
//            if (!JsonUtils.checkJSONKey(pJson, "requestIp")) {
                requestIp = pJson.getString("requestIp");
//            }
            log.setRequestIp(requestIp);

           int tagInt =  logDaoImpl.insertLogInfo(log);
           if (tagInt == 0){
               resultJSON.put("status",-1);
               resultJSON.put("message","添加失败!");
               return resultJSON;
           }
            resultJSON.put("status",1);
            resultJSON.put("message","添加成功!");

        }catch (Exception e){
            resultJSON.put("status",0);
            resultJSON.put("message",e.getMessage());
        }
        return resultJSON;
    }
}
