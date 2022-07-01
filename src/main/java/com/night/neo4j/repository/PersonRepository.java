package com.night.neo4j.repository;

import com.night.neo4j.domain.PersonNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Date 2022/6/30 20:17
 * @created by zhengjingyun
 * @desc
 */
public interface PersonRepository extends Neo4jRepository<PersonNode,Long> {


    @Query("match (node:PersonNode) return node")
    List<PersonNode> getByName(@Param("name") String name);
//    List<PersonNode> getByName();

}