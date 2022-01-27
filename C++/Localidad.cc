// BOTELLA MARTINEZ, JAVIER

#include "Localidad.h"

Localidad::Localidad()
{
	nombre = "";
	coor = Coordenadas();
	info = InfoTur();
	id = -1;
	cost = false;
}

Localidad::Localidad(string s)
{
	nombre = s;
	coor = Coordenadas();
	info = InfoTur();
	id = -1;
	cost = false;
}

Localidad::Localidad(const Localidad &a)
{
	*this = a;
}

Localidad & Localidad::operator=(const Localidad &a)
{
	if(this != &a)
	{
		nombre = a.nombre;
		coor = a.coor;
		info = a.info;
		id = a.id;
		cost = a.cost;
	}

	return *this;
}

Localidad::~Localidad()
{
	nombre = "";
	coor = Coordenadas();
	info = InfoTur();
	id = -1;
}

int Localidad::setCoor(int i, int j, vector< vector<char> > &mapa)
{
	int ret = -1;

	if(!mapa.empty() && coor.getFila() == -1 && coor.getColumna() == -1 && i >= 0 && j >= 0 
		&& ((unsigned int) i < mapa.size()) && ((unsigned int) j < mapa.front().size()) 
		&& mapa[i][j] == 'T')
	{
		coor = Coordenadas(i,j);

		mapa[i][j] = 'L';

		if(i-1 >= 0 && mapa[i-1][j] == 'M')
            cost = true;
        else if(j-1 >= 0 && mapa[i][j-1] == 'M')
            cost = true;
        else if(j+1 < (int)mapa[i].size() && mapa[i][j+1] == 'M')
            cost = true;
        else if(i+1 < (int)mapa.size() && mapa[i+1][j] == 'M')
	       	cost = true;

		id = mapa.front().size() * i + j;
		ret = id;
	}

	return ret;
}

void Localidad::setInfo(InfoTur &a)
{
	info = a;
}

string Localidad::getNombre()
{
	return nombre;
}

Coordenadas & Localidad::getCoor()
{
	return coor;
}

InfoTur & Localidad::getInfo()
{
	return info;
}

int Localidad::getId()
{
	return id;
}

bool Localidad::getCost()
{
	return cost;
}

void Localidad::setCost(bool c)
{
	cost = c;
}

ostream & operator<<(ostream &out, const Localidad &a)
{
	out << a.id << "-" << a.nombre << "-" << a.coor << "\n" << a.info;
	return out;
}