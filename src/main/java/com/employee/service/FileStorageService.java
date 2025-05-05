package com.employee.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

	String saveFile(MultipartFile file , String path) throws Exception;
}
