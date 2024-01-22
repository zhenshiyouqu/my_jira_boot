package org.example.my_jira_boot.exception;

public class GeneralException extends RuntimeException{
    private MsgEnum msgEnum;

    public GeneralException(MsgEnum msgEnum) {
        super(msgEnum.getDesc());
        this.msgEnum = msgEnum;
    }

}
