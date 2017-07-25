package com.llahn.common.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.llahn.common.utils.FileUtil;

public class BaseController {
	protected static final String SUCCESS = "SUCCESS";
	protected static final String ERROR = "ERROR";

	protected static final String REDIRECT = "redirect:";
	protected static final String FORWARD = "forward:";

	/** 
	 * @Title: renderFile 
	 * @Description: 返回前台文件流
	 * @param @param fileName
	 * @param @param filePath
	 * @param @return    参数 
	 * @return ResponseEntity<byte[]>    返回类型 
	 * @throws 
	 */ 
	protected ResponseEntity<byte[]> renderFile(String fileName, String filePath) {
		byte[] bytes = FileUtil.toByteArray(filePath);
		return renderFile(fileName, bytes);
	}

	/**
	 * @Title: renderFile @Description: 返回前台文件流 @param @param
	 * fileName @param @param fileBytes @param @return 参数 @return
	 * ResponseEntity<byte[]> 返回类型 @throws
	 */
	protected ResponseEntity<byte[]> renderFile(String fileName, byte[] fileBytes) {
		String dfileName = null;
		try {
			dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", dfileName);
		return new ResponseEntity<byte[]>(fileBytes, headers, HttpStatus.CREATED);
	}
}
