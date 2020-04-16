import unittest
from selenium import  webdriver
import os,time,sys,csv
from src0416 import text1
from src0416 import text2

'''
def createtestsuit():
    suit=unittest.TestSuite()
    suit.addTest(text1.Baidu1("test_search"))
    suit.addTest(text2.Baidu2("test_sear"))
    suit.addTest(text1.Baidu1("test_hao"))
    return suit

if __name__=='__main__':
    suit=createtestsuit()
    runner=unittest.TextTestRunner(verbosity=2)
    runner.run(suit)
'''

'''
def createsuit():
    suit=unittest.TestSuite()
    suit.addTest(text1.Baidu1("test_hao"))
    suit.addTest(text2.Baidu2("test_sear"))
    return suit
if __name__=='__main__':
    suit=createsuit()
    runner=unittest.TextTestRunner(verbosity=3)
    runner.run(suit)
'''
def createmaksuit():
    suit=unittest.TestSuite()
    suit.addTest(unittest.makeSuite(text1.Baidu1))
    suit.addTest(unittest.makeSuite(text2.Baidu2))
    return suit
def createtestloader():
    suite1=unittest.TestLoader().loadTestsFromTestCase(text1.Baidu1)
    suite2=unittest.TestLoader().loadTestsFromTestCase(text2.Baidu2)
    suit=unittest.TestSuite([suite1,suite2])
    return suit

def creatediscover():
    discover=unittest.defaultTestLoader.discover("../src0416",pattern='text*.py',top_level_dir=None)
    return discover
    # discover=unittest.defaultTestLoader.discover("../src0416",pattern='text*.py',top_level_dir=None)
    # print(discover)
    # return  discover

if __name__=='__main__':
    suit=creatediscover()
    runner=unittest.TextTestRunner(verbosity=2)
    runner.run(suit)