package com.joker.dao.user;

import com.joker.dao.BaseDao;
import com.joker.pojo.User;
import com.mysql.jdbc.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * dao是持久层：查数据库
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User getLoginUser(Connection connection, String userCode) throws SQLException{
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if (connection != null){
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};

            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
                }
                BaseDao.closeResource(null,pstm,rs);
        }
        return user;

}

    @Override//修改当前用户密码
    public int updatePwd(Connection connection, int id, String password) throws SQLException {

        PreparedStatement pstm = null;
        int execute = 0;
        if (connection != null){
            String sql = "update smbms_user set userPassword=? where id=?";
            Object[] params = {password,id};
            execute = BaseDao.execute(connection,sql,params,pstm);
            BaseDao.closeResource(null,pstm,null);
        }

        return execute;
    }

    @Override//根据用户名或者角色查询用户总数
    public int getUserCount(Connection connection, String userName, int userRole) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        int count = 0;

        if (connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) count from smbms_user u , smbms_role r where u.userRole=r.id ");
            ArrayList<Object> list = new ArrayList<>();//存放我们 的参数

            if (!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");//list起始index ：0
            }
            if (userRole > 0){
                sql.append("and u.userRole = ?");
                list.add(userRole);//index:1
            }
            Object[] params  = list.toArray();
            //输出完整的sql语句
            System.out.println("UserDaoImpl: " + sql.toString());
            resultSet= BaseDao.execute(connection, pstm, resultSet, sql.toString(), params);
            if (resultSet.next()){
                count = resultSet.getInt("count");//从结果集中获取最终的数量
            }
            BaseDao.closeResource(null,pstm,resultSet);
        }
        return count;
    }

    @Override
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception {

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();
        if(connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
            List<Object> list = new ArrayList<Object>();
            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");
            }
            if(userRole > 0){
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }

            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            Object[] params = list.toArray();
            System.out.println("sql ----> " + sql.toString());
            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);
            while(rs.next()){
                User _user = new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setUserRole(rs.getInt("userRole"));
                _user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(_user);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return userList;
    }
}

