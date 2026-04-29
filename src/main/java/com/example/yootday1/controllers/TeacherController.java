package com.example.yootday1.controllers;

import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.domain.entity.Parent;
import com.example.yootday1.domain.entity.Teacher;
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
    public ResponseEntity<ApiResponse<List<Teacher>>> getTeacher(){
        return ResponseEntity.ok(ApiResponse.success(teacherService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Teacher>> getTeacherById(@PathVariable("id") Long id){
        Optional<Teacher> teacher = teacherService.findById(id);
        if (teacher.isPresent()){
            return ResponseEntity.ok((ApiResponse.success(teacher.get())));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Teacher>> create(@RequestBody Teacher teacher){
        return ResponseEntity.ok(ApiResponse.success(teacherService.save(teacher)));
    }
    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<Teacher>> update(@PathVariable("id") Long id, @Valid @RequestBody Teacher teacher){
        return ResponseEntity.ok(ApiResponse.success(teacherService.updateTeacher(id,teacher)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Void>> detele(@PathVariable("id") Long id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok(ApiResponse.successMessage("Xoa Thanh cong"));
    }
}
