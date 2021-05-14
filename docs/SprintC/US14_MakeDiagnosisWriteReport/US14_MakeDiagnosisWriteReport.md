# US 007 - To resgister a new Employee 

## 1. Requirements Engineering


### 1.1. User Story Description


As an administrator, I want to resgister a new employee.



### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**


**From the client clarifications:**

> **Question:** Which attributes a employee have?
>  
> **Answer:** Employee ID, Organization Role, Name, Address, Phone Number, E-Mail, Standard Occupational Classification (SOC) code.
>
> **Question:** "When creating a new employee, the attributes 'Employee ID' and 'Doctor Index Number', are implemented by the administrator or incremented by the system?" - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=7547#p10159]
>
> **Answer:** Only the employee ID should be generated. The Doctor Index Number should be introduced by the administrator.
>
> **Question:** "Regarding the registration of a new employee, which is the organization role's format?" - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=7928#p10353]
> 
> **Answer:** "Organization Role: a string with no more than 15 characters."
> 
> **Question:** When the application is delivered, should it have default employees, ex:administrator, or should be completly empty (without any user or employee)? - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=7668#p9993]
> 
> **Answer:** "One Administrator must be registered before starting the application for the first time."
> 
> **Question:** "Are there any other employee roles than the ones specified in the documents?" - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=7738#p10084]
> 
> **Answer:** "No."
>
> **Question:** "Is there any size limit to the employee's name?" - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=7973]
>
> **Answer:** "Employee Name: 'a string with no more than 35 characters'."

### 1.3. Acceptance Criteria


* **AC1:** "Each user must have a single role defined in the system."
* **AC2:** "The "auth" component available on the repository must be reused (without modifications)."
* **AC3:** "The employee ID should be generated from the initials of the employee name and should include a number. The number has 5 digits and is increases automatically when a new employee is registered in the system."
* **AC4:** "Employee Name: a string with no more than 35 characters."
* **AC5:** "Organization Role: a string with no more than 15 characters."
* **AC6:** "SOC code: a number with 4 digits."
* **AC7:** "Doctor Index Number: a number with 6 digits."


### 1.4. Found out Dependencies

* No dependecies founded.

### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* an user role,
	* a name,
	* an adress,
	* a phone number,
	* an e-mail,
	* a standard occupational classification code,
	* a doctor index number.
	
* Selected data:
	* an organization role.
	
* Generated data:
	* an employeeID.


**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Alternative 1**

![US007_SSD](US007_SSD.svg)


### 1.7 Other Relevant Remarks

n/a


## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 

![US007_MD](US007_MD.svg)

### 2.2. Other Remarks

n/a


## 3. Design - User Story Realization 

### 3.1. Rationale


### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Company
 * AuthFacade
 * Employee

Other software classes identified: 

 * RegistEmployeeUI  
 * RegistEmployeeController
 * RolesMapper
 * EmployeeStore
 * EmployeeMapper
 * EmployeeDto
 * RolesStore
 * OrgRole


## 3.2. Sequence Diagram (SD)

**Alternative 1**

![US006_SD](US007_SD.svg)

## 3.3. Class Diagram (CD)

**From alternative 1**

![US007_CD](US007_CD.svg)

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Task class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Task instance = new Task(null, null, null, null, null, null, null);
	}
	

**Test 2:** Check that it is not possible to create an instance of the Task class with a reference containing less than five chars - AC2. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureReferenceMeetsAC2() {
		Category cat = new Category(10, "Category 10");
		
		Task instance = new Task("Ab1", "Task Description", "Informal Data", "Technical Data", 3, 3780, cat);
	}


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class CreateTaskController 

		public boolean createTask(String ref, String designation, String informalDesc, 
			String technicalDesc, Integer duration, Double cost, Integer catId)() {
		
			Category cat = this.platform.getCategoryById(catId);
			
			Organization org;
			// ... (omitted)
			
			this.task = org.createTask(ref, designation, informalDesc, technicalDesc, duration, cost, cat);
			
			return (this.task != null);
		}


## Class Organization


		public Task createTask(String ref, String designation, String informalDesc, 
			String technicalDesc, Integer duration, Double cost, Category cat)() {
		
	
			Task task = new Task(ref, designation, informalDesc, technicalDesc, duration, cost, cat);
			if (this.validateTask(task))
				return task;
			return null;
		}



# 6. Integration and Demo 

* A new option on the Employee menu options was added.

* Some demo purposes some tasks are bootstrapped while system starts.


# 7. Observations

Platform and Organization classes are getting too many responsibilities due to IE pattern and, therefore, they are becoming huge and harder to maintain. 

Is there any way to avoid this to happen?





