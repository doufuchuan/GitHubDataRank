package com.example.talentrank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.talentrank.entity.Developer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeveloperMapper extends BaseMapper<Developer> {

    @Select("select * from developers")
    public List<Developer> find();

    @Select("select * from developers where username = #{username}")
    public Developer findByName(String username);

//    @Select("insert into developers values (#{id}, #{github_id}, #)")
//    public int insert();
    @Insert("INSERT INTO developers values (#{github_id}, #{github_id}, #{username}, #{nation},#{repos},#{followers}, #{contributions}, #{stars}, #{issues}, #{talent_rank}) ")
    public int insert(Developer developer);
}
