package org.example.my_jira_boot.controller;

import org.example.my_jira_boot.PO.Bug;
import org.example.my_jira_boot.general.Result;
import org.example.my_jira_boot.general.ResultUtil;
import org.example.my_jira_boot.service.BugService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping(path = "/bug")
@RestController
public class BugController {
    @Resource
    private BugService bugService;

    //类比RequirementController的写法，实现bug的增删改查
    @GetMapping("/get/bugs")
    public Result<List<Bug>> getBugs(@RequestParam(value = "creatorId") Integer creatorId){
        List<Bug> bugs = bugService.getBugs(creatorId);
        return ResultUtil.success(bugs);
    }

    @PostMapping("/add/bug")
    public Result<Bug> addBug(@RequestBody Bug bug){
        Bug bug1 = bugService.addBug(bug);
        return ResultUtil.success(bug1);
    }

    @PostMapping("/update/bug")
    public Result<Bug> updateBug(@RequestBody Bug bug){
        Bug bug1 = bugService.updateBug(bug);
        return ResultUtil.success(bug1);
    }


}
