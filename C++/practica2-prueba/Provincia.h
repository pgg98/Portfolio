// BOTELLA MARTINEZ, JAVIER

#ifndef PROVINCIA_h
#define PROVINCIA_h


#include "LNear.h"

class Provincia
{
    friend ostream& operator<<(ostream &, Provincia &);

    private:
        Localidad lc;
        LNear locprox;

    public:
        Provincia();
        Provincia(Localidad l);
        Provincia(const Provincia &);
        ~Provincia();
        Provincia & operator=(const Provincia &);

        void calculaCercanas(Coleccion &, int );
        int borraLocalidad(string );
        LNear & getCercanas();
        string getCostera(Coleccion &);
        LNear getCosteras(Coleccion &);
        string getConAeropuerto();

        Localidad & getLocalidad();
};

#endif
