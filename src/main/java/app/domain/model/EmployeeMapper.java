package app.domain.model;

import app.controller.App;
import auth.domain.model.Email;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
<<<<<<< HEAD
import java.text.ParseException;
=======
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
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
<<<<<<< HEAD
    public static Employee toDtoE(EmployeeDto empDto) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
=======
    public static Employee toDtoE(EmployeeDto empDto) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
        String orgRole = empDto.getUserRole();
        String name = empDto.getNameDto();
        String employeeId = empDto.getId();
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
<<<<<<< HEAD
    public static SpecialistDoctor toDtoSD(EmployeeDto empDto) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
=======
    public static SpecialistDoctor toDtoSD(EmployeeDto empDto) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
        String orgRole = empDto.getUserRole();
        String name = empDto.getNameDto();
        String employeeId = empDto.getId();
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
