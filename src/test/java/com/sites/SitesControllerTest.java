package com.sites;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sites.controllers.SitesController;
import com.sites.controllers.SitesDataStub;
import com.sites.models.Site;
import com.sites.repository.SitesRepository;

public class SitesControllerTest {
	
	@InjectMocks
	private SitesController sc;
	
	@Mock
	private SitesRepository sitesRepo;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSitesGet(){
		Site site = new Site();
		site.setId(1L);
		when(sitesRepo.findOne(1L)).thenReturn(site);
		
		Site site2 = sc.get(1L);
		
		verify(sitesRepo).findOne(1L); //ensure that this call occurred just once
		
		assertThat(site2.getId(), is(1L)); 
	}
	
	@Test
	public void testSitesList(){
		when(sitesRepo.findAll()).thenReturn(SitesDataStub.list());
		
		Integer count = sc.list().size();
		
		verify(sitesRepo).findAll();
		
		MatcherAssert.assertThat(count, is(2));		
	}
	
	@Test
	public void testSitesUpdate(){
				
		when(sitesRepo.findOne(2L)).thenReturn(SitesDataStub.get(2L));
		
		Site site = sc.get(2L);
		
		when(sitesRepo.saveAndFlush(site)).thenReturn(site);
		
		assertThat(site.getId(), is(2L));
	}
	
	@Test
	public void testDelete(){
		//arrange
		when(sitesRepo.findOne(2L)).thenReturn(SitesDataStub.get(2L));
		Site site = sc.get(2L);
		
		//act
		sc.delete(site.getId());
		
		//assert
		verify(sitesRepo).delete(site); //that it was called just once		
	}
}
