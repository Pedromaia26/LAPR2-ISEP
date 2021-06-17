package app.controller;

import app.domain.model.*;
import app.mappers.LaboratoryMapper;
import app.mappers.RolesMapper;
import app.mappers.dto.EmployeeDto;
import app.mappers.dto.LaboratoryDTO;
import app.mappers.dto.OrgRoleDto;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
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

    public RegistEmployeeController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this.company= App.getInstance().getCompany();
    }

    public List<OrgRoleDto> getRoles() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        rStore = App.getInstance().getCompany().getOrgRoleStore();
        rStore.addDefaultRoles();
        lRoles = rStore.getRoles();
        lRolesDto = rolesmapper.toDTO(lRoles);
        return lRolesDto;
    }

    public boolean createEmployee(EmployeeDto empDto) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this.emp = App.getInstance().getCompany().getEmployeeStore().createEmployee(empDto, this.company);
        return App.getInstance().getCompany().getEmployeeStore().validateEmployee(emp);
    }

    public boolean createSpecialistDoctor(EmployeeDto spedocdto) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this.empsd = App.getInstance().getCompany().getEmployeeStore().createSpecialistDoctor(spedocdto, this.company);
        return App.getInstance().getCompany().getEmployeeStore().validateSpecialistDoctor(empsd);
    }

    public List<Employee> getEmployeeList() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        return App.getInstance().getCompany().getEmployeeStore().getEmployeeList();
    }

    public List<SpecialistDoctor> getSpecialistDoctorList() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        return App.getInstance().getCompany().getEmployeeStore().getSpecialistDoctors();
    }

    public void saveEmployee() throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, ParseException, BarcodeException {
        App.getInstance().getCompany().getEmployeeStore().saveEmployee(emp);
        App.getInstance().getCompany().getEmployeeStore().createUser(emp);
    }

    public void saveSpecialistDoctor() throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, ParseException, BarcodeException {
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
