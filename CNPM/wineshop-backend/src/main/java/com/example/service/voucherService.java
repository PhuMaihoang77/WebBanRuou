package com.example.voucher.service;

import com.example.voucher.model.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository repository;

    public Voucher createVoucher(Voucher voucher) {
        // 8.1.6: Kiểm tra mã trùng
        if (repository.existsByCode(voucher.getCode())) {
            throw new IllegalArgumentException("Mã voucher đã tồn tại."); // 8.2.1
        }
        // 8.1.6: Kiểm tra thời gian hợp lệ
        LocalDate today = LocalDate.now();
        if (voucher.getEndDate().isBefore(voucher.getStartDate()) ||
                voucher.getEndDate().isBefore(today)) {
            throw new IllegalArgumentException("Thời gian không hợp lệ!"); // 8.2.2
        }
        try {
            // 8.1.7: Lưu voucher
            return repository.save(voucher);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Không thể lưu voucher. Vui lòng thử lại sau."); // 8.2.3
        }
    }
}