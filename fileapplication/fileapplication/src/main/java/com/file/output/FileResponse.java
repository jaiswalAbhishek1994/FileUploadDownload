package com.file.output;

/**
 * @author Abhishek.Jaiswal
 *
 */
public class FileResponse {

	private String fileName;

	private String location;

	private String contentType;

	public FileResponse() {
	}

	public FileResponse(String fileName, String location, String contentType) {
		super();
		this.fileName = fileName;
		this.location = location;
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "UploadFileResponse [fileName=" + fileName + ", location=" + location + ", contentType=" + contentType
				+ "]";
	}

}
