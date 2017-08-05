package com.lalit.spring5web.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.lalit.spring5web.model.Author;
import com.lalit.spring5web.model.Book;
import com.lalit.spring5web.model.Publisher;
import com.lalit.spring5web.repositories.AuthorRepository;
import com.lalit.spring5web.repositories.BookRepository;
import com.lalit.spring5web.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		
		initData();
	}

	private void initData() {
		
	//Author Sid
	Author sid = new Author("Sidney", "Sheldon");
	Publisher penguine = new Publisher("Penguine Publisher", "London");
	Book midnight = new Book("Midnight Sun", "ISBN-1234");
	midnight.setPublisher(penguine);
	sid.getBooks().add(midnight);
	midnight.getAuthors().add(sid);
	
	authorRepository.save(sid);
	publisherRepository.save(penguine);
	bookRepository.save(midnight);
	
	//Author Cook
	Author cook = new Author("Robin", "Cook");
	Publisher collins = new Publisher("Harper Collins Publisher", "Dublin");
	Book congo = new Book("Congo", "ISBN-5678");
	congo.setPublisher(collins);
	sid.getBooks().add(congo);
	midnight.getAuthors().add(cook);
	
	authorRepository.save(cook);
	publisherRepository.save(collins);
	bookRepository.save(congo);
		
	}

}
