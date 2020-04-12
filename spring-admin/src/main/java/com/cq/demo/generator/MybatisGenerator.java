package com.cq.demo.generator;




public class MybatisGenerator {
    /** MySQL 生成演示 */
    public static void main(String[] args) {

       /* AutoGenerator mpg = new AutoGenerator();
        // 全局配置

        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("E://inputClass"); // 输出文件路径
        gc.setFileOverride(true);
        gc.setActiveRecord(false); // 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false); // XML 二级缓存
        gc.setBaseResultMap(true); // XML ResultMap
        gc.setBaseColumnList(false); // XML columList
        gc.setAuthor("chenqu"); // 作者

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://192.168.31.187:3306/demo?useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8");
        mpg.setDataSource(dsc);

        // 策略配置

        StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix(new String[] { "sys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel); // 表名生成策略
        strategy.setInclude(new String[]{"sys_dept","sys_dict","sys_log","sys_menu","sys_role","sys_role_dept","sys_role_menu","sys_user_role","sys_user_token"}); // 需要生成的表

        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.cq.demo");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();*/
    }
}
