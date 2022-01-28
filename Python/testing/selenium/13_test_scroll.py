from selenium import webdriver
import time
import math


try:
    link = "http://suninjuly.github.io/execute_script.html"
    browser = webdriver.Chrome()
    browser.get(link)

    x = browser.find_element_by_css_selector("#input_value").text
    y = str(math.log(abs(12*math.sin(int(x)))))
    answer = browser.find_element_by_css_selector("#answer")
    answer.send_keys(y)
    robotCheckbox = browser.find_element_by_css_selector("#robotCheckbox")
    robotCheckbox.click()
    browser.execute_script("window.scrollBy(0, 100);") # scroll
    robotsRule = browser.find_element_by_css_selector("#robotsRule")
    robotsRule.click()
    button = browser.find_element_by_css_selector("button.btn")
    browser.execute_script("return arguments[0].scrollIntoView(true);", button) # scroll
    button.click()
finally:
    time.sleep(10)
    browser.quit()