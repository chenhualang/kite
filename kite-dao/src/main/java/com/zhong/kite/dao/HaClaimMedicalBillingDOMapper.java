package com.zhong.kite.dao;

import com.zhong.kite.model.HaClaimMedicalBillingDO;

public interface HaClaimMedicalBillingDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ha_claim_medical_billing
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ha_claim_medical_billing
     *
     * @mbggenerated
     */
    int insert(HaClaimMedicalBillingDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ha_claim_medical_billing
     *
     * @mbggenerated
     */
    int insertSelective(HaClaimMedicalBillingDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ha_claim_medical_billing
     *
     * @mbggenerated
     */
    HaClaimMedicalBillingDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ha_claim_medical_billing
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(HaClaimMedicalBillingDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ha_claim_medical_billing
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(HaClaimMedicalBillingDO record);
}