package com.liuyanzhao.config.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExcelListener extends AnalysisEventListener {
    private List<Object> datas = new ArrayList<Object>();

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
        datas.add(o);
        //根据自己业务做处理
        doSomething(o);
    }

    private void doSomething(Object object) {
        //1、入库调用接口
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // datas.clear();//解析结束销毁不用的资源
    }
}
