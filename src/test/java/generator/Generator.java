package generator;

import generator.engine.impl.ORM.MybatisEngine;
import generator.engine.impl.controller.ControllerBaseEngine;
import generator.parameter.SystemParameters;
import generator.parameter.UserParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangh09 on 2017/6/30.
 */
public class Generator {
    static Logger logger = LoggerFactory.getLogger(Generator.class);

    public static void execute() throws Exception {
        //      new SpringCloudBaseEngine().execute();
        new MybatisEngine().execute();
        new ControllerBaseEngine().execute();

        //  new KafkaEngine().execute();
        printlnResult();
    }

    private static void printlnResult() {
        //   DirectoryUtils.readFile(UserParameters.getDestPath());
        logger.info("\n\n");
        logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        logger.info("@      Genarated Successfully !      @");
        logger.info("@            Thank you!              @");
        logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    public static void main(String[] args) throws Exception {
        String author = "hexingfu";
        String dbHost = "192.168.50.103";
        String dbPort = "3306";
        String dbUser = "rtdv";
        String dbPass = "rt123@My156";
        String dbName = "nongyequan";
        String packageName = "com.dakun.jianzhong";
        UserParameters.initParam(author, dbHost, dbUser, dbPass,
                dbName, dbPort, packageName);
        UserParameters.addMicroService("account-service");
        UserParameters.addMicroService("resource-service");
        UserParameters.addMicroService("social-service");
        UserParameters.addMicroService("product-service");
        Generator.execute();
    }
}
