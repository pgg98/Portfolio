// BOTELLA MARTINEZ, JAVIER

#include "InfoTur.h"


//								CONSTRUCTORES
InfoTur::InfoTur()
{
	top = "";
	aer = false;
	mus = 0;
	mon = 0;
	hot = 0;
	res = 0;
}

InfoTur::InfoTur(int m, int mo, int h, int r, bool a)
{
	if(m >= 0)
		mus = m;
	else
		mus = 0;

	if(mo >= 0)
		mon = mo;
	else
		mon = 0;

	if(h >= 0)
		hot = h;
	else
		hot = 0;

	if(r >= 0)
		res = r;
	else
		res = 0;

	aer = a;
	top = "";
}

InfoTur::InfoTur(const InfoTur &a)
{
	*this = a;
}


//								DESTRUCTOR
InfoTur::~InfoTur()
{
	top = "";
	aer = false;
	mus = 0;
	mon = 0;
	hot = 0;
	res = 0;
}


//								OPERADORES 
InfoTur& InfoTur::operator=(const InfoTur &a)
{
	if(this != &a)
	{
		mon = a.mon;
		mus = a.mus;
		hot = a.hot;
		res = a.res;
		aer = a.aer;
		top = a.top;
	}

	return *this;
}

bool InfoTur::operator!=(const InfoTur &a)
{
	bool ret = true;

	if(mus == a.mus && mon == a.mon && hot == a.hot && res == a.res && aer == a.aer && top == a.top)
		ret = false;

	return ret;
}

bool InfoTur::operator==(const InfoTur &a)
{
	bool ret = false;

	if(mus == a.mus && mon == a.mon && hot == a.hot && res == a.res && aer == a.aer && top == a.top)
		ret = true;

	return ret;
}

//								METODOS
vector<int> InfoTur::getInfoTur()
{
	vector<int> ret;
	ret.push_back(mus);
	ret.push_back(mon);
	ret.push_back(hot);
	ret.push_back(res);
	ret.push_back(aer);

	return ret;
}

string InfoTur::getMasFrecuente()
{
	string ret = "aeropuerto";		// Aeropuerto > Hotel > Restaurante > Monumento > Museo

	if(res > mon && res > mus && res > hot && res > aer)
		ret = "restaurante";
	else if(mus > mon && mus > hot && mus > aer)
		ret = "museo";
	else if(mon > hot && mon > aer)
		ret = "monumento";
	else if(hot > aer)
		ret = "hotel";

	return ret;
}

string InfoTur::getTop()
{
	return top;
}
void InfoTur::setTop(string n)
{
	top = n;
}

bool InfoTur::getAer()
{
	return aer;
}


ostream& operator<<(ostream &out, const InfoTur &a)
{
	out << a.mus << " " << a.mon << " " << a.hot << " " << a.res << " " << a.aer << " " << a.top << "\n";
	return out;
}

