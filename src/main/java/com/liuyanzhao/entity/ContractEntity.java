package com.liuyanzhao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
public class ContractEntity implements Serializable {

    /**
     * 主键uuid
     */
    private String id ;
    /**
     * 合同编码
     */
    private String contractCode ;
    /**
     * 合同签订日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date singDate ;
    /**
     * 资金类型
     */
    private String fundsType ;
    /**
     * 甲方企业id
     */
    private String enterpriseId ;
    /**
     * 甲方企业（融资企业）
     */
    private String enterpriseName ;
    /**
     * 甲方统一社会信用代码
     */
    private String creditCode ;
    /**
     * 乙方企业id
     */
    private String partcreditId;
    /**
     * 乙方企业名称 （下游企业）
     */
    private String partEnterpriseName ;
    /**
     * 统一社会信用代码
     */
    private String partCreditCode ;
    /**
     *  项目金额
     */
    private BigDecimal totalAmount ;
    /**
     *  项目总吨位
     */
    private BigDecimal totalWeight ;
    /**
     * 约定对账日
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date reconciliationDay;
    /**
     * 付款方式
     */
    private String payment;
    /**
     * 付款方式合同原文信息
     */
    private String paymentContent ;
    /**
     * 支付比例
     */
    private String paymentRatio ;
    /**
     * 合同影像文件地址
     */
    private String contractFile ;
    /**
     * 审核意见
     */
    private String auditOpinion ;
    /**
     *  审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date auditDate;
    /**
     * 审核结果1.待审核2.审核中3.审核通过4.驳回
     */
    private String auditResults ;
    /**
     * 创建者
     */
    private String createBy ;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate ;
    /**
     * 修改者
     */
    private String modifyBy ;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyDate;
    /**
     * 删除标志 1未删除 2:已删除
     */
    private String deleteFlag ;
    /**
     * 幂等token
     */
    private String token ;
}
