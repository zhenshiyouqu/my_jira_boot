package org.example.my_jira_boot.controller;

import org.example.my_jira_boot.VO.GeneralBoardCard;
import org.example.my_jira_boot.general.Result;
import org.example.my_jira_boot.service.GeneralBoardService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(path = "/generalBoard")
public class GeneralBoardController {
    @Resource
    private GeneralBoardService generalBoardService;

    @RequestMapping(path = "/getCardList")
    public Result<List<GeneralBoardCard>> getCardList(@RequestParam( "userId") Integer userId){
        return null;
    }

}
