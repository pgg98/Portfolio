// BOTELLA MARTINEZ, JAVIER

#ifndef LOCALIDAD_h
#define LOCALIDAD_h

#include "InfoTur.h"
#include "Coordenadas.h"

class Localidad
{
	friend ostream & operator<<(ostream &, const Localidad &);

	private:
		string nombre;
		Coordenadas coor;
		InfoTur info;
		int id;
		bool cost;
	public:
		Localidad();
		Localidad(string s);
		Localidad(const Localidad &);
		~Localidad();
		Localidad & operator=(const Localidad &);
		int setCoor(int i, int j, vector< vector<char> > &mapa);
		void setInfo(InfoTur &a);
		string getNombre();
		Coordenadas & getCoor();
		InfoTur & getInfo();
		int getId();

		bool getCost();
		void setCost(bool );
};

#endif