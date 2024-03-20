package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.QuyDoiDiem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuyDoiDiemService {

    QuyDoiDiem createQuyDoiDiem(QuyDoiDiem quyDoiDiem);

    List<QuyDoiDiem> getAllQuyDoiDiems();

    Optional<QuyDoiDiem> getQuyDoiDiemById(UUID id);

    QuyDoiDiem updateQuyDoiDiem(UUID id, QuyDoiDiem quyDoiDiem);

    void deleteQuyDoiDiem(UUID id);
}
