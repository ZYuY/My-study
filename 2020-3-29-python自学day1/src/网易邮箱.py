from selenium import webdriver
import time
driver=webdriver.Chrome()
driver.get("https://mail.163.com/#return")
driver.find_element_by_link_text("密码登录").click()
driver.implicitly_wait(10)
driver.find_element_by_class_name("j-inputtext dlemail j-nameforslide").clear()
driver.find_element_by_class_name("j-inputtext dlemail j-nameforslide").send_keys("zyuyu0607")
driver.find_element_by_class_name("password") .clear()
driver.find_element_by_name("password").send_keys("happyzyy0607")
driver.find_element_by_id("dologin").click()
time.sleep(5)
driver.quit()
