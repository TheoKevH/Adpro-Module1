# Modul Advanced Programming
![Background](https://www.xyzonemedia.com/wp-content/uploads/2024/10/Screenshot_2024-06-20_115902.png)
Nama: Theodore Kevin Himawan<br />
NPM: 2306210973<br />
Kelas: Adpro A

## Deployment URL
[ADV Shop](selfish-magda-theokevh-b6e25430.koyeb.app/)

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