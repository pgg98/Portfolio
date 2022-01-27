// BOTELLA MARTINEZ, JAVIER

#ifndef COLECCION_h
#define COLECCION_h

#include <fstream>
#include "Localidad.h"

class Coleccion
{
	friend ostream & operator<<(ostream &, const Coleccion &);

	private:
		vector< vector<char> > mapa;
		vector<Localidad> ldes;
	public:
		Coleccion();
		Coleccion(const Coleccion &);
		~Coleccion();
		Coleccion & operator=(const Coleccion &);
		void lectura(string s);
		vector< vector<char> > & getMapa();
		vector<Localidad> & getLocalidades();
		char getCoorMapa(Coordenadas c);

		string getLocalidad(int , int );
};

#endif