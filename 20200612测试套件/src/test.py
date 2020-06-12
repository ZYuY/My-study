import unittest
import time
import os,sys
from src import Baidu01
from src import Baidu02
import HTMLTestRunner
def createsuit():
    # suit=unittest.TestSuite()
    # suit.addTest(Baidu01.Baidu1("test_hao1"))
    # return suit

    # suit=unittest.TestSuite()
    # suit.addTest(Baidu01.Baidu1("test_baidu1"))
    # suit.addTest(Baidu02.Baidu2("test_baidu2"))
    # suit.addTest(Baidu02.Baidu2 ("test_hao2"))
    # return suit

    suit=unittest.TestSuite()
    suit.addTest(unittest.makeSuite(Baidu01.Baidu1))
    suit.addTest(unittest.makeSuite(Baidu02.Baidu2))
    return suit

    # discover=unittest.defaultTestLoader.discover('../src',pattern='Baidu*.py',top_level_dir=None)
    # return discover
# def savescreenshot(self,driver,file_name):
#   if not os.path.exists('./image'):
#       os.makedirs('./image')
# now=time.strftime("%Y%m%d-%H%M%S",time.localtime(time.time()))
# #截图保存
# driver.get_screenshot_as_file('./image/'+now+'-'+file_name)
# time.sleep(1)
if __name__=="__main__":

    curpath=sys.path[0]
    print(curpath)
    now=time.strftime("%Y-%m-%d-%H %M %S",time.localtime(time.time()))


    if not os.path.exists(curpath+'/resultreport'):
                os.makedirs(curpath + '/resultreport')
    filename =curpath + '/resultreport/' + now + 'resultreport.html'
    with open(filename, 'wb') as fp:
    #出html报告
        runner = HTMLTestRunner.HTMLTestRunner(stream=fp, title=u'测试报告', description=u'用例执行情况',verbosity=2)
        suit=createsuit()
    # runner=unittest.TextTestRunner(verbosity=2)
        runner.run(suit)
    # suit=createsuit()
    # runner=unittest.TextTestRunner (verbosity=2)
    # runner.run(suit)

