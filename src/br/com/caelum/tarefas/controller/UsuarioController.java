package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
public class UsuarioController {
	
	private final JdbcUsuarioDao dao;
	
	@Autowired
	public UsuarioController(JdbcUsuarioDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "usuario/formulario-login";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session){
		
		if (dao.existeUsuario(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:/";
		} else {
		
			return "redirect:loginForm?erro=usuario ou senha invalidos";
		
		}
	}
	
}
