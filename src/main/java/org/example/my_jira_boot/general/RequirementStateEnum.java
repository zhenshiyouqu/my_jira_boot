package org.example.my_jira_boot.general;

public enum RequirementStateEnum {
    //表示需求的几个状态open,viewing,developing,testing,online
    OPEN("open"),
    VIEWING("viewing"),
    DEVELOPING("developing"),
    TESTING("testing"),
    ONLINE("online");

    private String state;

    RequirementStateEnum(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
