package com.zhong.kite.dao;

import com.zhong.kite.model.HaPreclaimAttachment;

public interface HaPreclaimAttachmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ha_preclaim_attachment
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ha_preclaim_attachment
     *
     * @mbggenerated
     */
    int insert(HaPreclaimAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ha_preclaim_attachment
     *
     * @mbggenerated
     */
    int insertSelective(HaPreclaimAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ha_preclaim_attachment
     *
     * @mbggenerated
     */
    HaPreclaimAttachment selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ha_preclaim_attachment
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(HaPreclaimAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ha_preclaim_attachment
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(HaPreclaimAttachment record);
}