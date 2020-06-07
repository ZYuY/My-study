from selenium import webdriver
import time
import os
driver=webdriver.Chrome()
filepath="file:///"+os.path.abspath("E:\\测试脚本学习\\selenium2html\\frame.html")
driver.get(filepath)
driver.implicitly_wait(5)
driver.switch_to.frame('f1')
driver.switch_to.frame('f2')
driver.switch_to_default.content()
# driver.find_element_by_id('kw') .send_keys("李明健")
# driver.find_element_by_id('su') .click()
driver.find_element_by_link_text('click') .click()
driver.maximize_window()
time.sleep(5)
driver.quit()