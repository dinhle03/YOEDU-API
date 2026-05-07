package com.example.yootday1.controllers;

import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.domain.entity.Parent;
import com.example.yootday1.domain.entity.Teacher;
import com.example.yootday1.dto.parent.ParentResponse;
import com.example.yootday1.dto.parent.ParentUpsertRequest;
import com.example.yootday1.dto.teacher.TeacherResponse;
import com.example.yootday1.dto.teacher.TeacherUpsertRequest;
import com.example.yootday1.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherResponse>> findAll(){
        return ResponseEntity.ok(teacherService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TeacherResponse> findById(@PathVariable Long id){
        return teacherService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TeacherResponse> create(@Valid @RequestBody TeacherUpsertRequest req){
        return ResponseEntity.ok(teacherService.create(req));
    }
    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponse> update(@PathVariable Long id,@Valid @RequestBody TeacherUpsertRequest req){
        return ResponseEntity.ok(teacherService.update(id,req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {
        teacherService.delete(id);
        return ResponseEntity.ok().build();
    }
}
