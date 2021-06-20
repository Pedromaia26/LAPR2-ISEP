# US 017 - To import clinical tests 

## 1. Requirements Engineering


### 1.1. User Story Description


As a laboratory coordinator, I want to import clinical tests from a CSV file.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

""

**From the client clarifications:**

> **Question:** "Should we write some kind of report or should we just leave the report field empty and simply add the date?"
>  
> **Answer:** "Leave empty and simply add the date." - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9204#p12186]

> **Question:** "When loading a .csv file after another .csv has been loaded beforehand, do we keep the tests that were loaded previously or do we replace them with the new tests being loaded from the new .csv?"
>  
> **Answer:** "The tests should not be deleted after being loaded." - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=9300#p12178]


> **Question:** "If some kind of data is wrong, what should happen should we just ignore the line where it is located"
>  
> **Answer:** "The application should not load tests that have incorrect attribute values. The application should identify the tests that have incorrect values and it should continue loading all valid tests that exist in the file. A message should be sent to the console to identify the tests/lines that have incorrect values." - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8960#p11890]

> **Question:** "Should we show the data that the laboratory coordinator is importing?"
>  
> **Answer:** "Yes, it should show all the data that was imported at that time." - [link: https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=8960#p11890]



### 1.3. Acceptance Criteria


* **AC1:** If the file contains invalid data (e.g., a parameter not defined in the system), that data should not be load into the system. An exception should be thrown.




### 1.4. Found out Dependencies


* There is no dependency found.


### 1.5 Input and Output Data


**Input Data:**
	
* Selected data: The CSV file.

**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Alternative 1**

![US017_SSD](US017_SSD.svg)



### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.


## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 

![US17_MD](US17_MD.svg)

### 2.2. Other Remarks

n/a


## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID | Question: Which class is responsible for...                     | Answer                        | Justification (with patterns)                                                                                                                                                                          |
|:-------------  |:--------------------------------------------------------------- |:-----------------------------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Step 1  		 | ... interacting with the actor?                                 | ImportCSVFileUI                | **Pure Fabrication**: none of the domain models classes had the responsability of interactiong with the user.                                                                                          |
|                | ... coordinating the US?                                        | ImportCSVFileController        | **Controller**                                                                                                                                                                                         |
| Step 2  		 |                                   |                      |                                                                                                                                                     |
| Step 3  		 | ... selecting the file           |  ImportCSVFileUI                             |  **IE** Responsible for user interactions                                                                                                                                                                                                  |
| Step 4  		 |                                                                 |                               |                                                                                                                                                                                                        |
| Step 5  		 | ... Knows all the clients           |ClientStore | **Information Expert**: Owns the existing clients. 
|                | ... Knows all the laboratorys              |  LaboratoryStore       | **Information Expert**: Owns the existing Labs.                                                                                                                           |
|                | ...knows all the laborders           |      LabOrderStore                |**Information Expert**: Owns the existing LabOrders.         |
|                | ... knows all the parameters             |     Parameter Store              |**Information Expert**: Owns the existing Parameters.           |
|                | ... knows all the parameter category     |    parameterCategoryStore     |**Information Expert**: Owns the existing Parameter categorys.         |
|                | ... knows all the test types        |    TestTypeStore                  | **Information Expert**: Owns the existing Test Types.           |
|                |... Knows the client store               |  Company                    |  **Information Expert**: Knows the existing stores.                                                                             |
|                | ...knows the laboratory store            |      Company                |**Information Expert**: Knows the existing stores. |
|                | ... knows the laborder store             |     Company                 |**Information Expert**: Knows the existing stores. |
|                | ... knows the parameter store            |    Company                  |**Information Expert**: Knows the existing stores. |
|                | ... knows the test store                 |    Company                  |**Information Expert**: Knows the existing stores. |
|                | ... knows the parameter category store   |    Company                  |**Information Expert**: Knows the existing stores. |
|                | ... knows the test type store            |   Company                   |**Information Expert**: Knows the existing stores. |
|                | ... knows the client data                |    Client                   |**IE** Knows its own data  |
|                |... knows the laboratory data             |   Laboratory             |**IE** Knows its own data  |
|                |... knows the laborder data               |   laborder            |**IE** Knows its own data  |
|                |... knows the parameter data              |   Parameter              |**IE** Knows its own data  |
|                |... knows the test data                   |   Test                |**IE** Knows its own data  |
|                |... knows the parameter category data     | Parameter Category        |**IE** Knows its own data  |
|                |... knows the test type data              |  TestType             |**IE** Knows its own data   |
|Step 6  		 |  ... informing operation success?         |  ImportCSVFileUI                        |      IE: is responsible for user interactions.                                                                                                                                                                                                  |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Company
 * Client
 * Laboratory
 * LabOrder
 * Parameter
 * Test
 * Parameter Category
 * TestType
 
Other software classes (i.e. Pure Fabrication) identified: 

 * ImportCSVFileUI  
 * ImportCSVFileController
 * ClientStore
 * LaboratoryStore
 * LabOrderStore
 * ParameterStore
 * TestStore
 * ParameterCategoryStore
 * TestTypeStore

## 3.2. Sequence Diagram (SD)

**Alternative 1**

![US017_SD](US017_SD.svg)


## 3.3. Class Diagram (CD)

**From alternative 1**

![US005_CD](US017_CD.svg)

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





