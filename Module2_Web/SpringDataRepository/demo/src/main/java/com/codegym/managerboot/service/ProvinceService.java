package com.codegym.managerboot.service;

import com.codegym.managerboot.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Object findById(Long id);

    void save(Province province);

    void remove(Long id);
}
