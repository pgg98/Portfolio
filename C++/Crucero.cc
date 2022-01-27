// BOTELLA MARTINEZ, JAVIER

#include "Provincia.h"

int main(int argc, char* argv[])
{
    Coleccion c = Coleccion();

    string n = argv[1];
    c.lectura(n);

    if((int)c.getLocalidades().size() > 0)
    {
        Localidad inicio = c.getLocalidades()[0];
        bool entra = inicio.getCost();

        Provincia p = Provincia(inicio);
        p.calculaCercanas(c, 99999999);

        LNear costs = p.getCosteras(c);

        if(!inicio.getCost())
        {
            if(!costs.esVacia())
            {
                cout << inicio.getNombre() << " " << costs.getLocalidad(0).getNombre() << " " << costs.getDis(0) << endl; 
                inicio = costs.getLocalidad(0);
                entra = true;
            }
            else
                entra = false;
        }

        if(entra)
        {
            vector< vector<char> > mapa = c.getMapa();
            Coordenadas cotemp = inicio.getCoor();

            int x1 = cotemp.getFila();
            int y1 = cotemp.getColumna();

            int xn = x1;
            int yn = y1;

            Localidad ltemp = inicio;

            int alg = -1;
            vector<int> algtotal = vector<int>();

            int dtotal = 0;
            int dtparcial = 0;

            vector<Localidad> cloc = vector<Localidad>();

            if(mapa[x1][y1+1] == 'M' && (mapa[x1+1][y1+1] == 'T' || mapa[x1+1][y1+1] == 'L'))
            {
                xn = x1 + 1;
                yn = y1 + 1; 

                alg = 1;
            }
            else if(mapa[x1+1][y1+1] == 'M' && (mapa[x1+1][y1] == 'T' || mapa[x1+1][y1] == 'L'))
            {
                xn = x1 + 1;
                yn = y1;

                alg = 2;
            }
            else if(mapa[x1+1][y1] == 'M' && (mapa[x1+1][y1-1] == 'T' || mapa[x1+1][y1-1] == 'L'))
            {
                xn = x1 + 1;
                yn = y1 - 1;

                alg = 3;
            }
            else if(mapa[x1+1][y1-1] == 'M' && (mapa[x1][y1-1] == 'T' || mapa[x1][y1-1] == 'L'))
            {
                xn = x1;
                yn = y1 - 1;

                alg = 4;
            }
            else if(mapa[x1][y1-1] == 'M' && (mapa[x1-1][y1-1] == 'T' || mapa[x1-1][y1-1] == 'L'))
            {
                xn = x1 - 1;
                yn = y1 - 1;

                alg = 5;
            }
            else if(mapa[x1-1][y1-1] == 'M' && (mapa[x1-1][y1] == 'T' || mapa[x1-1][y1] == 'L'))
            {
                xn = x1 - 1;
                yn = y1;

                alg = 6;
            }
            else if(mapa[x1-1][y1] == 'M' && (mapa[x1-1][y1+1] == 'T' || mapa[x1-1][y1+1] == 'L'))
            {
                xn = x1 - 1;
                yn = y1 + 1;

                alg = 7;
            }
            else if(mapa[x1-1][y1+1] == 'M' && (mapa[x1][y1+1] == 'T' || mapa[x1][y1+1] == 'L'))
            {
                xn = x1;
                yn = y1 + 1;

                alg = 0;
            }
            else
            {
                xn = x1;
                yn = y1;
            }

            if(alg != -1)
            {
                algtotal.push_back(alg);
                dtparcial = dtparcial + 1;
                dtotal = dtotal + 1; 

                cloc.push_back(c.getLocalidad(x1,y1));

                if(mapa[xn][yn] == 'L')
                {
                    cout << c.getLocalidad(x1,y1) << " " << c.getLocalidad(xn,yn) << " " << dtparcial << endl;
                    dtparcial = 0;
                    cloc.push_back(c.getLocalidad(xn,yn));
                }

                int alg2 = -1;
                bool valida = false;

                int xn2 = -1;
                int yn2 = -1;

                while((x1 != xn2 || y1 != yn2) && alg != -1)
                {
                    while(!valida)
                    {
                        alg2 = (alg + 5)%8;

                        switch(alg2)
                        {
                            case 0:
                                if(mapa[xn][yn+1] != 'M')
                                {
                                    xn2 = xn;
                                    yn2 = yn + 1;
                                    valida = true;
                                }    
                                break;
                            case 1:
                                if(mapa[xn+1][yn+1] != 'M')
                                {
                                    xn2 = xn + 1;
                                    yn2 = yn + 1;
                                    valida = true;
                                }
                                break;
                            case 2:
                                if(mapa[xn+1][yn] != 'M')
                                {
                                    xn2 = xn + 1;
                                    yn2 = yn;
                                    valida = true;
                                }
                                break;
                            case 3:
                                if(mapa[xn+1][yn-1] != 'M')
                                {
                                    xn2 = xn + 1;
                                    yn2 = yn - 1;
                                    valida = true;
                                }
                                break;
                            case 4:
                                if(mapa[xn][yn-1] != 'M')
                                {
                                    xn2 = xn;
                                    yn2 = yn - 1;
                                    valida = true;
                                }
                                break;
                            case 5:
                                if(mapa[xn-1][yn-1] != 'M')
                                {
                                    xn2 = xn - 1;
                                    yn2 = yn - 1;
                                    valida = true;
                                }
                                break;
                            case 6:
                                if(mapa[xn-1][yn] != 'M')
                                {
                                    xn2 = xn - 1;
                                    yn2 = yn;
                                    valida = true;
                                }
                                break;
                            case 7:
                                if(mapa[xn-1][yn+1] != 'M')
                                {
                                    xn2 = xn - 1;
                                    yn2 = yn + 1;
                                    valida = true;
                                }
                                break;
                        }

                        if(valida)
                            alg = alg2;
                        else
                        {
                            alg++;
                            if(alg == 8 )
                                alg = 0;
                        }
                    }

                    valida = false;

                    algtotal.push_back(alg2);
                    dtparcial = dtparcial + 1;
                    dtotal = dtotal + 1;

                    if(mapa[xn2][yn2] == 'L')
                    {
                        cloc.push_back(c.getLocalidad(xn2,yn2));
                        cout << cloc[cloc.size()-2].getNombre() << " " << cloc[cloc.size()-1].getNombre() << " " <<dtparcial << endl;
                        dtparcial = 0;
                    }
                    xn = xn2;
                    yn = yn2;
                }
            }

            cout << "total=" << dtotal << endl;

            for(int i = 0; i < (int)algtotal.size(); i++)
            {
                cout << algtotal[i];
            }

            cout << endl;
        }
    }
    else
        cout << "total=0" << endl << endl;
}