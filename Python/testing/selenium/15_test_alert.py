'''
alert = browser.switch_to.alert
alert.accept()
alert_text = alert.text

confirm = browser.switch_to.alert
confirm.accept()
confirm.dismiss()

prompt = browser.switch_to.alert
prompt.send_keys("My answer")
prompt.accept()
'''

from selenium import webdriver
import time
import math


try:
    link = "http://suninjuly.github.io/alert_accept.html"
    browser = webdriver.Chrome()
    browser.get(link)

    button = browser.find_element_by_css_selector("button.btn")
    button.click()

    confirm = browser.switch_to.alert
    confirm.accept()

    x = browser.find_element_by_css_selector("#input_value").text
    y = str(math.log(abs(12*math.sin(int(x)))))
    answer = browser.find_element_by_css_selector("#answer")
    answer.send_keys(y)
    button = browser.find_element_by_css_selector("button.btn")
    button.click()
finally:
    time.sleep(10)
    browser.quit()