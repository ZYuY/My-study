# name=input("请输入姓名");
# print("你好",name);
# print(1024*768);
# a='abc';
# b=a;
# a='ABC';
# print(a);
# print(b);
# n = 123
# f = 456.789
# s1 = 'Hello, world'
# s2 = 'Hello, \'Adam\''
# s3 = r'Hello, "Bart"'
# s4 = r'''中国,
# Lisa!'''
# print(s1);
# print(s2);
# print(s3);
# print(s4);
# a=input("请输入年纪");
# age=int(a);
# if age>10:
#     print("我%d大"%age);
#     print("哈哈");
# else:
#     print("你是猪");
# sum=0;
# lists=[1,2,3,4,5];
# for list in lists:
#     sum+=list;
# print(sum);
# list=list(range(10));
# print(list);
# sum=0;
# for a in range(10):
#     sum+=a;
# print(sum);
# sum=0;
# n=99;
# while n>0:
#     sum+=n;
#     n-=2;
# print(sum);
# L = ['Bart', 'Lisa', 'Adam'];
# # for list in L:
# #     print("hello，%s"%list);
# n=0;
# while n<3:
#     print("hello，%s" %L[n]);
#     n+=1;
# n = 0
# while n < 10:
#     n = n + 1
#     if n % 2 == 0: # 如果n是偶数，执行continue语句
#         continue # continue语句会直接继续下一轮循环，后续的print()语句不会执行
#     print(n)

n=0;
while n<10:
    n=n+1;
    if n%2==0:
        continue;
    print(n);
print("哈哈");