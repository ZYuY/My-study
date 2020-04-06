from selenium import webdriver
import time

from selenium.webdriver.common.keys import Keys

driver=webdriver.Chrome()
driver.get("https://www.baidu.com/")
driver.implicitly_wait(5)
# driver.find_element_by_id("kw") .send_keys(Keys.TAB)
# driver.find_element_by_id("kw").send_keys(Keys.ENTER)
driver.find_element_by_id("kw").send_keys("美团")
driver.find_element_by_id("su").click()
time.sleep(3)
driver.find_element_by_id("kw").send_keys(Keys.CONTROL ,'a')
time.sleep(3)
driver.find_element_by_id("kw").send_keys(Keys.CONTROL,'x')
time.sleep(3)
driver.find_element_by_id("kw").send_keys("腾讯")
driver.find_element_by_id("su").submit()
time.sleep(3)
driver.quit()
