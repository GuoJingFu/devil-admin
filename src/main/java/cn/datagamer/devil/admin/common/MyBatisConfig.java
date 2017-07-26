package cn.datagamer.devil.admin.common;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * Mybatis配置
 * @author Devil
 * @mail 562157205@qq.com
 * @date 2017年7月5日 上午9:44:39
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages="cn.datagamer.devil.admin.mapper")
public class MyBatisConfig {
    
    @Autowired
    private Environment env;
    
    /**
     * 创建数据源
     */
    @Bean
    public DataSource getDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("jdbc.driverClassName"));
        props.put("url", env.getProperty("jdbc.url"));
        props.put("username", env.getProperty("jdbc.username"));
        props.put("password", env.getProperty("jdbc.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }
    
    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(env.getProperty("mybatis.config-locations")));
        fb.setDataSource(ds); //指定数据源
        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage")); //指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));  //指定xml文件位置
        return fb.getObject();
    }
    
}
