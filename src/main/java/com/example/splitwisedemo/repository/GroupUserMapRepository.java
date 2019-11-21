package com.example.splitwisedemo.repository;

import com.example.splitwisedemo.entity.GroupUserMap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUserMapRepository extends CrudRepository<GroupUserMap, Long> {
}
