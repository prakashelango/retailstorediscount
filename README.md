# retailstorediscount
Retail Store Discount.
Steps to Run the App.
1. mvn install {Create Jar file}
2. java -jar target/retailsales-0.0.1-SNAPSHOT.jar {Run the jar file}
3. Access the application using 8080 port host is localhost.
4. Creating User.
Method Post
http://localhost:8080/user/add
{
"userid":0,
"username":"Prakash",
"role":"Employee",
"createddate":"2019-08-30T06:36:35.000+0000",
"password":"abc"
}
5. Adding Products
Method Post
Add first Product
http://localhost:8080/products/add
{
"id":0,
"itemname":"Coalgate",
"itemqty":5,
"itemprice":"20",
"itemtype":"GROCERY"
}
Add Second Product
http://localhost:8080/products/add
{
"id":0,
"itemname":"EGG",
"itemqty":10,
"itemprice":"10",
"itemtype":"FOOD"
}

6. Add to Cart
Method Post
http://localhost:8080/cart/add
{
"id":0,
"userid":1,
"productid":1
}
Add two products to cart by passing product id.
http://localhost:8080/cart/add
{
"id":0,
"userid":1,
"productid":2
}

7.Appling Discount
Method Get
http://localhost:8080/bill/applydiscount/{UserId}
http://localhost:8080/bill/applydiscount/1