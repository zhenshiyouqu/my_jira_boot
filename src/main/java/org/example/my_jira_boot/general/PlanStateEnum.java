package org.example.my_jira_boot.general;

public enum PlanStateEnum {
//表示计划的几个状态open inProgress done closed
    OPEN("open"),
    IN_PROGRESS("inProgress"),
    DONE("done"),
    CLOSED("closed");

    public final String state;
    PlanStateEnum(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
