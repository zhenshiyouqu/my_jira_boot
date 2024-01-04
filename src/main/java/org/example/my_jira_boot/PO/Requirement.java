package org.example.my_jira_boot.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.sql.Date;

@Data
@Builder
@TableName("requirement")
public class Requirement {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String requirement_name;

    private Integer detailId;

    private Integer ownerId;

    private String status;


    private Date dueDate;


    private String priority;

    private Date createTime;

    private Date last_updated_time;

    private String last_update;

}