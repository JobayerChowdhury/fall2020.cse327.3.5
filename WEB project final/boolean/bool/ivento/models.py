from django.db import models

# Create models here.
class Product(models.Model):
    product_id = models.AutoField
    product_name = models.CharField(max_length=50)
    category = models.CharField(max_length=50, default="")
    sub_category = models.CharField(max_length=50, default="")
    price = models.IntegerField(default=0)
    quantity = models.IntegerField(default=0)
    description = models.CharField(max_length= 200)
    add_date = models.DateField()
    image = models.ImageField(upload_to="ivento/images",default="")

    def __str__(self):
        return self.product_name

class Contact(models.Model):
    msg_id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=50)
    email = models.CharField(max_length=70, default="")
    phone = models.CharField(max_length=70, default="")
    desc = models.CharField(max_length=500, default="")


    def __str__(self):
        return self.name

class Orders(models.Model):
    order_id= models.AutoField(primary_key=True)
    items_Ivento = models.CharField(max_length=5000)
    name=models.CharField(max_length=100)
    email=models.CharField(max_length=100)
    address=models.CharField(max_length=100)
    phone = models.CharField(max_length=50, default="")

class Event(models.Model):
    event_id = models.AutoField
    event_select=models.CharField(max_length=50)
    vanue_type=models.CharField(max_length=50)
    location=models.CharField(max_length=100)
