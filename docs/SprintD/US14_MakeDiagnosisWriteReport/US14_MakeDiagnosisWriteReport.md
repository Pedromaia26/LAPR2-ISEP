# US 014 - To make a Diagnosis and write a Report 

## 1. Requirements Engineering


### 1.1. User Story Description


As a specialist doctor, I intend to make the diagnosis and write a report for a given test.



### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**


>	"The results of all chemical analyses are analysed by a specialist doctor who makes a diagnosis and writes a report that afterwards will be delivered to the client."


**From the client clarifications:**

> **Question:** "Once the specialist doctor decides to write the report for a given test, should the results of the chemical analysis and the reference values be presented on the screen? If not, how should the specialist doctor access the data related to the diagnosis he needs to make?" [link - https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8497#p11126]
>  
> **Answer:** "After selecting a test (to make the diagnosis/report) the results of the chemical analysis and the reference values should be presented on the screen. Then the Specialist Doctor should write the report."

-

> **Question:** "Should we order the list of tests to be displayed by date of chemical analysis older to newer?" [link - https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8571#p11230]
>  
> **Answer:** "Sorting is not required in this sprint."

-

> **Question:** "What kind of validation should the external module do? Should it show the test reference values next to the test parameter results for the Specialist Doctor to validate it by himself? Or should it show on the console that the values of the test parameter results are valid, doing everything automatically?" [link - https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8643#p11312]
> 
> **Answer:** "The system should 'show the test reference values next to the test parameter results'."

-

> **Question:** "What characterizes a diagnosis? What it needs to have in it to be a valid diagnosis?" [link - https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8292#p10845]
>
> **Answer:** "The report contains the diagnosis. The report is free text and should have no more than 400 words."

-

> **Question:** "Regarding the tests that the Specialist Doctor can write a report about. Should the SD chose from a list of tests? and Should him only receive a list of test that have completed all the previous steps?" [link - https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8250#p10889]
> 
> **Answer:** "The system shows all tests ready (that have completed all the previous steps) to make the diagnosys and the Specialist Doctor selects one test. Then, the Specialist Doctor writes the report for the selected test."

-

> **Question:** "Can the Specialist Doctor edit a report once it has already been written?" [link - https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8268#p10898]
>
> **Answer:** "No."

-

> **Question:** "Once the specialist doctor decides to write the report for a given test, should the results of the chemical analysis and the reference values be presented on the screen?" [link - https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8497#p11183]

> **Answer:** "After selecting a test (to make the diagnosis/report) the results of the chemical analysis and the reference values should be presented on the screen. Then the Specialist Doctor should write the report."

-

> **Question:** "While in the 'Make a diagnosis and write a report' option of the main menu, should the specialist doctor be able to make a diagnosis and write a report for more than one test?" [link - https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8497#p11183]

> **Answer:** "After writing a report the SD can choose to write other reports without leaving the use case."

### 1.3. Acceptance Criteria


* **AC1:** The report is free text and should have no more than 400 words.


### 1.4. Found out Dependencies


* There is a dependency to "US012 Record the results of a test" since at least a result of a test must recorded to create the corresponding report and diagnosis.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* a Report.
	
* Selected data:
	* Test to be perfomed a report and diagnosis.


**Output Data:**

* List of tests;
* List of test parameters;  
* (In)success of the operation.

### 1.6. System Sequence Diagram (SSD)

![US014_SSD](US014_SSD.svg)

### 1.7 Other Relevant Remarks


## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 

![US014_MD](US014_MD.svg)

### 2.2. Other Remarks

n/a


## 3. Design - User Story Realization 

### 3.1. Rationale

| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
|:-------------  |:--------------------- |:------------|:---------------------------- |
| Step 1  		 |	... interacting with the actor? | WriteReportUI   |  Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model.           |
| 			  		 |	... coordinating the US? | WriteReportController | Controller.                             |
| Step 2  		 |	... knowing the existing tests?	 |  TestStore  |  IE: TestStore has the responsability to know all the tests.                            |
| 	 |	... knowing the TestStore?	 |  Company  |  IE: Company has the responsability to know the TestStore.                            |
|  		 |	... transfer the domain objects in DTO?	 |  TestMapper  |  DTO: The WriteReportUI can't have access to the tests.                            |
| Step 3  		 |	 |   |   |
| Step 4  		 |	... knowing the test parameters to show? | Test  | IE: Test knows its own results. |
| Step 5  		 |	... create a new instance of Report? | Test  | Creator(Rule 1).  |
|  		 |	... validating the Report? | Report  | IE: Report knows its onw information.  |
| Step 6  		 |		 |  |                              |              
| Step 7  		 |	... save the creation date? | Report | IE: Report knows its onw information. |
|  		 |	... validate the data?	 |  Report  |  IE: Report knows its onw information.                            |
|  		 |	... create a new instance of Report?	 |  Test  |  Creator(Rule 1).                            |
| Step 8  		 |	... informing operation success? | WriteReportUI  | IE: is responsible for user interactions.  | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Company
 * Test
 * Report

Other software classes (i.e. Pure Fabrication) identified: 

 * WriteReportUI
 * WriteReportController
 * TestStore
 * TestMapper
 * TestDto
 * TestParameterMapper


## 3.2. Sequence Diagram (SD)

![US014_SD](US014_SD.svg)

## 3.3. Class Diagram (CD)

![US014_CD](US014_CD.svg)

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





