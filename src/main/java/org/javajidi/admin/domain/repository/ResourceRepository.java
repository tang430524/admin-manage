package org.javajidi.admin.domain.repository;

import org.javajidi.admin.domain.modle.Resource;

import java.util.List;

/**
 * Created by xieqiang on 2016/9/17.
 */
public interface ResourceRepository {

    void add(Resource resource);

    void update(Resource resource);

    Resource get(String code);

    List<Resource> list();

    void remove(String code);
}
