import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class demo01 {
    private static Logger logger = LoggerFactory.getLogger(demo01.class);
    public static void main(String[] args) {
        //通过硬编码的方式配置DruidDataSource
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.91.188:3306/wulin?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("OS6t3gNVw/cMJzLvwBcpteUA338vz/caDgBORuN4UDE3eu+a+fj+Su5x3NtSmXiF6UddYclxjKMwtcwMsesPfg==");
        dataSource.setMaxActive(20); //最大连接数
        dataSource.setInitialSize(5); //初始化连接数
        dataSource.setMinIdle(10);  //最小空闲数
        try {
            dataSource.setFilters("config,stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dataSource.setConnectionProperties("config.decrypt=true;config.decrypt.key=MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAInW36sLDZWKhh599ijWlQqH3fEaqhLG+VcNWQJikTLK5OLM3TpsB/e3VxdMRJs541IaN+Yb9LTALW8G/ns8qIkCAwEAAQ==");


        //通过数据库连接池获取连接
        try {
            System.out.println(dataSource.getUsername() );
            System.out.println(dataSource.getPassword() );

            Connection connection = dataSource.getConnection();
            logger.debug("getConnectCount:" + String.valueOf(dataSource.getConnectCount()));
            logger.debug("getPoolingCount:" + String.valueOf(dataSource.getPoolingCount()));
            logger.debug("getActiveCount:" + String.valueOf(dataSource.getActiveCount()));

            System.out.println(connection != null);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
