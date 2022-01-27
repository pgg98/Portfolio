// BOTELLA MARTINEZ, JAVIER

#ifndef LNEAR_h
#define LNEAR_h


#include "Coleccion.h"

class LNear
{
	private:
		class NodoL;
		NodoL *pr = NULL;
		NodoL *ul = NULL;
		Localidad error;

	public:

		LNear();
		LNear(const LNear &);
		~LNear();
		LNear & operator=(const LNear &);
		bool esVacia();
		int rango();
		void insertaLocalidad(Localidad p, int d);
		int borraLocalidad(string s);
		void borraLocalidades(int k);
		Localidad & getLocalidad(int i);

		int size();
		int getDis(int i);
	
	friend ostream & operator<<(ostream &, const LNear &);
	friend ostream & operator<<(ostream &, LNear::NodoL &);
};

class LNear::NodoL
{
	public:
		Localidad loc;
		int dis;
		NodoL *next = NULL;
		NodoL *prev = NULL;

		NodoL();
		NodoL(Localidad n);
		NodoL(const NodoL &);
		~NodoL();
		NodoL & operator=(const NodoL &);
};


#endif