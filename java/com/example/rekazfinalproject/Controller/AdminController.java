package com.example.rekazfinalproject.Controller;


import com.example.rekazfinalproject.Model.Admin;
import com.example.rekazfinalproject.Service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")

public class AdminController {

    private final AdminService adminService;

    // Suliman
    @GetMapping("/get-all-admin")
    public ResponseEntity getAllAdmin() {
        return ResponseEntity.status(200).body(adminService.getAllAdmins());
    }

    // Suliman
    @PostMapping("/add-admin")
    public ResponseEntity addAdmin(@Valid @RequestBody Admin admin) {
        adminService.addAdmin(admin);
        return ResponseEntity.status(200).body("admin successfully added");
    }

    // Suliman
    @PutMapping("/update-admin/{id}")
    public ResponseEntity updateAdmin(@PathVariable int id, @Valid @RequestBody Admin admin) {
        adminService.updateAdmin(id, admin);
        return ResponseEntity.status(200).body("admin successfully updated");
    }

    // Suliman
    @DeleteMapping("/delete-admin/{id}")
    public ResponseEntity deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.status(200).body("admin successfully deleted");
    }
}
