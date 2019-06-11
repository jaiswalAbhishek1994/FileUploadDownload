package com.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.file.entity.File;
import com.file.exception.FileNotFoundException;
import com.file.repository.FileRepository;

@Service
public class DownloadFileSerevice {

	@Autowired
	private FileRepository dbFileRepository;

	public File getFile(int fileId) throws FileNotFoundException {
		return dbFileRepository.findById(fileId)
				.orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
	}
}
