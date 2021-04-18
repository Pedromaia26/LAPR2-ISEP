# OO Analysis #

The construction process of the domain model is based on the client specifications, especially the nouns (for _concepts_) and verbs (for _relations_) used. 

## Rationale to identify domain conceptual classes ##
To identify domain conceptual classes, start by making a list of candidate conceptual classes inspired by the list of categories suggested in the book "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development". 


### _Conceptual Class Category List_ ###

**Business Transactions**

* Test

---

**Transaction Line Items**

* Sample

---

**Product/Service related to a Transaction or Transaction Line Item**

* Diagnosis
* Parameter

---


**Transaction Records**

* Report of the samples

---  


**Roles of People or Organizations**


* Receptionist
* Medical lab technician
* Courier
* Clinical chemistry technologist
* Specialist doctor
* Laboratory coordinator
* Client
* Administrator

---

**Places**

* Clinical analysis laboratories
* Chemical laboratory
* Company's headquarters

---

**Noteworthy Events**

* Chemical analysis

---


**Physical Objects**

*

---


**Descriptions of Things**

* Type of test
* Category
* Result


---


**Catalogs**

*  

---


**Containers**

*  

---


**Elements of Containers**

*  

---


**Organizations**

* Company

---

**Other External/Collaborating Systems**

*  NHS reports generator API

---


**Records of finance, work, contracts, legal matters**

* 

---


**Financial Instruments**

*  

---


**Documents mentioned/used to perform some work/**

* Medical Report
* Lab order

---



## **Rationale to identify associations between conceptual classes** ##

An association is a relationship between instances of objects that indicates a relevant connection and that is worth of remembering, or it is derivable from the List of Common Associations: 

+ **_A_** is physically or logically part of **_B_**
+ **_A_** is physically or logically contained in/on **_B_**
+ **_A_** is a description for **_B_**
+ **_A_** known/logged/recorded/reported/captured in **_B_**
+ **_A_** uses or manages or owns **_B_**
+ **_A_** is related with a transaction (item) of **_B_**
+ etc.




| Concept (A) 		|  Association   	|  Concept (B) |
-|----------	   		|:-------------:		|------:       |
| Category        |   created by    | Administrator      |
| Chemical laboratory   |   located at    | Company's headquarter  |
|                       |   is a          | Laboratory   |
| Client   | checks | Result |
| Clinical analysis laboratory     | is a           | Laboratory    |
| Clinical chemistry technologist  |   is a  		 	| Employee  |
|                                  |   works at     | Company's headquarters   |  
|                                  |   analysis     | Sample     |
|                                  |   records       | Result               |
| Company                 |   owns          | Laboratory   |
|                         |   has             | Employee  |
| Lab order               |   contains      | Parameter    |
|                         |   gives rise    | Test         |
| Laboratory coordinator  |   is a           | Employee    |
|                         |   validates      | Result      |
|                         |   validates      | Report      |
| Medical Lab Technician  |   is a             | Employee           |
|                         |   collects       | Sample             |
|                         |   works at       | Clinical analysis laboratory  |
| Parameter          |   performed under | Category    |
| Receptionist       |   is              | Employee    |
|            		|   works at   		| Clinical analysis laboratory       |
|                   |   interacts with  | Client |
| Specialist doctor           |   is a          | Employee  |
|                            |   analysis     | Result  |
|                            |   writes       | Report |
| Test                       |   registered by | Receptionist      |
|                            |   performed by | Medical lab technician  |
|                            |   measures     | Parameter          |
|                            |   requested by | Client             |                   



## Domain Model

**Do NOT forget to identify concepts atributes too.**

**Insert below the Domain Model Diagram in a SVG format**

![DM.svg](DM.svg)



