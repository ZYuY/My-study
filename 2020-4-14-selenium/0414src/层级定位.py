import os

from selenium import webdriver
import time

from selenium.webdriver import ActionChains

driver=webdriver.Chrome()
file_path="file:///"+os.path.abspath("E:\测试脚本学习\selenium2html\level_locate.html")
driver.get(file_path)
driver.find_element_by_link_text("Link1").click()
driver.implicitly_wait(10)
list=driver.find_element_by_id("dropdown1").find_elements_by_link_text("Action")
webdriver.ActionChains(driver).move_to_element(list[0]).perform()
time.sleep(5)
driver.quit()