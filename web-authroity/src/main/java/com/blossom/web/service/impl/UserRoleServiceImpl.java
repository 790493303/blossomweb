package com.blossom.web.service.impl;

import com.blossom.web.dao.IUserRoleDao;
import com.blossom.web.model.UserRoleEntity;
import com.blossom.web.service.IUserRoleService;
import com.blossom.web.util.JsonUtils;
import com.blossom.web.util.LoggerUtils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Blossom
 * @Description 用户角色service接口实现
 * @time 2017/3/9 11:33
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService{

    private static final Class CLAZZ = UserRoleServiceImpl.class;

    @Resource(name = "userRoleDao")
    private IUserRoleDao userRoleDao;

    /**
     * @param pJson
     * @description 添加用户角色
     * @author Blossom
     * @DateTime 2017/3/9 11:32
     */
    @Override
    public JSONObject saveUserRole(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"saveUserRole",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"userId")
                    || JsonUtils.checkJSONKey(pJson,"roleId")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }

            Integer userId = pJson.getInt("userId");
            Integer roleId = pJson.getInt("roleId");

            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setRoleId(roleId);
            userRole.setUserId(userId);

            Integer intTag = userRoleDao.saveUserRole(userRole);

            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("添加失败!");
            }

            return JsonUtils.sealedSuccessJSON("添加成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"saveUserRole",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 删除用户角色
     * @author Blossom
     * @DateTime 2017/3/9 11:32
     */
    @Override
    public JSONObject removeUserRole(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"removeUserRole",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)
                        || JsonUtils.checkJSONKey(pJson,"userRoleId")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }

            String userRoleId = pJson.getString("userRoleId");
            Map<String,Object> map = new HashMap<>();
            map.put("userRoleId",userRoleId);
            Integer intTag = userRoleDao.removeUserRole(map);
            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("删除失败!");
            }

            return JsonUtils.sealedSuccessJSON("删除成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"removeUserRole",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }
}
