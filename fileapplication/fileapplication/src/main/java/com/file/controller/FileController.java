package com.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.file.entity.File;
import com.file.exception.FileNotFoundException;
import com.file.exception.FileStorageException;
import com.file.output.FileResponse;
import com.file.service.DownloadFileSerevice;
import com.file.service.UploadFileService;

@CrossOrigin(maxAge = 3600)
@RestController
public class FileController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(FileController.class);

	@Autowired
	private UploadFileService uploadService;

	@Autowired
	private DownloadFileSerevice downService;

	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable int fileId) throws FileNotFoundException {
		File fileDown = downService.getFile(fileId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileDown.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDown.getFileName() + "\"")
				.body(new ByteArrayResource(fileDown.getData()));
	}

	@PostMapping("/uploadFile")
	public FileResponse uploadFile(@RequestParam("file") MultipartFile file) throws FileStorageException {
		File fileStore = uploadService.storeFile((MultipartFile) file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/{fileId}")
				.buildAndExpand(fileStore.getId()).toUriString();

		return new FileResponse(fileStore.getFileName(), fileDownloadUri, file.getContentType());
	}

}
