package com.example.rekazfinalproject.Repository;

import com.example.rekazfinalproject.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findAdminById(int id);
}
