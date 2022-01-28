from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium import webdriver
import time
import math


try:
    browser = webdriver.Chrome()
    browser.get("http://suninjuly.github.io/explicit_wait2.html")
    price = WebDriverWait(browser, 15).until(
            EC.text_to_be_present_in_element ((By.ID, "price"), '100')
        )
    button = browser.find_element_by_css_selector("#book")
    button.click()

    x = browser.find_element_by_css_selector("#input_value").text
    y = str(math.log(abs(12*math.sin(int(x)))))
    answer = browser.find_element_by_css_selector("#answer")
    answer.send_keys(y)
    button = browser.find_element_by_css_selector("#solve")
    button.click()

finally:
    time.sleep(10)
    browser.quit()