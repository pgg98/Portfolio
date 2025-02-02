#include <iostream>
#include "loadjpeg.c"
using namespace std;
/****************************************************************************************************

    CarGL (main.cpp)

    Grado en Ingenier�a Multimedia.
    Pr�ctica de Gr�ficos por Computador.
    OpenGL con Shaders.
  ------------------------------------------------------------------------------------------

    CarsGL (C) 2012-2016 - Juan Antonio Pucholin Garc�a (puchol@dccia.ua.es)

    Changelog:

    Versi�n 1.0 (Noviembre 2012)
        - Versi�n inicial para Code::Blocks 10.05

    Versi�n 1.1 (Noviembre 2012)
        - Arreglado el bug de selecci�n incorrecta debido al panel inferior de controles

    Versi�n 1.2 (Octubre 2013 )
        - Adaptaci�n de la librer�a GLUI a Code::Blocks 12.11 y 13.12

    Versi�n 1.3 (Octubre 2014 )
        - Adaptaci�n de la librer�a GLUI a Code::Blocks 13.12

    Versi�n 2.0 (Octubre 2015 )
        - Adaptaci�n del c�digo empleando Shaders (Modern OpenGL Graphics)

    Versi�n 2.1 (Septiembre 2016 )
        - Modificaci�n de los scrollbars de las luces para manipular la posisi�n (compatible con Code::Blocks 16.01)

    NOTA:   Para que esta aplicaci�n compile se necesita tener copiados los
            siguientes ficheros desde la carpeta "Para Copiar":

            glut32.dll  -> C:\Windows\system

            Si es un Windows de 32 bits:
            glew32s.lib -> C:\Program Files\CodeBlocks\MinGW\lib
            glew32.lib  -> C:\Program Files\CodeBlocks\MinGW\lib
            libglui32.a -> C:\Program Files\CodeBlocks\MinGW\lib
            glut32.lib  -> C:\Program Files\CodeBlocks\MinGW\lib

            glui.h      -> C:\Program Files\CodeBlocks\MinGW\include\GL
            glut.h      -> C:\Program Files\CodeBlocks\MinGW\include\GL
            glew.h      -> C:\Program Files\CodeBlocks\MinGW\include\GL

            y la carpeta completa
            glm         -> C:\Program Files\CodeBlocks\MinGW\include

            Si es un Windows de 64 bits:
            glew32s.lib -> C:\Program Files (x86)\CodeBlocks\MinGW\lib
            glew32.lib  -> C:\Program Files (x86)\CodeBlocks\MinGW\lib
            libglui32.a -> C:\Program Files (x86)\CodeBlocks\MinGW\lib
            glut32.lib  -> C:\Program Files (x86)\CodeBlocks\MinGW\lib

            glui.h      -> C:\Program Files (x86)\CodeBlocks\MinGW\include\GL
            glut.h      -> C:\Program Files (x86)\CodeBlocks\MinGW\include\GL
            glew.h      -> C:\Program Files (x86)\CodeBlocks\MinGW\include\GL

            y la carpeta completa
            glm         -> C:\Program Files (x86)\CodeBlocks\MinGW\include


            ACLARACI�N:
                Hay varias librer�as libglui32.a en la carpeta "otros"
                - Renombrar libglui32.10.05.a a libglui32.a para usar Code::Blocks 10.05
                - Renombrar libglui32.12.11.a a libglui32.a para usar Code::Blocks 12.11
                - Renombrar libglui32.13.12.a a libglui32.a para usar Code::Blocks 13.12 o superior

****************************************************************************************************/

#include "Objects.h"
#include <GL\glui.h>

/**************************************** myGlutKeyboard() **********/

void Keyboard(unsigned char Key, int x, int y)
{
    switch(Key)
    {
        case 27:
        case 'q':
            exit(0);
            break;

    }

    glutPostRedisplay();
}

/**************************************** mySpecialKey() *************/

static void SpecialKey(int key, int x, int y)
{
    TPrimitiva *car = escena.GetCar(escena.seleccion);

    if(car != NULL){
        switch (key)
        {
            case GLUT_KEY_UP:   // El coche avanza
            car->rr += 10;

            car->rcar = car->rcar + car->rrz;
            std::cout << "angulo: " << car->rcar << std::endl;

            car->tz += cos(glm::radians(car->rcar))*2;
            car->tx -= sin(glm::radians(car->rcar))*2;

            std::cout << "coche(x,z) = (" << car->tx << "," << car->tz <<")" << endl;
                break;
            case GLUT_KEY_DOWN:   // El coche retrocede

                break;
            case GLUT_KEY_LEFT:
                if(car->rrz >= -30)
                car->rrz -= 1;
                break;

            case GLUT_KEY_RIGHT:
                if(car->rrz <= 30)
                car->rrz += 1;
                break;
        }
        std::cout << "rotacion en rueda z: " << car->rrz;
        std::cout << "velocidad: " << car->velocidad << endl;
    }
    glutPostRedisplay();
}

/***************************************** myGlutMenu() ***********/

void Menu( int value )
{
  Keyboard( value, 0, 0 );
}

void Render()
{
    escena.Render();

}

void Idle()
{
    gui.Idle();
}

void Reshape(int x, int y){
    gui.Reshape(x, y);
}

void Mouse(int button, int button_state, int x, int y ){
    int tecla;
    tecla = glutGetModifiers();
    if(button_state == GLUT_UP){
        if(escena.movido == false){
            std::cout << "click para seleccionar" << std::endl;
            escena.Pick3D(x, y);
        }
        else{
            escena.movido = false;
            escena.operacion = NINGUNA;
            escena.last_x = 0;
            escena.last_y = 0;
            escena.activo_z = false;
        }
    }
    else{
        escena.last_x = x;
        escena.last_y = y;
        if(tecla & GLUT_ACTIVE_CTRL){
            escena.activo_z = true;
        }
        if(button == GLUT_LEFT_BUTTON){
            if(tecla & GLUT_ACTIVE_SHIFT){
                escena.operacion = TRASLADAR; // traslacion.
            }
            else{
                escena.operacion = ROTAR; // rotacion.
            }
        }
        else{
            escena.operacion = ESCALAR; // escalado.
        }
    }
    gui.Mouse(button, button_state, x, y);
}

void Motion(int x, int y){
    escena.movido = true;
    int difx, dify;
    difx = x - escena.last_x;
    dify = y - escena.last_y;
    if(escena.operacion == ROTAR){ // rotacion
        if(!escena.activo_z){
            escena.rot_x += dify /3.0;
            escena.rot_y += difx /3.0;
        }
        else{
            escena.rot_z += difx / 3.0;
        }
    }
    escena.last_x = x;
    escena.last_y = y;
    std::cout << x << ", " << y << endl;

    if(escena.operacion == TRASLADAR){ // traslacion
        if(!escena.activo_z){
            escena.view_position[0] += difx/10.0;
            escena.view_position[1] += dify/10.0;
        }
        else{
            escena.view_position[2] += dify/10.0;
        }
    }
    if(escena.operacion == ESCALAR){ // escalado.
        if(!escena.activo_z){
            escena.scale += difx / 10.0;
            escena.scale += dify/ 10.0;
        }
        else{
            escena.scale += difx / 10.0;
        }
    }
    gui.Motion(x, y);


    std::cout << "en motion" << endl;
    std::cout << escena.view_position[0] << ",";
    std::cout << escena.view_position[1] << ",";
    std::cout << escena.view_position[2] << endl;

    for(int i = 0; i < 16; i++){
        cout << escena.view_rotate[i] << " ";
        if((i + 1) % 4 == 0)
            cout << endl;
    }
    cout << "--------------" << endl;
}

void cargarTextura(int id){
    int width, height;
    unsigned char *img;

    width = escena.texturas_width[id];
    height = escena.texturas_height[id];
    img = escena.texturas[id];


    glBindTexture(GL_TEXTURE_2D, escena.texturas_id[id]);
    glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_WRAP_S,GL_REPEAT); // HORIZONTAL
    glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_WRAP_T,GL_REPEAT); // VERTICAL

    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
    glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_DECAL);

    glTexImage2D(GL_TEXTURE_2D, 0, 3, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, img);

}
/**************************************** main() ********************/
void cargarTexturas(){
    // loadjpeg devuelve un vector con los bytes de color de la imagen.

    escena.texturas[0] = LoadJPEG("..\\..\\Texturas\\micubo.jpg",
                                  &escena.texturas_width[0],
                                  &escena.texturas_height[0]);
    escena.texturas[1] = LoadJPEG("..\\..\\Texturas\\cono.jpg",
                                  &escena.texturas_width[1],
                                  &escena.texturas_height[1]);
    escena.texturas[2] = LoadJPEG("..\\..\\Texturas\\micubo.jpg",
                                  &escena.texturas_width[2],
                                  &escena.texturas_height[2]);

    /*escena.texturas[3] = LoadJPEG("..\\..\\Texturas\\road.jpg",
                                  &escena.texturas_width[2],
                                  &escena.texturas_height[2]);

    escena.texturas[4] = LoadJPEG("..\\..\\Texturas\\tarbol.jpg",
                                  &escena.texturas_width[2],
                                  &escena.texturas_height[2]);
    escena.texturas[5] = LoadJPEG("..\\..\\Texturas\\tfarola.jpg",
                                  &escena.texturas_width[2],
                                  &escena.texturas_height[2]);

    escena.texturas[6] = LoadJPEG("..\\..\\Texturas\\banco.jpg",
                                  &escena.texturas_width[2],
                                  &escena.texturas_height[2]);*/


    glGenTextures(3, escena.texturas_id);
    for(int i = 0; i < 3; i++){
        cargarTextura(i);
    }



}

int main(int argc, char* argv[])
{
    // Inicializa GLUT and crea la ventana principal
    glutInit(&argc, argv);
    glutInitDisplayMode( GLUT_RGBA | GLUT_DOUBLE | GLUT_DEPTH | GLUT_STENCIL | GLUT_MULTISAMPLE );
    glutInitWindowPosition( 50, 50 );
    glutInitWindowSize( 1400, 800 );

    int main_window = glutCreateWindow( "CarGL V2.0 (2015) con Shaders" );

    // Inicializa los valores de OpenGL para esta Aplicaci�n
    escena.InitGL();
    gui.Init(main_window);

    glutDisplayFunc( Render );
//    glutDisplayFunc(RenderSelection);
    GLUI_Master.set_glutReshapeFunc( Reshape );
    GLUI_Master.set_glutKeyboardFunc( Keyboard );
    GLUI_Master.set_glutSpecialFunc( SpecialKey );
    GLUI_Master.set_glutMouseFunc( Mouse );
    glutMotionFunc( Motion );

    /**** We register the idle callback with GLUI, *not* with GLUT ****/
    GLUI_Master.set_glutIdleFunc( Idle );

    // Crea los objetos
    TPrimitiva *road = new TPrimitiva(CARRETERA_ID, CARRETERA_ID);
    TPrimitiva *car1 = new TPrimitiva(1, COCHE_ID);
    TPrimitiva *car2 = new TPrimitiva(2, COCHE_ID);

    // 1. creamos la primitiva.
    TPrimitiva *figura = new TPrimitiva(TODO_ID, TODO_ID); // SOLAMENTE VOY A PONER UNO.
    TPrimitiva *arbol = new TPrimitiva(ARBOL_ID, ARBOL_ID);
    TPrimitiva *semaforo = new TPrimitiva(SEMAFORO_ID, SEMAFORO_ID);
    TPrimitiva *farola = new TPrimitiva(FAROLA_ID, FAROLA_ID);
    TPrimitiva *banco = new TPrimitiva(BANCO_ID, BANCO_ID);
    TPrimitiva *papelera = new TPrimitiva(PAPELERA_ID, PAPELERA_ID);


    car2->colores[0][0] = 0.3;
    car2->colores[0][1] = 0.8;
    car2->colores[0][2] = 0.4;
    car2->colores[0][3] = 1.0;
    car2->tx = 2;
    car2->tz = 3;

    // 2. a�dimos la primitiva.

    escena.AddCar(car1);
    escena.AddCar(car2);
    escena.AddObject(road); // objeto nuevo al final del vector de objetos
                            // la funcion de render ya se encaragara de recorrer este vector
                            // y llamara a la funcion para cada objeto que este en el vector.
    escena.AddObject(figura);
    escena.AddObject(arbol);
    escena.AddObject(semaforo);
    escena.AddObject(farola);
    escena.AddObject(banco);
    escena.AddObject(papelera);


 // 2.texturas: cargar los bytes de color a los vectores de texturas.
    cargarTexturas();
    /**** Regular GLUT main loop ****/
    glutMainLoop();

    return EXIT_SUCCESS;
}

