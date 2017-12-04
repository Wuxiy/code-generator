package generator.parameter;

/**
 * Created by wangh09 on 2017/7/3.
 */
public class SystemParameters {
    //目标项目在硬盘上的基础路径,运行前请务必修改DEST_PROJECT_PATH为实际值
    public static String DEST_PROJECT_PATH = "D:\\workspace\\zuannong\\social-service";

    //当前项目在硬盘上的基础路径，如果当前项目作为一个module被引入到其他项目时，请将该参数修改为实际值
    public static String CUR_PROJECT_PATH = System.getProperty("user.dir");

    public static final String JAVA_PATH = "/src/main/java";
    public static final String RESOURCE_PATH = "/src/main/resources";
    public static final String CONTROLLER_PACKAGE_NAME = "controller";
    public static final String MODEL_PACKAGE_NAME = "model";
    public static final String MAPPER_PACKAGE_NAME = "mapper";
    public static final String SERVICE_PACKAGE_NAME = "service";
    public static final String FILTER_PACKAGE_NAME = "filter";
    public static final String UTILS_PACKAGE_NAME = "utils";
    public static final String CONFIG_PACKAGE_NAME = "config";
    public static final String MESSAGE_QUEUE_PACKAGE_NAME = "mq";
    public static final String JDBC_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    public static final String INNER_PATH = "remove-me";

    public static final String MAPPER_INTERFACE_REFERENCE = UserParameters.getPackageName() + "."+UTILS_PACKAGE_NAME+".Mapper";

}
