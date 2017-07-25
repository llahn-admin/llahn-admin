package com.llahn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
 * @ClassName: LlahnApplication 
 * @Description: SpringBoot官方启动方式
 * @company HPE  
 * @author lilei   
 * @date 2017年7月24日 下午3:05:38 
 *  
 */ 
@SpringBootApplication
public class LlahnApplication {
	protected final static Logger logger = LoggerFactory.getLogger(LlahnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LlahnApplication.class, args);
		logger.info("GunsApplication is sussess!");
	}
}
