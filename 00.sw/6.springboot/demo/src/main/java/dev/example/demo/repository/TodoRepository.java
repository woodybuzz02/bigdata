package dev.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.example.demo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{ //<Entity, 기본키타입>

}
