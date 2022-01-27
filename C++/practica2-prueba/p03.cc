/**
* @author Alicia Garrido
* Se crea una coleccion y se invoca su metodo lectura. Se crea una provincia cuya capital es la primera localidad de la coleccion.  
* Se invoca calculaCercanas de la provincia con la coleccion y getCercanas. Se muestra la provincia por pantalla. 
* Se invoca borraLocalidad de la lista con el nombre de la primera localidad de la lista.
* Se muestra la provincia por pantalla
*/
#include "Provincia.h"

int main(int argc,char* argv[]){
  Coleccion col;
  int rango=22;
  if(argc==2){
    col.lectura(argv[1]);
    vector<Localidad> locas=col.getLocalidades();
    if(locas.size()>0){
      Provincia lejana(locas[0]);
      lejana.calculaCercanas(col,rango);
      cout<<"Provincia:"<<endl;
      cout<<lejana;
      LNear& lista=lejana.getCercanas();
      Localidad& primera=lista.getLocalidad(0);
      string nombre=primera.getNombre();
      int distancia=lista.borraLocalidad(nombre);
      cout<<"Se ha borrado la localidad "<<nombre<<" que estaba a una distancia de "<<distancia<<endl;
      cout<<"Provincia:"<<endl;
      cout<<lejana;
    }
  }
  else cout<<"Forma de uso: "<<argv[0]<<" fichero_entrada"<<endl;
}
 