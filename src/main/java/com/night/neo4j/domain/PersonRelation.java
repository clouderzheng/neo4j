package com.night.neo4j.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date 2022/6/30 21:06
 * @created by zhengjingyun
 * @desc
 */
@Data
@RelationshipEntity("link")
public class PersonRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    PersonNode startPersonNode;

    @EndNode
    PersonNode endPersonNode;




    @Relationship
    Set<PersonRelationLink> personRelationLinks = new HashSet<>();

}
