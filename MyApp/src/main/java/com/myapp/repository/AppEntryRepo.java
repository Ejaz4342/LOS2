package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.model.AppEntry;

public interface AppEntryRepo extends JpaRepository<AppEntry, Long> {

}
