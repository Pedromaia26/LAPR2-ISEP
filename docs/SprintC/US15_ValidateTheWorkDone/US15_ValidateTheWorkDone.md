# US 015 - To validate the work done by the clinical chemistry technologist and specialist doctor

## 1. Requirements Engineering


### 1.1. User Story Description


  As a laboratory coordinator, I want to validate the work done by the clinical chemistry technologist and specialist doctor. 



### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	"After the specialist doctor has completed the diagnosis, the results of the clinical analyses and the report become available in the system and must be validated by the laboratory coordinator. To validate the work done, the laboratory coordinator checks the chemical test/result and associated diagnosis made and confirms that everything was done correctly."





**From the client clarifications:**

> **Question:** "Regarding the process of validating a certain test/result, what validation states should be considered by the laboratory coordinator? For example, can "Valid" or "Invalid" be accepted as a confirmation for the chemical test/result and its diagnosis?" - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8251#p10789]
>  
> **Answer:** Only valid state. The system shows all tests ready to validate and the laboratory coordinator selects one or more tests to mark as validated. 

-

> **Question:** "Should the laboratory coordinator validate the test results one by one or should he do only one validation of all of them?" - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8180#p10708]
>  
> **Answer:** The coordinator can validate all or a subset of test results.

-

> **Question:** "When the laboratory coordinator wants to validate a test does all the tests available show up for him or does he search using a code that identifies a specific test?" - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8177#p10704]
>  
> **Answer:** The system shows all tests ready to validate and the laboratory coordinator selects one or more tests to mark as validated.

-

> **Question:** "What should happen to a test if either the test report or the results are invalid?" - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8177#p10704]
>  
> **Answer:** The laboratory coordinator only sees the test dates of tests that already have all dates registered in the system.


### 1.3. Acceptance Criteria


* **AC1:** The system does not show client personal information but shows all dates (test registration date, chemical analysis date and diagnosis date).4


### 1.4. Found out Dependencies


* There is a dependency to "US012 Record the results of a given test" since the clinical chemistry technologist must have recorded the test results.
* There is a dependency to "US014 Make the diagnosis and write a report" since the specialist doctor must have made the diagnosis and written the report.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* a reference, 
	* a designation, 
	* an informal description
	* a technical description
	* an estimated duration
	* an estimated cost
	
* Selected data:
	* Test to be validated 


**Output Data:**

* List of tests ready to validate
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Alternative 1**

![US15_SSD](US15_SSD.svg)


**Other alternatives might exist.**

### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.


## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 

![US006_MD](US006_MD.svg)

### 2.2. Other Remarks

n/a


## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
|:-------------  |:--------------------- |:------------|:---------------------------- |
| Step 1  		 |	... interacting with the actor? | CreateTaskUI   |  Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model.           |
| 			  		 |	... coordinating the US? | CreateTaskController | Controller                             |
| 			  		 |	... instantiating a new Task? | Organization   | Creator (Rule 1): in the DM Organization has a Task.   |
| 			  		 | ... knowing the user using the system?  | UserSession  | IE: cf. A&A component documentation.  |
| 			  		 |	... knowing to which organization the user belongs to? | Platform  | IE: has registed all Organizations |
| 			  		 |							 | Organization   | IE: knows/has its own Employees|
| 			  		 |							 | Employee  | IE: knows its own data (e.g. email) |
| Step 2  		 |							 |             |                              |
| Step 3  		 |	...saving the inputted data? | Task  | IE: object created in step 1 has its own data.  |
| Step 4  		 |	...knowing the task categories to show? | Platform  | IE: Task Categories are defined by the Platform. |
| Step 5  		 |	... saving the selected category? | Task  | IE: object created in step 1 is classified in one Category.  |
| Step 6  		 |							 |             |                              |              
| Step 7  		 |	... validating all data (local validation)? | Task | IE: owns its data.| 
| 			  		 |	... validating all data (global validation)? | Organization | IE: knows all its tasks.| 
| 			  		 |	... saving the created task? | Organization | IE: owns all its tasks.| 
| Step 8  		 |	... informing operation success?| CreateTaskUI  | IE: is responsible for user interactions.  | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Organization
 * Platform
 * Task

Other software classes (i.e. Pure Fabrication) identified: 

 * CreateTaskUI  
 * CreateTaskController


## 3.2. Sequence Diagram (SD)

**Alternative 1**

![US006_SD](US006_SD.svg)

**Alternative 2**

![US006_SD](US006_SD_v2.svg)

## 3.3. Class Diagram (CD)

**From alternative 1**

![US006_CD](US006_CD.svg)

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





