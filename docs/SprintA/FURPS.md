# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._



 Email
 
  * “The client must receive an email/SMS alerting that the results are already available.”
 Evaluation
 
  * “To verify if the number of tests waiting for results are decreasing, the system should do the difference between the number of new tests and the number of results available in a interval of time.”
 Register
 
  * “The receptionist must add the regist of a new client’s data (citizen card number, NHS number, birth date, sex, TIF, phone number, e-mail and name) to the system.”
 Security
 
  * “Only the specialist doctor is allowed to access all client data.”
  * “Everyone should have a password holding seven alphanumeric characters, including three capital letters and two digits.”
  * “The laboratory coordinator validates the clinical analyses and the report.”
 ?Localization?
 
  * “The application must support the English language only.”
 Counting
 
  * “Counting the numer of covid 19 tests performed, identifying all the positive ones and report the total number of covid 19 cases per day, week and per month.”
 Reporting
 
  * “Generate daily and automatic reports with all the information demanded by NHS.”
 ?Test Register?
 
  * “The medical lab technicians who collect the samples have to register all tests perfomed.”



## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._


 User Manual
 
  * “The accuracy of the prediction models and the time complexity analysis of the algorithms should be properly documented in the application user manual (in the annexes) that must be delivered with the application.”
 Javadoc
 
  * “Use of Javadoc to generate useful documentation for Java code.”

## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._


(fill in here )

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._



 Execution Time
 
  * “It is intended that the choice of the ordering algorithm (name or TIF) is based on the algorithm complexity (mainly the execution time).”

## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 



 Configuration
 
  * “The ordering algorithm to be used by the application must be defined through a configuration file.”
 Testability
 
  * “The development team must implement unit tests for all methods except methods that implement Input/Output operations.”
 Adaptability
 
  * “The system should be developed having in mind the need to easily support other kinds of tests.”
 Unit Test
 
  * “The development team must implement unit tests for all methods except methods that implement Input/Output operations. The unit tests should be implemented using the JUnit 4 framework. The JaCoCo plugin should be used to generate the coverage report.”


## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._
  

 Programming Language
 
  * “The application must be developed in Java language using the IntelliJ IDE or Netbeans.”


### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._


 Images
 
  * “All the images/figures produced during the software development process should be recorded in SVG format.”
 Object Serialization
 
  * “The application should use object serialization to ensure data persistence between two runs of the application.”
 Ordering
 
  * “To facilitate the access to the results, the application must allow ordering the clients by TIF and by name.”


### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._


 Validation
 
  * “The application uses an external module that is responsible for doing an automatic validation using test reference values.”
 JavaFX11
 
  * “The application graphical interface is to be developed in JavaFX 11.”
 Barcode
 
  * “A barcode identifying a sample must be generated using an external API.”

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

(fill in here )
