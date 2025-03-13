package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.CodeSnippet;
import com.example.demo.service.CodeSnippetService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/api/codeSnippet")
public class CodeSnippetController {
	
	@Autowired
	private CodeSnippetService codeSnippetService;

	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public CodeSnippet addCodeSnippet(@RequestBody CodeSnippet codeSnippet)
	{
		return codeSnippetService.createSnippet(codeSnippet);
	}
	
	@GetMapping
	@ResponseStatus(code=HttpStatus.OK)
	public List<CodeSnippet> getAllCodeSnippet()
	{
		return codeSnippetService.getAllCodeSnippet();
		
	}
	@GetMapping("/language/{language}")
	@ResponseStatus(code=HttpStatus.OK)
	public List<CodeSnippet> getCodeSnippetByLanguage(@PathVariable String language)
	{
		return codeSnippetService.findByLanguage(language);
	}
	@GetMapping("/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public CodeSnippet getCodeSnippetById(@PathVariable Long id)
	{
		return codeSnippetService.getCodeSnippetById(id);
	}
	
	 @GetMapping("/search")
	 @ResponseStatus(code=HttpStatus.OK)
	 public List<CodeSnippet> searchSnippets(@RequestParam String keyword) 
	 {
	        return codeSnippetService.searchCodeSnippets(keyword);
	 }
	
	@PutMapping("/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public CodeSnippet updateCodeSnippet(@PathVariable Long id,@RequestBody CodeSnippet codeSnippet)
	{
		return codeSnippetService.updateCodeSnippet(id, codeSnippet);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteCodeSnippet(@PathVariable Long id)
	{
		codeSnippetService.deleteCodeSnippet(id);
	}
}
