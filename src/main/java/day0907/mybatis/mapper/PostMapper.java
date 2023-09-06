package day0907.mybatis.mapper;

import day0907.pojo.Post;

import java.util.List;

public interface PostMapper {
    List<Post> selectAll();

    Post selectById(long id);
}
