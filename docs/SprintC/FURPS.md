# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._


 Email
 
  * “The client must receive an email/SMS alerting that the results are already available.”
  
 Security
 
  * “Only the specialist doctor is allowed to access all client data.”
  * “Everyone should have a password holding seven alphanumeric characters, including three capital letters and two digits.”
  * “The laboratory coordinator validates the clinical analyses and the report.”
  
 Reporting
 
  * “Generate daily and automatic reports with all the information demanded by NHS.”
 
 Persistence
 
  * “The application should use object serialization to ensure data persistence between two runs of the application.”
  

## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._


 Help and documentation
 
  * “The accuracy of the prediction models and the time complexity analysis of the algorithms should be properly documented in the application user manual (in the annexes) that must be delivered with the application.”
  * “Use of Javadoc to generate useful documentation for Java code.”
  
 Aesthetics / Consistency
 
  * "The user interface must be simple, intuitive and consistent."

## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._


 Availabilty

  * "The system should not fail more than 5 days in one year."
  
 Recoverability
 
  * "Whenever the system fails, there should be no data loss."

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._


 Execution Time
 
  * “It is intended that the choice of the ordering algorithm (name or TIF) is based on the algorithm complexity (mainly the execution time).”
  
 Response Time
 
  * "Any interface between a user and the system shall have a maximum response time of 3 seconds."
  
 Start-up Time
 
  * "The system should start up in less than 10 seconds."
  
 Memory Consumption
 
  * "The application will be deployed to a machine with 8GB of RAM."

## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 
 
 Localization
 
  * “The application must support the English language only.”

 Configurability
 
  * “The ordering algorithm to be used by the application must be defined through a configuration file.”
  
 Testability
 
  * “The development team must implement unit tests for all methods except methods that implement Input/Output operations.”
  
 Adaptability
 
  * “The system should be developed having in mind the need to easily support other kinds of tests.”
  
  

## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._
  
 
 Use of development tools
 
 * "TheJaCoCo plugin should be used to generate the coverage report."
 * “The application must be developed in Java language using the IntelliJ IDE or Netbeans.”
 * “The application graphical interface is to be developed in JavaFX 11.” 



### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._


 Implementation languages
 
  * “The application must be developed in Java language using the IntelliJ IDE or Netbeans.”

 Standards / Patterns 
 
  * “All the images/figures produced during the software development process should be recorded in SVG format.”
  * “To facilitate the access to the results, the application must allow ordering the clients by TIF and by name.”
  
 Operating System
 
  * "The application should run on all platforms for which there exists a Java Virtual Machine."


### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

 External System
 
   * “The application uses an external module that is responsible for doing an automatic validation using test reference values.”
   * “A barcode identifying a sample must be generated using an external API.”
   * The company is also required to generate daily (automatic) reports with all the information demanded by the NHS and should send them to the NHS using their API."



### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

(fill in here )
