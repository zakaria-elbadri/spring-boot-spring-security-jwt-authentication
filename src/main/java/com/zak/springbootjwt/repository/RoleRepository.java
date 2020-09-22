package com.zak.springbootjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zak.springbootjwt.models.ERole;
import com.zak.springbootjwt.models.Role;

/**
 * @author Zakaria El Badri
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(ERole name);
}
