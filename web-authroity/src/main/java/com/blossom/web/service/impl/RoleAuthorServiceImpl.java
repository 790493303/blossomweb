package com.blossom.web.service.impl;

import com.blossom.web.dao.IRoleAuthorDao;
import com.blossom.web.model.RoleAuthorEntity;
import com.blossom.web.service.IRoleAuthorService;
import com.blossom.web.util.JsonUtils;
import com.blossom.web.util.LoggerUtils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Blossom
 * @Description 角色权限service接口实现
 * @time 2017/3/9 11:17
 */
@Service("roleAuthorService")
public class RoleAuthorServiceImpl implements IRoleAuthorService{

    private static final Class CLAZZ = RoleServiceImpl.class;

    @Resource(name = "roleAuthorDao")
    private IRoleAuthorDao roleAuthorDao;

    /**
     * @param pJson
     * @description 添加角色权限
     * @author Blossom
     * @DateTime 2017/3/9 11:15
     */
    @Override
    public JSONObject saveRoleAuthor(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"saveRoleAuthor",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"authortyId")
                    || JsonUtils.checkJSONKey(pJson,"roleId")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }

            Integer roleId = pJson.getInt("roleId");
            Integer authortyId = pJson.getInt("authortyId");
            Integer authortyType = pJson.getInt("authortyType");

            RoleAuthorEntity roleAuthor = new RoleAuthorEntity();
            roleAuthor.setAuthortyId(authortyId);
            roleAuthor.setRoleId(roleId);
            roleAuthor.setRoleAuthortyId(authortyType);

            Integer intTag = roleAuthorDao.saveRoleAuthor(roleAuthor);

            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("添加失败!");
            }

            return JsonUtils.sealedSuccessJSON("添加成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"saveRoleAuthor",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 删除角色权限
     * @author Blossom
     * @DateTime 2017/3/9 11:16
     */
    @Override
    public JSONObject removeRoleAuthor(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"removeRoleAuthor",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"roleAuthortyId")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }
            String roleAuthortyId = pJson.getString("roleAuthortyId");
            Map<String,Object> map = new HashMap<>();
            map.put("roleAuthortyId",roleAuthortyId);

            Integer intTag = roleAuthorDao.removeRoleAuthor(map);
            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("删除失败!");
            }

            return JsonUtils.sealedSuccessJSON("删除成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"removeRoleAuthor",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }
}
