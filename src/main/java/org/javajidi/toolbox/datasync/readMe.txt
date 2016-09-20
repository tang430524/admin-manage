两个数据源之间表同步

示例：
    public static void main(String[] arg) throws Exception{
        DataSource source= DataSourceBuilder.create().driverClassName("com.mysql.jdbc.Driver").url("jdbc:mysql://localhost/b?autoReconnect=true&characterEncoding=utf-8").username("root").password("root").build();

        DataSource dest= DataSourceBuilder.create().driverClassName("com.mysql.jdbc.Driver").url("jdbc:mysql://localhost/a?autoReconnect=true&characterEncoding=utf-8").username("root").password("root").build();
        TableDataSynchronizer tableDataSync=new TableDataSynchronizer(source,dest);
        tableDataSync.syncTable("init_config");//以id为主键
        tableDataSync.syncTable("switch_config", Collections.singletonList("cons_key"));//以cons_key为主键
    }