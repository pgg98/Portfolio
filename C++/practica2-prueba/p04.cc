/**
* @author Alicia Garrido
* Se crea una coleccion y una lista. Se invoca el metodo lectura de la coleccion y getLocalidades. Se consulta si
* la lista esta vacia. Se insertan las localidades de la coleccion en la lista con diferentes distancias, consultando y
* mostrando el rango de la lista con cada insercion. Se consulta si la lista esta vacia. Se muestra la lista por pantalla
*/
#include "LNear.h"

vector<int> creaDistancias(){
  vector<int> v;
  v.push_back(22);
  v.push_back(12);
  v.push_back(31);
  v.push_back(25);
  v.push_back(5);
  v.push_back(9);
  return v;
}
int main(int argc,char* argv[]){
  Coleccion col;
  LNear lista;
  if(argc==2){
    col.lectura(argv[1]);
    vector<Localidad> locas=col.getLocalidades();
    vector<int> distancias=creaDistancias();
    cout<<"la lista esta vacia? -> "<<lista.esVacia()<<" y su rango es "<<lista.rango()<<endl;
    for(int i=0;i<(int)locas.size()&& i<(int)distancias.size();i++){
      lista.insertaLocalidad(locas[i],distancias[i]);
      cout<<"insertada "<<locas[i].getNombre()<<" -> rango de la lista "<<lista.rango()<<endl;
    }
    cout<<"la lista esta vacia? -> "<<lista.esVacia()<<" => Contenido de la lista:"<<endl;
    cout<<lista;
  }
  else cout<<"Forma de uso: "<<argv[0]<<" fichero_entrada"<<endl;
}
 