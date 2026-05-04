package com.example.yootday1.controllers;

import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.domain.entity.Course;
import com.example.yootday1.domain.entity.Parent;
import com.example.yootday1.dto.parent.ParentResponse;
import com.example.yootday1.dto.parent.ParentUpsertRequest;
import com.example.yootday1.dto.student.StudentResponse;
import com.example.yootday1.dto.student.StudentUpsertRequest;
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
    public ResponseEntity<List<ParentResponse>> findAll(){
        return ResponseEntity.ok(parentService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ParentResponse> findById(@PathVariable Long id){
        return parentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ParentResponse> create(@Valid @RequestBody ParentUpsertRequest req){
        return ResponseEntity.ok(parentService.create(req));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ParentResponse> update(@PathVariable Long id,@Valid @RequestBody ParentUpsertRequest req){
        return ResponseEntity.ok(parentService.update(id,req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws  NotFoundException{
        parentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
