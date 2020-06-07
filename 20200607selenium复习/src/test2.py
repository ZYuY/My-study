from selenium import webdriver
import time

from selenium.webdriver import ActionChains
from selenium.webdriver.common import keys
from selenium.webdriver.common.keys import Keys

driver=webdriver.Chrome()
driver.get("https://www.baidu.com/")
driver.implicitly_wait(3)
driver.find_element_by_id("kw").send_keys("乃万")
#driver.find_element_by_id("su").submit()
dri=driver.find_element_by_id("su")
#ActionChains(driver).context_click(dri) .perform()
ActionChains(driver).double_click(dri) .perform()
# driver.find_element_by_id("kw").send_keys(Keys.CONTROL ,'a' )
# time.sleep(3)
# driver.find_element_by_id("kw") .send_keys(Keys.CONTROL ,'x')
# time.sleep(3)
# driver.find_element_by_id("kw") .send_keys("猪")
# time.sleep(3)
# js="var q=document.documentElement.scrollTop=10000"
# driver.execute_script(js)
time.sleep(5)
driver.quit()