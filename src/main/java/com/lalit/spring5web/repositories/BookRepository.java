package com.lalit.spring5web.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lalit.spring5web.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
