'''
pytest -v --tb=line --reruns 1 13_test_reruns.py
'''

from selenium import webdriver
import pytest


@pytest.fixture()
def settings():
    print("\nstart browser for test..")
    browser = webdriver.Chrome()
    link = "http://selenium1py.pythonanywhere.com/"
    yield (browser, link)
    print("\nquit browser..")
    browser.quit()

def test_guest_should_see_login_link_pass(settings):
    browser, link = settings
    browser.get(link)
    browser.find_element_by_css_selector("#login_link")


def test_guest_should_see_login_link_fail(settings):
    browser, link = settings
    browser.get(link)
    browser.find_element_by_css_selector("#magic_link")
