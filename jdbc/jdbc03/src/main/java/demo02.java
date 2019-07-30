import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class demo02 {
    private static Logger logger = LoggerFactory.getLogger(demo02.class);
    public static void main(String[] args) {
        //读取配置文件的方式建立DruidDataSource
        InputStream resourceAsStream = demo02.class.getResourceAsStream("/jdbc.properties");
        Properties properties = new Properties();
        try {;
            properties.load(resourceAsStream);

            DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            System.out.println(dataSource.getPassword());

            Connection connection = dataSource.getConnection();

            logger.debug("getConnectCount:" + String.valueOf(dataSource.getConnectCount()));
            logger.debug("getPoolingCount:" + String.valueOf(dataSource.getPoolingCount()));
            logger.debug("getActiveCount:" + String.valueOf(dataSource.getActiveCount()));

            System.out.println( connection != null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
