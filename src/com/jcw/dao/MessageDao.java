package com.jcw.dao;

import com.jcw.bean.Message;
import com.jcw.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.description;

/**
 * Created by jiangchangwei on 2017/5/25.
 */
public class MessageDao {
    /**
     * 根据查询条件查询消息列表
     */
//    public List<Message> queryMessageList(String command, String description) {
//        List<Message> messageList = new ArrayList<Message>();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message?useUnicode=true&useCharacterEncoding=UTF8", "jcw-testing", "jcw-testing");
//            StringBuilder s = new StringBuilder("select id, command, description, content from message where 1 = 1 ");
//            List<String> paramList = new ArrayList<String>();
//            if(command != null && !"".equals(command.trim())) {
//                s.append(" and command=?");
//                paramList.add(command);
//            }
//
//            if(description != null && !"".equals(description.trim())) {
//                s.append(" and description like ?");
//                paramList.add("%" + description + "%");
//            }
//            System.out.println(s.toString());
//            PreparedStatement statment = conn.prepareStatement(s.toString());
//            for(int i = 0; i < paramList.size(); i++) {
//                statment.setString(i+1, paramList.get(i));
//            }
//            ResultSet rs = statment.executeQuery();
//            messageList = new ArrayList<Message>();
//            while(rs.next()) {
//                Message message = new Message();
//                messageList.add(message);
//                message.setId(rs.getInt("id"));
//                message.setCommand(rs.getString("command"));
//                message.setDescription(rs.getString("description"));
//                message.setContent(rs.getString("content"));
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return messageList;
//    }

    public List<Message> queryMessageList(String command, String description) {
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList = new ArrayList<Message>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            messageList = sqlSession.selectList("Message.queryMessageList",message);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return messageList;
    }

    public void deleteOne(int id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Message.deleteOne",id);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

    public void deleteBatch(List<Integer> ids) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Message.deleteBatch",ids);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

    public static void main(String[] args) {
        MessageDao messageDao = new MessageDao();
        messageDao.queryMessageList("", "");
    }
}
