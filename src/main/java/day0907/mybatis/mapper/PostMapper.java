package day0907.mybatis.mapper;

import day0907.pojo.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostMapper {
    List<Post> selectAll();

    Post selectById(long id);

    List<Post> selectByCondition(@Param("status") int status, @Param("title") String title, @Param("content") String content);
}
