#include<iostream>
using namespace std;
#include<iomanip>
int main()
{
	int a=161;
	cout<<"dec:"<<dec<<a<<endl;            //十进制
	cout<<"hex:"<<hex<<a<<endl;            //十六进制
	cout<<"oct:"<<setbase(8)<<a<<endl;     //八进制
	char *pt="hello world";
	cout<<setw(16)<<pt<<endl;               //域宽为16
	cout<<setfill('*')<<setw(16)<<pt<<endl;
	double k=12.345678;
	cout<<setiosflags(ios::scientific)<<setprecision(8);  //按指数形式输出，保留8位小数
	cout<<"k="<<k<<endl;
	cout<<"k="<<setprecision(4)<<k<<endl;
	cout<<"k="<<setiosflags(ios::left)<<setiosflags(ios::fixed)<<k<<endl;  //左对齐，定点格式输出

	return 0;
}
