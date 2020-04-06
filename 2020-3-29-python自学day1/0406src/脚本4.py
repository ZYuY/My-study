import os

from selenium import webdriver
import time
driver=webdriver.Chrome()
file_path='file:///'+os.path.abspath('C:\\课件\\我的课件\\测试\\selenium2\\locateElement\\checkbox.html')
driver.get(file_path)
inputs=driver.find_element_by_tag_name(input)
for input in inputs:
    if input.get_attribute('type')=='checkbox':
        input.click()
time.sleep(5)
driver.quit()