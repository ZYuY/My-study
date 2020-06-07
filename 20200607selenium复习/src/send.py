from selenium import webdriver
import time
import os
driver=webdriver.Chrome()
filepath="file:///"+os.path.abspath("E:\\测试脚本学习\\selenium2html\\send.html")
driver.get(filepath)
driver.implicitly_wait(5)
driver.find_element_by_xpath("/html/body/input") .click()
time.sleep(5)
alert=driver.switch_to.alert
alert.send_keys("张玉玉")
time.sleep(3)
alert.accept()
time.sleep(3)
driver.quit()