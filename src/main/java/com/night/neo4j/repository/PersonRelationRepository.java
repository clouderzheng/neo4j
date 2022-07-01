package com.night.neo4j.repository;

import com.night.neo4j.domain.PersonNode;
import com.night.neo4j.domain.PersonRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @Date 2022/6/30 20:17
 * @created by zhengjingyun
 * @desc
 */
public interface PersonRelationRepository extends Neo4jRepository<PersonRelation,Long> {
}