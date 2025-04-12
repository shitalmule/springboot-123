package com.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class practise {
			
		@PostMapping("/")
		private void m1() {
			
			System.out.println("hi");
			
			
			
		}
	}


