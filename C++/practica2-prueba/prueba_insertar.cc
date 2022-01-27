// DNI 74019946 FERNANDEZ BELLIURE, ANTONIO JOSE
#include <vector>
#include <fstream>
#include <sstream>
#include <cstdlib>
#include "LNear.h"

int main(int argc, char *argv[]){


	Localidad loc1 = Localidad("Alicante");
	Localidad loc2 = Localidad("Alicante");
	Localidad loc3 = Localidad("Barcelona");
	Localidad loc4 = Localidad("Teruel");
	Localidad loc5 = Localidad("Teruel");
	Localidad loc6 = Localidad("Valladolid");
	Localidad loc7 = Localidad("Pamplona");
	Localidad loc8 = Localidad("Gijon");
	Localidad loc9 = Localidad("Euskadi");
	Localidad loc10 = Localidad("Burgos");
	Localidad loc11= Localidad("Cordoba");
	Localidad loc12= Localidad("Albacete");

	InfoTur info = InfoTur(1,2,3,4,true);

	loc1.setInfo(info);
	loc2.setInfo(info);
	loc3.setInfo(info);
	loc4.setInfo(info);
	loc5.setInfo(info);
	loc6.setInfo(info);
	loc7.setInfo(info);
	loc8.setInfo(info);
	loc9.setInfo(info);
	loc10.setInfo(info);
	loc11.setInfo(info);
	loc12.setInfo(info);

	LNear lista;

	cout<<"***Vamos a insertar***"<<endl;
	lista.insertaLocalidad(loc1,1);
	lista.insertaLocalidad(loc2,2);
	lista.insertaLocalidad(loc3,4);
	lista.insertaLocalidad(loc4,18);
	lista.insertaLocalidad(loc5,3);
	lista.insertaLocalidad(loc6,1);
	lista.insertaLocalidad(loc7,4);
	lista.insertaLocalidad(loc8,4);
	lista.insertaLocalidad(loc9,4);
	lista.insertaLocalidad(loc10,4);
	lista.insertaLocalidad(loc11,18);
	lista.insertaLocalidad(loc12,1);
	lista.insertaLocalidad(loc1,85);
	lista.insertaLocalidad(loc8,1);
	lista.insertaLocalidad(loc12,85);
	lista.insertaLocalidad(loc3,85);
	//no se van a insertar
	lista.insertaLocalidad(loc8,1);
	lista.insertaLocalidad(loc12,85);
	lista.insertaLocalidad(loc3,85);

	cout<<"***Primera lista***"<<endl;//16
	cout<<lista<<endl;
	cout<< "Rango: "<<lista.rango()<<endl;

	LNear lista2;
	

	lista2.insertaLocalidad(loc4,18);
	lista2.insertaLocalidad(loc3,4);
	lista2.insertaLocalidad(loc1,1);
	lista2.insertaLocalidad(loc2,2);
	lista2.insertaLocalidad(loc8,1);
	lista2.insertaLocalidad(loc12,85);
	lista2.insertaLocalidad(loc5,3);
	lista2.insertaLocalidad(loc6,1);
	lista2.insertaLocalidad(loc7,4);
	lista2.insertaLocalidad(loc11,18);
	lista2.insertaLocalidad(loc12,1);
	lista2.insertaLocalidad(loc1,85);
	lista2.insertaLocalidad(loc10,1);
	lista2.insertaLocalidad(loc2,4);
	//no se van a insertar
	lista2.insertaLocalidad(loc4,18);
	lista2.insertaLocalidad(loc3,4);
	lista2.insertaLocalidad(loc1,1);
	lista2.insertaLocalidad(loc2,2);

	cout<<"***Segunda Lista***"<<endl;//14
	cout<<lista2;
	cout<< "Rango: "<<lista.rango()<<endl;

	cout<<endl;
	cout<<"***Vamos a eliminar individualmente algun nodo***"<<endl;

	lista.borraLocalidad("Teruel");
	lista.borraLocalidad("Albacete");
	lista.borraLocalidad("Xixona");//no deberia borrar nada

	cout<<"***Primera lista***"<<endl;//16
	cout<<lista<<endl;
	cout<< "Rango: "<<lista.rango()<<endl;

	cout<<endl;
	cout<<"***Vamos a eliminar los que sean mayores que 18***"<<endl;

	lista.borraLocalidades(18);

	cout<<"***Primera lista***"<<endl;//16
	cout<<lista<<endl;
	cout<< "Rango: "<<lista.rango()<<endl;

	cout<<endl;
	cout<<"***Vamos a probar getLocalidad()***"<<endl;

	cout<<lista.getLocalidad(2);
	cout<<lista.getLocalidad(4);
	cout<<lista.getLocalidad(0);
	cout<<lista.getLocalidad(10);

	return 0;
}