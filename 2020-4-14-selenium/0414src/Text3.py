import os

from selenium import webdriver
import time
driver=webdriver.Chrome()
file_path="file:///"+os.path.abspath("E:\测试脚本学习\selenium2html\checkbox.html")
driver.get(file_path)
inputs=driver.find_elements_by_tag_name('input')
for input in inputs:
    if input.get_attribute('type')=='checkbox':
        input.click()
time.sleep(5)
# file_path='file:///'+os.path.abspath("E:\测试脚本学习\selenium2html\checkbox.html")
# driver.get(file_path)
# inputs=driver.find_elements_by_tag_name('input')
# for input in inputs:
#     if input.get_attribute('type')=='checkbox':
#         input.click()
# time.sleep(5)
driver.quit()