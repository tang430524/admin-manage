package org.javajidi.admin.infrastructure;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author qiang.xie
 * @date 2016/9/29
 */
public class BeanUtil {

    public static void copeProperties(Object from,Object dest){
        try {
            BeanUtils.copyProperties(dest, from);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
