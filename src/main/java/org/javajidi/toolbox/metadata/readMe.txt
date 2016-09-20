获取数据库表信息

示例：
public static void main(String[] arg) {
        DataSource dataSource= DataSourceBuilder.create().driverClassName("com.mysql.jdbc.Driver").url("jdbc:mysql://localhost/kugou_show?autoReconnect=true&characterEncoding=utf-8").username("root").password("root").build();
        JdbcMetaDataFetcher fetcher=new JdbcMetaDataFetcher(dataSource);
        System.out.println(fetcher.getAllTables());
    }