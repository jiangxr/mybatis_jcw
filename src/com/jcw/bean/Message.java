package com.jcw.bean;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * Created by jiangchangwei on 2017/5/24.
 * 与消息表对应的实体类
 */
public class Message {
    private int id;
    private String command;
    private String description;
    private String content;


    public Message() {
    }

    public Message(int id, String command, String description, String content) {
        this.id = id;
        this.command = command;
        this.description = description;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
