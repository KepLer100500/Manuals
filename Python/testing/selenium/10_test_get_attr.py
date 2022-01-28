from selenium import webdriver
import time
import math


try:
    link = "http://suninjuly.github.io/get_attribute.html"
    browser = webdriver.Chrome()
    browser.get(link)

    x = browser.find_element_by_css_selector("#treasure").get_attribute("valuex")
    y = str(math.log(abs(12*math.sin(int(x)))))
    answer = browser.find_element_by_css_selector("#answer")
    answer.send_keys(y)
    robotCheckbox = browser.find_element_by_css_selector("#robotCheckbox")
    robotCheckbox.click()
    robotsRule = browser.find_element_by_css_selector("#robotsRule")
    robotsRule.click()
    button = browser.find_element_by_css_selector("button.btn")
    button.click()
finally:
    time.sleep(10)
    browser.quit()