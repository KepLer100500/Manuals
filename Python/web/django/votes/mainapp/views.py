from django.shortcuts import render, get_object_or_404
from django.http import HttpResponse, HttpResponseRedirect
from .models import *
from django.urls import reverse
from django.views.generic import ListView, DetailView


class IndexView(ListView):
    template_name = 'mainapp/index.html'
    context_object_name = 'questions'
    
    def get_context_data(self, *, object_list=None, **kwargs):
        context = super().get_context_data(**kwargs)
        context['title'] = 'Вопросы'
        return context

    def get_queryset(self):
        return Question.objects.order_by('-pub_date')[:5]


class VoteDetailView(DetailView):
    model = Question
    template_name = 'mainapp/detail.html'


class ResultsView(DetailView):
    model = Question
    template_name = 'mainapp/result.html'


def vote(request, question_id):
    question = get_object_or_404(Question, pk=question_id)
    try:
        selected_choise = question.choise_set.get(pk=request.POST['choise'])
    except:
        context = {
            'question': question,
            'error_message': 'Вы не выбрали вариант ответа!',            
        }
        return render(request, 'mainapp/detail.html', context)
    else:
        selected_choise.votes += 1
        selected_choise.save()
    return HttpResponseRedirect(reverse('mainapp:results', args=(question_id,)))
