import unittest
from ddt import ddt,data
from selenium import webdriver
import time
@ddt
class Baidu1(unittest.TestCase):
    def setUp(self):
     self.driver=webdriver.Chrome()
     self.url="http://www.baidu.com/"
     self.driver.implicitly_wait(5)
     # self.verificationErrors = []
     # self.accept_next_alert = True
    def tearDown(self):
        self.driver.quit()
        # self.assertEqual([], self.verificationErrors)
    # @unittest.skip("skipping")
    @data("Lisa","张一凡","蒋欣")
    def test_baidu1(self,value):
        self.driver.get(self.url)
        self.driver.find_element_by_id("kw").clear()
        self.driver.find_element_by_id("kw") .send_keys(value)
        self.driver.find_element_by_id("su") .click()
        time.sleep(5)
    def test_hao1(self):
        self.driver.get(self.url)
        self.driver.find_element_by_link_text("hao123") .click()
        # self.assertEqual(u"hao123_上网从这里开始", self.driver.title)
        time.sleep(5)
    if __name__=="__main__":
        unittest.main()

