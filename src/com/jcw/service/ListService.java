package com.jcw.service;

import com.jcw.bean.Message;
import com.jcw.dao.MessageDao;

import java.util.List;

/**
 * Created by jiangchangwei on 2017/5/25.
 * 列表相关的业务功能
 */
public class ListService {
    public List<Message> queryMessageList(String command, String description) {
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command, description);
    }

}
