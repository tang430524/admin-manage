package org.javajidi.toolbox.metadata;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

/**
 * @author qiang.xie
 * @date 2016/9/20
 */
public class Test {

    public static void main(String[] arg) {
        DataSource dataSource= DataSourceBuilder.create().driverClassName("com.mysql.jdbc.Driver").url("jdbc:mysql://localhost/kugou_show?autoReconnect=true&characterEncoding=utf-8").username("root").password("root").build();
        JdbcMetaDataFetcher fetcher=new JdbcMetaDataFetcher(dataSource);
        System.out.println(fetcher.getAllTables());
    }
}
