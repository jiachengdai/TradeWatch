package org.design.tradewatch.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.design.tradewatch.Entity.SubGraph;

import java.util.List;

@Mapper
public interface GraphMapper {
    @Insert("insert into subgraphs (title,level,updatetime,description,preview) values (#{title},#{level},#{nowTime},#{description},#{preview})")
    void saveSubGraph(String title, Integer level, String nowTime, String description,String preview);
    @Select("SELECT COALESCE(MAX(gid), 0)+1 FROM subgraphs")
    Integer getLatestGraphId();
    @Select("select * from subgraphs where gid=#{gid}")
    SubGraph getSubGraphInfo(Long gid);
    @Select("select * from subgraphs")
    List<SubGraph> getAllSubGraphs();
    @Update("update subgraphs set title=#{subGraph.title} , level=#{subGraph.level},description=#{subGraph.description},preview=#{subGraph.preview} where gid=#{gid} ")
    void updateSubGraph(Long gid, SubGraph subGraph);
}
