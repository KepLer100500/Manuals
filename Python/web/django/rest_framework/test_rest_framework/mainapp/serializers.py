from rest_framework import serializers
from .models import *


class CitySerializer(serializers.Serializer):
    name = serializers.CharField(max_length=255)  # Создаём сериализатор на основе полей модели
    country_id = serializers.IntegerField()

    def create(self, validated_data):
        return City.objects.create(**validated_data)  # Вернуть созданный экземпляр модели

    def update(self, instance, validated_data):
        # Обновить значение экзмепляра модели (instance), значением validated_data
        instance.name = validated_data.get('name', instance.name)
        instance.save()
        return instance  # Возвращаем экземпляр модели, который обновили
