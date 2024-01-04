package org.example.my_jira_boot;

import org.example.my_jira_boot.PO.Requirement;
import org.example.my_jira_boot.mapper.RequirementMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ApplicationTest {
    @Resource
    private RequirementMapper requirementMapper;
    @Test
    public void testMybatis(){
        Requirement requirement = requirementMapper.selectById(1);
        System.out.println(requirement.toString());
    }
}
