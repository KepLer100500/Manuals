from selenium import webdriver
import time
import math


try:
    link = "http://suninjuly.github.io/redirect_accept.html"
    browser = webdriver.Chrome()
    browser.get(link)

    button = browser.find_element_by_css_selector("button.trollface")
    button.click()

    browser.switch_to.window(browser.window_handles[1])

    x = browser.find_element_by_css_selector("#input_value").text
    y = str(math.log(abs(12*math.sin(int(x)))))
    answer = browser.find_element_by_css_selector("#answer")
    answer.send_keys(y)
    button = browser.find_element_by_css_selector("button.btn")
    button.click()
finally:
    time.sleep(10)
    browser.quit()