from pydantic import BaseModel, ValidationError, Field, validator
from typing import List


class City(BaseModel):
    city_id: int = Field(alias='cityId')  # camelCase in fieldName in JSON
    name: str


class Region(BaseModel):
    region_id: int
    name: str
    # city_list: list[City] # for python 3.9
    city_list: List[City]


class RegionForGenerateError(BaseModel):
    """
    Wrong type for name of region, it's int, but expected str. 
    """
    region_id: int
    name: int
    city_list: List[City]


class ShowValidatorWorks(BaseModel):
    test_id: int

    @validator('test_id')
    def test_must_be_positive_number(cls, test_id: int) -> int:
        if test_id < 0:
            return 'Input id is negative number!'  # raise ValueError('some text')
        return test_id


def generate_exception_json(input_json: str) -> str:
    """
    Function must returned name of region, 
    but input json contain error, type of region name is wrong,
    it's int, but expected str. 
    """
    try:
        region = RegionForGenerateError.parse_raw(input_json)
        return region.name
    except ValidationError as e:
        return e.json()


def get_region_name(input_json: str) -> str:
    """
    Function returned name of region
    """
    region = Region.parse_raw(input_json)
    return region.name


def get_city_name(input_json: str) -> str:
    """
    Function returned name of first city in list of central region
    """
    region = Region.parse_raw(input_json)
    return region.city_list[0].name


def build_json_from_firts_city(input_json: str) -> str:
    """
    Function return json with edit: city_id -> cityId
    """
    region = Region.parse_raw(input_json)
    return region.city_list[0].json(by_alias=True)  # In build json use alias for class


def main():
    input_json = '''
                {
                    "region_id": 1,
                    "name": "Центральный регион",
                    "city_list": [{
                            "cityId": 1,
                            "name": "Санкт Петербург"
                        }, {
                            "cityId": 2,
                            "name": "Москва"
                        }
                    ]
                }
                '''
    print(generate_exception_json(input_json))                     # message of error in json format
    print(get_region_name(input_json))                             # Центральный регион
    print(get_city_name(input_json))                               # Санкт Петербург
    print(build_json_from_firts_city(input_json))                  # {"cityId": 1, "name": "\u0421\u0430\u043d\ ...
    print(City.parse_raw(build_json_from_firts_city(input_json)))  # city_id=1 name='Санкт Петербург'
    print(ShowValidatorWorks.parse_raw('{"test_id": -1}'))         # test_id='Input id is negative number!'


if __name__ == "__main__":
    main()
