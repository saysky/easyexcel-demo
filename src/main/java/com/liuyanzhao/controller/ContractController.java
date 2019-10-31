package com.liuyanzhao.controller;

import com.liuyanzhao.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/scm/contract/")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping("import")
    public List<String> batchImport(@RequestParam("file") MultipartFile file) {
        List<String> errorMsg = new ArrayList<>();
        try {
            errorMsg = contractService.batchImport(file);
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
        }
        return errorMsg;
    }
}
