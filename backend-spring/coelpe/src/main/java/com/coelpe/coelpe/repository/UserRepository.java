package com.coelpe.coelpe.repository;

import com.coelpe.coelpe.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
