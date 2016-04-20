package br.gov.ro.portovelho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gov.ro.portovelho.model.HQ;
import br.gov.ro.portovelho.repository.HQRepository;

@Controller
@Transactional
public class HQController {
	@Autowired
	private HQRepository repository;
	
	@ResponseBody 
	@RequestMapping(value = "/hq/", method = RequestMethod.GET) 
	public Iterable listar() { 
		return repository.findAll(); 
	} 
	
	@ResponseBody 
	@RequestMapping(value = "/hq/salvar", method = RequestMethod.POST) 
	public HQ salvar(@RequestBody final HQ hq) { 
		return repository.save(hq); 
	} 
}
