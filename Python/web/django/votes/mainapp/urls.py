from django.urls import path
from .views import *


app_name = 'mainapp'
urlpatterns = [
    path('', IndexView.as_view(), name='index'),
    path('<int:pk>/', VoteDetailView.as_view(), name='detail'),
    path('<int:pk>/results/', ResultsView.as_view(), name='results'),
    path('<int:question_id>/vote/', vote, name='vote'),
]
