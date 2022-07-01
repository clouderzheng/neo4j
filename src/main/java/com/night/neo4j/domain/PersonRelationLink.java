package com.night.neo4j.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @Date 2022/7/1 11:19
 * @created by zhengjingyun
 * @desc
 */
@Data
@Builder
public class PersonRelationLink {

    String relation;

    long distance;

    long score;

}
