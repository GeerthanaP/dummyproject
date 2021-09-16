package com.facebookboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.facebookboot.entity.FacebookEmployee;
@Repository
public interface FacebookDAOInterface extends JpaRepository<FacebookEmployee, String>{
	@Query("delete from FacebookEmployee e where e.name=:nn")
	public int deleteByUsername(@Param("nn") String name);
}
