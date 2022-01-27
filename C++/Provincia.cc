// BOTELLA MARTINEZ, JAVIER

#include "Provincia.h"

Provincia::Provincia()
{
    lc = Localidad();
    locprox = LNear();
}

Provincia::Provincia(Localidad l)
{
    lc = l;
    locprox = LNear();
}

Provincia::Provincia(const Provincia &a)
{
    *this = a;
}

Provincia::~Provincia()
{
    lc = Localidad();
    locprox = LNear();  
}

Provincia & Provincia::operator=(const Provincia &a)
{
    if(this != &a)
    {
        lc = a.lc;

        if(!locprox.esVacia())
            locprox.borraLocalidades(-999999);

        locprox = a.locprox;
    }

    return *this;
}


void Provincia::calculaCercanas(Coleccion &c, int n)
{
    vector< vector <char> > mapa = c.getMapa();
    Coordenadas coor = lc.getCoor();  
    vector<Localidad> lds = c.getLocalidades(); 
    
    int x1 = coor.getFila();
    int y1 = coor.getColumna();

    if(!locprox.esVacia())
        locprox.borraLocalidades(0);

    for(int i = 0; i < (int)lds.size(); i++)
    {
        int x2 = lds[i].getCoor().getFila();
        int y2 = lds[i].getCoor().getColumna();

        int dis = abs(x1 - x2) + abs(y1 - y2);
                 
        if(dis <= n && dis != 0)
           locprox.insertaLocalidad(lds[i], dis);
    }
}

int Provincia::borraLocalidad(string s)
{
    int ret = locprox.borraLocalidad(s);

    return ret;
}

LNear & Provincia::getCercanas()
{
    return locprox;
}

string Provincia::getCostera(Coleccion &c)
{
    string ret = "no hay ninguna localidad costera";

    if(!locprox.esVacia())
    {
        bool sal = false;
        vector<Localidad> ldes = c.getLocalidades();

        for(int i = 0; !sal && i < locprox.size(); i++)
        {
            if(locprox.getLocalidad(i).getCost())
            {
                for(int j = 0; !sal && j < (int)ldes.size(); j++)
                {
                    if(ldes[j].getCoor().getFila() == locprox.getLocalidad(i).getCoor().getFila()
                        && ldes[j].getCoor().getColumna() == locprox.getLocalidad(i).getCoor().getColumna()
                        && ldes[j].getNombre() == locprox.getLocalidad(i).getNombre()
                        && ldes[j].getCost() && ldes[j].getId() == locprox.getLocalidad(i).getId())
                    {
                        sal = true;
                        ret = locprox.getLocalidad(i).getNombre();
                    }
                }
            }
        }
    }

    return ret;
}

LNear Provincia::getCosteras(Coleccion &c)
{
    LNear ret = LNear();

    if(!locprox.esVacia())
    {
        bool sal = false;
        vector<Localidad> ldes = c.getLocalidades();

        for(int i = 0; i < locprox.size(); i++)
        {
            if(locprox.getLocalidad(i).getCost())
            {
                for(int j = 0; !sal && j < (int)ldes.size(); j++)
                {
                    if(ldes[j].getCoor().getFila() == locprox.getLocalidad(i).getCoor().getFila()
                        && ldes[j].getCoor().getColumna() == locprox.getLocalidad(i).getCoor().getColumna()
                        && ldes[j].getNombre() == locprox.getLocalidad(i).getNombre()
                        && ldes[j].getCost() && ldes[j].getId() == locprox.getLocalidad(i).getId())
                    {
                        sal = true;
                        ret.insertaLocalidad(locprox.getLocalidad(i), locprox.getDis(i));
                    }
                }

                sal = false;
            }
        }
    }

    return ret;
}

string Provincia::getConAeropuerto()
{
    string ret = "sin aeropuerto";

    if(lc.getInfo().getAer())
    {
        ret = "propio";
    }
    else if(!locprox.esVacia())
    {
        bool sal = false;

        for(int i = 0; !sal && i < locprox.size(); i++)
        {
            if(locprox.getLocalidad(i).getInfo().getAer())
            {
                ret = locprox.getLocalidad(i).getNombre();
                sal = true;
            }
        }
    }

    return ret;
}

Localidad & Provincia::getLocalidad()
{
    return lc;
}

ostream& operator<<(ostream &out, Provincia &a)
{
    out << a.lc.getNombre() << "\n" << a.locprox;
    return out;
}
