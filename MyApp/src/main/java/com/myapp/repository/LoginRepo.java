package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.model.LoginForm;

public interface LoginRepo extends JpaRepository<LoginForm, String> {

}
