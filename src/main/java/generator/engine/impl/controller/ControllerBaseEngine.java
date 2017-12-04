package generator.engine.impl.controller;

import freemarker.template.TemplateExceptionHandler;
import generator.engine.Engine;
import generator.parameter.SystemParameters;
import generator.parameter.UserParameters;
import generator.utils.TextUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangh09 on 2017/6/30.
 */
public class ControllerBaseEngine implements Engine {
    private static final String TEMPLATE_FILE_PATH = SystemParameters.CUR_PROJECT_PATH + "/src/main/resources/templates";

    private static freemarker.template.Configuration getConfiguration() throws IOException {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return cfg;
    }

    public static void generateForModel(String innerPath, String microService, String subUrl, String upperCaseModel, boolean isUUID) {
//****************************************************************
        try {
            String lowerCaseModel = TextUtils.upperToLowerBegin(upperCaseModel);
            freemarker.template.Configuration cfg = getConfiguration();
            String microServicePath = StringUtils.isEmpty(microService) ? "" : microService + "/";

            Map<String, Object> data = new HashMap<>();
            data.put("date", new Date().toString());
            data.put("author", UserParameters.getAuthor());
            data.put("modelNameUpperCamel", upperCaseModel);
            data.put("modelNameLowerCamel", TextUtils.upperToLowerBegin(upperCaseModel));
            data.put("packageName", UserParameters.getPackageName() + "." + SystemParameters.SERVICE_PACKAGE_NAME
                    /*+(StringUtils.isEmpty(microService) ? "" : "." + microService)*/
            );
            data.put("basePackageName", UserParameters.getPackageName());
            data.put("utilsPackageName", UserParameters.getPackageName() + "." + SystemParameters.UTILS_PACKAGE_NAME);
            data.put("mapperPackageName", UserParameters.getPackageName() + "." + SystemParameters.MAPPER_PACKAGE_NAME);

            File file = new File(SystemParameters.DEST_PROJECT_PATH + SystemParameters.JAVA_PATH + TextUtils.packageConvertPath(UserParameters.getPackageName()) +
                    "/" + SystemParameters.SERVICE_PACKAGE_NAME + "/"  + upperCaseModel + "Service.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (isUUID)
                cfg.getTemplate("service/uuidService.ftl").process(data, new FileWriter(file));
            else
                cfg.getTemplate("service/service.ftl").process(data, new FileWriter(file));

            data.clear();
            data.put("date", new Date().toString());
            data.put("author", UserParameters.getAuthor());
            data.put("baseRequestMapping", (StringUtils.isEmpty(innerPath) ? "" : "/" + innerPath)
                   /* +(StringUtils.isEmpty(microService) ? "" : "/" + microService + "-service") */
                    + "/" + subUrl);
            data.put("modelNameUpperCamel", upperCaseModel);
            data.put("modelNameLowerCamel", lowerCaseModel);
            data.put("packageName", UserParameters.getPackageName() + "." + SystemParameters.CONTROLLER_PACKAGE_NAME
                   /* +(StringUtils.isEmpty(microService) ? "" : "." + microService)*/
            );
            data.put("basePackageName", UserParameters.getPackageName());
            data.put("utilsPackageName", UserParameters.getPackageName() + "." + SystemParameters.UTILS_PACKAGE_NAME);
            data.put("servicePackageName", UserParameters.getPackageName() + "." + SystemParameters.SERVICE_PACKAGE_NAME
                /*    +(StringUtils.isEmpty(microService) ? "" : "." + microService)*/
            );

            file = new File(SystemParameters.DEST_PROJECT_PATH + SystemParameters.JAVA_PATH + TextUtils.packageConvertPath(UserParameters.getPackageName()) +
                    "/" + SystemParameters.CONTROLLER_PACKAGE_NAME + "/"  + upperCaseModel + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (isUUID)
                cfg.getTemplate("controller/uuidController.ftl").process(data, new FileWriter(file));
            else
                cfg.getTemplate("controller/controller.ftl").process(data, new FileWriter(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generateInfoController() {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", new Date().toString());
            data.put("author", UserParameters.getAuthor());
            data.put("packageName", UserParameters.getPackageName() + "." + SystemParameters.CONTROLLER_PACKAGE_NAME);
            data.put("utilsPackageName", UserParameters.getPackageName() + "." + SystemParameters.UTILS_PACKAGE_NAME);
            File file = new File(SystemParameters.DEST_PROJECT_PATH + SystemParameters.JAVA_PATH + TextUtils.packageConvertPath(UserParameters.getPackageName()) +
                    "/" + SystemParameters.CONTROLLER_PACKAGE_NAME + "/InfoController.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("controller/InfoController.ftl").process(data,
                    new FileWriter(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generateForAccount(String innerPath, String microService, String subUrl, String upperCaseModel, String upperRole) {
//****************************************************************
        try {
            String lowerCaseModel = TextUtils.upperToLowerBegin(upperCaseModel);
            String lowerRole = TextUtils.upperToLowerBegin(upperRole);
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", new Date().toString());
            data.put("author", UserParameters.getAuthor());
            data.put("modelNameUpperCamel", upperCaseModel);
            data.put("modelNameLowerCamel", TextUtils.upperToLowerBegin(upperCaseModel));
            data.put("packageName", UserParameters.getPackageName() + "." + SystemParameters.SERVICE_PACKAGE_NAME + "." + microService);
            data.put("basePackageName", UserParameters.getPackageName());
            data.put("utilsPackageName", UserParameters.getPackageName() + "." + SystemParameters.UTILS_PACKAGE_NAME);
            data.put("mapperPackageName", UserParameters.getPackageName() + "." + SystemParameters.MAPPER_PACKAGE_NAME);

            File file = new File(SystemParameters.DEST_PROJECT_PATH + SystemParameters.JAVA_PATH + TextUtils.packageConvertPath(UserParameters.getPackageName()) +
                    "/" + SystemParameters.SERVICE_PACKAGE_NAME + "/" + microService + "/" + upperCaseModel + "Service.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("service/uuidService.ftl").process(data,
                    new FileWriter(file));

            data.clear();
            data.put("date", new Date().toString());
            data.put("author", UserParameters.getAuthor());
            data.put("baseRequestMapping", "/" + innerPath + "/" + microService + "-service/" + subUrl);
            data.put("modelNameUpperCamel", upperCaseModel);
            data.put("modelNameLowerCamel", lowerCaseModel);

            data.put("roleNameUpperCamel", upperRole);
            data.put("roleNameLowerCamel", lowerRole);

            data.put("packageName", UserParameters.getPackageName() + "." + SystemParameters.CONTROLLER_PACKAGE_NAME + "." + microService);
            data.put("basePackageName", UserParameters.getPackageName());
            data.put("utilsPackageName", UserParameters.getPackageName() + "." + SystemParameters.UTILS_PACKAGE_NAME);
            data.put("servicePackageName", UserParameters.getPackageName() + "." + SystemParameters.SERVICE_PACKAGE_NAME + "." + microService);


            file = new File(SystemParameters.DEST_PROJECT_PATH + SystemParameters.JAVA_PATH + TextUtils.packageConvertPath(UserParameters.getPackageName()) +
                    "/" + SystemParameters.CONTROLLER_PACKAGE_NAME + "/" + microService + "/" + upperCaseModel + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("controller/accountController.ftl").process(data,
                    new FileWriter(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void execute() {
        for (int i = 0; i < UserParameters.tableNames.length; i++) {
            for (int j = 0; j < UserParameters.tableNames[i].length; j++) {
                boolean isUUID = UserParameters.tableNames[i][3].equals("3");
                String tableName = UserParameters.tableNames[i][0];
                String microService = UserParameters.tableNames[i][1];
                String subUrl = UserParameters.tableNames[i][2];
                String upperCaseModel = TextUtils.tableNameConvertUpperCamel(tableName);

                generateForModel("", microService, subUrl, upperCaseModel, isUUID);
            }
        }
    }
}
