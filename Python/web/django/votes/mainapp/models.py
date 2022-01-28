from django.db import models


class Question(models.Model):
    """
    Вопрос
    """
    text = models.CharField(max_length=255, verbose_name='Текст вопроса')
    pub_date = models.DateTimeField(auto_now_add=True, verbose_name='Время создания')

    def __str__(self):
        return '({}) Вопрос: {} был создан {}'.format(self.pk ,self.text, self.pub_date)

    class Meta:
        verbose_name = 'Вопрос'
        verbose_name_plural = 'Вопросы'
        

class Choise(models.Model):
    """
    Вариант ответа
    """
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    text = models.CharField(max_length=255, verbose_name='Текст варианта ответа')
    votes = models.IntegerField(default=0, verbose_name='Количесто лайков')

    def __str__(self):
        return 'Вопрос: {} - вариант ответа: {}'.format(self.question, self.text)

    class Meta:
        verbose_name = 'Вариант ответа'
        verbose_name_plural = 'Варианты ответа'
