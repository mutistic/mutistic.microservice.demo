package com.mutistic.cloud.repository;

import com.mutistic.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * user repository > dao
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
