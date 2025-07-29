package com.project.e_commerce_login_user.infra.db.repositories;

import com.project.e_commerce_login_user.infra.db.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDBRepository extends JpaRepository<UserModel, UUID> {
}
