from math import ceil
from django.contrib.auth.decorators import login_required
from django.shortcuts import render,redirect
from django.contrib import auth
from django.contrib.auth.models import User
from .models import Product, Contact, Orders, Event


# Create views here.
def home(request):
    return render(request,'ivento/home.html')

@login_required(login_url = 'Login')
def index(request):
    products= Product.objects.all()
    allProds=[]
    catprods= Product.objects.values('category', 'id')
    cats= {item["category"] for item in catprods}
    for cat in cats:
        prod=Product.objects.filter(category=cat)
        n = len(prod)
        nSlides = n // 4 + ceil((n / 4) - (n // 4))
        allProds.append([prod, range(1, nSlides), nSlides])
    params={'allProds':allProds }
    return render(request,"ivento/index.html", params)

def register(request):
    if request.method == "POST":
        #match password
        password = request.POST['password1']
        if request.POST['password1'] == request.POST['password2']:
            try:
                user = User.objects.get(email=request.POST['email'])
                return render(request, 'ivento/register.html', {'error' : "Username already exist"})
            except User.DoesNotExist:
                if len(password)<6:
                    return render(request, 'ivento/register.html', {'error' : "Password is too small"})
                user = User.objects.create_user(username=request.POST['username'],email=request.POST['email'],
                                                password=request.POST['password1'])
                #login the user
                auth.login(request, user)
                return redirect(index)
        else:
            return render(request,'ivento/register.html',{'error':"Password do not match"})

    else:
        return render(request,'ivento/register.html')

def login(request):
    if request.method == "POST":
        #check if a user exist by username and password
        user = auth.authenticate(username=request.POST['username'],password=request.POST['password'])
        if user is not None:
            auth.login(request,user)
            return redirect(index)
        else:
            return render(request,'ivento/home.html',{'error':"Invalid Login!Try again"})
    else:
        return render(request, 'ivento/home.html')

def logout(request):
    auth.logout(request)
    return redirect(home)

@login_required(login_url = 'Login')
def event(request):
    if request.method == "POST" :
        enent_select = request.POST.get('event_select', '')
        vanue_type = request.POST.get('vanue_type', '')
        location = request.POST.get('location', '')
        event = Event(event_select=enent_select, vanue_type=vanue_type, location=location)
        event.save()
        return redirect(index)
    return render(request, 'ivento/event.html')


@login_required(login_url = 'Login')
def about(request):
    return render(request, 'ivento/about.html')

def searchMatch(query, item):
    if query in item.product_name.lower() or query in item.category.lower():
        return True
    else:
        return False
def search(request):
    query= request.GET.get('search')
    allProds = []
    catprods = Product.objects.values('category', 'id')
    cats = {item['category'] for item in catprods}
    for cat in cats:
        prodtemp = Product.objects.filter(category=cat)
        prod=[item for item in prodtemp if searchMatch(query, item)]
        n = len(prod)
        nSlides = n // 4 + ceil((n / 4) - (n // 4))
        if len(prod)!= 0:
            allProds.append([prod, range(1, nSlides), nSlides])
    params = {'allProds': allProds, "msg":""}
    if len(allProds)==0 or len(query)<4:
        params={'msg':"Please make sure to enter relevant search query"}
    return render(request, 'ivento/search.html', params)

@login_required(login_url = 'Login')
def checkout(request):
    if request.method == "POST" :
        items_Ivento = request.POST.get('items', '')
        name = request.POST.get('name', '')
        email = request.POST.get('email', '')
        address = request.POST.get('address', '')
        phone = request.POST.get('phone', '')

        order = Orders(items_Ivento=items_Ivento, name=name, email=email, address=address, phone=phone)
        order.save()
        thank = True
        return render(request, 'ivento/checkout.html', {'thank' : thank})
    return render(request, 'ivento/checkout.html')

@login_required(login_url = 'Login')
def contactus(request):
    thank = False
    if request.method == "POST" :
        print(request)
        name = request.POST.get('name', '')
        email = request.POST.get('email', '')
        phone = request.POST.get('phone', '')
        desc = request.POST.get('desc', '')
        contact = Contact(name=name, email=email, phone=phone, desc=desc)
        contact.save()
        thank = True
        return render(request, 'ivento/contactus.html', {'thank' : thank})
    return render(request, 'ivento/contactus.html')
