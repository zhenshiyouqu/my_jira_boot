package org.example.my_jira_boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.log4j.Log4j2;
import org.example.my_jira_boot.PO.Bug;
import org.example.my_jira_boot.mapper.BugMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Log4j2
public class BugService {
    @Resource
    private BugMapper bugMapper;
    public List<Bug> getBugs(Integer creatorId){
        //get bugs by userId
        List<Bug> bugs = bugMapper.selectList(new QueryWrapper<Bug>().eq("creator_id", creatorId));
        return bugs;
    }

    public Bug addBug(Bug bug){
        log.info(bug);
        //add bug
        bugMapper.insert(bug);
        return bug;
    }

    public Bug updateBug(Bug bug){
        //update bug
        bugMapper.updateById(bug);
        return bug;
    }


}
