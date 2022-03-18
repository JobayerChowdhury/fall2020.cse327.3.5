from django.urls import path
from . import views
from django.views.decorators.csrf import csrf_exempt
urlpatterns = [
    path("", views.home, name="HomePage"),
    path("index/",views.index,name="Indexpage"),
    path("register/", views.register, name="Register"),
    path("login/", views.login, name="Login"),
    path("event/", views.event, name="Event Selection"),
    path("logout/", views.logout, name="Logout"),
    path("about/", views.about, name="AboutUs"),
    path("search/", views.search, name="Search"),
    path("checkout/", views.checkout, name="CheckOut"),
    path("contactus/", views.contactus, name="Contact Us")
]