from selenium import webdriver
import time
driver=webdriver.Chrome()
driver.get("https://www.baidu.com/")
driver.implicitly_wait(10)
driver.find_element_by_id("kw") .send_keys("西乡县")
driver.find_element_by_id("su").click()
driver.implicitly_wait(5)
driver.find_element_by_partial_link_text("最美古镇").click()
# driver.find_element_by_id("kw").clear()
# time.sleep(6)
#
# driver.find_element_by_id("kw").send_keys("西安")
# driver.maximize_window()
# # driver.find_element_by_link_text("hao123").click()
# driver.set_window_size(500,800)
# driver.find_element_by_id("su").submit()
time.sleep(5)
driver.quit()