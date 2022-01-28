'''
pytest -s -v -m smoke 6_test_fixture_marked.py                  # run only smoke test
pytest -s -v -m "not smoke" 6_test_fixture_marked.py            # run any tests, but not run smoke
pytest -s -v -m "smoke or regression" 6_test_fixture_marked.py  # run smoke AND regression tests
pytest -s -v -m "smoke and regression" 6_test_fixture_marked.py # run tests which have a two marks: smoke and regression

For hide warnings need create pytest.ini file:

[pytest]
markers =
    smoke: marker for smoke tests
    regression: marker for regression tests

'''

import pytest
from selenium import webdriver

link = "http://selenium1py.pythonanywhere.com/"


@pytest.fixture(scope="function")
def browser():
    print("\nstart browser for test..")
    browser = webdriver.Chrome()
    yield browser
    print("\nquit browser..")
    browser.quit()


class TestMainPage1():

    @pytest.mark.smoke ###
    def test_guest_should_see_login_link(self, browser):
        browser.get(link)
        browser.find_element_by_css_selector("#login_link")

    @pytest.mark.regression ###
    def test_guest_should_see_basket_link_on_the_main_page(self, browser):
        browser.get(link)
        browser.find_element_by_css_selector(".basket-mini .btn-group > a")