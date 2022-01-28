from django.urls import path
from .views import ApiCity


app_name = "mainapp"


urlpatterns = [
    path('city/', ApiCity.as_view()),
    path('city/<int:pk>', ApiCity.as_view()),
]
