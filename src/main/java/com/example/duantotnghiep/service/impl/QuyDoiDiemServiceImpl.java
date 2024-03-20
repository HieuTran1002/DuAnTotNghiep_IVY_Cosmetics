package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.QuyDoiDiem;
import com.example.duantotnghiep.repository.QuyDoiDiemRepository;
import com.example.duantotnghiep.service.QuyDoiDiemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class QuyDoiDiemServiceImpl implements QuyDoiDiemService {

    @Autowired
    private QuyDoiDiemRepository quyDoiDiemRepository;

    @Override
    public QuyDoiDiem createQuyDoiDiem(QuyDoiDiem quyDoiDiem) {
        return quyDoiDiemRepository.save(quyDoiDiem);
    }

    @Override
    public List<QuyDoiDiem> getAllQuyDoiDiems() {
        return quyDoiDiemRepository.findAll();
    }

    @Override
    public Optional<QuyDoiDiem> getQuyDoiDiemById(UUID id) {
        return quyDoiDiemRepository.findById(id);
    }

    @Override
    public QuyDoiDiem updateQuyDoiDiem(UUID id, QuyDoiDiem quyDoiDiem) {
        Optional<QuyDoiDiem> optionalQuyDoiDiem = quyDoiDiemRepository.findById(id);
        if (optionalQuyDoiDiem.isPresent()) {
            QuyDoiDiem existingQuyDoiDiem = optionalQuyDoiDiem.get();
            return quyDoiDiemRepository.save(existingQuyDoiDiem);
        } else {
            return null;
        }
    }

    @Override
    public void deleteQuyDoiDiem(UUID id) {
        quyDoiDiemRepository.deleteById(id);
    }
}
