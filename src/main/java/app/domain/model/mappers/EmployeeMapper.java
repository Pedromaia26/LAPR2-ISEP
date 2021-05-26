package app.domain.model.mappers;

import app.controller.App;
import app.domain.model.Employee;
import app.domain.model.SpecialistDoctor;
import app.domain.model.dto.EmployeeDto;
import auth.domain.model.Email;
import auth.domain.store.UserRoleStore;

public class EmployeeMapper extends UserRoleStore{

    /**
     * Divide into attributes the Employee received by parameter.
     * Returns a new Employee.
     * @param empDto A EmployeeDto instance
     * @return A new Employee
     */
    public static Employee toDtoE(EmployeeDto empDto){
        String orgRole = empDto.getUserRole();
        String name = empDto.getName();
        String employeeId = empDto.getId();
        String address = empDto.getAdress();
        long phoneNumber = empDto.getPhoneNumber();
        Email email = empDto.getEmail();
        int socCode = empDto.getSocCode();

        return App.getInstance().getCompany().getOrgRole().createEmployee(orgRole, employeeId, name, address, phoneNumber, email, socCode);
    }

    /**
     * Divide into attributes the Specialist Doctor received by parameter.
     * Returns a new Specialist Doctor.
     * @param empDto A EmployeeDto instance
     * @return A new Specialist Doctor
     */
    public static SpecialistDoctor toDtoSD(EmployeeDto empDto){
        String orgRole = empDto.getUserRole();
        String name = empDto.getName();
        String employeeId = empDto.getId();
        String address = empDto.getAdress();
        long phoneNumber = empDto.getPhoneNumber();
        Email email = empDto.getEmail();
        int socCode = empDto.getSocCode();
        int docIndexNumber = empDto.getDocIndexNumber();

        return App.getInstance().getCompany().getOrgRole().createEmployee(orgRole, employeeId, name, address, phoneNumber, email, socCode, docIndexNumber);
    }

}
