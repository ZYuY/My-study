from selenium import webdriver
import time
import os
driver=webdriver.Chrome()
filepath="file:///"+os.path.abspath("E:\\测试脚本学习\\selenium2html\\drop_down.html")
driver.get(filepath)
driver.implicitly_wait(5)

d=driver.find_element_by_id("ShippingMethod")
d.find_element_by_xpath("//option[@value='10.69']").click()
time.sleep(5)
driver.quit()