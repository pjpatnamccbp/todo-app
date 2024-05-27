package com.tech.todo_app.dao;

import com.tech.todo_app.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hp ON 27-05-2024
 * @Description
 **/
@Repository
public interface TodoJpaRepository extends JpaRepository<Todo,Integer> {
    List<Todo> findAllByName(String name);
}
