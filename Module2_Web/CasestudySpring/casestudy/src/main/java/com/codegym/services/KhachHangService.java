package com.codegym.services;

import com.codegym.entity.FuramaKhachHang;

public interface KhachHangService {
    public  Iterable<FuramaKhachHang> getAllKhachHang();

    public FuramaKhachHang getKhachHang(Long IdKhachHang);

    public void saveKhachHang(FuramaKhachHang khachHang);

    public void deleteKhachHang(Long idKhachHang);

}
