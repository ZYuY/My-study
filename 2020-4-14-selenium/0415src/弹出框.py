from selenium import webdriver
import os,time
driver=webdriver.Chrome()
'''
file_path="file:///"+os.path.abspath("E:\测试脚本学习\selenium2html\\alert.html")
driver.get(file_path)
driver.find_element_by_id("tooltip").click()
time.sleep(3)
alert=driver.switch_to_alert()
time.sleep(5)
# print(alert.text)
# alert.accept()
# alert.dismiss()
'''

'''
file_path="file:///"+os.path.abspath("E:\测试脚本学习\selenium2html\send.html")
driver.get(file_path)
driver.find_element_by_xpath("/html/body/input").click()
time.sleep(3)
alert=driver.switch_to_alert()
time.sleep(3)
alert.send_keys("张玉玉")
time.sleep(3)
alert.accept()
'''
file_path="file:///"+os.path.abspath("E:\测试脚本学习\selenium2html\modal.html")
driver.get(file_path)
driver.find_element_by_id("show_modal").click()
time.sleep(3)
p=driver.find_element_by_id("myModal").find_element_by_id("click")
time.sleep(5)
p.click()
time.sleep(5)
list=driver.find_element_by_class_name("modal-footer").find_elements_by_tag_name("button")
list[0].click()
time.sleep(5)
driver.quit()