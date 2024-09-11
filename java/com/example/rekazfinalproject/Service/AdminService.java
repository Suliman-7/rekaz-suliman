package com.example.rekazfinalproject.Service;

import com.example.rekazfinalproject.Api.ApiException;
import com.example.rekazfinalproject.Model.Admin;
import com.example.rekazfinalproject.Repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AdminService {

    private final AdminRepository adminRepository;

    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    public void addAdmin(Admin admin){
        adminRepository.save(admin);
    }

    public void updateAdmin( int id ,Admin admin1){
        Admin admin = adminRepository.findAdminById(id);
        if(admin == null){
            throw new ApiException("Admin not found");
        }
        admin.setName(admin1.getName());
        admin.setEmail(admin1.getEmail());
        admin.setPhoneNumber(admin1.getPhoneNumber());
    }

    public void deleteAdmin(int id){
        Admin admin = adminRepository.findAdminById(id);
        if(admin == null){
            throw new ApiException("Admin not found");
        }
        adminRepository.delete(admin);
    }

}
