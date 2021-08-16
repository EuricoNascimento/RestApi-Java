package com.praxia.springcontactmysqlj.repository;

import com.praxia.springcontactmysqlj.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Long> {}
