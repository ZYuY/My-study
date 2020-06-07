from selenium import webdriver
import time
import os
driver=webdriver.Chrome()
filepath="file:///"+os.path.abspath("E:\\测试脚本学习\\selenium2html\\checkbox.html")
driver.get(filepath)
inputs=driver.find_elements_by_tag_name("input")

for input in inputs:
    if input.get_attribute("type") =="checkbox":
        input.click()
time.sleep(5)
driver.quit()