import time
import math
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

@pytest.fixture()
def browser():
    print("\nstart browser for test..")
    browser = webdriver.Chrome()
    browser.implicitly_wait(10)
    yield browser
    print("\nquit browser..")
    browser.quit()

@pytest.mark.parametrize('page', ['236895', '236896', '236897', '236898', '236899', '236903', '236904', '236905'])
def test_find_message(browser, page):
    link = f"https://stepik.org/lesson/{page}/step/1"
    browser.get(link)
    #time.sleep(10)
    answer_memo = browser.find_element_by_css_selector('textarea')
    answer_memo.send_keys(str(math.log(int(time.time()))))
    button = browser.find_element_by_css_selector('.submit-submission')
    button.click()
    solution = browser.find_element_by_css_selector('.smart-hints__hint').text
    assert "Correct!" == solution
