package day0904.mapper;

import day0904.mybatis.mapper.UserMapper;
import day0904.mybatis.po.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

@Slf4j
public class UserMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    public static void createSqlSessionFactory() throws Exception {
        // 创建sqlSessionFactory

        // mybatis配置文件
        String resource = "day0904/mybatis/mybatisConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testInsertUser(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            User user = new User();
            user.setName("username");
            user.setBalance(100);

            int id = mapper.insertUser(user);

            session.commit();

            System.out.println(id);
        }
    }

    @Test
    public void testSelectUser(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //User user = session.selectOne("day0905.mybatis.mapper.UserMapper.selectUser", 1);
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(1);
            System.out.println(user);

            log.trace("trace msg");
            log.debug("debug msg");
            log.info("info msg");
            log.warn("warn msg");
            log.error("error msg");
        }
    }

    @Test
    public void testUpdateUser(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            User user = new User();
            user.setId(1);
            user.setName("username 556");
            user.setBalance(5);

            int id = mapper.updateUser(user);

            session.commit();

            System.out.println(id);
        }
    }

    @Test
    public void testDeleteUser(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            int id = mapper.deleteUser(1);

            session.commit();

            System.out.println(id);
        }
    }
}
