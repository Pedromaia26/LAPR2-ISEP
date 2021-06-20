# US 018 - To send a report

## 1. Requirements Engineering


### 1.1. User Story Description


As an Administrator I want to send the Covid-19 report to the NHS at any time. I want to define the interval of dates to fit the regression model, the number of historical points (number of days or number of weeks) that must be sent to the NHS, the regression model to use and select the independent variables to use. 



### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

> ""




**From the client clarifications:**

> **Question:** "In US 18, should we ask the user to select which parameter he/she wants be analyzed for the hypothesis tests (a or b)?"
>  
> **Answer:** "Yes." - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9234]

> **Question:** "If on a certain day or week there aren't any Covid 19 tests realized and therefore no clients, should we consider the mean age to be 0?"
>  
> **Answer:** "Yes, you should consider the mean age to be zero. Sundays should not be considered in your analysis." - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9297#p12183]

> **Question:** "Should the reports sent to the NHS be saved in the app, or are they just sent?"
>  
> **Answer:** "There is no need to save the report in the app." - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9271#p12173]

> **Question:** "From the report example we got that the administrator defines the dates interval to fit the model. Which date should the application use to provide the report? Is it the registration date or results registration date?"
>  
> **Answer:** "The registration date should be considered. But only tests that have already been validated should be considered." - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8944#p11884]

> **Question:** "Should the number of historical points have the same range as the date interval defined by the administrator?"
>  
> **Answer:** "No. The points within the interval are used to fit the linear regression model. The number of historical points are the points for which we want to send the estimates/expect values to NHS. The points within the interval and historical points can overlap. Please carefully review the report example file available in moodle." - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8942#p11881]





### 1.3. Acceptance Criteria


* **AC1:** The sunday day may not be consider as a work day;


### 1.4. Found out Dependencies


### 1.5 Input and Output Data


**Input Data:**
	
* Selected data: day;
				data to add to NHS report;
				interval;
* Typed data: number of historical points;
		      regression model;
			  significance level;
			  confident level;

**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Alternative 1**

![US018_SSD.svg](US018_SSD.svg)



### 1.7 Other Relevant Remarks


## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 

![US018_MD.svg](US018_MD.svg)

### 2.2. Other Remarks

n/a


## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID | Question: Which class is responsible for...                     | Answer                        | Justification (with patterns)                                                                                                                                                                          |
|:-------------  |:--------------------------------------------------------------- |:-----------------------------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Step 1  		 | ... interacting with the actor?                                 | RecordSampleUI                | **Pure Fabrication**: none of the domain models classes had the responsability of interactiong with the user.                                                                                          |
|                | ... coordinating the US?                                        | RecordSampleController        | **Controller**                                                                                                                                                                                         |
| Step 2  		 | ... knowing the tests to show?                                  | TestStore                     | **Information Expert**: Owns the existing tests.                                                                                                                                                       |
|                | ... knowing the test store                                      | Company                       | **Information Expert**: Knows the existing stores.                                                                                                                                                     |
|                | ... process the data and convert it to dto                      | TestMapper                    | **DTO**: So that the UI can't interact directly with the domain.                                                                                                                                       |
| Step 3  		 |                                                                 |                               |                                                                                                                                                                                                        |
| Step 4  		 |                                                                 |                               |                                                                                                                                                                                                        |
| Step 5  		 | ... knowing the number of samples?                              | Test                          |**Information Expert**: knowing how many samples were collected.                                                                                                                                        |
| 		         | ... instantiating a new Sample?                                 | Test                          | **Creator (R1)** and **HC+LC**: Applying the Creator (R1) would be in the "Company". But, by applying HC + LC to the "Company", this transfers the responsibility to the test class                    |
|        		 | ... validating all data (local validation)?                     | Sample                        | IE: owns its data.                                                                                                                                                                                     |
|        		 | ... validating all data (global validation)?                    | Test                          | IE: owns its data.                                                                                                                                                                                     |
|                | ... adapting the interface                                      | BarcodeAdapter                | **Protected variations**: Identify points of predicted variation or instability (variety of interfaces) and assign responsibilities (to the adapters) to create a stable interface around those points.|                                                                                             |
| Step 6  		 |                                                                 |                               |                                                                                                                                                                                                        |
| Step 7  		 | ... validating all data (global validation)?                    | Test                          | IE: owns its data.                                                                                                                                                                                     |
|                | ... saving the sample?                                          | Test                          | IE: Test know its own data                                                                                                                                                                             |
| Step 8  		 | ... informing operation success?                                | RecordSampleUI                | IE: is responsible for user interactions.                                                                                                                                                              |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Sample
 * Test
 * Company
 

Other software classes (i.e. Pure Fabrication) identified: 

 * RecordSampleUI  
 * RecordSampleController
 * TestStore
 * TestMapper
 * BarcodeAdapter

## 3.2. Sequence Diagram (SD)

**Alternative 1**

![US018_SD.svg](US018_SD.svg)


## 3.3. Class Diagram (CD)

**From alternative 1**

![US018_CD.svg](US018_CD.svg)

# 4. Tests 

**Test 1:** Confirm if the barcode is correct 

	@Test
        public void getBarcode() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException {
    
            Company c= new Company("ManyLabs");
            Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
    
            ParameterCategory pc = new ParameterCategory("hemogram", "09090");
    
            Parameter p = new Parameter("01981", "aa", "blood", pc);
            List<Parameter> param = new ArrayList<>();
    
            param.add(p);
    
            ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
            ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
            c.getParameterCategoryStore().addToList(pc1);
            c.getParameterCategoryStore().addToList(pc2);
    
            List<ParameterCategory> listPC = new ArrayList<>();
            ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");
    
            listPC.add(pca);
            TestType testesss = new TestType("asd","asd","12345",listPC);
    
            c.getTestTypeStore().addToList(testesss);
    
            LabOrder labOrder= new LabOrder(testesss,param);
    
            c.getLabOrderStore().addToList(labOrder);
    
            app.domain.model.Test nteste=new app.domain.model.Test(c, client,123412341200L,labOrder);
    
    
            c.getTestStore().addToList(nteste);
    
            Sample s = new Sample(c);
    
            nteste.addSample(s);
    
            List<app.domain.model.Test> samples = c.getTestStore().getTests();
    
            assertEquals("00000000001",s.getBarcode().getBarcodeNumber());
        }
	

**Test 2:** Check if sample equals to null 

	@Test
        public void testEqualsNull() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException {
            Company c= new Company("ManyLabs");
            Company c2= new Company("ManyLabs2");
            Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
    
            ParameterCategory pc = new ParameterCategory("hemogram", "09090");
    
            Parameter p = new Parameter("01981", "aa", "blood", pc);
            List<Parameter> param = new ArrayList<>();
    
            param.add(p);
    
            ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
            ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
            c.getParameterCategoryStore().addToList(pc1);
            c.getParameterCategoryStore().addToList(pc2);
    
            List<ParameterCategory> listPC = new ArrayList<>();
            ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");
    
            listPC.add(pca);
            TestType testesss = new TestType("asd","asd","12345",listPC);
    
            c.getTestTypeStore().addToList(testesss);
    
            LabOrder labOrder= new LabOrder(testesss,param);
    
            c.getLabOrderStore().addToList(labOrder);
    
            app.domain.model.Test nteste=new app.domain.model.Test(c, client,123412341200L,labOrder);
    
    
            c.getTestStore().addToList(nteste);
    
    
            Sample s = new Sample(c);
    
            Sample s2 =null;
    
            assertNotEquals(s,s2);
    
        }


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class RecordSampleController 

		public boolean createNewSample(SampleDTO dto) throws BarcodeException, IllegalAccessException, InstantiationException, ClassNotFoundException, OutputException {
                this.test=sampleMapper.toModel(dto,testStore);
                this.samp = this.test.RecordNewSample(company);
        
               return this.test.validateSample(samp,company );
        
            }


## Class Test


		public Sample RecordNewSample(Company c) throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException {
                return new Sample(c);
            }



# 6. Integration and Demo 

* A new option on the Employee menu options was added.

* Some demo purposes some tasks are bootstrapped while system starts.


# 7. Observations

Platform and Organization classes are getting too many responsibilities due to IE pattern and, therefore, they are becoming huge and harder to maintain. 

Is there any way to avoid this to happen?





