package com.blossom.web.service.impl;

import com.blossom.web.dao.IUserAuthorDao;
import com.blossom.web.model.UserAuthorEntity;
import com.blossom.web.service.IUserAuthorService;
import com.blossom.web.util.JsonUtils;
import com.blossom.web.util.LoggerUtils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Blossom
 * @Description 用户权限service接口实现
 * @time 2017/3/9 11:45
 */
@Service("userAuthorService")
public class UserAuthorServiceImpl implements IUserAuthorService{

    private static final Class CLAZZ = UserAuthorServiceImpl.class;

    @Resource(name = "userAuthorDao")
    private IUserAuthorDao userAuthorDao;

    /**
     * @param pJson
     * @description 添加用户权限
     * @author Blossom
     * @DateTime 2017/3/9 11:44
     */
    @Override
    public JSONObject saveUserAuthor(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"saveUserAuthor",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"userId")
                    || JsonUtils.checkJSONKey(pJson,"authortyId")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }

            Integer userId = pJson.getInt("userId");
            Integer authortyId = pJson.getInt("authortyId");
            String authortyType = pJson.getString("authortyType");

            UserAuthorEntity userAuthor = new UserAuthorEntity();

            userAuthor.setUserId(userId);
            userAuthor.setAuthortyId(authortyId);
            userAuthor.setAuthortyType(authortyType);

            Integer intTag = userAuthorDao.saveUserAuthor(userAuthor);

            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("添加失败!");
            }

            return JsonUtils.sealedSuccessJSON("添加成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"saveUserAuthor",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 删除用户权限
     * @author Blossom
     * @DateTime 2017/3/9 11:45
     */
    @Override
    public JSONObject removeUserAuthor(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"removeUserAuthor",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"userAuthortyId")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }

            String userAuthortyId = pJson.getString("userAuthortyId");
            Map<String,Object> map = new HashMap<>();
            map.put("userAuthortyId",userAuthortyId);
            Integer intTag = userAuthorDao.removeUserAuthor(map);
            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("删除失败!");
            }

            return JsonUtils.sealedSuccessJSON("删除成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"removeUserAuthor",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }
}
