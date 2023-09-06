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

    List<Post> selectByConditionWithDynamicSQL(Map<String, Object> map);

    List<Post> selectByOneCondition(Map<String, Object> map);

    void add(Post post);

    void update(Map<String, Object> map);

    void delById(long id);

    void deleteByIds(long[] ids);
}
