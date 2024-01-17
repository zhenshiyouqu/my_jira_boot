package org.example.my_jira_boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.my_jira_boot.PO.Bug;
import org.example.my_jira_boot.PO.Plan;
import org.example.my_jira_boot.PO.Requirement;
import org.example.my_jira_boot.PO.RequirementUser;
import org.example.my_jira_boot.VO.GeneralBoardCard;
import org.example.my_jira_boot.mapper.BugMapper;
import org.example.my_jira_boot.mapper.PlanMapper;
import org.example.my_jira_boot.mapper.RequirementMapper;
import org.example.my_jira_boot.mapper.RequirementUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneralBoardService {

    @Resource
    private BugMapper bugMapper;
    @Resource
    private PlanMapper planMapper;
    @Resource
    private RequirementMapper requirementMapper;
    @Resource
    private RequirementUserMapper requirementUserMapper;

    //从Bug、Plan、requirement表中查出userid对应的所有记录，然后组装成GeneralBoardCard的列表返回
    public List<GeneralBoardCard>  getCardList(Integer userId){
        //processor_id或identifier_id匹配
        List<Bug> bugs = bugMapper.selectList(new QueryWrapper<Bug>()
        .eq("processor_id", userId)
                .or()
                .eq("identifier_id", userId)
        );
        //principal_id匹配
        List<Plan> plans = planMapper.selectList(new QueryWrapper<Plan>().eq(
                "principal_id", userId
        ));
        //根据user_id
        List<RequirementUser> requirementUsers = requirementUserMapper.selectList(new QueryWrapper<RequirementUser>()
                .eq("user_id", userId));
        List<Integer>  requirementIds= requirementUsers.stream().map(RequirementUser::getRequirementId).collect(Collectors.toList());

        //根据requirementUsers的requirement_id查出对应的requirement
        List<Requirement> requirements = requirementMapper.selectBatchIds(requirementIds);

        bugs.stream().filter(
                bug -> bug.getProcessorId().equals(userId)
        )

    }


}
