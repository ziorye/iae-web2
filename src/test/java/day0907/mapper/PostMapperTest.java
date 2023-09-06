package day0907.mapper;

import day0907.mybatis.mapper.PostMapper;
import day0907.pojo.Post;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class PostMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    public static void createSqlSessionFactory() throws Exception {
        // 创建sqlSessionFactory

        // mybatis配置文件
        String resource = "day0907/mybatis/mybatis-config.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    void test() {
        Assertions.assertTrue(true);
    }
}