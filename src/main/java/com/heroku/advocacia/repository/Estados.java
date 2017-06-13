package com.heroku.advocacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heroku.advocacia.model.Estado;

public interface Estados extends JpaRepository<Estado, Long> {

}
