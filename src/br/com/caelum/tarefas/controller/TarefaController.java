package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefaController {
	
	private final JdbcTarefaDao dao;
	
	@Autowired
	public TarefaController(JdbcTarefaDao dao){
		this.dao = dao;
	}
	
	@RequestMapping("novaTarefa")
	public String formulario() {		
		
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		
		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		
		dao.adiciona(tarefa);
		
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		
		List<Tarefa> tarefas = dao.lista();
		
		model.addAttribute("tarefas", tarefas);
		
		return "tarefa/lista";
	}
	
	@RequestMapping("exibeTarefa")
	public String exibe(Long id, Model model) {
		
		Tarefa tarefa = dao.buscaPorId(id);
		model.addAttribute("tarefa", tarefa);
		
		return "tarefa/exibir";
	}
	
	@RequestMapping("modificarTarefa")
	public String modificar(Tarefa tarefa) {
		
		dao.altera(tarefa);
			
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("excluirTarefa")
	public String excluir(Tarefa tarefa) {
		
		dao.remove(tarefa);
		
		return "redirect:listaTarefas";
	}
	
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finaliza(Tarefa tarefa){
		
		dao.finaliza(tarefa.getId());
		
	}

}
