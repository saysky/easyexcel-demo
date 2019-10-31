package com.liuyanzhao.service.impl;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.liuyanzhao.config.excel.ExcelListener;
import com.liuyanzhao.dto.ContractExcel;
import com.liuyanzhao.entity.ContractEntity;
import com.liuyanzhao.service.ContractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Slf4j
@Service
public class ContractServiceImpl implements ContractService {


    @Override
    public List<String> batchImport(MultipartFile file) throws Exception {
        //错误信息列表
        List<String> errorMsgList = new ArrayList<>();

        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        InputStream inputStream = file.getInputStream();
        ExcelListener listener = new ExcelListener();

        ExcelReader excelReader;
        if (".xlsx".equalsIgnoreCase(suffix)) {
            excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, listener);
        } else {
            excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, listener);
        }

        //读取信息
        excelReader.read(new Sheet(1, 1, ContractExcel.class));

        //获取数据
        List<Object> list = listener.getDatas();

        //如果数据为空
        if (list == null || list.size() == 0) {
            errorMsgList.add("请填写数据");
            return errorMsgList;
        }
        List<ContractEntity> contractEntityList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ContractExcel contractExcel = (ContractExcel) list.get(i);
            //1.检查字段
            errorMsgList = check(errorMsgList, contractExcel, (i + 1));
            if (errorMsgList != null && errorMsgList.size() > 0) {
                return errorMsgList;
            }

            //2.将contractExcel拷贝到contractEntity
            ContractEntity contractEntity = new ContractEntity();
            BeanUtils.copyProperties(contractExcel, contractEntity);
            contractEntity.setId(UUID.randomUUID().toString());
            contractEntityList.add(contractEntity);
        }

        //数据库操作：批量插入
        //TODO
        System.out.println(contractEntityList);

        return errorMsgList;
    }

    /**
     * 检查字段
     * @param errorMsgList
     * @param contractExcel
     * @param lineNum 行号
     * @return
     */
    private List<String> check(List<String> errorMsgList, ContractExcel contractExcel, int lineNum) {
        if (contractExcel != null) {
            //举例
            if (contractExcel.getContractCode() == null || "".equals(contractExcel.getContractCode())) {
                errorMsgList.add("第" + lineNum + "行合同编号为空");
            }
            if (contractExcel.getSingDate() == null || "".equals(contractExcel.getSingDate())) {
                errorMsgList.add("第" + lineNum + "行签订日期为空");
            }
            //等等...
            //TODO
        }
        return errorMsgList;
    }


}
