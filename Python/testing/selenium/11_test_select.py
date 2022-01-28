from selenium import webdriver
from selenium.webdriver.support.ui import Select
import time


try:
    link = "http://suninjuly.github.io/selects2.html"
    browser = webdriver.Chrome()
    browser.get(link)

    num1 = browser.find_element_by_css_selector("#num1").text
    num2 = browser.find_element_by_css_selector("#num2").text
    sum_num = int(num1) + int(num2)
    select = Select(browser.find_element_by_tag_name("#dropdown"))
    select.select_by_value(str(sum_num)) 
    button = browser.find_element_by_css_selector("button.btn")
    button.click()
finally:
    time.sleep(10)
    browser.quit()