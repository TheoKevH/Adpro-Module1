# Modul Advanced Programming
![Background](https://www.xyzonemedia.com/wp-content/uploads/2024/10/Screenshot_2024-06-20_115902.png)
Nama: Theodore Kevin Himawan<br />
NPM: 2306210973<br />
Kelas: Adpro A

## Deployment URL
[ADV Shop](selfish-magda-theokevh-b6e25430.koyeb.app/)

## Reflection

1. **Explain what principles you apply to your project!**
- *Single Responsibility Principle (SRP)*
   
   <p align="justify">I applied SRP by making sure all my classes only have on responsibility. Also, in my Spring Boot project, it is separated into controllers, services, repositories, and model. This is to make sure each processes are done by their own class. Additionally, I seperated the CarController from the ProductController. Because those two classes handle different things, I removed the "extends".</p>
  <br />
- *Open Closed Principle (OCP)*
   <p align="justify">I have ensured that classes are open for extension but cannot be modified that simply. Also, I have created the update() method so that future subclasses do not need to modify its entire behavior.</p>
   <br />
- *Interface Segregation Principle (ISP)*
   <p align="justify">I applied ISP by separating the CarService and ProductService interfaces because the services that implements them only specifically need one of them (not both).</p>
   <br />
- Dependency Inversion Principle (DIP)
   <p align="justify">I applied DIP by changing my controller. Previously, <code>CarController</code> depended on a concrete class <code>CarServiceImpl</code>. I changed it so that it is not tightly coupled, now it dependes on an abstract class <code>CarService</code>.</p>

2. **Explain the advantages of applying SOLID principles to your project with examples.**

   <p align="justify"> Applying SOLID principles to our project provides scalability, maintainability, testability, and flexibility, making it easier to manage as the application grows. For example, by following Single Responsibility Principle (SRP), we separated the tasks: <code>CarController</code> only handles HTTP requests, while <code>CarServiceImpl</code> manages business logic, and <code>CarRepository</code> handles database operations, ensuring changes in one layer don’t affect others. Additionally, SOLID principles simplify code development, allowing us to extend our code without modifying existing functionality. For example, if we need to add a new controller, we can do so without disturbing other controller files. These principles also streamline implementation, as we don’t have to handle irrelevant methods inherited from a superclass, because of the Liskov Substitution Principle (LSP). Also, Interface Segregation Principle (ISP) ensures that we only implement the necessary methods, preventing us from being forced to include unnecessary functionality.</p>
   

3. **Explain the disadvantages of not applying SOLID principles to your project with examples.**

   <p align="justify">Not applying SOLID principles to our project can lead to several issues, including tight coupling, code duplication, reduced maintainability, and difficulty in scaling. For example, without the Single Responsibility Principle (SRP), if <code>CarController</code> also handled business logic, any change to how cars are managed would require modifying the controller, making the code harder to maintain and test. Not applying the Open Closed Principle (OCP) means that adding a new product model would require modifying all of the other classes as well. Without the Liskov Substitution Principle (LSP), if <code>CarController</code> incorrectly extended <code>ProductController</code>, it might inherit and override methods that are not relevant to cars, leading to unexpected behavior and unnecessary dependencies.</p>
<details>
   <summary><b>Reflection 3</b></summary>

## Reflection 3

1. **Code quality issues that I fixed & my strategy on fixing them:**

<ul>
    <li>
        <b>Unnecessary Modifier "public"</b>
        <p>
            Some of my methods have the modifier "public" set to them. I deleted the modifier because methods are automatically "public abstract". This way, I reduce redundancy in my code.
        </p>
    </li>
    <li>
        <b>No permission defined</b>
        <p>
            For my workflow, I specifically set the permission in my ci.yml file. When I explicitly set the permissions, the workflow is now safer.
        </p>
    </li>
    <li>
        <b>Increase test coverage</b>
        <p>
            I created new tests for <code>ProductRepository</code>, <code>ProductController</code>, <code>HomePageController</code>, <code>ProductServiceImpl</code>, and <code>EshopApplicationTests</code>. My strategy is to at least make one test case for each method on each file. Because of this, my code coverage is now <b>100%</b>
        </p>
    </li>
</ul>

2. Yes, I believe my current code has met the definition of Continuous Integration (CI) and Continuous Deployment (CD). Firstly, when I push a new change to my repo, the automated CI would test the newly updated code to make sure it is up to standards. I think this is already an implementation of CI, because the workflow automates build and testing. I also have code scanning workflows. Additionally, the code meets the definition of CD because everytime I push or merge something into master, it automatically starts deploying to <b>Koyeb</b>. All of these reasons show that my code has successfully implemented the CI/CD pipeline.

</details>

<details>
  <summary><b>Reflection 1</b></summary>

## Reflection 1

Clean code principles & secure coding practices that I have applied to my code:

1. **Meaningful Names**  
   I have given clear & descriptive names for all of my variables, classes, and functions.

2. **Don't Repeat Yourself (DRY)**  
   I have avoided code duplication by reusing components that I have previously made.

3. **Single Responsibility Principle (SRP)**  
   I separated the classes based on their functions. So, each class only has one responsibility instead of doing a lot of things at once.

4. **Consistent Code**  
   I have tried to write consistent code by using the same conventions and ensuring the formatting is the same across all files, making it more readable.

5. **Avoiding Hardcoded Values**  
   I created my own model `Product` to store the data instead of writing it one by one.

6. **Proper Redirection**  
   After **creating**, **editing**, or **deleting** a product, the user is redirected back to the product list page to avoid data duplication.

**Issue Found:**  
I found a mistake in the code. There is a warning message:
> `cannot resolve 'products'`

I think this happens because, in the controller, the `productListPage` method did not correctly add the product.  
I fixed it by changing the return value from `'ProductList'` to match the actual HTML page name.

**Future Improvement:**
- I have not added comments to my code.
- I should include a few **clear comments** to improve readability and maintainability.

</details>

<details>
    <summary><b>Reflection 2</b></summary>

## Reflection 2 

1. After writing unit tests, I feel tired, but I understand the importance of testing (both unit & functional tests) in software development. I think we should make unit tests according to how many functions/methods we have. Each method should have a corresponding unit test. We should also have unit tests to check for edge cases. If we have 100% code coverage, it does not mean that our code has no bugs or error. Code coverage only means how much of our code is tested, not if it works properly as we want or not.


2. When a new functional test is created, I think it does not implement clean code. Many variables and setup processes will be replicated. It is not aligned with the do not repeat yourself principle. To fix this, we can create a base functional test class so that it can be reused multiple times by others. For example, the base URL can be written so that the tests do not need to initialize it again and again.

</details>