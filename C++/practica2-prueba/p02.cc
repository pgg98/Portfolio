/**
* @author Alicia Garrido
* Se crea una coleccion y se invoca su metodo lectura. Se crea una provincia cuya capital es la primera localidad de la coleccion.  
* Se invoca calculaCercanas de la provincia con la coleccion. Se muestra la provincia por pantalla. Se invoca getCosteras y se 
* muestra por pantalla el resultado
*/
#include "Provincia.h"

int main(int argc,char* argv[]){
  Coleccion col;
  int rango=20;
  if(argc==2){
    col.lectura(argv[1]);
    vector<Localidad> locas=col.getLocalidades();
    if(locas.size()>0){
      Provincia lejana(locas[0]);
      lejana.calculaCercanas(col,rango);
      cout<<"Provincia:"<<endl;
      cout<<lejana;
      cout<<"Costeras:"<<endl;
      cout<<lejana.getCosteras(col);
    }
  }
  else cout<<"Forma de uso: "<<argv[0]<<" fichero_entrada"<<endl;
}
 