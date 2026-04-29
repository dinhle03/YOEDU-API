package com.example.yootday1.service;

import com.example.yootday1.domain.entity.Parent;
import com.example.yootday1.domain.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    List<Parent> findAll();
    Optional<Parent> findById(Long id);
    Parent save(Parent parent);
    Parent updateParent(Long id, Parent parent);
    void deleteParent(Long id);
}
