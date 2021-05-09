package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {

    static List<Employee> Employees = new ArrayList<>();
    static List<SpecialistDoctor> SpecialistDoctors = new ArrayList<>();

    public static Employee createEmployee(EmployeeDto empDto){
        return EmployeeMapper.toDto(empDto, Employees);
    }

    public static SpecialistDoctor createSpecialistDoctor(EmployeeDto specdocdto){
        return EmployeeMapper.toDto(SpecialistDoctors, specdocdto);
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

    public List<Employee> getEmployeeList(){
        return Employees;
    }

    public void saveEmployee(Employee emp){
        Employees.add(emp);
    }

    public void saveSpecialistDoctor(SpecialistDoctor emp){
        SpecialistDoctors.add(emp);
    }

    public List<SpecialistDoctor> getSpecialistDoctors(){
        return SpecialistDoctors;
    }

    public boolean validateSpecialistDoctor(SpecialistDoctor emp){
        if(emp == null)
            return false;
        return !this.SpecialistDoctors.contains(emp);
    }

}
