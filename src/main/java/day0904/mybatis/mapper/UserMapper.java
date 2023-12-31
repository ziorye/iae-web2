package day0904.mybatis.mapper;

import day0904.mybatis.po.User;

public interface UserMapper {

    User selectUser(int id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
