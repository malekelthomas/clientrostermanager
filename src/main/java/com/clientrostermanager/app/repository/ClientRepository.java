package com.clientrostermanager.app.repository;

import com.clientrostermanager.app.models.Client;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository <Client, Integer> {}
