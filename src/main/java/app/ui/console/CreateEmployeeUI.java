package app.ui.console;

import app.controller.App;
import app.controller.RegistEmployeeController;
import app.mappers.dto.EmployeeDto;
import app.mappers.dto.LaboratoryDTO;
import app.mappers.dto.OrgRoleDto;
import auth.domain.model.Email;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class CreateEmployeeUI  implements Runnable{
    public CreateEmployeeUI()
    {
    }

    public void run() {
        Scanner ler = new Scanner(System.in);
        RegistEmployeeController employeeController = null;
        try {
            employeeController = new RegistEmployeeController();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException | IOException | OutputException | ParseException | BarcodeException e) {
            e.printStackTrace();
        }

        List<OrgRoleDto> lRolesDto = null;
        try {
            lRolesDto = employeeController.getRoles();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException | IOException | OutputException | ParseException | BarcodeException e) {
            e.printStackTrace();
        }

        String op;
        String role = null;
        int num;
        int docIndexNumber = 0;
        boolean exists = false;

        System.out.print("List of employee roles:\n");

        for(OrgRoleDto orgRole : lRolesDto){
            System.out.printf("%d - %s%n",lRolesDto.indexOf(orgRole)+1, orgRole.getDesignation());
        }
        System.out.print("Select a role:\n");
        String Orgop = ler.nextLine();
        try {
            if (Integer.parseInt(Orgop) <= lRolesDto.size() && Integer.parseInt(Orgop) >=1) {
                role = lRolesDto.get(Integer.parseInt(Orgop)-1).getDesignation();
                exists = true;
            }

        } catch (NumberFormatException e) {
            for (OrgRoleDto orgRole : lRolesDto){
                if (Orgop.equalsIgnoreCase(orgRole.getDesignation())){
                    role = orgRole.getDesignation();
                    exists = true;
                }
            }
        }

        if (exists) {
            try {
                System.out.println("Select the LaboratoryID to work");
                List<LaboratoryDTO> laboratoryDTO = employeeController.getLaboratoryDTO();
                for(LaboratoryDTO dto: laboratoryDTO){
                    System.out.printf("Laboratory:%nLab ID: %s%nLab Name: %s%nPhone Number: %d%n", dto.getLaboratoryIDDto(),dto.getNameDto(),dto.getPhoneNumberDto());
                }
                String labId= ler.nextLine();
                System.out.print("Name: ");
                String name = ler.nextLine();
                System.out.print("Address: ");
                String address = ler.nextLine();
                System.out.print("Phone number: ");
                long phoneNumber = ler.nextLong();
                ler.nextLine();
                System.out.print("Email: ");
                String m = ler.nextLine();
                Email email = new Email(m);
                System.out.print("SOC code: ");
                int socCode = ler.nextInt();
                ler.nextLine();
                if (role.equalsIgnoreCase("specialist doctor")) {
                    System.out.print("Doctor Index Number: ");
                    docIndexNumber = ler.nextInt();
                    if (employeeController.createSpecialistDoctor(new EmployeeDto(role, name, address, phoneNumber, email, socCode,labId, docIndexNumber))) {
                        ConfirmDataSave(role, name, address, phoneNumber, email, socCode, docIndexNumber, employeeController);
                    } else System.out.print("Employee created without success.\n");
                } else {
                    if (employeeController.createEmployee(new EmployeeDto(role, name, address, phoneNumber, email, socCode, labId))) {
                        ConfirmDataSave(role, name, address, phoneNumber, email, socCode, docIndexNumber, employeeController);
                    } else System.out.print("Employee created without success.\n");
                }
            }catch (Exception e){
                System.out.println("Invalid data");
            }
        }
        else{
            System.out.println("The selected role does not exist.");
        }
    }

    public void ConfirmDataSave(String role, String name, String address, long phoneNumber, Email email, int socCode, int docIndexNumber, RegistEmployeeController employeeController) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        String op;
        Scanner ler = new Scanner(System.in);

        if (docIndexNumber == 0){
            System.out.print("Data confirmation:\n");
            System.out.printf("User Role: %s%nName: %s%nAddress: %s%nEmail: %s%nPhone number: %d%nSOC code: %d%n", role, name, address, email, phoneNumber, socCode);
        }
        else{
            System.out.print("Data confirmation:\n");
            System.out.printf("User Role: %s%nName: %s%nAddress: %s%nEmail: %s%nPhone number: %d%nSOC code: %d%nDoctorIndexNumber: %d%n", role, name, address, email, phoneNumber, socCode, docIndexNumber);
        }
        System.out.print("Do you want to create the employee?(Y/N)\n");
        op = ler.next();
        if (op.equalsIgnoreCase("Y") || op.equalsIgnoreCase("yes")) {
            if (!App.getInstance().getCompany().getAuthFacade().existsUser(String.valueOf(email))) {
                try {
                    if (docIndexNumber == 0) employeeController.saveEmployee();
                    else employeeController.saveSpecialistDoctor();
                    System.out.print("Employee created with success.\n");
                } catch (IOException | OutputException | ParseException | BarcodeException e) {
                    e.printStackTrace();
                }
            } else {
                throw new IllegalArgumentException("Employee already created.");
            }
        } else System.out.print("Employee regist canceled.\n");
    }
}
