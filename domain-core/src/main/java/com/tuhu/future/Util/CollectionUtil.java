package com.tuhu.future.Util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duyashuo
 */
public class CollectionUtil {

    public static <T, E> List<E> copyList(List<T> srcList, Class<E> targetClazz) {
        List<E> result = new ArrayList<>();

        srcList.forEach(item->{
            try {
                E instance = targetClazz.newInstance();
                BeanUtils.copyProperties(item, instance);
                result.add(instance);
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        });
        return result;
    }
}
