package org.example.my_jira_boot.general;

public enum BugStateEnum {
//表示缺陷的几个状态open fixed verified closed
    OPEN("open"),
    FIXED("fixed"),
    VERIFIED("verified"),
    CLOSED("closed");

    public final String state;
    BugStateEnum(String state) {
        this.state = state;
    }
}
