from selenium import webdriver
import time

from selenium.webdriver import ActionChains
from selenium.webdriver.common.keys import Keys

driver=webdriver.Chrome()
driver.get("http://baidu.com/")
driver.implicitly_wait(5)
driver.find_element_by_id("kw").send_keys("北京")
su=driver.find_element_by_id("su")
ActionChains(driver).context_click(su).perform()
time.sleep(5)
ActionChains(driver).double_click(su).perform()
time.sleep(6)
ActionChains(driver).context_click(su).perform()
# driver.find_element_by_id("su").click()
# time.sleep(5)
# driver.find_element_by_id("kw").send_keys(Keys.CONTROL,'a')
# driver.find_element_by_id("kw").send_keys(Keys.CONTROL,'x')
# driver.find_element_by_id("kw").send_keys("上海")
# # driver.find_element_by_id("su").click()
# driver.find_element_by_id("kw").send_keys(Keys.ENTER)
# time.sleep(5)
# driver.back()
# time.sleep(5)
# driver.forward()
# time.sleep(5)
driver.quit()