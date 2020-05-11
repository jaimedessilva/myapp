package com.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Convidado;
import com.repository.ConvidadoRepository;
import com.repository.PagRepository;

/**gestaoFesta
 * ConvidadoController.java
 * @author jaime
 * Em 10-05-2020 **/

@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadoRepository convidadoDao;
	@Autowired
	private PagRepository repository;
	
	/*
	 *   Listar Com paginação e Ordenação  
	 */
	@GetMapping("/lista")
	public String listaConvidadosOrder(@PageableDefault (size = 10, sort = "id") Pageable pg, Model model) {
		Page<Convidado> page = repository.findAll(pg);
		List<Sort.Order> sortOrder = page.getSort().stream().collect(Collectors.toList());
		if(sortOrder.size() > 0) {
			Sort.Order order = sortOrder.get(0);
			model.addAttribute("sortProperty", order.getProperty());
			model.addAttribute("sortDesc", order.getDirection() == Sort.Direction.DESC);
		}
		model.addAttribute("page", page);
		return "lista-paginada"; 
	}
	/*
	 *  Url: /add-convidado
	 *  html: add-convidado.html 
	 */
	@GetMapping ("/form-add-convidado")
	public String formCadastrar () {	
		return "add-convidado";
	}
	/*
	 *  Create New
	 */
	@PostMapping("/add-convidado")
	public String cadastrar(Convidado co) {
		
		convidadoDao.save(co);
		return "redirect:/lista";
	}
	/*
	 *  FORM
	 *  Url: edit-convidado
	 *  html: edit-convidado.html
	 */
	@GetMapping("/form-edit-convidado/{id}")
	public String formAtualizar(@PathVariable("id") long id, Model model) {
		Convidado convidado = convidadoDao.findById(id).
				orElseThrow(() -> new IllegalArgumentException("Id Invalido:" + id));
		model.addAttribute("convidado", convidado);       
		
		return "edit-convidado";
	}
	/*
	 *  Update
	 */
	@PostMapping("/atualizar/{id}")
	public String atualizar(@PathVariable("id") long id, @Valid Convidado co,
			BindingResult rs, Model model ) {
			if (rs.hasErrors()) {
				co.setId(id);
				return "edit-convidado";
			}
			convidadoDao.save(co);
			model.addAttribute("convidados", convidadoDao.findAll());
		return "redirect:/lista";
	}
	/*
	 *  FORM
	 *  Url: form-delete-convidado
	 *  html: form-del.html
	 */
	@GetMapping("/form-delete-convidado/{id}")
	public String formDelete(@PathVariable("id") long id, Model model) {
		Convidado convidado = convidadoDao.findById(id).
				orElseThrow(() -> new IllegalArgumentException("Id Invalido:" + id));
				model.addAttribute("convidado", convidado);  //Atualiza    
		
		return "form-del";
	}
	/*
	 *  Delete
	 */
	@GetMapping("/deletar/{id}")
	public String delete(@PathVariable("id") long id, Model model) {
		Convidado convidado = convidadoDao.findById(id).
				orElseThrow(() -> new IllegalArgumentException("Id Invalido:" + id));
		      convidadoDao.delete(convidado);
		      model.addAttribute("convidado",convidadoDao.findAll());

		return "redirect:/lista";
	}

}
