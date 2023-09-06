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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    void selectAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);
            List<Post> posts = mapper.selectAll();
            Assertions.assertTrue(posts.size() > 0);
            Assertions.assertNotNull(posts.get(0).getCreatedAt());
            Assertions.assertNotNull(posts.get(0).getUpdatedAt());
            Assertions.assertEquals(1, posts.get(0).getUserId());
            Assertions.assertEquals(0, posts.get(0).getViewCount());
        }
    }

    @Test
    void selectById() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);
            long id = 1;
            Post post = mapper.selectById(id);
            Assertions.assertEquals("npm-registry-speedup", post.getSlug());
        }
    }

    @Test
    void testSqlStatementWithSpecialTag() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            List<Object> objects = sqlSession.selectList("day0907.mybatis.mapper.PostMapper.sqlStatementWithSpecialTag");
            Assertions.assertTrue(objects.size() > 0);
        }
    }

    @Test
    void selectByCondition() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);
            List<Post> posts = mapper.selectByCondition(1, "npm%", "%慢%");
            Assertions.assertTrue(posts.size() > 0);
        }
    }

    @Test
    void selectByConditionWithObject() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);

            Post post = new Post();
            post.setStatus(1);
            post.setTitle("npm%");
            post.setContent("%慢%");

            List<Post> posts = mapper.selectByCondition(post);

            Assertions.assertTrue(posts.size() > 0);
        }
    }

    @Test
    void selectByConditionWithMap() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);

            Map<String, Object> map = new HashMap<>();
            map.put("status", 1);
            map.put("title", "npm%");
            map.put("content", "%慢%");

            List<Post> posts = mapper.selectByCondition(map);

            Assertions.assertTrue(posts.size() > 0);
        }
    }

    @Test
    void selectByConditionWithDynamicSQL() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);

            Map<String, Object> map = new HashMap<>();
            map.put("status", 1);
            map.put("title", "");
            map.put("content", "%慢%");

            List<Post> posts = mapper.selectByConditionWithDynamicSQL(map);

            Assertions.assertEquals(4, posts.size());
        }
    }
}
