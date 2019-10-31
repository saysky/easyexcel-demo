package com.liuyanzhao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 言曌
 * @date 2019-10-30 21:01
 */

public interface ContractService {

    List<String> batchImport(MultipartFile file) throws Exception;
}
