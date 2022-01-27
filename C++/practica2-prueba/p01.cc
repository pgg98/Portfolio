/**
* @author Alicia Garrido
* Se crea una coleccion y una lista. Se invoca el metodo lectura de la coleccion y getLocalidades.
* Se insertan las localidades de la coleccion en la lista con diferentes distancias. Se muestra
* la lista por pantalla
*/
#include "LNear.h"

int main(int argc,char* argv[]){
  Coleccion col;
  LNear lista;
  if(argc==2){
    col.lectura(argv[1]);
    vector<Localidad> locas=col.getLocalidades();
    for(int i=0;i<(int)locas.size();i++){
      lista.insertaLocalidad(locas[i],i+1);
    }
    cout<<"Contenido de la lista:"<<endl;
    cout<<lista;
  }
  else cout<<"Forma de uso: "<<argv[0]<<" fichero_entrada"<<endl;
}
 