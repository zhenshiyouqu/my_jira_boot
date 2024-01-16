package org.example.my_jira_boot.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


// {
//        title: 'Ant Design Title 1',
//        description: 'Ant Design Description 1',
//        linkWork: 'Ant Design LinkWork 1',
//        expectedDateFrom: '2024-01-30',
//        expectedDateTo: '2024-01-30',
//        actualDateFrom: '2024-02-30',
//        actualDateTo: '2024-03-30',
//        expectedDays: '30',
//        actualDays: '15',
//        principal: 'Bob Lee',
//        creator: 'Ant Design Creator 1',
//        status: 'Ant Design Status 1',
//        tags: ['nice', 'developer']
//    },
@Data
@TableName("plan")
public class Plan {
    @TableId
    private Integer id;
    private String title;
    private String description;
    private String linkWorkId;
    private String linkWorkType;
    private Date expectedDateFrom;
    private Date expectedDateTo;
    private Date actualDateFrom;
    private Date actualDateTo;
    private Integer expectedDays;
    private Integer actualDays;
    private String principalId;
    private String creatorId;
    private String status;
    private String tags;
    private Date createDate;
    private Date lastUpdateDate;
}
