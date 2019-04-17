package com.tujietg.gradpro.mapper;

import com.tujietg.gradpro.pojo.OrderQuestionsReply;
import com.tujietg.gradpro.pojo.OrderQuestionsReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderQuestionsReplyMapper {
    int countByExample(OrderQuestionsReplyExample example);

    int deleteByExample(OrderQuestionsReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderQuestionsReply record);

    int insertSelective(OrderQuestionsReply record);

    List<OrderQuestionsReply> selectByExample(OrderQuestionsReplyExample example);

    OrderQuestionsReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderQuestionsReply record, @Param("example") OrderQuestionsReplyExample example);

    int updateByExample(@Param("record") OrderQuestionsReply record, @Param("example") OrderQuestionsReplyExample example);

    int updateByPrimaryKeySelective(OrderQuestionsReply record);

    int updateByPrimaryKey(OrderQuestionsReply record);
}