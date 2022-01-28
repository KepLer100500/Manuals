from selenium.webdriver.common.by import By


class LoginPageLocators():
    LOGIN_FORM = (By.CSS_SELECTOR, "#login_form")
    REGISTER_FORM = (By.CSS_SELECTOR, "#register_form")
    REGISTER_FORM_EMAIL = (By.CSS_SELECTOR, "#id_registration-email")
    REGISTER_FORM_PASSWORD = (By.CSS_SELECTOR, "#id_registration-password1")
    REGISTER_FORM_RE_PASSWORD = (By.CSS_SELECTOR, "#id_registration-password2")
    REGISTER_FORM_BUTTON = (By.CSS_SELECTOR, "button[name=registration_submit]")


class ProductLocators():
    BASKET_BUTTON = (By.CSS_SELECTOR, ".btn-add-to-basket")
    PRODUCT_LABEL = (By.CSS_SELECTOR, ".alertinner > strong:nth-child(1)")
    PRODUCT_NAME = (By.CSS_SELECTOR, ".product_main > h1")
    SUCCESS_MESSAGE = (By.CSS_SELECTOR, "#messages > .alert-success:nth-child(1)")


class BasePageLocators():
    LOGIN_LINK = (By.CSS_SELECTOR, "#login_link")
    LOGIN_LINK_INVALID = (By.CSS_SELECTOR, "#login_link_inc")
    BASKET_LINK = (By.CSS_SELECTOR, '.btn-group > .btn-default:nth-child(1)')
    USER_ICON = (By.CSS_SELECTOR, ".icon-user")


class BasketPageLocators():
    BASKET_TOTALS = (By.CSS_SELECTOR, "#basket_totals")
    EMPTY_MESSAGE = (By.CSS_SELECTOR, "#content_inner")
