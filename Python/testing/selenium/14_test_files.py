from selenium import webdriver
import time
import os 

try:
    link = "http://suninjuly.github.io/file_input.html"
    browser = webdriver.Chrome()
    browser.get(link)

    inputs = browser.find_elements_by_css_selector('.form-control')
    for input in inputs:
        input.send_keys('test')
    current_dir = os.path.abspath(os.path.dirname(__file__))
    file_path = os.path.join(current_dir, '12_test_js.py')
    file_element = browser.find_element_by_css_selector('#file')
    file_element.send_keys(file_path)
    button = browser.find_element_by_css_selector("button.btn")
    button.click()    

finally:
    time.sleep(10)
    browser.quit()

