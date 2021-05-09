package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;

import java.util.List;
import java.util.List;
import java.util.List;

public class EmployeeMapper extends UserRoleStore{

    public static Employee toDto(EmployeeDto empDto, List<Employee> Employees){
        UserRole userRole = empDto.getUserRole();
        String name = empDto.getName();
        StringBuilder employeeId = new StringBuilder();
        for (int i = 0; i < name.length(); i++){
            if (i == 0){
                employeeId.append(Character.toUpperCase(name.charAt(i)));
            }
            if(name.charAt(i) == ' '){
                employeeId.append(Character.toUpperCase(name.charAt(i + 1)));
            }
        }
        String numEmployees = String.format("%05d", Employees.size()+1);
        employeeId.append(numEmployees);
        String address = empDto.getAdress();
        long phoneNumber = empDto.getPhoneNumber();
        Email email = empDto.getEmail();
        int socCode = empDto.getSocCode();

        return new Employee(userRole, employeeId.toString(), name, address, phoneNumber, email, socCode);
    }

    public static SpecialistDoctor toDto(List<SpecialistDoctor> SpecialistDoctors, EmployeeDto empDto){
        UserRole userRole = empDto.getUserRole();
        String name = empDto.getName();
        String employeeId = "";
        for (int i = 0; i < name.length(); i++){
            if(name.charAt(i) == ' '){
                employeeId += Character.toUpperCase(name.charAt(i+1));
            }
        }
        String numEmployees = String.format("%05d", SpecialistDoctors.size()+1);
        employeeId += numEmployees;
        String address = empDto.getAdress();
        long phoneNumber = empDto.getPhoneNumber();
        Email email = empDto.getEmail();
        int socCode = empDto.getSocCode();
        int docIndexNumber = empDto.getDocIndexNumber();

        return new SpecialistDoctor(userRole, employeeId, name, address, phoneNumber, email, socCode, docIndexNumber);
    }

}
