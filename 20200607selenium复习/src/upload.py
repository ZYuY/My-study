from selenium import webdriver
import time
import os
driver=webdriver.Chrome()
filepath="file:///"+os.path.abspath("E:\\测试脚本学习\\selenium2html\\upload-file.html")
driver.get(filepath)
driver.implicitly_wait(5)
driver.find_element_by_name("file").send_keys('D:\\PycharmProjects\\test\\upload.txt')
time.sleep(2)
driver.quit()