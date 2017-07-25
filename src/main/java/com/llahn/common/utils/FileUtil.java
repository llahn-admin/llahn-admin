package com.llahn.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.log4j.Logger;

import com.llahn.common.exception.BizExceptionEnum;
import com.llahn.common.exception.BussinessException;


public class FileUtil {
	private static Logger log = Logger.getLogger(FileUtil.class);
	
	public static byte[] toByteArray(String filename) {

		File f = new File(filename);
		if (!f.exists()) {
			log.error("文件未找到！" + filename);
			throw new BussinessException(BizExceptionEnum.FILE_NOT_FOUND);
		}
		FileChannel channel = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(f);
			channel = fs.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
			while ((channel.read(byteBuffer)) > 0) {
				// do nothing
				// System.out.println("reading");
			}
			return byteBuffer.array();
		} catch (IOException e) {
			throw new BussinessException(BizExceptionEnum.FILE_READING_ERROR);
		} finally {
			try {
				channel.close();
			} catch (IOException e) {
				throw new BussinessException(BizExceptionEnum.FILE_READING_ERROR);
			}
			try {
				fs.close();
			} catch (IOException e) {
				throw new BussinessException(BizExceptionEnum.FILE_READING_ERROR);
			}
		}
	}
}
