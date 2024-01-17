package org.example.my_jira_boot.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("requirement_user")
@Data
public class RequirementUser {
    @TableId
    private Integer id;
    private Integer requirementId;
    private Integer userId;
    private String role;
    private String createTime;
    private String updateTime;
}
