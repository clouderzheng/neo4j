package com.night.neo4j.test;

import com.alibaba.fastjson.JSON;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import static org.neo4j.driver.Values.parameters;

/**
 * @Date 2022/6/30 16:26
 * @created by zhengjingyun
 * @desc
 */
public class TestDriver {

    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687");
        Session session = driver.session();
        //这里注意 ，之前的版本字段注入是使用的{}，现在新版本的使用的$
        //创建一个person 节点 name=tom，address=北京
        session.run("CREATE (n:person {name:$name,address: $address})",
                parameters("name", "tom", "address", "北京"));
        //创建一个person 节点 name=night，address=四川
        session.run("CREATE (n:person {name:$name,address: $address})",
                parameters("name", "night", "address", "四川"));
        //查询person节点的name字段为night的节点
        Result result = session.run( "MATCH (a:person) WHERE a.name = $name " +
                        "RETURN a.name AS name, a.address AS address",
                parameters( "name", "night"));
        while (result.hasNext()) {
            Record record = result.next();
            System.out.println( record.get( "address" ).asString() + "" + record.get( "name" ).asString() );
        }
        //为night到tom节点建立一个属性relation=邻居的关系
        session.run(" match (n:person{name:$name1}),(q:person{name:$name}) create (n) -[l:link{relation:$relation}] ->(q)",
                parameters("name1", "night", "name", "tom", "relation", "邻居"));

        session.close();
        driver.close();
    }
}
