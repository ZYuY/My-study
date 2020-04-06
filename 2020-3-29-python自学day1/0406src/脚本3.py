from selenium import webdriver
import time

from selenium.webdriver import ActionChains

driver=webdriver.Chrome()
driver.get("https://www.baidu.com/")
driver.implicitly_wait(5)
driver.find_element_by_id("kw").send_keys("猪猪男孩")
su=driver.find_element_by_id("su")
ActionChains(driver).context_click(su).perform()

# ActionChains(driver).context_click(su).perform()
# time.sleep(6)
ActionChains(driver).double_click(su).perform()
time.sleep(6)
tmp=driver.find_element_by_id("kw")
new=driver.find_element_by_id("su")
ActionChains(driver).drag_and_drop(tmp,new).perform()
driver.quit()