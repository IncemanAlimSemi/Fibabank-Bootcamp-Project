# Fibabank-Bootcamp-Project
Fibabank Bootcamp Microservice Project

## Not: Mikroservisleri tek tek deneyebilmeniz için Inventory ve Shopping mikroservislerine Client eklenmiştir.

# Postgre SQL kullanılarak iki farklı database oluşturulmuştur.

<p align="center">
<img src="Ss/InventoryDB.png"> 
<img src="Ss/ShoppingDB.png"> 
</p>

# Inventory'nin içinde bulunan tabloların içeriği.

<p align="center">
<img src="Ss/CategoryTable.png"> 
<img src="Ss/ProductTable.png" > 
</p>

# Get /commerce/inventory/categories için sonuçlar

<p align="center">
<img src="Ss/categories1.png" width=48%> 
<img src="Ss/categories2.png" width=50.2%> 
</p>

# Get /commerce/inventory/products/{categoryId} için sonuçlar

<p align="center">
<img src="Ss/products1.png" width=49%> 
<img src="Ss/products2.png" width=49%> 
</p>

# Get /commerce/inventory/product/{productId} için sonuçlar

<p align="center">
<img src="Ss/product1.png"> 
<img src="Ss/product2.png"> 
</p>

# Get /commerce/shopping/cart/create?customerName=Name için sonuçlar

<p align="center">
<img src="Ss/create1.png"> 
<img src="Ss/create2.png"> 
</p>

# Post /commerce/shopping/cart/add (RequestBody alıyor) için sonuçlar

<p align="center">
<img src="Ss/add1.png"> 
<img src="Ss/add2.png"> 
</p>

# Get /commerce/shopping/cart/find/{cartId} için sonuçlar (Ekleme işleminden sonra)

<p align="center">
<img src="Ss/find1.png" > 
</p>

# Delete /commerce/shopping/cart/{cartId}/remove/{productId} için sonuçlar

<p align="center">
<img src="Ss/remove1.png" > 
</p>

# Get /commerce/shopping/cart/find/{cartId} için sonuçlar (Silme işleminden sonra)

<p align="center">
<img src="Ss/find1.1.png" > 
</p>

# Get /commerce/shopping/checkout/{cartId} için sonuçlar

<p align="center">
<img src="Ss/checkout.png" > 
<img src="Ss/checkout1.png" > 
</p>





