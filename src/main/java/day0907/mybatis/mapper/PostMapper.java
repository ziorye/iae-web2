package day0907.mybatis.mapper;

import day0907.pojo.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PostMapper {
    List<Post> selectAll();

    Post selectById(long id);

    List<Post> selectByCondition(@Param("status") int status, @Param("title") String title, @Param("content") String content);

    List<Post> selectByCondition(Post post);

    List<Post> selectByCondition(Map<String, Object> map);
}
