#include "Provincia.h"

int main(int argc, char *argv[]){
	cout<<"Creo una coleccion"<<endl;
	Coleccion col=Coleccion();
	//if(argc==2){
		col.lectura("data");

		if(col.getLocalidades().size()>0){
			cout<<"Esta es mi coleccion:"<<endl;
			cout<<col;
			Provincia a=Provincia(col.getLocalidades()[0]);
			cout<<"He creado una provincia\n"<<endl;
			

			cout<<"CALCULO CERCANAS\n"<<endl;
			a.calculaCercanas(col,8);
			cout<<"Copio esta provincia en b y las muestro:"<<endl;
			Provincia b=a;
			cout<<"a:"<<endl<<a<<endl;
			cout<<"b:"<<endl<<b<<endl;
			cout<<"Vuelvo a calcular ceccanas con una distancia menor y vuelvo a mostrar:"<<endl;
			a.calculaCercanas(col,7);
			cout<<"a:"<<endl<<a<<endl;
			cout<<"b:"<<endl<<b<<endl;
			cout<<"\nA partir de ahora vamos a trabajar con la provincia a"<<endl;

			cout<<"\nVAMOS A PROBAR A BORRAR VARIAS LOCALIDADES\n"<<endl;
			cout<<"borro Alicante: "<<a.borraLocalidad("Alicante")<<endl;
			cout<<"borro Cocentaina: "<<a.borraLocalidad("Cocentaina")<<endl;
			cout<<"\nVuelvo a mostrar:"<<endl;
			cout<<a;

			cout<<"\nMUESTRO GETCERCANAS\n"<<endl;
			cout<<a.getCercanas();

			cout<<"\nBUSCAMOS LA PRIMERA COSTERA\n"<<endl;
			cout<<"La localidad costera mas cercana es: "<<a.getCostera(col)<<endl;

			cout<<"\nBUSCO TODAS LAS COSTERAS\n"<<endl;
			cout<<a.getCosteras(col);

			cout<<"\nPOR ULTIMO MIRO SI HAY AEROPUERTO\n"<<endl;
			//se puede modificar el fichero de entrada para comprobar todas las posibilidades
			//-sin ningun aeropuerto
			//-con aeropuerto en la primera(que es la de la provincia)
			//-sin aeropuerto en la primera pero en otras si
			cout<<a.getConAeropuerto()<<endl;;
			
		}
		
	//}





	return 0;
}