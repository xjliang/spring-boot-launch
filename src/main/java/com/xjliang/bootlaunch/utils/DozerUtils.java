package com.xjliang.bootlaunch.utils;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import org.dozer.DozerBeanMapper;

public class DozerUtils {

    static DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List destinationList = Lists.newArrayList();
        for (Object object : sourceList) {
            Object destinationObject = dozerBeanMapper.map(object, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
}
