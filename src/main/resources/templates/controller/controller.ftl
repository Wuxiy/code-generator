package ${packageName};

import ${utilsPackageName}.Result;
import ${utilsPackageName}.ResultGenerator;
import ${basePackageName}.model.${modelNameUpperCamel};
import ${servicePackageName}.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ${utilsPackageName}.StateUtils;
import ${utilsPackageName}.TextUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {

    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public Result add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @PostMapping("/add-batch")
    public Result addBatch(@RequestBody List<${modelNameUpperCamel}> ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam(required = true) Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/edit")
    public Result update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @GetMapping("/get")
    public Result detail(@RequestParam(required = true) Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.get(id);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "null") Map<String, Object> params) {

        int page = Integer.parseInt((String) params.getOrDefault("page", "0"));
        int size = Integer.parseInt((String) params.getOrDefault("size", "0"));
        params.remove("page");
        params.remove("size");

        Condition condition = new Condition(${modelNameUpperCamel}.class);
        Example.Criteria criteria = condition.createCriteria();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (StringUtils.isEmpty(value)) {
                continue;
            }

            criteria.andEqualTo(key, params.get(key));
        }

        if(page != 0 && size !=0) {
            PageHelper.startPage(page, size);
        }
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.list(condition);

        if(page != 0 && size !=0) {
            return ResultGenerator.genListOrPageResult(list, page, size);
        } else {
            return ResultGenerator.genSuccessResult(list);
        }
    }
}
