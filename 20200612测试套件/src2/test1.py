import os

from selenium import webdriver
import time

driver=webdriver.Chrome()
file="file:///"+os.path.abspath("E:\\测试脚本学习\\selenium2html\\modal.html")
driver.get(file)
driver.implicitly_wait(5)
# drivers=driver.find_elements_by_tag_name('input')
# for input in drivers:
#     if input.get_attribute('type')=='checkbox':
#         input.click()

# driver.find_element_by_link_text('Link1').click()
# dri=driver.find_element_by_class_name('dropdown-menu').find_element_by_link_text('Action')
# time.sleep(2)
# webdriver.ActionChains(driver).double_click(dri).perform()

# driver.find_element_by_id("ShippingMethod").find_element_by_xpath("//*[@id='ShippingMethod']/option[5]").click()

# driver.find_element_by_id("tooltip").click()
# time.sleep(3)
# alert=driver.switch_to.alert
# alert.accept()


# driver.find_element_by_tag_name('input').click()
# alert=driver.switch_to.alert
# alert.send_keys("limingjian")
# time.sleep(3)
# alert.accept()

driver.find_element_by_id("show_modal").click()
time.sleep(3)
link=driver.find_element_by_id("myModal").find_element_by_id('click')
link.click()
time.sleep(3)
p=driver.find_element_by_class_name("modal-footer").find_elements_by_tag_name("button")
p[0].click()

time.sleep(5)
driver.quit()

