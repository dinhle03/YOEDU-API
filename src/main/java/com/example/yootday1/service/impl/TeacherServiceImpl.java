package com.example.yootday1.service.impl;

import com.example.yootday1.domain.entity.Teacher;
import com.example.yootday1.repository.TeacherRepository;
import com.example.yootday1.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    public Optional<Teacher> findById(Long id){
        return teacherRepository.findById(id);
    }

    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher teacher){
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id){
        teacherRepository.deleteById(id);
    }
}
