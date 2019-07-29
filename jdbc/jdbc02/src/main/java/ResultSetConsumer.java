import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 处理ResultSet结果集的实现
 */
public interface ResultSetConsumer<T> {
    //处理ResultSet的方法
    T apply(ResultSet resultSet) throws SQLException;

    //获取实现
    void accept(T t);
}
