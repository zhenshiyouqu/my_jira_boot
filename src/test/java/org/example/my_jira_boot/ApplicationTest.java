package org.example.my_jira_boot;

import org.example.my_jira_boot.PO.Bug;
import org.example.my_jira_boot.PO.Requirement;
import org.example.my_jira_boot.controller.BugController;
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

    //测试org.example.my_jira_boot.controller.BugController.addBug
    @Test
    public void testAddBug(){
        Bug bug = new Bug();
        bug.setCreatorId(1);
        bug.setRelavantId(1);
        bug.setProcessorId(1);
        bug.setIdentifierId(1);
        bug.setTitle("test");
        bug.setDescription("test");
        bug.setStatus("test");
        bug.setPriority("test");
        bug.setDamage("test");
        bug.setResolution("test");
        bug.setCommentsId(1);
        bug.setRequirementId(1);
        bug.setEnv("test");
        bug.setVersion("test");
        bug.setRelatedIssues("test");
        System.out.println(bugController.addBug(bug));


    }


}
