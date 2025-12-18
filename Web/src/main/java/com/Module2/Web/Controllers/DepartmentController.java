package com.Module2.Web.Controllers;

import com.Module2.Web.DTO.DepartmentDTO;
import com.Module2.Web.Entities.Department;
import com.Module2.Web.Services.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @GetMapping
    public List<DepartmentDTO> getAllDepartments()
    {
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable Long id)
    {
        return departmentService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDTO createDepartment(@RequestBody @Valid DepartmentDTO dto)
    {
        return departmentService.create(dto);
    }

    @PutMapping("/{id}")
    public DepartmentDTO updateDepartment(
            @PathVariable Long id, @RequestBody @Valid DepartmentDTO dto)
    {
        return departmentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartment(@PathVariable Long id)
    {
        departmentService.delete(id);
    }
}
