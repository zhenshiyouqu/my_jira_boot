package org.example.my_jira_boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.my_jira_boot.PO.Bug;
import org.example.my_jira_boot.PO.Plan;
import org.example.my_jira_boot.PO.Requirement;
import org.example.my_jira_boot.PO.RequirementUser;
import org.example.my_jira_boot.VO.CardItem;
import org.example.my_jira_boot.VO.GeneralBoardCard;
import org.example.my_jira_boot.general.BugStateEnum;
import org.example.my_jira_boot.general.PlanStateEnum;
import org.example.my_jira_boot.general.RequirementStateEnum;
import org.example.my_jira_boot.mapper.BugMapper;
import org.example.my_jira_boot.mapper.PlanMapper;
import org.example.my_jira_boot.mapper.RequirementMapper;
import org.example.my_jira_boot.mapper.RequirementUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public List<GeneralBoardCard> getCardList(Integer userId) {
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
        List<Integer> requirementIds = requirementUsers.stream().map(RequirementUser::getRequirementId).collect(Collectors.toList());

        //根据requirementUsers的requirement_id查出对应的requirement
        List<Requirement> requirements = requirementMapper.selectBatchIds(requirementIds);

        ArrayList<CardItem> newCardItems = new ArrayList<>();
        ArrayList<CardItem> inProgressCardItems = new ArrayList<>();
        ArrayList<CardItem> DoneCardItems = new ArrayList<>();

        bugs.stream().filter(
                bug -> BugStateEnum.OPEN.getState().equals(bug.getStatus())
        ).forEach(
                bug -> {
                    CardItem cardItem = new CardItem();
                    cardItem.setType("bug");
                    cardItem.setDescription(bug.getTitle());
                    cardItem.setLinkWorkId(bug.getRelavantId());
                    newCardItems.add(cardItem);
                }
        );


        bugs.stream().filter(
                bug -> BugStateEnum.FIXED.getState().equals(bug.getStatus()) || BugStateEnum.VERIFIED.getState().equals(bug.getStatus())
        ).forEach(
                bug -> {
                    CardItem cardItem = new CardItem();
                    cardItem.setType("bug");
                    cardItem.setDescription(bug.getTitle());
                    cardItem.setLinkWorkId(bug.getRelavantId());
                    inProgressCardItems.add(cardItem);
                }
        );

        bugs.stream().filter(
                bug -> BugStateEnum.CLOSED.getState().equals(bug.getStatus())
        ).forEach(
                bug -> {
                    CardItem cardItem = new CardItem();
                    cardItem.setType("bug");
                    cardItem.setDescription(bug.getTitle());
                    cardItem.setLinkWorkId(bug.getRelavantId());
                    DoneCardItems.add(cardItem);
                }
        );

        plans.stream().filter(
                plan -> PlanStateEnum.OPEN.getState().equals(plan.getStatus())
        ).forEach(
                plan -> {
                    CardItem cardItem = new CardItem();
                    cardItem.setType("plan");
                    cardItem.setDescription(plan.getTitle());
                    cardItem.setLinkWorkId(plan.getLinkWorkId());
                    newCardItems.add(cardItem);
                }
        );

        plans.stream().filter(
                plan -> PlanStateEnum.IN_PROGRESS.getState().equals(plan.getStatus())
        ).forEach(
                plan -> {
                    CardItem cardItem = new CardItem();
                    cardItem.setType("plan");
                    cardItem.setDescription(plan.getTitle());
                    cardItem.setLinkWorkId(plan.getLinkWorkId());
                    inProgressCardItems.add(cardItem);
                }
        );

        plans.stream().filter(
                plan -> PlanStateEnum.DONE.getState().equals(plan.getStatus()) || PlanStateEnum.CLOSED.getState().equals(plan.getStatus())
        ).forEach(
                plan -> {
                    CardItem cardItem = new CardItem();
                    cardItem.setType("plan");
                    cardItem.setDescription(plan.getTitle());
                    cardItem.setLinkWorkId(plan.getLinkWorkId());
                    DoneCardItems.add(cardItem);
                }
        );

        requirements.stream().filter(
                requirement -> RequirementStateEnum.OPEN.getState().equals(requirement.getStatus())
        ).forEach(
                requirement -> {
                    CardItem cardItem = new CardItem();
                    cardItem.setType("requirement");
                    cardItem.setDescription(requirement.getRequirementName());
                    cardItem.setLinkWorkId(requirement.getDetailId());
                    newCardItems.add(cardItem);
                }
        );

        requirements.stream().filter(
                requirement -> RequirementStateEnum.VIEWING.getState().equals(requirement.getStatus()) ||
                        RequirementStateEnum.DEVELOPING.getState().equals(requirement.getStatus()) ||
                        RequirementStateEnum.TESTING.getState().equals(requirement.getStatus())
        ).forEach(
                requirement -> {
                    CardItem cardItem = new CardItem();
                    cardItem.setType("requirement");
                    cardItem.setDescription(requirement.getRequirementName());
                    cardItem.setLinkWorkId(requirement.getDetailId());
                    inProgressCardItems.add(cardItem);
                }
        );
        requirements.stream().filter(
                requirement -> RequirementStateEnum.ONLINE.getState().equals(requirement.getStatus())
        ).forEach(
                requirement -> {
                    CardItem cardItem = new CardItem();
                    cardItem.setType("requirement");
                    cardItem.setDescription(requirement.getRequirementName());
                    cardItem.setLinkWorkId(requirement.getDetailId());
                    DoneCardItems.add(cardItem);
                }
        );

        //组装成GeneralBoardCard的列表返回

        //New的卡片
        GeneralBoardCard bugCard = new GeneralBoardCard();
        bugCard.setTitle("New");
        bugCard.setCardItems(newCardItems);

        //In Progress的卡片
        GeneralBoardCard planCard = new GeneralBoardCard();
        planCard.setTitle("In Progress");
        planCard.setCardItems(inProgressCardItems);

        //Done的卡片
        GeneralBoardCard requirementCard = new GeneralBoardCard();
        requirementCard.setTitle("Done");
        requirementCard.setCardItems(DoneCardItems);
        //Put Off的卡片
        GeneralBoardCard putOffCard = new GeneralBoardCard();
        putOffCard.setTitle("Put Off");
        putOffCard.setCardItems(new ArrayList<>());

        ArrayList<GeneralBoardCard> generalBoardCards = new ArrayList<>();
        generalBoardCards.add(bugCard);
        generalBoardCards.add(planCard);
        generalBoardCards.add(requirementCard);
        generalBoardCards.add(putOffCard);
        return generalBoardCards;
    }
}
