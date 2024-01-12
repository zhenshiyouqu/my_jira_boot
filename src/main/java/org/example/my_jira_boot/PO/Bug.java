package org.example.my_jira_boot.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@TableName("bug")
public class Bug {
    @TableId
    private Integer id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private String damage;
    private Integer creatorId;
    private Integer relavantId;
    private String createTime;
    private String updateTime;
    private String resolution;
    private Integer commentsId;
    private Integer requirementId;
    private String env;
    private String version;
    private String relatedIssues;
    private Integer processorId;
    private Integer identifierId;
}