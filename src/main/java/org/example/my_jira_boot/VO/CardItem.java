package org.example.my_jira_boot.VO;


import lombok.Data;

@Data
public class CardItem {
    private String description;
    private Integer linkWorkId;
    private String type;
}