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

