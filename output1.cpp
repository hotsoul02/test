#include <iostream>
using namespace std;
int main()
{
	cout<<"1234567890"<<endl;
	cout<<"Deafault width is"<<cout.width()<<endl;  
	int i=1234;
	cout<<i<<endl;
	cout.width(12);        //设置域宽为12
	cout<<i<<endl;
	cout<<"Deafault fill is"<<cout.fill()<<endl;
	cout<<i<<endl;
	cout.width(12);       //所设置的域宽仅对下一个输出流有效，一次输出完成后，域宽恢复为0
	cout.fill('*');
	cout.setf(ios::left);
	cout<<i<<endl;
	cout<<"Deafault precision is"<<cout.precision()<<endl;
	float j=12.3456789;
	cout<<j<<endl;
	cout.width(12);
	cout.setf(ios::right);
	cout.precision(5);
	cout<<j<<endl;
	return 0;
}
