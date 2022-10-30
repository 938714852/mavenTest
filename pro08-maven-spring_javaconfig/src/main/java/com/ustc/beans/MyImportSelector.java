package com.ustc.beans;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @author : wtq
 * @date: 2022/10/30
 */
@Component
public class MyImportSelector implements ImportSelector {
    //可以以字符串的形式返回多个Bean
    //字符串必须是类的完整限定名，getBean不能根据名字去获取，必须要根据类型获取
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.ustc.beans.Person","com.ustc.beans.Wife"};
    }
}
