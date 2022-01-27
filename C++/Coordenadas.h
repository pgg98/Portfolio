// BOTELLA MARTINEZ, JAVIER

#ifndef COORDENADAS_h
#define COORDENADAS_h

#include<iostream>
#include<string>
#include<vector>

using namespace std;

class Coordenadas
{
	friend ostream & operator<<(ostream &, const Coordenadas &);

	private:
		int fila, col;
	public:
		Coordenadas();
		Coordenadas(int fila, int col);
		Coordenadas(const Coordenadas &);
		~Coordenadas();
		Coordenadas & operator=(const Coordenadas &);
		int getFila();
		int getColumna();
};

#endif