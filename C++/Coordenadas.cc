// BOTELLA MARTINEZ, JAVIER

#include "Coordenadas.h"

Coordenadas::Coordenadas()
{
	fila = -1;
	col = -1;
}

Coordenadas::Coordenadas(int i, int j)
{
	if(i >= 0 && j >= 0)
	{
		fila = i;
		col = j;
	}
	else
	{
		fila = -1;
		col = -1;
	}
}

Coordenadas::Coordenadas(const Coordenadas &a)
{
	*this = a;
}

Coordenadas::~Coordenadas()
{
	fila = -1;
	col = -1;
}

Coordenadas & Coordenadas::operator=(const Coordenadas &a)
{
	if(this != &a)
	{
		fila = a.fila;
		col = a.col; 
	}

	return *this;
}


int Coordenadas::getFila()
{
	return fila;
}

int Coordenadas::getColumna()
{
	return col;
}

ostream & operator<<(ostream &out, const Coordenadas &a)
{
	out << "(" << a.fila << "," << a.col << ")";

	return out;
}
