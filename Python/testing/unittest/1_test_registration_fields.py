import unittest
from selenium import webdriver
import time


class Testregistrations(unittest.TestCase):
    def check_fields(self, page):
        link = f"http://suninjuly.github.io/registration{page}.html"
        browser = webdriver.Chrome()
        browser.get(link)

        first_name = browser.find_element_by_css_selector("div.first_block input.form-control.first")
        second_name = browser.find_element_by_css_selector("div.first_block input.form-control.second")
        email = browser.find_element_by_css_selector("div.first_block input.form-control.third")

        first_name.send_keys("test1")
        second_name.send_keys("test2")
        email.send_keys("test3")

        button = browser.find_element_by_css_selector("button.btn")
        button.click()
        time.sleep(1)
        welcome_text_elt = browser.find_element_by_tag_name("h1")
        welcome_text = welcome_text_elt.text

        self.assertEqual("Congratulations! You have successfully registered!", welcome_text, "Error!!!")
        time.sleep(10)
        browser.quit()

    def test_page1(self):
        self.check_fields(2)
        
    def test_page2(self):
        self.check_fields(1)


if __name__ == "__main__":
    unittest.main()
