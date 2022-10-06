package com.api.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.auth.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
	
	@Query(value = "SELECT * FROM Users u WHERE u.username = ?1",nativeQuery = true)
	public Users findUserByUsername(String username);
	
	@Modifying
	@Query(value = "UPDATE Users set password = ?1 where id = ?2",nativeQuery = true)
	public int updatePassword(String password, long UserId);
}