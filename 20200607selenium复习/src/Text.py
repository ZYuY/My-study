from selenium import webdriver
import os
import time

driver=webdriver.Chrome()
filepath="file:///"+os.path.abspath("E:\\测试脚本学习\\selenium2html\\drop_down.html")
driver.get(filepath)
driver.implicitly_wait(3)
# inputs=driver.find_elements_by_tag_name("input")
# for input in inputs:
#     if input.get_attribute("type")=='checkbox':
#         input.click()

# driver.switch_to.frame('f1')
# driver.switch_to.frame('f2')
# driver.find_element_by_id("kw").send_keys('创造营')
# driver.find_element_by_id("su") .click()

# driver.find_element_by_link_text('Link1') .click()
# driver.implicitly_wait(5)
# dri=driver.find_element_by_id("dropdown1").find_elements_by_link_text("Action")
# driver.implicitly_wait(5)
# webdriver .ActionChains (driver).move_to_element(dri[0]) .perform()

driver.find_element_by_id("ShippingMethod").find_element_by_xpath("//option[@value='10.69']").click()
time.sleep(5)
driver.quit()