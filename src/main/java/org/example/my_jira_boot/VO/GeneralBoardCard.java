package org.example.my_jira_boot.VO;

import lombok.Data;

import java.util.List;
@Data
public class GeneralBoardCard {
    private String title;
    private List<CardItem> cardItems;
}


@Data
class CardItem {
    private String description;
    private Integer linkWorkId;
    private String type;
}