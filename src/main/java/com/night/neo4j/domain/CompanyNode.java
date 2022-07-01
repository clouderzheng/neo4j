package com.night.neo4j.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @Date 2022/6/30 21:21
 * @created by zhengjingyun
 * @desc
 */
@Data
@NodeEntity(label = "company")
public class CompanyNode {

    @Id
    @GeneratedValue
    private Long id;

    String name;

    Double price;
}
