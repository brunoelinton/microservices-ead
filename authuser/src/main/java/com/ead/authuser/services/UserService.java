package com.ead.authuser.services;

import com.ead.authuser.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    @Transactional(readOnly = true)
    List<UserModel> findAll();

    @Transactional(readOnly = true)
    Optional<UserModel> findById(UUID userId);

    @Transactional
    void delete(UserModel userModel);

    @Transactional
    void save(UserModel userModel);

    @Transactional(readOnly = true)
    boolean existByUsername(String username);

    @Transactional(readOnly = true)
    boolean existByEmail(String email);

    @Transactional(readOnly = true)
    Page<UserModel> findAll(Specification<UserModel> spec, Pageable pageable);
}
