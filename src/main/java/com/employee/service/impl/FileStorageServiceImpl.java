package com.employee.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employee.service.FileStorageService;

@Service
public class FileStorageServiceImpl implements FileStorageService {

	@Value("${file.upload-dir}")
	private String fileDirectory;

	@Override
	public String saveFile(MultipartFile file, String path) throws IOException {
		
		if (file == null || file.isEmpty()) {
			throw new FileNotFoundException(" File cannot be empty");
		}

		String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

		Path dirPath = Paths.get(fileDirectory, path);
		try {

			Files.createDirectories(dirPath);
			Path filePath = dirPath.resolve(fileName);
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
			return fileName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IOException("Folder not created");
		}

	}

}
