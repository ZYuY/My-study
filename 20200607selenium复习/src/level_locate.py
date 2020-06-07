from selenium import webdriver
import time
import os

from selenium.webdriver.support.wait import WebDriverWait

driver=webdriver.Chrome()
filepath="file:///"+os.path.abspath("E:\\测试脚本学习\\selenium2html\\level_locate.html")
driver.get(filepath)
driver.implicitly_wait(5)
WebDriverWait(driver,10).until(lambda the_driver:
the_driver.find_element_by_id('dropdown1').is_displayed())
driver.find_element_by_link_text('Link1') .click()
driver.implicitly_wait(5)
dri=driver.find_element_by_id('dropdown1').find_elements_by_link_text('Action')
driver.implicitly_wait(5)
webdriver.ActionChains(driver).move_to_element(dri[0]) .perform()
#webdriver.ActionChains(driver).move_to_element(dri[0]).perform()
time.sleep(5)
driver.quit()