package com.llahn.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

import com.llahn.common.properties.DruidProperties;

/** 
 * @ClassName: MybatisConfig 
 * @Description: mybatis配置
 * @company HPE  
 * @author lilei   
 * @date 2017年7月24日 下午5:09:53 
 *  
 */ 
@Configuration
@MapperScan(basePackages = {"com.llahn.common.persistence.dao","com.llahn.*.dao"})
public class MybatisConfig {
	@Autowired
    DruidProperties druidProperties;

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
        return paginationInterceptor;
    }

    /**
     * druid数据库连接池
     */
    @Bean(initMethod = "init")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.coinfig(dataSource);
        return dataSource;
    }
}
