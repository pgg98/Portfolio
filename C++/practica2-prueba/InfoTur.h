// BOTELLA MARTINEZ, JAVIER

#ifndef INFOTUR_h
#define INFOTUR_h

#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <vector>

using namespace std;

class InfoTur
{

	friend ostream & operator<<(ostream &, const InfoTur &);

	private:
		int mus, mon, hot, res;
		bool aer;
		string top;
	public: 
		InfoTur();
		InfoTur(int m, int mo, int h, int r, bool a);
		InfoTur(const InfoTur &);
		~InfoTur();
		InfoTur & operator=(const InfoTur &);
		bool operator!=(const InfoTur &);
		bool operator==(const InfoTur &);
		vector<int> getInfoTur();
		string getMasFrecuente();
		void setTop(string n);
		string getTop();
		bool getAer();

};

#endif
