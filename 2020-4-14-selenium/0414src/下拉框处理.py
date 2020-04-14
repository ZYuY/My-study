import os

from selenium import webdriver
import time

from selenium.webdriver import ActionChains

driver=webdriver.Chrome()
file_path="file:///"+os.path.abspath("E:\测试脚本学习\selenium2html\drop_down.html")
driver.get(file_path)
dri=driver.find_element_by_id("ShippingMethod")
dri.find_element_by_xpath("//*[@value='10.69']").click()
time.sleep(6)
driver.quit()
