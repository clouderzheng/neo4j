package com.night.neo4j.controller;

import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.Values.parameters;

/**
 * @Date 2022/7/1 8:33
 * @created by zhengjingyun
 * @desc
 */
@RequestMapping("/cypher")
@RestController
public class CypherController {

    @Autowired
    private Session session;

    @RequestMapping("/createNode")
    public String createNode(){

        session.run(" create (dept:dept{no:$no,position:$position})",parameters("no","3000","position","java"));
        session.run(" create (dept:dept{no:$no,position:$position})",parameters("no","2000","position","bigdata"));

        return "success";
    }


    @RequestMapping("/createNodeRelation")
    public String createNodeRelation(){
        List<Record> records = queryNodes();

        session.run(" match(dept1:dept{position:$position1}),(dept2:dept{position:$position2})" +
                " create (dept1) -[e:link{relation:$relation}] -> (dept2)",
                parameters("position1",records.get(0).get("position").asString(),
                        "position2",records.get(1).get("position").asString(),
                        "relation","send"));

        return "success";
    }


    @RequestMapping("/queryNodes")
    public List<Record> queryNodes(){

        List<Record> records = new ArrayList<>();
        Result run = session.run(" match(dept:dept) return dept.no as no ,dept.position as position ");
        while (run.hasNext()){
            Record next = run.next();
            records.add(next);
            System.out.println( "no ->" + next.get("no") +" | position ->" + next.get("position"));
        }

        return records;
    }
}
