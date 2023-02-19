package com.ngsystem.controller;

import com.ngsystem.dto.EmployeeDTO;
import com.ngsystem.model.Employee;
import com.ngsystem.service.IEmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService service;
    @Qualifier("employeeMapper")
    private final ModelMapper mapper;
    //traer todos los empleados

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> readAll() throws Exception{
        List<EmployeeDTO> list=service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    //trae por id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Employee obj=service.readByid(id);
        return new ResponseEntity<>(this.convertToDto(obj),HttpStatus.OK);
    }
    //crear un empleado
    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody  EmployeeDTO dto) throws Exception{
        Employee obj=service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody EmployeeDTO dto) throws Exception{
        dto.setIdEmploye(id) ;
        Employee obj= service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    private EmployeeDTO convertToDto(Employee obj){
        return mapper.map(obj,EmployeeDTO.class);
    }
    private Employee convertToEntity(EmployeeDTO dto){
        return mapper.map(dto, Employee.class);
    }
}
