package com.blossom.web.service.impl;

import com.blossom.web.dao.*;
import com.blossom.web.model.AuthorEntity;
import com.blossom.web.model.RoleEntity;
import com.blossom.web.model.UserEntity;
import com.blossom.web.service.IUserService;
import com.blossom.web.util.*;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author Blossom
 * @Description 用户Service接口实现
 * @time 2017/3/6 23:23
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    private static final Class clazz = UserServiceImpl.class;

    @Resource(name = "userDao")
    private IUserDao userDao;
    @Resource(name = "roleAuthorDao")
    private IRoleAuthorDao roleAuthorDao;
    @Resource(name = "userRoleDao")
    private IUserRoleDao userRoleDao;
    @Resource(name = "userAuthorDao")
    private IUserAuthorDao userAuthorDao;

    /**
     * @param pJson
     * @description 获取所有用户信息
     * @author Blossom
     * @DateTime 2017/3/8 10:31
     */
    @Override
    public JSONObject queryAllUserInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(clazz,"queryAllUserInfo",pJson.toString());
        try{
            if (JsonUtils.checkJSONIsNull(pJson)){ //无条件获取全部用户信息
                List<UserEntity> userEntities = userDao.queryAllUserInfo();
                return JsonUtils.sealedSuccessJSON(null,"users",userEntities);
            }
            //按条件查询
            return null;
        }catch (Exception e){
            LoggerUtils.addLoggerError(clazz,"queryAllUserInfo",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }

    }

    /**
     * @param pJson
     * @description 获取指定用户信息
     * @author Blossom
     * @DateTime 2017/3/8 10:32
     */
    @Override
    public JSONObject queryUserInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(clazz,"queryUserInfo",pJson.toString());
        try {
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"loginAccount")){
                return JsonUtils.sealedErrorJSON("账号不能为空!");
            }
            String loginAccount = pJson.getString("loginAccount");
            Map<String,Object> map = new HashMap<>();
            map.put("loginAccount",loginAccount);
            UserEntity userEntity = userDao.queryOneUserInfo(map);
            LoggerUtils.addLoggerDebug(clazz,"queryUserInfo",userEntity.toString());
            if (ObjectUtils.isEmpty(userEntity)){
                return JsonUtils.sealedErrorJSON("账号错误!");
            }
            return JsonUtils.sealedSuccessJSON(null,"user",userEntity);

        }catch (Exception e){
            LoggerUtils.addLoggerError(clazz,"queryUserInfo",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 添加用户信息
     * @author Blossom
     * @DateTime 2017/3/8 13:42
     */
    @Override
    public JSONObject saveUserInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(clazz,"saveUserInfo",pJson.toString());
        try {
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"loginAccount")
                    || JsonUtils.checkJSONKey(pJson,"loginPassword")
                    || JsonUtils.checkJSONKey(pJson,"userName")
                    || JsonUtils.checkJSONKey(pJson,"telephone")
                    || JsonUtils.checkJSONKey(pJson,"email")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }

            String loginAccount = pJson.getString("loginAccount");
            String loginPassword = pJson.getString("loginPassword");
            String userName = pJson.getString("userName");
            String telephone = pJson.getString("telephone");
            String email = pJson.getString("email");
            Date createTime = DateUtils.format();

            UserEntity user = new UserEntity();

            user.setLoginAccount(loginAccount);
            user.setLoginPassword(loginPassword);
            user.setUserName(userName);
            user.setCreateTime(createTime);
            user.setEmail(email);
            user.setTelephone(telephone);

           Integer intTag = userDao.insertUserInfo(user);
           if (null == intTag || intTag == 0){
               return JsonUtils.sealedErrorJSON("添加失败!");
           }

           return JsonUtils.sealedSuccessJSON("添加成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(clazz,"saveUserInfo",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 删除用户信息
     * @author Blossom
     * @DateTime 2017/3/8 13:43
     */
    @Override
    public JSONObject removeUserInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(clazz,"removeUserInfo",pJson.toString());
        try {
            if (JsonUtils.checkJSONIsNull(pJson) || JsonUtils.checkJSONKey(pJson,"userId")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }
            String userId = pJson.getString("userId");
            Map<String,Object> map = new HashMap<>();
            map.put("userId",userId);
            Integer intTag = userDao.deleteUserInfo(map);
            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("删除失败!");
            }
            return JsonUtils.sealedSuccessJSON("删除成功!");
        }catch (Exception e){
            LoggerUtils.addLoggerError(clazz,"removeUserInfo",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }


    /**
     * @param pJson
     * @description 修改用户信息
     * @author Blossom
     * @DateTime 2017/3/8 13:43
     */
    @Override
    public JSONObject updateUserInfo(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(clazz,"updateUserInfo",pJson.toString());
        try {
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"userId")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }
            Map<String,Object> map = new HashMap<>();
            map.put("userId",pJson.getString("userId"));
            String loginAccount = "";
            if (pJson.containsKey(loginAccount)){
                loginAccount = pJson.getString("loginAccount");
            }
            map.put("loginAccount",loginAccount);

            String loginPassword = "";
            if (pJson.containsKey("loginPassword")){
                loginPassword = pJson.getString("loginPassword");
            }
            map.put("loginPassword",loginPassword);

            String telephone = "";
            if (pJson.containsKey("telephone")){
                telephone = pJson.getString("telephone");
            }
            map.put("telephone",telephone);

            String userName = "";
            if (pJson.containsKey("userName")){
                userName = pJson.getString("userName");
            }
            map.put("userName",userName);

            String email = "";
            if (pJson.containsKey("email")){
                email = pJson.getString("email");
            }
            map.put("email",email);

            Date loginTime = null;
            if (pJson.containsKey("loginTime")){
                loginTime = (Date)pJson.get("loginTime");
            }
            map.put("loginTime",loginTime);

            Date lastLoginTime = null;
            if (pJson.containsKey("lastLoginTime")){
                lastLoginTime = (Date)pJson.get("lastLoginTime");
            }
            map.put("lastLoginTime",lastLoginTime);

            Integer loginCount = null;
            if (pJson.containsKey("loginCount")){
                loginCount = pJson.getInt("loginCount");
            }
            map.put("loginCount",loginCount);

            Integer intTag = userDao.updateUserInfo(map);
            if (null == intTag || intTag == 0){
                return JsonUtils.sealedErrorJSON("修改失败!");
            }

            return JsonUtils.sealedSuccessJSON("修改成功!");

        }catch (Exception e){
            LoggerUtils.addLoggerError(clazz,"updateUserInfo",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @param pJson
     * @description 获取用户角色
     * @author Blossom
     * @DateTime 2017/3/8 16:06
     */
    @Override
    public JSONObject queryUserRole(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(clazz,"updateUserInfo",pJson.toString());
        try {
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"loginAccount")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }
            String loginAccount = pJson.getString("loginAccount");
            Map<String,Object> map = new HashMap<>();
            map.put("loginAccount",loginAccount);
            Set<String> roleSet = new HashSet<>();
            roleSet = queryRoleAuthor(map);
            /*List<RoleEntity> roleEntities = roleDao.queryRoleInfoByUserAccount(map);
            Set<String> roleSet = new HashSet<>();
            if (!CollectionUtils.isEmpty(roleEntities)){
                for(RoleEntity role:roleEntities){
                    roleSet.add(role.getRoleName());
                }
            }*/

            return JsonUtils.sealedSuccessJSON("","roleSet",roleSet);

        }catch (Exception e){
            LoggerUtils.addLoggerError(clazz,"",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }

    /**
     * @description 封装获取角色
     * @author Blossom
     * @DateTime 2017/3/8 16:29
     * @param
     */
    private Set<String> queryRoleAuthor(Map<String,Object> pMap){
        List<RoleEntity> roleEntities = userRoleDao.queryRoleInfoByUserAccount(pMap);
        Set<String> roleSet = new HashSet<>();
        if (!CollectionUtils.isEmpty(roleEntities)){
            for(RoleEntity role:roleEntities){
                roleSet.add(role.getRoleName());
            }
        }
        return roleSet;
    }

    /**
     * @param pJson
     * @description 获取用户权限
     * @author Blossom
     * @DateTime 2017/3/8 16:07
     */
    @Override
    public JSONObject queryUserAuthor(JSONObject pJson) {
        LoggerUtils.addLoggerInfo(clazz,"updateUserInfo",pJson.toString());
        try {
            if (JsonUtils.checkJSONIsNull(pJson)
                    || JsonUtils.checkJSONKey(pJson,"loginAccount")){
                return JsonUtils.sealedErrorJSON("参数不全!");
            }
            String loginAccount = pJson.getString("loginAccount");
            Map<String,Object> map = new HashMap<>();
            map.put("loginAccount",loginAccount);
            List<AuthorEntity> authorEntities = userAuthorDao.queryAuthorInfoByUserAccount(map);
            Set<String> authorSet = new HashSet<>();
            if (!CollectionUtils.isEmpty(authorEntities)){
                for(AuthorEntity author: authorEntities){
                    authorSet.add(author.getAuthortyUrl());
                }
            }

            //获取角色的权限
            Set<String> roleSet = queryRoleAuthor(map);
            if (!CollectionUtils.isEmpty(roleSet)){
                Iterator itarator = roleSet.iterator();
                RoleEntity roleEntity = null;
                List<AuthorEntity> authors = null;
                while (itarator.hasNext()){
                    roleEntity = (RoleEntity) itarator.next();
                    map.put("roleId",roleEntity.getRoleId());
                    authors =roleAuthorDao.queryAuthorInfoByRoleId(map);
                    if (!CollectionUtils.isEmpty(authors)){
                        for(AuthorEntity author: authors){
                            authorSet.add(author.getAuthortyUrl());
                        }
                    }
                }
            }

            return JsonUtils.sealedSuccessJSON("","authorSet",authorSet);

        }catch (Exception e){
            LoggerUtils.addLoggerError(clazz,"",e.getMessage());
            e.printStackTrace();
            return JsonUtils.sealedExceptionJSON(e);
        }
    }
}
