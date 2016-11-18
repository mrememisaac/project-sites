package com.sites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sites.models.Site;

//wow this is so simple compared to on .net
//repository for persistence management
public interface SitesRepository extends JpaRepository<Site, Long> {

}
