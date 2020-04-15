from selenium import webdriver
import time,os
driver=webdriver.Chrome()
file_path="file:///"+os.path.abspath("E:\测试脚本学习\selenium2html\\upload.html")
driver.get(file_path)
driver.find_element_by_name("file").send_keys("E:\测试脚本学习\src0409")
time.sleep(5)
driver.quit()