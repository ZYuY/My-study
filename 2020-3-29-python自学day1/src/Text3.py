# coding = utf-8
from selenium import webdriver
import time
driver =webdriver.Chrome()
driver.get('http://www.baidu.com')
time.sleep(3)
print(driver.title)
driver.quit()