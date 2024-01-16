package org.example.my_jira_boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.my_jira_boot.PO.Plan;
import org.example.my_jira_boot.mapper.PlanMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlanService {
    @Resource
    private PlanMapper planMapper;

    //添加get add update delete Plan的方法
    public List<Plan> getPlan(Integer creatorId){
        List<Plan> creatorId1 = planMapper.selectList(
                new QueryWrapper<Plan>().eq("creator_id", creatorId)
        );
        return creatorId1;

    }

    public void addPlan(Plan plan){
        planMapper.insert(plan);
    }

    public void updatePlan(Plan plan){
        planMapper.updateById(plan);
    }

    public void deletePlan(Plan plan){
        planMapper.deleteById(plan);
    }


}
