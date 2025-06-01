package com.UniDistrital.FirstActivity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.UniDistrital.FirstActivity.models.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Long> {

}