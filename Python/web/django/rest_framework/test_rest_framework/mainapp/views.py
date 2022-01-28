from rest_framework.response import Response
from rest_framework.generics import get_object_or_404
from rest_framework.views import APIView
from .models import *
from .serializers import CitySerializer


class ApiCity(APIView):
    @staticmethod
    def get(request):
        """
        http://localhost:8000/api/city/
        """
        cities = City.objects.all()                     # Достаём из базы все города
        serializer = CitySerializer(cities, many=True)  # Перегоняем полученную структуру данных в json
        return Response({
            "success": serializer.data
        })

    @staticmethod
    def post(request):
        """
        http://localhost:8000/api/city/
        {
            "city": {
                "name": "Кисловодск",
                "country_id": 1
            }
        }
        """
        city = request.data.get('city')                # Забираем данные с get запроса
        serializer = CitySerializer(data=city)         # Перегоняем из json в формат класса модели данных
        if serializer.is_valid(raise_exception=True):  # Если сериализация прошла без ошибок
            city_saved = serializer.save()             # Сохраняем экзмемпляр в модели
        return Response({
            "success": "Город '{}' успешно создан".format(city_saved.name)
        })

    @staticmethod
    def put(request, pk):
        """
        http://localhost:8000/api/city/1
        {
            "city": {
                "name": "ололо"
            }
        }
        """
        saved_city = get_object_or_404(City.objects.all(), pk=pk)  # Забираем с модели экземпляр или вернём ошибку 404
        data = request.data.get('city')                            # Забираем данные с get запроса
        serializer = CitySerializer(instance=saved_city, data=data, partial=True)  # Перегоняем data в формат модели
        if serializer.is_valid(raise_exception=True):              # Если сериализация прошла без ошибок
            city_saved = serializer.save()                         # Сохраняем экзмемпляр в модели
        return Response({
            "success": "Город '{}' обновлён".format(city_saved.name)
        })

    @staticmethod
    def delete(request, pk):
        """
        http://localhost:8000/api/city/1
        """
        city = get_object_or_404(City.objects.all(), pk=pk)  # Забираем с модели экземпляр или вернём ошибку 404
        city.delete()                                        # Удаляем найденный экземпляр модели
        return Response({
            "success": "Город с id `{}` был удалён".format(pk)
        }, status=204)
