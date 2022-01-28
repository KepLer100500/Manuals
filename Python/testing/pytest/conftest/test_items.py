link = "http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207"

def test_add_to_cart_button_is_displayed(browser):
    browser.get(link)
    button = browser.find_elements_by_css_selector(".btn-add-to-basket")
    assert button, 'Button not found!'