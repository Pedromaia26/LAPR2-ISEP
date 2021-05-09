package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeMapper extends UserRoleStore{

    public static Employee toDto(Employee empDto, List<Employee> Employees){
        String userRole = empDto.getUserRole();
        String name = empDto.getName();
        String employeeId = "";
        for (int i = 0; i < name.length(); i++){
            if(name.charAt(i) == ' '){
                employeeId += Character.toUpperCase(name.charAt(i+1));
            }
        }
        String numEmployees = String.format("%05d", Employees.size()+1);
        employeeId += numEmployees;
        String address = empDto.getAdress();
        long phoneNumber = empDto.getPhoneNumber();
        Email email = empDto.getEmail();
        int socCode = empDto.getSocCode();

        return new Employee(userRole, employeeId, name, address, phoneNumber, email, socCode);
    }

}
