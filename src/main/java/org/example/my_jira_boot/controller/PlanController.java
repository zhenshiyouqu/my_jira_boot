package org.example.my_jira_boot.controller;

import org.example.my_jira_boot.PO.Plan;
import org.example.my_jira_boot.general.Result;
import org.example.my_jira_boot.general.ResultUtil;
import org.example.my_jira_boot.service.PlanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Resource
    private PlanService planService;

    //添加get add update delete Plan的方法

    @GetMapping("/get")
    public Result<List<Plan>> getPlan(@RequestParam("creatorId") Integer creatorId){
        List<Plan> plan = planService.getPlan(creatorId);
        return ResultUtil.success(plan);
    }



}
