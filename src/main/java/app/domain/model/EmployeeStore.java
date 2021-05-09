package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {

    static List<Employee> Employees = new ArrayList<>();

    public static Employee createEmployee(Employee empDto){
        return EmployeeMapper.toDto(empDto, Employees);
    }

    public boolean validateEmployee(Employee emp){
        if(emp == null)
            return false;
        return !this.Employees.contains(emp);
    }

    public boolean addEmployee(Employee emp){
        if (!validateEmployee(emp))
            return false;
        return this.Employees.add(emp);
    }

    public void saveEmployee(Employee emp){
        Employees.add(emp);
    }

}
