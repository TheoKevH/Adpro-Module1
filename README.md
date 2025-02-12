# Modul Advanced Programming
![Background](https://www.xyzonemedia.com/wp-content/uploads/2024/10/Screenshot_2024-06-20_115902.png)
Nama: Theodore Kevin Himawan<br />
NPM: 2306210973<br />
Kelas: Adpro A

## Reflection 1
Clean code principles & secure coding practices that I have applied to my code:
1. **Meaningful Names**
<br />I have given a clear & descriptive name for all of my variables, classes, and functions.
2. **Don't Repeat Yourself (DRY)**
<br />I have avoided code duplication by reusing components that I have previously made.
3. **Single Responsibility Principle (SRP)**
<br />I seperated the classes based on their functions. So, each class only has one responsibility instead of doing a lot of things at once.
4. **Consistent Code**
<br />In my code, I have tried to write a consistent code by using the same conventions and making sure the formatting is the same across all files so that it is readable.
5. **Avoiding Hardcoded Values**
<br />I created my own model `Product` to store the data instead of writing it one by one.
6. **Proper Redirection**
<br />After <b>create</b>, <b>edit</b>, or <b>delete</b> a product, it will redirect back to the product list page to avoid data duplication.

I found a mistake in the code. There is a warning message:
> cannot resolve 'products'

<p align="justify">I think this is because in the controller, the `productListPage` did not correctly add the product. I fixed it by changing the return to 'ProductList' to match the HTML page. Also, I have not commented on my code. I think I should give a few clear comments to improve my coding practices.</p>

## Reflection 2 

1. After writing unit tests, I feel tired, but I understand the importance of testing (both unit & functional tests) in software development. I think we should make unit tests according to how many functions/methods we have. Each method should have a corresponding unit test. We should also have unit tests to check for edge cases. If we have 100% code coverage, it does not mean that our code has no bugs or error. Code coverage only means how much of our code is tested, not if it works properly as we want or not.


2. When a new functional test is created, I think it does not implement clean code. Many variables and setup processes will be replicated. It is not aligned with the do not repeat yourself principle. To fix this, we can create a base functional test class so that it can be reused multiple times by others. For example, the base URL can be written so that the tests do not need to initialize it again and again.

