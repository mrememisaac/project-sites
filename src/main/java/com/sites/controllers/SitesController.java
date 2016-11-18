package com.sites.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sites.models.Site;
import com.sites.repository.SitesRepository;

@RestController
@RequestMapping("api/v1/")
public class SitesController {

	@Autowired
	private SitesRepository sitesRepository; //injected by spring framework
	
	//returns all sites in the db
	@RequestMapping(value = "sites", method = RequestMethod.GET)
	public List<Site> list() {
		return sitesRepository.findAll();
	}

	//persists a site
	@RequestMapping(value = "sites", method = RequestMethod.POST)
	public Site create(@RequestBody Site site) {
		return sitesRepository.saveAndFlush(site);
	}

	//gets a site by id
	@RequestMapping(value = "sites/{id}", method = RequestMethod.GET)
	public Site get(@PathVariable Long id) {
		return sitesRepository.findOne(id);
	}

	//updates a site
	@RequestMapping(value = "sites/{id}", method = RequestMethod.PUT)
	public Site update(@PathVariable Long id, @RequestBody Site site) {
		Site existingSite = sitesRepository.findOne(id);
		if(existingSite != null){
			BeanUtils.copyProperties(site, existingSite);
			return sitesRepository.saveAndFlush(existingSite);
		}
		return null;		
	}

	//deletes a site
	@RequestMapping(value = "sites/{id}", method = RequestMethod.DELETE)
	public Site delete(@PathVariable Long id) {
		Site existingSite = sitesRepository.findOne(id);
		if(existingSite != null){			
			sitesRepository.delete(existingSite);
			return existingSite;
		}
		return null;
	}
}
