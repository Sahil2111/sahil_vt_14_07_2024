package com.sahil1.demo.repository;


import com.sahil1.demo.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}

