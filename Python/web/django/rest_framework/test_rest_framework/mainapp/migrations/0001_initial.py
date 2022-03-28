# Generated by Django 3.1.7 on 2021-04-05 18:38

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='VkontakteUser',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=255, verbose_name='Имя пользователя')),
                ('link_to_page', models.URLField(verbose_name='Ссылка на страницу')),
            ],
            options={
                'verbose_name': 'Пользователь ВК',
                'verbose_name_plural': 'Пользователи ВК',
            },
        ),
        migrations.CreateModel(
            name='VkontaktePhoto',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('image', models.ImageField(upload_to='', verbose_name='Фотография')),
                ('user', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='mainapp.vkontakteuser')),
            ],
            options={
                'verbose_name': 'Фотография',
                'verbose_name_plural': 'Фотографии',
            },
        ),
    ]