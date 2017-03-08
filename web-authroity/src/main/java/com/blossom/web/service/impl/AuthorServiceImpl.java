package com.blossom.web.service.impl;

import com.blossom.web.dao.IAuthorDao;
import com.blossom.web.model.AuthorEntity;
import com.blossom.web.service.IAuthorService;
import com.blossom.web.util.JsonUtils;
import com.blossom.web.util.LoggerUtils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 权限service接口实现
 * @time 2017/3/6 23:25
 */
@Service("authorService")
public class AuthorServiceImpl implements IAuthorService{

    private static final Class CLAZZ = AuthorServiceImpl.class;

    @Resource(name = "authorDao")
    private IAuthorDao authorDao;


    /**
     * @param pJson
     * @description 获取全部的权限信息
     * @author Blossom
     * @DateTime 2017/3/8 15:37
     */
    @Override
    public JSONObject queryAllAuthorInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"queryAllAuthorInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)){ //无条件获取全部权限
                List<AuthorEntity> authorEntities = authorDao.queryAllAuthorInfo();
                return JsonUtils.sealedSuccessJSON("","authors",authorEntities);
            }
            //按条件获取权限
            return null;
        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 根据用户账号获取权限
     * @author Blossom
     * @DateTime 2017/3/8 15:38
     */
    @Override
    public JSONObject queryAuthorInfoByUserAccount(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"queryAllAuthorInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"loginAccount")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }
            Map<String,Object> map = new HashMap<>();
            String loginAccount = pJson.getString("loginAccount");
            List<AuthorEntity> authorEntities = authorDao.queryAuthorInfoByUserAccount(map);

            return JsonUtils.sealedSuccessJSON("","authors",authorEntities);

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 根据角色获取权限
     * @author Blossom
     * @DateTime 2017/3/8 15:39
     */
    @Override
    public JSONObject queryAuthorInfoByRoleId(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"queryAllAuthorInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"roleId")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }
            String roleId = pJson.getString("roleId");
            Map<String,Object> map = new HashMap<>();
            map.put("roleId",roleId);
            List<AuthorEntity> authorEntities = authorDao.queryAuthorInfoByRoleId(map);

            return JsonUtils.sealedSuccessJSON("","authors",authorEntities);

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }
}
