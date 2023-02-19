package com.ngsystem.service.Impl;

import com.ngsystem.model.Employee;
import com.ngsystem.repository.IEmployeeRepo;
import com.ngsystem.repository.IGenericRepo;
import com.ngsystem.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl extends CRUDImpl<Employee,Integer> implements IEmployeeService {

    private final IEmployeeRepo repo;
    @Override
    protected IGenericRepo<Employee, Integer> getRepo() {
        return repo;
    }
}
