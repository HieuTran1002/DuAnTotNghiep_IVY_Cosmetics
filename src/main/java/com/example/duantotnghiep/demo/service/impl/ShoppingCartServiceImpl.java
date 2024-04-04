package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.GioHangChiTietEntity;
import com.example.duantotnghiep.demo.entity.GioHangEntity;
import com.example.duantotnghiep.demo.entity.KhachHangEntity;
import com.example.duantotnghiep.demo.entity.SanPhamChiTietEntity;
import com.example.duantotnghiep.demo.repository.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingCartServiceImpl {
    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;
    private final GioHangRepository gioHangRepository;
    private final KhachHangRepository khachHangRepository;
    private final GioHangChiTietRepository gioHangChiTietRepository;
    @Autowired
    public ShoppingCartServiceImpl(GioHangRepository gioHangRepository,KhachHangRepository khachHangRepository,GioHangChiTietRepository gioHangChiTietRepository){
        this.gioHangRepository=gioHangRepository;
        this.gioHangChiTietRepository=gioHangChiTietRepository;
        this.khachHangRepository=khachHangRepository;
    }
    public UUID findCreatCardByCustomerId(UUID customerId , HttpSession session){
        KhachHangEntity khachHangEntity=khachHangRepository.findById(customerId).orElse(null);
        if(khachHangEntity ==null){
            return  null;
        }
        // tim gio hang cua khach hang
        GioHangEntity gioHangEntity=gioHangRepository.findByKhachHangEntity(khachHangEntity);
        if (gioHangEntity == null){
            // neu khong tim thay gio hang cua khach hang
            gioHangEntity=new GioHangEntity();
            gioHangEntity.setKhachHangEntity(khachHangEntity);
            gioHangEntity=gioHangRepository.save(gioHangEntity);
        }
        UUID gioHangId=gioHangEntity.getId();
        session.setAttribute("gioHangId",gioHangId); // luu id gio hang vao session
        return gioHangId;
    }
    public void addToCart(UUID gioHangId , UUID chiTietId){
        // them san pham vao gio hang dua tren id cua gio hang va chi tiet san pham
        GioHangEntity gioHangEntity=gioHangRepository.findById(gioHangId).orElse(null);
        SanPhamChiTietEntity sanPhamChiTietEntity=sanPhamChiTietRepository.findById(chiTietId).orElse(null);
        if(gioHangEntity !=null && sanPhamChiTietEntity !=null){
            GioHangChiTietEntity qty=gioHangChiTietRepository.findByGioHangAndSanPhamChiTietEntity(gioHangEntity,sanPhamChiTietEntity);
            if(qty != null){
                qty.setSoLuong(qty.getSoLuong()+1);
                gioHangChiTietRepository.save(qty);
            }else {
                GioHangChiTietEntity newItem=new GioHangChiTietEntity();
                newItem.setGioHang(gioHangEntity);
                newItem.setSanPhamChiTietEntity(sanPhamChiTietEntity);
                newItem.setDonGia(sanPhamChiTietEntity.getSanPhamEntity().getGiaBan());
                newItem.setSoLuong(1);
                gioHangChiTietRepository.save(newItem);
            }
        }
    }
    public List<GioHangChiTietEntity> getCartByGioHangId(HttpSession session){
        UUID gioHangId=(UUID) session.getAttribute("gioHangId");
        // lay thong tin gio hang dua tren Id cua gio hang
        GioHangEntity gioHangEntity=gioHangRepository.findById(gioHangId).orElse(null);
        if (gioHangEntity != null){
            return gioHangEntity.getGioHangChiTietEntities();
        }
        return null;
    }
    public BigDecimal sumTotalPrice(List<GioHangChiTietEntity> cartItems){
        BigDecimal totalPrice=BigDecimal.ZERO;
        for(GioHangChiTietEntity item : cartItems){
            BigDecimal itemTotal=item.getSanPhamChiTietEntity().getSanPhamEntity().getGiaBan().multiply(BigDecimal.valueOf(item.getSoLuong()));
            totalPrice=totalPrice.add(itemTotal);
        }
        return totalPrice;
    }
    public void removeCart(UUID cartItems){
        gioHangChiTietRepository.deleteById(cartItems);
    }

}
