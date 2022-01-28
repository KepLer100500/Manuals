'''
EC.

title_is
title_contains
presence_of_element_located
visibility_of_element_located
visibility_of
presence_of_all_elements_located
text_to_be_present_in_element
text_to_be_present_in_element_value
frame_to_be_available_and_switch_to_it
invisibility_of_element_located
element_to_be_clickable
staleness_of
element_to_be_selected
element_located_to_be_selected
element_selection_state_to_be
element_located_selection_state_to_be
alert_is_present
'''

from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium import webdriver
import time


try:
    browser = webdriver.Chrome()

    browser.get("http://suninjuly.github.io/wait2.html")

    # говорим Selenium проверять в течение 5 секунд, пока кнопка не станет кликабельной
    button = WebDriverWait(browser, 5).until(
            EC.element_to_be_clickable((By.ID, "verify"))
        )
    button.click()
    message = browser.find_element_by_id("verify_message")

    assert "successful" in message.text

finally:
    time.sleep(10)
    browser.quit()