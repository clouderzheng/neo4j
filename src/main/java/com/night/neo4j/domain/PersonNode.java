package com.night.neo4j.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date 2022/6/30 20:55
 * @created by zhengjingyun
 * @desc
 */
@NodeEntity
@Data
public class PersonNode {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 姓名
     */
    String name;

    /**
     * 地址
     */
    String address;

    /**
     * 节点标签
     */
    @Labels
    Set<String> labels = new HashSet<>();

 }
