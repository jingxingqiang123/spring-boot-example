package com.miaoshaproject.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 检验信息的类
 * @author JingXingQiang
 * @date 2019/6/2 21:34
 */
@Component
public class ValidatorImpl implements InitializingBean {

    //java定义的接口检验工具
    private Validator validator;

    // 实现校验方法并返回校验结果
    public ValidationResult validate(Object bean){
        ValidationResult result =new ValidationResult();
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean);
        if (constraintViolationSet.size()>0){
            //有错误
            result.setHasErrors(true);
            constraintViolationSet.forEach(constraintViolation ->{
                String errMsg = constraintViolation.getMessage();
                String propertyName =constraintViolation.getPropertyPath().toString();
                result.getErrorMsgMap().put(propertyName, errMsg);
            });
        }
        return result;
    }

    /**spring bean初始化完成回调此方法*/
    @Override
    public void afterPropertiesSet() throws Exception {

        //将hibernate validator通过工厂的初始化方法使其实例化
       this.validator = Validation.buildDefaultValidatorFactory().getValidator();

    }
}
