import os
import time
from selenium import webdriver

driver=webdriver.Chrome()
file_path='file:///'+os.path.abspath("C:\\课件\\我的课件\\测试\\selenium2\\locateElement\\checkbox.html")
driver.get(file_path)
driver.switch_to.frame('f1')
driver.switch_to.frame('f2')

driver.find_element_by_link_text("Link1").click()
list=driver.find_element_by_id("dropdown1").find_element_by_link_text("Action")
webdriver.ActionChains (driver).move_to_element("list[0]") .perform()

driver.switch_to_default.content()