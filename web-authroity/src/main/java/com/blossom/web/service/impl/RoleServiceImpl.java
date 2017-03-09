package com.blossom.web.service.impl;

import com.blossom.web.dao.IRoleDao;
import com.blossom.web.dao.IUserRoleDao;
import com.blossom.web.model.RoleEntity;
import com.blossom.web.service.IRoleService;
import com.blossom.web.util.DateUtils;
import com.blossom.web.util.JsonUtils;
import com.blossom.web.util.LoggerUtils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 角色service接口实现
 * @time 2017/3/6 23:24
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    private static final Class CLAZZ = RoleServiceImpl.class;

    @Resource(name = "roleDao")
    private IRoleDao roleDao;
    @Resource(name = "userRoleDao")
    private IUserRoleDao userRoleDao;

    /**
     * @param pJson
     * @description 根据用户账号获取角色信息
     * @author Blossom
     * @DateTime 2017/3/8 14:55
     */
    @Override
    public JSONObject queryRoleInfoByUserAccount(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"queryRoleInfoByUserAccount",pJson.toString());
        try {
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"loginAccount")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }
            String loginAccount = pJson.getString("loginAccount");
            Map<String,Object> map = new HashMap<>();
            map.put("loginAccount",loginAccount);
            List<RoleEntity> roleEntities = userRoleDao.queryRoleInfoByUserAccount(map);

            return JsonUtils.sealedSuccessJSON("","roles",roleEntities);

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"queryRoleInfoByUserAccount",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 获取全部角色
     * @author Blossom
     * @DateTime 2017/3/9 10:19
     */
    @Override
    public JSONObject queryAllRoleInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"queryAllRoleInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)){ //获取全部角色
                List<RoleEntity> roleEntities = roleDao.queryAllRoleInfo();
                return JsonUtils.sealedSuccessJSON(null,"roles",roleEntities);
            }
            //按条件获取角色
            return null;
        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"queryAllRoleInfo",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 添加角色信息
     * @author Blossom
     * @DateTime 2017/3/9 10:20
     */
    @Override
    public JSONObject saveRoleInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"saveRoleInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"roleName")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }

            String roleName = pJson.getString("roleName");
            Integer parentRoleId = pJson.getInt("parentRoleId");
            String roleDescription = pJson.getString("roleDescription");
            Date createTime = DateUtils.format();

            RoleEntity role = new RoleEntity();

            role.setCreateTime(createTime);
            role.setParentRoleId(parentRoleId);
            role.setRoleDescription(roleDescription);
            role.setRoleName(roleName);

            Integer intTag = roleDao.saveRoleInfo(role);
            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("添加失败!");
            }

            return JsonUtils.sealedSuccessJSON("添加成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"saveRoleInfo",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 修改角色信息
     * @author Blossom
     * @DateTime 2017/3/9 10:21
     */
    @Override
    public JSONObject updateRoleInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"updateRoleInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"roleId")){
                return JsonUtils.sealedErrorJSON("参数不全！");
            }

            Integer roleId = pJson.getInt("roleId");

            String roleName = "";
            if (!JsonUtils.checkJSONKey(pJson,"roleName")){
                roleName = pJson.getString("roleName");
            }
            String roleDescription = "";
            if (!JsonUtils.checkJSONKey(pJson,"roleDescription")){
                roleDescription = pJson.getString("roleDescription");
            }

            Map<String,Object> map = new HashMap<>();
            map.put("roleDescription",roleDescription);
            map.put("roleId",roleId);
            map.put("roleName",roleName);

            Integer intTag = roleDao.updateRoleInfo(map);
            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("修改失败!");
            }

            return JsonUtils.sealedSuccessJSON("修改成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"updateRoleInfo",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 删除角色
     * @author Blossom
     * @DateTime 2017/3/9 10:21
     */
    @Override
    public JSONObject removeRoleInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(CLAZZ,"removeRoleInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"roleId")){
                return JsonUtils.sealedErrorJSON("参数不全！");
            }

            Integer roleId = pJson.getInt("roleId");
            Map<String,Object> map = new HashMap<>();
            map.put("roleId",roleId);

            Integer intTag = roleDao.removeRoleInfo(map);

            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("删除失败!");
            }

            return JsonUtils.sealedSuccessJSON("删除成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"removeRoleInfo",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }
}
