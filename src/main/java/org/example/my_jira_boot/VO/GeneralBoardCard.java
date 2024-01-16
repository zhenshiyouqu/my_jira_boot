package org.example.my_jira_boot.VO;

import lombok.Data;

import java.util.List;
@Data
public class GeneralBoardCard {
    private String title;
    private List<cardItem> cardItems;
}


@Data
class cardItem {
    private String description;
    private Integer linkWorkId;
    private String type;
}