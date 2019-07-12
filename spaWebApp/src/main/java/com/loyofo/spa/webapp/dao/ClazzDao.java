package com.loyofo.spa.webapp.dao;

import com.loyofo.spa.webapp.entity.Clazz;

import java.util.List;

public interface ClazzDao {

    Clazz getClazzById(String id);

    List<Clazz> getAllClazz();

}
