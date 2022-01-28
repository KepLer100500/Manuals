from .base_page import BasePage
from .locators import LoginPageLocators, BasePageLocators


class LoginPage(BasePage):
    def should_be_login_page(self):
        self.should_be_login_url()
        self.should_be_login_form()
        self.should_be_register_form()

    def should_be_login_url(self):
        assert 'login' in self.browser.current_url, "The substring 'login' is missing from the url"

    def should_be_login_form(self):
        assert self.is_element_present(
            *LoginPageLocators.LOGIN_FORM), "Login form is not presented"

    def should_be_register_form(self):
        assert self.is_element_present(
            *LoginPageLocators.REGISTER_FORM), "Register form is not presented"

    def register_new_user(self, email, password):
        self.browser.find_element(
            *LoginPageLocators.REGISTER_FORM_EMAIL).send_keys(email)
        self.browser.find_element(
            *LoginPageLocators.REGISTER_FORM_PASSWORD).send_keys(password)
        self.browser.find_element(
            *LoginPageLocators.REGISTER_FORM_RE_PASSWORD).send_keys(password)
        self.browser.find_element(
            *LoginPageLocators.REGISTER_FORM_BUTTON).click()

    def user_is_auth(self):
        assert self.is_element_present(
            *BasePageLocators.USER_ICON), "User is not auth!"
