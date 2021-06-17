package app.mappers;

import app.controller.App;
import app.domain.model.*;
import app.mappers.DTO.EmployeeDto;
import auth.domain.model.Email;
import auth.domain.store.UserRoleStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;

public class EmployeeMapper extends UserRoleStore{

    /**
     * Divide into attributes the Employee received by parameter.
     * Returns a new Employee.
     * @param empDto A EmployeeDto instance
     * @return A new Employee
     */
    public static Employee toDtoE(EmployeeDto empDto, Company company) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        String orgRole = empDto.getUserRole();
        String name = empDto.getNameDto();
        String employeeId = empDto.getId(company);
        String address = empDto.getAdressDto();
        long phoneNumber = empDto.getPhoneNumberDto();
        Email email = empDto.getEmailDto();
        int socCode = empDto.getSocCodeDto();
        String labId= empDto.getLabID();

        Laboratory lab= App.getInstance().getCompany().getLaboratoryStore().getLabByLabId(labId);

        return App.getInstance().getCompany().getOrgRole().createEmployee(orgRole, employeeId, name, address, phoneNumber, email, socCode, lab);
    }

    /**
     * Divide into attributes the Specialist Doctor received by parameter.
     * Returns a new Specialist Doctor.
     * @param empDto A EmployeeDto instance
     * @return A new Specialist Doctor
     */
    public static SpecialistDoctor toDtoSD(EmployeeDto empDto, Company company) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        String orgRole = empDto.getUserRole();
        String name = empDto.getNameDto();
        String employeeId = empDto.getId(company);
        String address = empDto.getAdressDto();
        long phoneNumber = empDto.getPhoneNumberDto();
        Email email = empDto.getEmailDto();
        int socCode = empDto.getSocCodeDto();
        int docIndexNumber = empDto.getDocIndexNumberDto();
        String labId= empDto.getLabID();

        Laboratory lab= App.getInstance().getCompany().getLaboratoryStore().getLabByLabId(labId);

        return App.getInstance().getCompany().getOrgRole().createEmployee(orgRole, employeeId, name, address, phoneNumber, email, socCode,lab, docIndexNumber);
    }

}
