package org.example.my_jira_boot.PO;

import lombok.Data;

import java.sql.Date;
@Data
public class Bug {
    private Integer id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private String severity;
    private Integer creator_id;
    private Integer relavant_id;
    private String resolution;
    private String attachments;
    private Integer comments_id;
    private Integer requirement_id;
    private String environment;
    private String version;
    private String related_issues;
    private Date create_time;
    private Date update_time;
}
