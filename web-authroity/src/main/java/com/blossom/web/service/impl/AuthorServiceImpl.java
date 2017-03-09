package com.blossom.web.service.impl;

import com.blossom.web.dao.IAuthorDao;
import com.blossom.web.dao.IRoleAuthorDao;
import com.blossom.web.dao.IUserAuthorDao;
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
    @Resource(name = "userAuthorDao")
    private IUserAuthorDao userAuthorDao;
    @Resource(name = "roleAuthorDao")
    private IRoleAuthorDao roleAuthorDao;


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
            LoggerUtils.addLoggerError(CLAZZ,"queryAllAuthorInfo",e.getMessage());
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
        LoggerUtils.addLoggerInfo(CLAZZ,"queryAuthorInfoByUserAccount",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"loginAccount")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }
            Map<String,Object> map = new HashMap<>();
            String loginAccount = pJson.getString("loginAccount");
            List<AuthorEntity> authorEntities = userAuthorDao.queryAuthorInfoByUserAccount(map);

            return JsonUtils.sealedSuccessJSON("","authors",authorEntities);

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"queryAuthorInfoByUserAccount",e.getMessage());
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
        LoggerUtils.addLoggerInfo(CLAZZ,"queryAuthorInfoByRoleId",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"roleId")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }
            String roleId = pJson.getString("roleId");
            Map<String,Object> map = new HashMap<>();
            map.put("roleId",roleId);
            List<AuthorEntity> authorEntities = roleAuthorDao.queryAuthorInfoByRoleId(map);

            return JsonUtils.sealedSuccessJSON("","authors",authorEntities);

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"queryAuthorInfoByRoleId",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 添加权限信息
     * @author Blossom
     * @DateTime 2017/3/9 10:52
     */
    @Override
    public JSONObject saveAuthorInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"saveAuthorInfo",pJson.toString());
        try {
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"authortyName")
                    || JsonUtils.checkJSONKey(pJson,"authortyDescription")
                    || JsonUtils.checkJSONKey(pJson,"authortyUrl")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }

            String authortyName = pJson.getString("authortyName");
            String authortyDescription = pJson.getString("authortyDescription");
            String authortyUrl = pJson.getString("authortyUrl");
            Integer parentAuthortyId = null;
            if (!JsonUtils.checkJSONKey(pJson,"parentAuthortyId")){
                parentAuthortyId = pJson.getInt("parentAuthortyId");
            }

            AuthorEntity author = new AuthorEntity();
            author.setAuthortyDescription(authortyDescription);
            author.setAuthortyName(authortyName);
            author.setAuthortyUrl(authortyUrl);
            author.setParentAuthortyId(parentAuthortyId);

            Integer intTag = authorDao.saveAuthorInfo(author);

            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("添加失败!");
            }

            return JsonUtils.sealedSuccessJSON("添加成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"saveAuthorInfo",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

        /**
         * @param pJson
         * @description 删除权限信息
         * @author Blossom
         * @DateTime 2017/3/9 10:52
         */
        @Override
        public JSONObject removeAuthorInfo(JSONObject pJson) {
            LoggerUtils.addLoggerInfo(CLAZZ,"removeAuthorInfo",pJson.toString());
            try{
                if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"authortyId")){
                    return JsonUtils.sealedErrorJSON("参数不全!");
                }

            String authortyId = pJson.getString("authortyId");
            Map<String,Object> map = new HashMap<>();
            map.put("authortyId",authortyId);
            Integer intTag = authorDao.removeAuthorInfo(map);
            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("删除失败!");
            }

            return JsonUtils.sealedSuccessJSON("删除成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"removeAuthorInfo",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 更新权限信息
     * @author Blossom
     * @DateTime 2017/3/9 10:53
     */
    @Override
    public JSONObject updateAuthorInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"updateAuthorInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"authortyId")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }

            String authortyId = pJson.getString("authortyId");
            String authortyName = "";
            if (!JsonUtils.checkJSONKey(pJson,"authortyName")){
                authortyName = pJson.getString("authortyName");
            }
            String authortyDescription = "";
            if (!JsonUtils.checkJSONKey(pJson,"authortyDescription")){
                authortyDescription = pJson.getString("authortyDescription");
            }
            String authortyUrl = "";
            if (!JsonUtils.checkJSONKey(pJson,"authortyUrl")){
                authortyUrl = pJson.getString("authortyUrl");
            }
            Map<String,Object> map = new HashMap<>();
            map.put("authortyId",authortyId);
            map.put("authortyUrl",authortyUrl);
            map.put("authortyName",authortyName);
            map.put("authortyDescription",authortyDescription);

            Integer intTag = authorDao.updateAuthorInfo(map);
            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("修改失败!");
            }

            return JsonUtils.sealedSuccessJSON("修改成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"updateAuthorInfo",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }
}
