package com.Module2.Web.Services;

import com.Module2.Web.DTO.DepartmentDTO;
import com.Module2.Web.Entities.Department;
import com.Module2.Web.Exceptions.ResourceNotFoundException;
import com.Module2.Web.Repositories.DepartmentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;
    public List<DepartmentDTO> getAll()
    {
        return departmentRepository.findAll()
                .stream()
                .map(dept -> modelMapper.map(dept, DepartmentDTO.class))
                .toList();
    }
    public DepartmentDTO getById(Long id)
    {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Department not found" + id));
                return modelMapper.map(department, DepartmentDTO.class);

    }
    public DepartmentDTO create(@Valid DepartmentDTO dto)
    {
        Department department = modelMapper.map(dto, Department.class);
        Department saved = departmentRepository.save(department);
        return modelMapper.map(department, DepartmentDTO.class);
    }
    public DepartmentDTO update(Long id, @Valid DepartmentDTO dto)
    {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department not found with id: " + id));
        department.setTitle(dto.getTitle());
        department.setIsActive(dto.getIsActive());
        Department updated = departmentRepository.save(department);
        return modelMapper.map(updated, DepartmentDTO.class);
    }
    public void delete(Long id)
    {
        if(!departmentRepository.existsById(id))
        {
            throw new ResourceNotFoundException("Department not found with id: "+ id);
        }
        departmentRepository.deleteById(id);
    }
}
