package com.joker.service.role;

import com.joker.dao.BaseDao;
import com.joker.dao.role.RoleDao;
import com.joker.dao.role.RoleDaoImpl;
import com.joker.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class RoleServiceImpl implements RoleService{
    //引入Dao
    private RoleDao roleDao;
    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }
    @Override
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = null;
        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }

        return roleList;

    }
//    @Test
//    public void test(){
//
//    }
}
