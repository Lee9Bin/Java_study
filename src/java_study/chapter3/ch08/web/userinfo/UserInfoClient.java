package java_study.chapter3.ch08.web.userinfo;
import java_study.chapter3.ch08.domain.userinfo.UserInfo;
import java_study.chapter3.ch08.domain.userinfo.dao.UserInfoDao;
import java_study.chapter3.ch08.domain.userinfo.dao.mysql.UserInfoMySqlDao;
import java_study.chapter3.ch08.domain.userinfo.dao.oracle.UserInfoOracleDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserInfoClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("db.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String dbType = prop.getProperty("DBTYPE");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("12345");
        userInfo.setUserName("이말순");
        userInfo.setPassword("1222");

        UserInfoDao userInfoDao = null;

        if (dbType.equals("ORACLE")){
            userInfoDao = new UserInfoOracleDao();
        }
        else if (dbType.equals("MYSQL")) {
            userInfoDao = new UserInfoMySqlDao();
        }

        else {
            System.out.println("db error");
            return;
        }

        userInfoDao.insertUserInfo(userInfo);
        userInfoDao.updateUserInfo(userInfo);
        userInfoDao.deleteUserInfo(userInfo);
    }
}
