package generator.parameter;

import java.util.ArrayList;

/**
 * Created by wangh09 on 2017/6/30.
 */
public class UserParameters {
    //1: auto id 2: non-auto id 3: uuid
    //1) 表名 2) service 3) api路径 3) id策略
    public static String[][] tableNames = {
//            {"account_company_page", "account",      "company/page",       "1"},
//            {"social_example",       "social",      "example",       "1"},
//            {"social_example_comment","social",      "example/comment",       "1"},
//            {"social_example_conversation","social",      "example/conversation",       "1"},
//            {"social_example_section","social",      "example/section",       "1"},
//            {"social_example_tag","social",      "example/tag",       "1"}
            /*{"account_message",       "account",    "message",      "3"}*/
            //{"social_tag",       "social",      "tag",       "1"},

//            {"account_user",       "account",      "user",       "1"},
//            {"account_dealer",       "account",    "dealer",      "2"},
//            {"account_expert",       "account",    "expert",      "2"},
//            {"account_follow_user",       "account", "follow",         "3"},
//            {"account_message",       "account",    "message",      "3"},
//            {"account_sms",       "account",        "sms",  "3"},
//            {"account_system_message",       "account",        "message/system",  "1"},
//            {"account_admin_message",       "account",        "message/admin",  "1"},
            //     {"account_admin",       "account",          "1"},

//            {"product_award_record",       "product",  "award",        "1"},
//            {"product_bottle",       "product",        "bottle",  "1"},
//            {"product_catalog",       "product",       "catalog",   "1"},
//            {"product_lottery",       "product",       "lottery",   "1"},
//            {"product_lottery_record",       "product", "lottery/record",         "1"},
//            {"product_lottery_rule",       "product",   "lottery/rule",       "1"},
//            {"product_product",       "product",        "product",  "1"},
//
//            {"product_package",       "product",  "package",        "1"},
//            {"product_specification",       "product",        "specification",  "1"},
//            {"product_trademark",       "product",       "trademark",   "1"},
//            {"product_register",       "product",       "register",   "1"},
//            {"product_standard",       "product", "standard",         "1"},
//            {"product_index",       "product",   "index",       "1"},
//            {"product_register_note",       "product",        "register/note",  "1"},
//            {"product_dosage",       "product",  "dosage",        "1"},
//            {"product_composition",       "product",        "composition",  "1"},
//            {"product_approve",       "product",       "approve",   "1"},
//            {"product_company",       "product",       "company",   "1"},
//            {"product_company_relation", "product", "company/relation", "1"},
//            {"product_box",       "product", "box",         "1"},
//            {"product_bottle",       "product",   "bottle",       "1"},
//            {"product_license_detail",       "product",        "license_detail",  "1"},
//            {"product_license",       "product",  "license",        "1"},
//            {"product_pictures",       "product",        "pictures",  "1"},
//            {"product_apply",       "product",       "apply",   "1"},
//            {"product_specification_line",       "product",       "specification/line",   "1"},
//            {"product_register_identity_code",       "product",       "register/identity",   "1"},
//            {"product_inspector",       "product",       "inspector",   "1"},
//            {"product_line",       "product", "line",         "1"},
//            {"product_line_group",       "product", "line/group",         "1"},
//            {"product_report_qr",       "product",   "report/qr",       "1"},
//            {"product_report",       "product",        "report",  "1"},
//            {"product_report_temp", "product", "report", "1"},
            //           {"product_lottery_result", "product", "lottery/result", "1"},
//            {"product_register_identity_code",       "product",       "register/identity",   "1"},
//            {"product_inspection",       "product",  "inspection",        "1"},
//            {"product_report_product",       "product",        "report/product",  "1"},
//            {"product_inspection_detail",       "product",       "inspection_detail",   "1"},
//            {"system_config",       "product",       "config",   "1"}
//            {"resource_crop",       "resource",         "crop", "1"},
//            {"resource_crop_catalog",       "resource", "crop/catalog",         "1"},
//            {"resource_crop_state",       "resource",   "crop/state",       "1"},
//            {"resource_fertilizer",       "resource",   "fertilizer",       "1"},
//            {"resource_pest",       "resource",         "pest", "2"},
//            {"resource_pesticide",       "resource",    "pesticide",      "1"},
//            {"resource_prevent",       "resource",      "prevent",    "1"},
//            {"resource_deficiency",       "resource",   "deficiency",       "2"},
//            {"resource_disease",       "resource",   "disease",       "2"},
//            {"resource_grass",       "resource",         "grass", "2"},
//            {"resource_harm",       "resource",    "harm",      "2"},
//            {"resource_pictures",       "resource",      "pictures",    "1"},
//            {"social_article",       "social",          "article",    "1"},
//            {"social_article_comment",       "social",   "article/comment",       "1"},
//            {"social_article_conversation",       "social", "article/conversation",         "1"},
//            {"social_article_tag",       "social",   "article/tag",       "1"},
//            {"social_attitude",       "social",      "attitude",    "1"},
//            {"social_follow",       "social",     "follow",     "1"},
//            {"social_question",       "social",   "question",       "1"},
//            {"social_question_comment",       "social",   "question/comment",       "1"},
//            {"social_question_conversation",       "social",  "question/conversation",        "1"},
//            {"signin",       "social",        "signin",  "1"},
            {"social_video",       "social",        "video",  "1"},
            {"social_banner",       "social",        "banner",  "1"}

    };


    private static String author;
    private static String dbHost;
    private static String dbUser;
    private static String dbPass;
    private static String dbName;
    private static String dbPort;
    private static String packageName;
    public static ArrayList<String> microServices = new ArrayList<>();

    public static void addMicroService(String serviceName) {
        microServices.add(serviceName);
    }

    public static String getMysqlHost() {
        return String.format("jdbc:mysql://%s:%s/%s", dbHost, dbPort, dbName);

    }

    public static String getAuthor() {
        return author;
    }

    public static void setAuthor(String author) {
        UserParameters.author = author;
    }

    public static String getDbHost() {
        return dbHost;
    }

    public static void setDbHost(String dbHost) {
        UserParameters.dbHost = dbHost;
    }

    public static String getDbUser() {
        return dbUser;
    }

    public static void setDbUser(String dbUser) {
        UserParameters.dbUser = dbUser;
    }

    public static String getDbPass() {
        return dbPass;
    }

    public static void setDbPass(String dbPass) {
        UserParameters.dbPass = dbPass;
    }

    public static String getDbName() {
        return dbName;
    }

    public static void setDbName(String dbName) {
        UserParameters.dbName = dbName;
    }

    public static String getDbPort() {
        return dbPort;
    }

    public static void setDbPort(String dbPort) {
        UserParameters.dbPort = dbPort;
    }

    public static String getPackageName() {
        return packageName;
    }

    public static void setPackageName(String packageName) {
        UserParameters.packageName = packageName;
    }

    public static void initParam(String author, String dbHost, String dbUser, String dbPass, String dbName,
                                 String dbPort, String packageName) {
        UserParameters.author = author;
        UserParameters.dbHost = dbHost;
        UserParameters.dbUser = dbUser;
        UserParameters.dbPass = dbPass;
        UserParameters.dbName = dbName;
        UserParameters.dbPort = dbPort;
        UserParameters.packageName = packageName;
    }

}
