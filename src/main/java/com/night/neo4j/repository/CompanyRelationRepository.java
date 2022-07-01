package com.night.neo4j.repository;

import com.night.neo4j.domain.CompanyRelation;
import com.night.neo4j.domain.PersonRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @Date 2022/6/30 20:17
 * @created by zhengjingyun
 * @desc
 */
public interface CompanyRelationRepository extends Neo4jRepository<CompanyRelation,Long> {
}