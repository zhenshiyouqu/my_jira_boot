package org.example.my_jira_boot;

import org.example.my_jira_boot.PO.Requirement;
import org.example.my_jira_boot.controller.BugController;
import org.example.my_jira_boot.controller.PlanController;
import org.example.my_jira_boot.controller.RequirementController;
import org.example.my_jira_boot.mapper.RequirementMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ApplicationTest {
    @Resource
    private RequirementMapper requirementMapper;
    @Resource
    private RequirementController requirementController;
    @Resource
    private BugController bugController;
    @Resource
    private PlanController planController;
    @Test
    public void testMybatis(){
        Requirement requirement = requirementMapper.selectById(1);
        System.out.println(requirement.toString());
    }
    //测试org.example.my_jira_boot.service.RequirementService.getRequirments
    @Test
    public void testGetRequirments(){
        System.out.println(requirementController.getRequirments(1));
    }

    //测试org.example.my_jira_boot.controller.BugController.getBugs
    @Test
    public void testGetBugs(){
        System.out.println(bugController.getBugs(1));
    }

    @Test
    public void testGetPlan() {
        System.out.println(planController.getPlan(1));
    }



}
