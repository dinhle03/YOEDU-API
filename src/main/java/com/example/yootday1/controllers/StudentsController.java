package com.example.yootday1.controllers;

import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.domain.entity.Student;
import com.example.yootday1.dto.student.StudentResponse;
import com.example.yootday1.dto.student.StudentUpsertRequest;
import com.example.yootday1.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.el.stream.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentsController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable Long id) {
        return studentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());

    }
    @PostMapping
    public ResponseEntity<StudentResponse> create(StudentUpsertRequest req){
        return ResponseEntity.ok(studentService.create(req));
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(@PathVariable Long id, StudentUpsertRequest req){
        return ResponseEntity.ok(studentService.update(id,req));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }
}