package com.example.yootday1.service.impl;

import com.example.yootday1.domain.entity.Course;
import com.example.yootday1.domain.entity.Parent;
import com.example.yootday1.repository.ParentRepository;
import com.example.yootday1.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;

    public List<Parent> findAll(){
        return parentRepository.findAll();
    }

    public Optional<Parent> findById(Long id){
        return parentRepository.findById(id);

    }

    public Parent save(Parent parent){
        return parentRepository.save(parent);
    }

    public Parent updateParent(Long id, Parent parent){
        parent.setId(id);
        return parentRepository.save(parent);
    }

    public void deleteParent(Long id){
         parentRepository.deleteById(id);
    }
}
