package com.night.neo4j.controller;

import com.alibaba.fastjson.JSON;
import com.night.neo4j.domain.CompanyNode;
import com.night.neo4j.domain.CompanyRelation;
import com.night.neo4j.domain.PersonNode;
import com.night.neo4j.domain.PersonRelation;
import com.night.neo4j.repository.CompanyRelationRepository;
import com.night.neo4j.repository.CompanyRepository;
import com.night.neo4j.repository.PersonRelationRepository;
import com.night.neo4j.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.peer.CanvasPeer;
import java.util.List;
import java.util.Optional;

/**
 * @Date 2022/6/30 20:56
 * @created by zhengjingyun
 * @desc
 */
@RequestMapping("/person")
@RestController
public class PersonController
{

    @Autowired
    private PersonRepository personRepository;


    @Autowired
    private PersonRelationRepository personRelationRepository;

    @Autowired
    private CompanyRepository companyRepository;


    @Autowired
    private CompanyRelationRepository companyRelationRepository;


    @RequestMapping("/create")
    public String createNode(){

        PersonNode personNode = new PersonNode();

        personNode.setName("Jim");
        personNode.setAddress("四川");
        personNode.getLabels().add("person");
        personNode.getLabels().add("human");
        personNode.getLabels().add("citizen");

        PersonNode save1 = personRepository.save(personNode);
        System.out.println(JSON.toJSONString(save1));

        PersonNode personNode2 = new PersonNode();

        personNode2.setName("Green");
        personNode2.setAddress("北京");
        PersonNode save = personRepository.save(personNode2);
        System.out.println(JSON.toJSONString(save));

        return "success";

    }




    @RequestMapping("/createCompany")
    public String createCompanyNode(){


        CompanyNode companyNode = new CompanyNode();
        companyNode.setName("特斯拉");
        companyNode.setPrice(3000d);
        companyRepository.save(companyNode);
        return "success";

    }


    @RequestMapping("/createCompanyRelation")
    public String createCompanyRelation(){


        // id = 1
        Optional<PersonNode> person = personRepository.findById(9L);

        System.out.println(JSON.toJSONString(person.get()));

        Optional<CompanyNode> companyNode = companyRepository.findById(10l);

        CompanyRelation companyRelation = new CompanyRelation();
        companyRelation.setCompanyNode(companyNode.get());
        companyRelation.setPersonNode(person.get());
        companyRelation.setRelation("员工");
        companyRelation.setIndexName("2号");

        companyRelationRepository.save(companyRelation);


        return "success";

    }




    @RequestMapping("/createRelation")
    public String createRelation(){
        // id = 1
        Optional<PersonNode> person1 = personRepository.findById(9L);

        System.out.println(JSON.toJSONString(person1.get()));
        // id = 2
        Optional<PersonNode> person2 = personRepository.findById(3L);
        System.out.println(JSON.toJSONString(person2.get()));

        PersonRelation personRelation = new PersonRelation();
        personRelation.setStartPersonNode(person1.get());
        personRelation.setEndPersonNode(person2.get());
//        personRelation.setIndexName("距离");
//        personRelation.setRelation("邻居");
        personRelationRepository.save(personRelation);

        return "success";
    }



    @RequestMapping("/queryByName")
    public String queryByName(){

        List<PersonNode> personNodes = personRepository.getByName("Green");
//        List<PersonNode> personNodes = personRepository.getByName();

        personNodes.forEach( personNode -> {
            System.out.println(JSON.toJSONString(personNode));
        });

        return "success";
    }

}
