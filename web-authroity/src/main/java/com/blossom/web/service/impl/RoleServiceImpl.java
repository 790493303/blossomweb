package com.blossom.web.service.impl;

import com.blossom.web.dao.IRoleDao;
import com.blossom.web.model.RoleEntity;
import com.blossom.web.service.IRoleService;
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
 * @Description 角色service接口实现
 * @time 2017/3/6 23:24
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    private static final Class CLAZZ = RoleServiceImpl.class;

    @Resource(name = "roleDao")
    private IRoleDao roleDao;

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
            List<RoleEntity> roleEntities = roleDao.queryRoleInfoByUserAccount(map);

            return JsonUtils.sealedSuccessJSON("","roles",roleEntities);

        }catch (Exception e){
            LoggerUtils.addLoggerError(CLAZZ,"queryRoleInfoByUserAccount",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }
}
