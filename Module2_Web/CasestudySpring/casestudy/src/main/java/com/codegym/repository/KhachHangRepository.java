package com.codegym.repository;

import com.codegym.entity.FuramaKhachHang;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends CrudRepository<FuramaKhachHang,Long> {
}
