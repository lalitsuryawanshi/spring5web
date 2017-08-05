package com.lalit.spring5web.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lalit.spring5web.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
