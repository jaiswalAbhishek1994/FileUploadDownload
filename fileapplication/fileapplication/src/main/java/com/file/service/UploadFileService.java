package com.file.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.file.entity.File;
import com.file.exception.FileStorageException;
import com.file.repository.FileRepository;

@Service
public class UploadFileService {

	@Autowired
	private FileRepository dbFileRepository;

	public File storeFile(MultipartFile file) throws FileStorageException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			File dbFile = new File(fileName, file.getContentType(), file.getBytes());

			return dbFileRepository.save(dbFile);
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

}
