/**
 * packageName  : com.example.side_api.config.mybatis
 * fileName     : DatabaseConfig
 * author       : SangHoon
 * date         : 2023-10-03
 * description  : Mybatis 설정 파일
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-10-03                SangHoon             최초 생성
 */
package com.example.side_api.config.mybatis;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * The type Database config.
 */
@Configuration
@PropertySource("classpath:application.yml")
@MapperScan(basePackages = "com.example.side_api.sample.out.mapper")
@RequiredArgsConstructor
public class DatabaseConfig {

    private final ApplicationContext context;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage(alias);
        factoryBean.setMapperLocations(context.getResources("classpath:mappers/*.xml"));
        factoryBean.setConfiguration(mybatisConfig());          // MyBatis 옵션을 설정
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /** --------------------------------------------------------------- */
    /** mybatis-config.xml 또는 application.yml 중 설정(상단/하단) */

    /**
     * application.properties 에서 mybatis.configuration 으로 시작하는 모든 설정을 읽어, 빈(Bean)으로 등록
     */
    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration mybatisConfig() {
        return new org.apache.ibatis.session.Configuration();
    }

    /**
     * application.yml 에서 alias 설정을 읽어와 등록
     */
    // @Value("${mybatis.type-aliases-package}")
    private String alias;

}