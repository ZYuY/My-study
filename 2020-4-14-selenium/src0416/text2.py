from selenium import webdriver
import unittest
import os,time
class Baidu2(unittest.TestCase):
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
    def test_sear(self):
        self.driver.get(self.base_url)
        self.driver.implicitly_wait(5)
        self.driver.find_element_by_id("kw").send_keys("陕西省高校开学")
        self.driver.find_element_by_id("su").click()
        time.sleep(5)
    if __name__=='__main__':
        unittest.main(verbosity=2)