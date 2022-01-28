'''
pytest -v -s --tb=line --language=en test_product_page.py
pytest -v -s -m need_review --tb=line --language=en test_product_page.py
'''
from .pages.product_page import ProductPage
from .pages.basket_page import BasketPage
from .pages.login_page import LoginPage
import pytest
import time


PRODUCT_PAGE = 'http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/'
PRODUCT_PAGE_OFFER = 'http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/?promo=offer0'



class TestUserAddToBasketFromProductPage():
    @pytest.fixture(scope="function", autouse=True)
    def setup(self, browser):
        email = 'kepler_' + str(time.time()) + '@fakemail.org'
        password = 'password000qwerty'
        page = LoginPage(browser, PRODUCT_PAGE)
        page.open()
        page.go_to_login_page()
        page.register_new_user(email, password)
        page.user_is_auth()

    @pytest.mark.skip
    def test_user_cant_see_success_message(self, browser):
        page = ProductPage(browser, PRODUCT_PAGE_OFFER)
        page.open()
        page.should_not_be_success_message()

    @pytest.mark.need_review
    def test_user_can_add_product_to_basket(self, browser):
        page = ProductPage(browser, PRODUCT_PAGE_OFFER)
        page.open()
        page.should_be_product_page()


@pytest.mark.need_review
def test_guest_can_add_product_to_basket(browser):
    page = ProductPage(browser, PRODUCT_PAGE_OFFER)
    page.open()
    page.should_be_product_page()

@pytest.mark.need_review
def test_guest_cant_see_product_in_basket_opened_from_product_page(browser):
    page = BasketPage(browser, PRODUCT_PAGE)
    page.open()
    page.go_to_basket_page()
    page.should_be_basket_page()

@pytest.mark.need_review
def test_guest_can_go_to_login_page_from_product_page(browser):
    page = ProductPage(browser, PRODUCT_PAGE)
    page.open()
    page.go_to_login_page()

@pytest.mark.skip
def test_guest_cant_see_success_message_after_adding_product_to_basket(browser):
    page = ProductPage(browser, PRODUCT_PAGE)
    page.open()
    page.click_to_basket_button()
    page.should_not_be_success_message()

@pytest.mark.skip
def test_message_disappeared_after_adding_product_to_basket(browser):
    page = ProductPage(browser, PRODUCT_PAGE)
    page.open()
    page.click_to_basket_button()
    page.should_not_be_disappeared_success_message()

@pytest.mark.skip
def test_guest_should_see_login_link_on_product_page(browser):
    page = ProductPage(browser, PRODUCT_PAGE)
    page.open()
    page.should_be_login_link()
