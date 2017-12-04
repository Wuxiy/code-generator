package ${packageName};

import ${basePackageName}.model.${modelNameUpperCamel};
import ${utilsPackageName}.AbstractService;
import ${mapperPackageName}.${modelNameUpperCamel}Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * Created by ${author} on ${date}.
 * @author ${author}
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ${modelNameUpperCamel}Service extends AbstractService<${modelNameUpperCamel}> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}