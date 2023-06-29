package java_study.chapter3.ch08.domain.userinfo.dao.oracle;

import java_study.chapter3.ch08.domain.userinfo.UserInfo;
import java_study.chapter3.ch08.domain.userinfo.dao.UserInfoDao;

public class UserInfoOracleDao implements UserInfoDao {
    @Override
    public void insertUserInfo(UserInfo userInfo) {
        System.out.println("Insert into Oracle DB userId = "+ userInfo.getUserId());
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("Update into Oracle DB userId = "+ userInfo.getUserId());

    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        System.out.println("Delete from Oracle DB userId = "+ userInfo.getUserId());
    }
}
