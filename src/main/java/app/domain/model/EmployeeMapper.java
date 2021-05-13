package app.domain.model;

import app.controller.App;
import auth.domain.model.Email;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;

import java.util.List;
import java.util.List;
import java.util.List;

public class EmployeeMapper extends UserRoleStore{

    /**
     * Divide into attributes the Employee received by parameter.
     * Returns a new Employee.
     * @param empDto A EmployeeDto instance
     * @param Employees A List of Employees
     * @return A new Employee
     */
    public static Employee toDto(EmployeeDto empDto, List<Employee> Employees){
        OrgRole orgRole = empDto.getUserRole();
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

        return App.getInstance().getCompany().getOrgRole().createEmployee(orgRole, employeeId.toString(), name, address, phoneNumber, email, socCode);
    }

    /**
     * Divide into attributes the Specialist Doctor received by parameter.
     * Returns a new Specialist Doctor.
     * @param SpecialistDoctors A List of Specialist Doctors
     * @param empDto A EmployeeDto instance
     * @return A new Specialist Doctor
     */
    public static SpecialistDoctor toDto(List<SpecialistDoctor> SpecialistDoctors, EmployeeDto empDto){
        OrgRole orgRole = empDto.getUserRole();
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
        String numEmployees = String.format("%05d", SpecialistDoctors.size()+1);
        employeeId.append(numEmployees);
        String address = empDto.getAdress();
        long phoneNumber = empDto.getPhoneNumber();
        Email email = empDto.getEmail();
        int socCode = empDto.getSocCode();
        int docIndexNumber = empDto.getDocIndexNumber();

        return App.getInstance().getCompany().getOrgRole().createEmployee(orgRole, employeeId.toString(), name, address, phoneNumber, email, socCode, docIndexNumber);
    }

}
