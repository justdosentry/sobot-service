package com.iqianjin.sobotservice.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGE,sqlSessionFactoryRef = "SobotSqlSessionFactory")
public class DataSourceConfig {

  static final String PACKAGE = "com.iqianjin.sobotservice.dao";
  static final String MAPPER_LOCATION = "classpath*:mapper/*.xml";

  @Value("${spring.datasource.driverClassName}")
  private String driverClass;

  @Value("${spring.datasource.url}")
  private String url;

  @Value("${spring.datasource.username}")
  private String user;

  @Value("${spring.datasource.password}")
  private String password;

  @Bean(name = "SobotDataSource")
  @Primary
  public DataSource SobotDataSource() {
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setDriverClassName(driverClass);
    dataSource.setUrl(url);
    dataSource.setUsername(user);
    dataSource.setPassword(password);
    return dataSource;
  }

  @Bean(name = "SobotTransactionManager")
  @Primary
  public DataSourceTransactionManager SobotTransactionManager() {
    return new DataSourceTransactionManager(SobotDataSource());
  }

  @Bean(name = "SobotSqlSessionFactory")
  @Primary
  public SqlSessionFactory SobotSqlSessionFactory(@Qualifier("SobotDataSource") DataSource SobotDataSource) throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(SobotDataSource);
    sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceConfig.MAPPER_LOCATION));
    sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
    return sessionFactory.getObject();
  }

}
