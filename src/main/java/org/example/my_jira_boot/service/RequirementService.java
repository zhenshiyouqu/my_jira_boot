package org.example.my_jira_boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.my_jira_boot.PO.Requirement;
import org.example.my_jira_boot.general.Result;
import org.example.my_jira_boot.mapper.RequirementMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RequirementService {
    @Resource
    private RequirementMapper requirementMapper;
    public List<Requirement> getRequirments(Integer ownerId){
        //get requirments by userId
        List<Requirement> requirements = requirementMapper.selectList(new QueryWrapper<Requirement>().eq("owner_id", ownerId));
        return requirements;
    }

    public Requirement addRequirement(Requirement requirement){
        //add requirement
        requirementMapper.insert(requirement);
        return requirement;
    }

    public Requirement updateRequirement(Requirement requirement){
        //update requirement
        requirementMapper.updateById(requirement);
        return requirement;
    }

}
