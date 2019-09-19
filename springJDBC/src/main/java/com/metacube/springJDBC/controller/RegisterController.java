package com.metacube.springJDBC.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.springJDBC.entities.Employee;
import com.metacube.springJDBC.entities.Organization;
import com.metacube.springJDBC.entities.Pass;
import com.metacube.springJDBC.entities.Vehicle;
import com.metacube.springJDBC.facade.EmployeeFacade;
import com.metacube.springJDBC.facade.OrganizationFacade;
import com.metacube.springJDBC.facade.PassFacade;
import com.metacube.springJDBC.facade.VehicleFacade;
import com.metacube.springJDBC.validators.CustomValidator;

@Controller
public class RegisterController {

	
	
	@Autowired
	EmployeeFacade empfacade;
	

	@Autowired
	OrganizationFacade orgFacade;
	

	@Autowired
	VehicleFacade vehiclefacade;
	
	@Autowired
	PassFacade passfacade;
	
		
	@Autowired
	@Qualifier("PasswordValidator")
	CustomValidator passwordValidator;
	
	@RequestMapping("/")
	public String home(Model model) throws Exception{
		Employee employee = new Employee();
		List<Organization> org_list = orgFacade.getAllOrganization();
		model.addAttribute("orgList", org_list);
		model.addAttribute("employee", employee);
		return "index";
	}
	
	@RequestMapping("/Register")
	public String registerEmployee(@Valid @ModelAttribute ("employee") Employee emp,BindingResult errorResult , Model model) throws Exception{
		passwordValidator.passwordMisMatch(emp, errorResult);
		if(errorResult.hasErrors()) {
			List<Organization> org_list = orgFacade.getAllOrganization();
			model.addAttribute("orgList", org_list);
			return "index";
		}
		Vehicle vehicle = new Vehicle();
		
			int res = empfacade.insertEmployee(emp);
			if(res>0){
				vehicle.setEmp_id(empfacade.getLastInsertedEmpId());
				model.addAttribute("vehicle",vehicle);
			}
			else{
				model.addAttribute("message", "Email Already Exist");
				Employee employee = new Employee();
				List<Organization> org_list = orgFacade.getAllOrganization();
				model.addAttribute("orgList", org_list);
				model.addAttribute("employee", employee);
				return "index";
			}
		
		return "vehicleform";
	}
	
	@RequestMapping("/vehicleRegister")
	public String VehicleRegister(@Valid @ModelAttribute ("vehicle") Vehicle vehicle,BindingResult errorResult , Model model) throws Exception{
		
		if(errorResult.hasErrors()) {
			return "vehicleform";
		}
		Pass pass = new Pass();
		if(vehiclefacade.insertVehicle(vehicle)>0){
			
			pass.setPass_type(vehicle.getType());
			pass.setEmp_id(vehicle.getEmp_id());
			pass.setVehicle_id(vehiclefacade.getlastInsertedVehicleId());
		}
		else{
			model.addAttribute("message", "Some error Occur!! Try Again");
			Employee employee = new Employee();
			List<Organization> org_list = orgFacade.getAllOrganization();
			model.addAttribute("orgList", org_list);
			model.addAttribute("employee", employee);
			return "index";
		}
		model.addAttribute("pass", pass);
		
		return "generate_pass";
	}

	@RequestMapping("/PassGenerated")
	public String pass(Model model,@RequestParam("plan") String plan,@ModelAttribute("pass") Pass pass) throws Exception{
		String rate = "";
		if( pass.getPass_type().equals("CYCLE")){
			if(plan.equals("daily"))
				rate="$0.6";
			else if(plan.equals("monthly"))
				rate="$1.38";
			else
				rate = "$6.94";
		}
		else if(pass.getPass_type().equals("MOTOR CYCLE")){
			if(plan.equals("daily"))
				rate="$0.13";
			else if(plan.equals("monthly"))
				rate="$2.77";
			else
				rate = "$13.88";	
		}
		else if(pass.getPass_type().equals("FOUR WHEELER")){
			if(plan.equals("daily"))
				rate="$0.277";
			else if(plan.equals("monthly"))
				rate="$6.94";
			else
				rate = "$48.61";
		}
		pass.setRate(rate);
		passfacade.insertPass(pass);
		model.addAttribute("message", "Register Successfully");
		Employee employee = new Employee();
		List<Organization> org_list = orgFacade.getAllOrganization();
		model.addAttribute("orgList", org_list);
		model.addAttribute("employee", employee);
		return "index";	
	}
}

