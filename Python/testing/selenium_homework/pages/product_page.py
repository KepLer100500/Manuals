from .base_page import BasePage
from .locators import ProductLocators


class ProductPage(BasePage):
    def should_be_product_page(self):
        self.should_not_be_success_message()
        self.click_to_basket_button()
        self.solve_quiz_and_get_code()
        self.check_product_name()

    def click_to_basket_button(self):
        basket_button = self.browser.find_element(
            *ProductLocators.BASKET_BUTTON)
        basket_button.click()

    def check_product_name(self):
        product_label = self.browser.find_element(
            *ProductLocators.PRODUCT_LABEL).text
        product_name = self.browser.find_element(
            *ProductLocators.PRODUCT_NAME).text
        assert product_label == product_name, 'Product name not eaqual product label in basket!'

    def should_not_be_success_message(self):
        assert self.is_not_element_present(
            *ProductLocators.SUCCESS_MESSAGE), "Success message is presented, but should not be"

    def should_not_be_disappeared_success_message(self):
        assert self.is_disappeared(
            *ProductLocators.SUCCESS_MESSAGE), "Success message is disappeared, but should not be"
