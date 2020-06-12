import unittest

from selenium import webdriver
import time

class Baidu2(unittest.TestCase):
    def setUp(self):
     self.driver=webdriver.Chrome()
     self.url="http://www.baidu.com/"
     self.driver.implicitly_wait(5)
     self.verificationErrors = []
     self.accept_next_alert = True
    def tearDown(self):
        self.driver.quit()
        self.assertEqual([], self.verificationErrors)
    def test_baidu2(self):
        self.driver.get(self.url)
        self.assertEqual(self.driver.title,"百度一下",msg="not equals!")
        self.driver.find_element_by_id("kw").clear()
        self.driver.find_element_by_id("kw") .send_keys("金子涵")
        self.driver.find_element_by_id("su") .click()
        time.sleep(5)
    def test_hao2(self):
        self.driver.get(self.url)
        self.driver.find_element_by_link_text("hao123") .click()
        self.assertEqual(u"hao123_上网从这里开始", self.driver.title)

    if __name__=="__main__":
        unittest.main()

