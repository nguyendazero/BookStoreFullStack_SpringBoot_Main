package com.bookStoreFullStack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bookStoreFullStack.entity.Book;
import com.bookStoreFullStack.entity.Category;
import com.bookStoreFullStack.service.BookService;
import com.bookStoreFullStack.service.CategoryService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private CategoryService categpryService;
	@Autowired
	private HttpSession session;
	
	@GetMapping("/home")
	public String home(Model model) {
		List<Book> books = bookService.getAllBooks();
		List<Category> categories = categpryService.getAllCategories();
		
		model.addAttribute("books", books);
		model.addAttribute("categories", categories);
		return "index";
	}
}
