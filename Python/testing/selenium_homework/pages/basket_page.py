from .base_page import BasePage
from .locators import BasketPageLocators


class BasketPage(BasePage):
    def should_be_basket_page(self):
        self.should_not_be_products_in_empty_basket()
        self.empty_basket_have_text()

    def should_not_be_products_in_empty_basket(self):
        assert self.is_not_element_present(
            *BasketPageLocators.BASKET_TOTALS), "Basket is not empty!"

    def empty_basket_have_text(self):
        basket_text = self.browser.find_element(
            *BasketPageLocators.EMPTY_MESSAGE).text
        assert 'Your basket is empty' in basket_text
