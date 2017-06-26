package com.spring.simple.dao;

import com.spring.simple.model.DiffFile;
import com.spring.simple.model.DiffFileExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDao {
    int countByExample(DiffFileExample example);

    int deleteByExample(DiffFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DiffFile record);

    int insertSelective(DiffFile record);

    List<DiffFile> selectByExample(DiffFileExample example);

    DiffFile selectByPrimaryKey(Integer id);

    List<DiffFile> selectByPaging(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

    int updateByExampleSelective(@Param("record") DiffFile record, @Param("example") DiffFileExample example);

    int updateByExample(@Param("record") DiffFile record, @Param("example") DiffFileExample example);

    int updateByPrimaryKeySelective(DiffFile record);

    int updateByPrimaryKey(DiffFile record);
}