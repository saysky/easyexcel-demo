package com.liuyanzhao.dto;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 言曌
 * @date 2019-10-30 21:19
 */
@Data
public class ContractExcel extends BaseRowModel {

    /**
     * 合同编码
     */
    @ExcelProperty(value = "合同编号", index = 0)
    private String contractCode;

    /**
     * 合同签订日期
     */
    @ExcelProperty(value = "合同签订日期", index = 1, format = "yyyy/MM/dd")
    private Date singDate;
    /**
     * 资金类型
     */
    @ExcelProperty(value = "资金类型", index = 2)
    private String fundsType;

    /**
     * 甲方企业（融资企业）
     */
    @ExcelProperty(value = "融资企业", index = 3)
    private String enterpriseName;

    /**
     * 甲方统一社会信用代码
     */
    @ExcelProperty(value = "甲方统一社会信用代码", index = 4)
    private String creditCode;

    /**
     * 乙方企业名称 （下游企业）
     */
    @ExcelProperty(value = "乙方企业名称", index = 5)
    private String partEnterpriseName;
    /**
     * 统一社会信用代码
     */
    @ExcelProperty(value = "乙方统一社会信用代码", index = 6)
    private String partCreditCode;
    /**
     * 项目金额
     */
    @ExcelProperty(value = "项目金额", index = 7)
    private BigDecimal totalAmount;
    /**
     * 项目总吨位
     */
    @ExcelProperty(value = "项目总吨位", index = 8)
    private BigDecimal totalWeight;
    /**
     * 约定对账日
     */
    @ExcelProperty(value = "约定对账日", index = 9, format = "yyyy/MM/dd")
    private Date reconciliationDay;
    /**
     * 付款方式
     */
    @ExcelProperty(value = "付款方式", index = 10)
    private String payment;
    /**
     * 支付比例
     */
    @ExcelProperty(value = "支付比例", index = 11)
    private String paymentRatio;
    /**
     * 合同影像文件地址
     */
    @ExcelProperty(value = "合同影像文件地址", index = 12)
    private String contractFile;

}
