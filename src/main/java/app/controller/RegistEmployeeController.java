package app.controller;

import app.domain.model.*;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.FileNotFoundException;
import java.io.IOException;
<<<<<<< HEAD
import java.text.ParseException;
=======
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
import java.util.ArrayList;
import java.util.List;

public class RegistEmployeeController {
    private Company company;

    private OrgRoleStore rStore;

    private List<OrgRole> lRoles = new ArrayList<>();
    private List<OrgRoleDto> lRolesDto = new ArrayList<>();

    private Employee emp;
    private SpecialistDoctor empsd;

    private RolesMapper rolesmapper = new RolesMapper();

    private LaboratoryMapper laboratoryMapper = new LaboratoryMapper();


<<<<<<< HEAD
    public RegistEmployeeController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this.company= App.getInstance().getCompany();
    }

    public List<OrgRoleDto> getRoles() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
=======
    public RegistEmployeeController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
        this.company= App.getInstance().getCompany();
    }

    public List<OrgRoleDto> getRoles() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
        rStore = App.getInstance().getCompany().getOrgRoleStore();
        rStore.addDefaultRoles();
        lRoles = rStore.getRoles();
        lRolesDto = rolesmapper.toDTO(lRoles);
        return lRolesDto;
    }

<<<<<<< HEAD
    public boolean createEmployee(EmployeeDto empDto) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
=======
    public boolean createEmployee(EmployeeDto empDto) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
        this.emp = App.getInstance().getCompany().getEmployeeStore().createEmployee(empDto);
        return App.getInstance().getCompany().getEmployeeStore().validateEmployee(emp);
    }

<<<<<<< HEAD
    public boolean createSpecialistDoctor(EmployeeDto spedocdto) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
=======
    public boolean createSpecialistDoctor(EmployeeDto spedocdto) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
        this.empsd = App.getInstance().getCompany().getEmployeeStore().createSpecialistDoctor(spedocdto);
        return App.getInstance().getCompany().getEmployeeStore().validateSpecialistDoctor(empsd);
    }

<<<<<<< HEAD
    public List<Employee> getEmployeeList() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        return App.getInstance().getCompany().getEmployeeStore().getEmployeeList();
    }

    public List<SpecialistDoctor> getSpecialistDoctorList() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        return App.getInstance().getCompany().getEmployeeStore().getSpecialistDoctors();
    }

    public void saveEmployee() throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, ParseException, BarcodeException {
=======
    public List<Employee> getEmployeeList() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
        return App.getInstance().getCompany().getEmployeeStore().getEmployeeList();
    }

    public List<SpecialistDoctor> getSpecialistDoctorList() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
        return App.getInstance().getCompany().getEmployeeStore().getSpecialistDoctors();
    }

    public void saveEmployee() throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
        App.getInstance().getCompany().getEmployeeStore().saveEmployee(emp);
        App.getInstance().getCompany().getEmployeeStore().createUser(emp);
    }

<<<<<<< HEAD
    public void saveSpecialistDoctor() throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, ParseException, BarcodeException {
=======
    public void saveSpecialistDoctor() throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
        App.getInstance().getCompany().getEmployeeStore().saveSpecialistDoctor(empsd);
        App.getInstance().getCompany().getEmployeeStore().createUser(empsd);
    }


    public List<Laboratory> getLaboratory(){
        return this.company.getLaboratoryStore().getLaboratoryList();
    }

    public List<LaboratoryDTO> getLaboratoryDTO(){
        return this.laboratoryMapper.toDto(getLaboratory());
    }
}
