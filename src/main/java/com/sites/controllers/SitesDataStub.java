package com.sites.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sites.models.Site;

public class SitesDataStub {
	
	public static Map<Long, Site> sites = new HashMap<Long, Site>();
	private static Long idIndex = 2L;
	
	//create a few memory sites for test purposes
	static
	{
		Site first = new Site(1L, "Kubwa", "Mega Filling Station", "In-Progress", 33.12, 44.2, 2015);
		sites.put(1L, first);
		Site second = new Site(2L, "Kubwa", "Mega Filling Station", "In-Progress", 33.12, 44.2, 2015);
		sites.put(2L, second);
	}
	
	public static List<Site> list(){
		return new ArrayList<Site>(sites.values());
	}
	
	public static Site create(Site site){
		
		idIndex += idIndex;
		site.setId(idIndex);
		sites.put(idIndex, site);
		return site;
	}
	
	public static Site get(long id){
		return sites.get(id);
	}
	
	public static Site update(long id, Site site){
		sites.put(id, site);
		return site;
	}
	
	public static Site delete(long id){
		return sites.remove(id);
	}
}
