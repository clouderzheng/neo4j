package com.night.neo4j.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @Date 2022/6/30 21:06
 * @created by zhengjingyun
 * @desc
 */
@Data
@RelationshipEntity(type = "link")
public class CompanyRelation {

    @Id
    @GeneratedValue
    private Long id;

    String indexName ;

    @StartNode
    PersonNode personNode;

    @EndNode
    CompanyNode companyNode;


    String relation;
}
