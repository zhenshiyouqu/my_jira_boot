package org.example.my_jira_boot.controller;

import org.example.my_jira_boot.PO.Requirement;
import org.example.my_jira_boot.general.Result;
import org.example.my_jira_boot.general.ResultUtil;
import org.example.my_jira_boot.service.RequirementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(path = "/requirement")
public class RequirementController {
    @Resource
    private RequirementService requirementService;
    @GetMapping("/get/requirements")
    public Result<List<Requirement>> getRequirments(@RequestParam(value = "ownerId") Integer ownerId){
        List<Requirement> requirments = requirementService.getRequirments(ownerId);
        return ResultUtil.success(requirments);
    }

}
