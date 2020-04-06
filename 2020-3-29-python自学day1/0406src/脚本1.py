from selenium import webdriver
import time
driver=webdriver.Chrome()
driver.get("https://www.baidu.com/")
driver.implicitly_wait(5)
driver.find_element_by_id("kw").send_keys("美团")
driver.find_element_by_id("su").click()
time.sleep(2)
js="var q=document.documentElement.scrollTop=100000"
driver.execute_script(js)
time.sleep(3)
js = "var q=document.documentElement.scrollTop=0"
driver.execute_script(js)
time.sleep(6)
driver.quit()