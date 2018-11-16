#include<fstream>
#include<iostream>
using namespace std;
struct Person
{
	char num[4];
	char name[20];
	int age;
	char sex;
	int grade;
};
int main()
{
	int i=0;
	Person stud[10]={"001","Zhangsan",'M',18,90,"002","Lisi",'F',19,80,"003","Wangwu",'F',18,98,"004","Zhaoliu",'M',18,68,"005","Tianqi",'F',19,77,"006","Liuba",'M',18,87,"007","Gaojiu",'M',18,86,"008","Sunshi",'F',17,95,"009","Zhouhao",'M',18,93,"010","Maoyu",'M',18,85};
	
	
	ofstream outfile("student.dat",ios::binary);
	if(!outfile)
	{
		cerr<<"open error!\n"<<endl;
		abort();
	}
	for(i=0;i<10;i++)
		outfile.write((char*)&stud[i],sizeof(stud[i]));
	outfile.close();


	ifstream infile("student.dat",ios::binary);
	if(!infile)
	{
		cerr<<"open error!"<<endl;
		abort();
	}
	for( i=0;i<10;i++)
	infile.read((char*)&stud[i],sizeof(stud[i]));
	infile.close();

	for( i=0;i<10;i++)
	{	cout<<"num:"<<stud[i].num<<"\t";
		cout<<"name:"<<stud[i].name<<"\t";
		cout<<"age:"<<stud[i].age<<"\t";
		cout<<"sex:"<<stud[i].sex<<"\t";
		cout<<"grade:"<<stud[i].grade<<endl;
	}
	return 0;
	}
