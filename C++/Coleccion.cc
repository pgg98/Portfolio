// BOTELLA MARTINEZ, JAVIER

#include "Coleccion.h"

Coleccion::Coleccion()
{
	mapa = vector< vector<char> >();
	ldes = vector<Localidad>();
}

Coleccion::Coleccion(const Coleccion &a)
{
	*this = a;
}

Coleccion::~Coleccion()
{
	mapa = vector< vector<char> >();
	ldes = vector<Localidad>();
}

Coleccion & Coleccion::operator=(const Coleccion &a)
{
	if(this != &a)
	{
		mapa = a.mapa;
		ldes = a.ldes;
	}

	return *this;
}

void Coleccion::lectura(string s)
{
	ifstream fich(s.c_str());

	if(!fich)
	{
		cerr << "ERROR en lectura de fichero" << endl;
	}

	string linea;

	while(getline(fich, linea) && linea != "<LOCALIDAD>") //MAPA
	{
		vector<char> ctemp = vector<char>(); 

		for(unsigned int i = 0; i < linea.length(); i++)
			ctemp.push_back(linea[i]);

		mapa.push_back(ctemp);
	}

	while(getline(fich, linea))	//LOCALIDAD
	{
		if(linea == "<LOCALIDAD>")
			getline(fich, linea);

		Localidad templ(linea);
		getline(fich, linea);

		string lim = " ";

		string sub1 = linea.substr(0, linea.find(lim));
		linea.erase(0, linea.find(lim) + lim.length());

		int x = atoi(sub1.c_str());
		int y = atoi(linea.c_str());

		int id = templ.setCoor(x, y, mapa);

		if(id != -1)
		{
			mapa[x][y] = 'L';

			getline(fich, linea);
		
			int info[] = {0,0,0,0};
			bool aer = false;
			string top = "";

			while(getline(fich, linea) && linea != "<LOCALIDAD>")
			{
				string temps = linea.substr(0, linea.find(lim));
				linea.erase(0, linea.find(lim) + lim.length());

				if(temps == "museo")
					info[0] = atoi(linea.c_str());
				else if(temps == "monumento")
					info[1] = atoi(linea.c_str());
				else if(temps == "hotel")
					info[2] = atoi(linea.c_str());
				else if(temps == "restaurante")
					info[3] = atoi(linea.c_str());
				else if(temps == "aeropuerto")
					aer = true;
				else
					top = temps + " " + linea;
			}	

			InfoTur inf(info[0], info[1], info[2], info[3], aer);
			inf.setTop(top);

			templ.setInfo(inf);

			ldes.push_back(templ);
		}
		else
			while(getline(fich, linea) && linea != "<LOCALIDAD>");


	}
}

vector< vector<char> > & Coleccion::getMapa()
{
	return mapa;
}

vector<Localidad> & Coleccion::getLocalidades()
{
	return ldes;
}

char Coleccion::getCoorMapa(Coordenadas c)
{
	char ret = 'X';

	if(c.getFila() >= 0 && ((unsigned int ) c.getFila() < mapa.size()) 
	&& c.getColumna() >= 0 && ((unsigned int)c.getColumna() < mapa.at(0).size()))
		ret = mapa.at(c.getFila()).at(c.getColumna());

	return ret;
}

string Coleccion::getLocalidad(int x, int y)
{
	bool sal = false;

	string ret = "";

	for(int i = 0; !sal && i < (int)ldes.size(); i++)
	{
		if(ldes[i].getCoor().getFila() == x && ldes[i].getCoor().getColumna() == y)
		{
			sal = true;
			ret = ldes[i].getNombre();
		}
	}

	return ret;
}

ostream & operator<<(ostream &out, const Coleccion &a)
{
	for(unsigned int i = 0; i < a.mapa.size(); i++)
	{
		for(unsigned int j = 0; j < a.mapa.at(i).size(); j++)
			out << a.mapa.at(i).at(j);

		out << "\n";
	}

	for(unsigned int i = 0; i < a.ldes.size(); i++)
		out << a.ldes.at(i) ;

	return out;
}