from selenium import webdriver
import time
import os
driver=webdriver.Chrome()
filepath="file:///"+os.path.abspath("E:\\测试脚本学习\\selenium2html\\modal.html")
driver.get(filepath)
driver.implicitly_wait(5)
driver.find_element_by_id("show_modal").click()
time.sleep(3)

#driver.find_element_by_id("myModal").find_element_by_class_name("modal-body").find_element_by_id("click");
driver.find_element_by_id("click").click()
time.sleep(5)

but=driver.find_element_by_class_name("modal-footer").find_elements_by_tag_name("button");
but[0].click()
time.sleep(3)
driver.quit()
