package com.example.yootday1.controllers;

import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.domain.entity.Course;
import com.example.yootday1.domain.entity.Parent;
import com.example.yootday1.service.ParentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parents")
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Parent>>> getParent(){
        return ResponseEntity.ok(ApiResponse.success(parentService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Parent>> getParentById(@PathVariable("id") Long id){
        Optional<Parent> parent = parentService.findById(id);
        if (parent.isPresent()){
            return ResponseEntity.ok((ApiResponse.success(parent.get())));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Parent>> create(@RequestBody Parent parent){
        return ResponseEntity.ok(ApiResponse.success(parentService.save(parent)));
    }
    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<Parent>> update(@PathVariable("id") Long id, @Valid @RequestBody Parent parent){
        return ResponseEntity.ok(ApiResponse.success(parentService.updateParent(id,parent)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Void>> detele(@PathVariable("id") Long id){
        parentService.deleteParent(id);
        return ResponseEntity.ok(ApiResponse.successMessage("Xoa Thanh cong"));
    }
}
