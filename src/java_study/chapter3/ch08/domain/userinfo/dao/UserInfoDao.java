package java_study.chapter3.ch08.domain.userinfo.dao;

import java_study.chapter3.ch08.domain.userinfo.UserInfo;

public interface UserInfoDao {
    void insertUserInfo(UserInfo userInfo);
    void updateUserInfo(UserInfo userInfo);
    void deleteUserInfo(UserInfo userInfo);
}
