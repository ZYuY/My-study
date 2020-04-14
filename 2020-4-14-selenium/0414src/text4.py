import os

from selenium import webdriver
import time
driver=webdriver.Chrome()
file_path="file:///"+os.path.abspath("E:\测试脚本学习\selenium2html\\frame.html")
driver.get(file_path)
driver.implicitly_wait(5)
driver.switch_to.frame('f1')
driver.switch_to.frame("f2")
driver.find_element_by_id("kw").send_keys("中国")
driver.find_element_by_id("su").click()
time.sleep(5)
driver.quit()