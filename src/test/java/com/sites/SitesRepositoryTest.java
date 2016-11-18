package com.sites;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sites.models.Site;
import com.sites.repository.SitesRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class SitesRepositoryTest {

	@Autowired
	private SitesRepository sitesRepo;
	
	@Test
	public void testFindAll(){
		List<Site> sites = sitesRepo.findAll();
		assertThat(sites.size(), is(greaterThanOrEqualTo(0)));
	}
}
