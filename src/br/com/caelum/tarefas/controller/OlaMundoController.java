package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

	@RequestMapping("/olaMundo")
	public String olaMundo() {
		System.out.println("Executando a lógica com Spring MVC");
		return "ola-mundo";
	}
	
}
