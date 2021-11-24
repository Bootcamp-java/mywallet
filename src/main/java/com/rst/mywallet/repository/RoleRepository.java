package com.rst.mywallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rst.mywallet.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRole(final String role);
}
