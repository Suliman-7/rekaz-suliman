package com.example.rekazfinalproject.Repository;


import com.example.rekazfinalproject.Model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    Owner findOwnerById(int id);
}
