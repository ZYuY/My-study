from selenium import webdriver
import unittest
import os,time
class Baidu1(unittest.TestCase):
    def setUp(self):
        self.driver=webdriver.Chrome()
        self.base_url="http://www.baidu.com"
        self.driver.maximize_window()
        self.errors=[]
        self.accept_newxt_alert=True
    def tearDown(self):
        self.driver.quit()
        self.assertEqual([],self.errors)
    # @ unittest.skip("skipping")
    def test_search(self):
        self.driver.get(self.base_url)
        self.driver.implicitly_wait(5)
        self.driver.find_element_by_id("kw").send_keys("高校开学")
        self.driver.find_element_by_id("su").click()
        time.sleep(5)
    def test_hao(self):
        self.driver.get(self.base_url)
        self.driver.find_element_by_link_text("hao123").click()
        time.sleep(6)
    if __name__=='__main__':
        unittest.main(verbosity=2)