package org.example.my_jira_boot.general;

import lombok.*;

@Data
public class Result<T>{
    private Integer code;
    private String msg;
    private T data;
}
