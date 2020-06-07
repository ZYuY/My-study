from selenium import webdriver
import time
import os
driver=webdriver.Chrome()
filepath="file:///"+os.path.abspath("E:\\测试脚本学习\\selenium2html\\alert.html")
driver.get(filepath)
driver.implicitly_wait(5)
driver.find_element_by_id('tooltip').click()
time.sleep(3)
dri=driver.switch_to.alert
#dri.accept()
print(dri.text)
dri.dismiss()
time.sleep(3)
driver.quit()