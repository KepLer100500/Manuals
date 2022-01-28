'''
Testing in Chrome browser 94.0.4606.71
Searching and testing input fields in registration form
'''

from selenium import webdriver
import time

cases = ["1", "2"]
for case in cases:
    try:
        link = "http://suninjuly.github.io/registration{}.html".format(case)
        browser = webdriver.Chrome()
        browser.get(link)

        first_name = browser.find_element_by_css_selector("div.first_block input.form-control.first")
        second_name = browser.find_element_by_css_selector("div.first_block input.form-control.second") # in second case this parameter is apsent
        email = browser.find_element_by_css_selector("div.first_block input.form-control.third")

        first_name.send_keys("test1")
        second_name.send_keys("test2")
        email.send_keys("test3")

        button = browser.find_element_by_css_selector("button.btn")
        button.click()
        time.sleep(1)
        welcome_text_elt = browser.find_element_by_tag_name("h1")
        welcome_text = welcome_text_elt.text

        assert "Congratulations! You have successfully registered!" == welcome_text
    finally:
        time.sleep(10)
        browser.quit()