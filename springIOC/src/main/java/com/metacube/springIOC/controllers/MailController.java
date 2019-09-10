package com.metacube.springIOC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.springIOC.Services.MailSender;

@RestController
@RequestMapping("/mail")
public class MailController {
	
	/*@Autowired
	@Qualifier("mock")
	private MailSender mail;*/
	
	private MailSender mail;
	
	/*@Autowired
	private MailSender mail;
	This use @primary*/
	
	@GetMapping
	public String getMail(){
		return mail.send();
	}
	
	@Autowired
	public void setMail(MailSender mail){
		this.mail=mail;
	}
	
	
	
	

}
