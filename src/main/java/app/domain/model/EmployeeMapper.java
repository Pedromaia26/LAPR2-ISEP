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
     * @return A new Employee
     */
    public static Employee toDtoE(EmployeeDto empDto){
        String orgRole = empDto.getUserRole();
        String name = empDto.getNameDto();
        String employeeId = empDto.getId();
        String address = empDto.getAdressDto();
        long phoneNumber = empDto.getPhoneNumberDto();
        Email email = empDto.getEmailDto();
        int socCode = empDto.getSocCodeDto();

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
        String name = empDto.getNameDto();
        String employeeId = empDto.getId();
        String address = empDto.getAdressDto();
        long phoneNumber = empDto.getPhoneNumberDto();
        Email email = empDto.getEmailDto();
        int socCode = empDto.getSocCodeDto();
        int docIndexNumber = empDto.getDocIndexNumberDto();

        return App.getInstance().getCompany().getOrgRole().createEmployee(orgRole, employeeId, name, address, phoneNumber, email, socCode, docIndexNumber);
    }

}
