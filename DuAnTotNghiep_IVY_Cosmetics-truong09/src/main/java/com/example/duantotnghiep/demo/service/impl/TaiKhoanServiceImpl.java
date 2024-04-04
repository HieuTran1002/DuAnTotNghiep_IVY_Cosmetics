package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.TaiKhoanEntity;
import com.example.duantotnghiep.demo.repository.TaiKhoanRepository;
import com.example.duantotnghiep.demo.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public Optional<TaiKhoanEntity> findByUserName(String userName) {
        return Optional.empty();
    }

    @Override
    public TaiKhoanEntity createTaiKhoan(TaiKhoanEntity taiKhoan) {
        return taiKhoanRepository.save(taiKhoan);
    }

    @Override
    public List<TaiKhoanEntity> getAllTaiKhoans() {
        return taiKhoanRepository.findAll();
    }

    public TaiKhoanEntity getOne(UUID id){
        return taiKhoanRepository.getOne(id);
    }

    public String getRoles(TaiKhoanEntity taiKhoan) {
        if(taiKhoan.getRoles() == 0){
            return "ADMIN";
        }else {
            return "USER";
        }
    }

    @Override
    public boolean authenticationSuccess(int role) {
        // Lấy thông tin xác thực từ SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Kiểm tra xem người dùng đã được xác thực chưa
        if (authentication != null && authentication.isAuthenticated()) {
            // Kiểm tra giá trị roles của người dùng
            return authentication.getAuthorities().stream()
                    .anyMatch(grantedAuthority -> {
                        String authority = grantedAuthority.getAuthority();
                        if (authority.equals("ADMIN") && role == 1) {
                            return true;
                        } else if (authority.equals("USER") && role == 0) {
                            return true;
                        }
                        return false;
                    });
        }
        return false;
    }

    @Override
    public Optional<TaiKhoanEntity> getTaiKhoanById(UUID id) {
        return taiKhoanRepository.findById(id);
    }


    @Override
    public TaiKhoanEntity updateTaiKhoan(UUID id, TaiKhoanEntity taiKhoan) {
        Optional<TaiKhoanEntity> optionalTaiKhoan = taiKhoanRepository.findById(id);
        if (optionalTaiKhoan.isPresent()) {
            TaiKhoanEntity existingTaiKhoan = optionalTaiKhoan.get();
            return taiKhoanRepository.save(existingTaiKhoan);
        } else {
            return null;
        }
    }

    @Override
    public void deleteTaiKhoan(UUID id) {
        taiKhoanRepository.deleteById(id);
    }
}
