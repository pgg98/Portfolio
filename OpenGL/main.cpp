
/****************************************************************************************************

    CarGL (main.cpp)

    Grado en Ingeniería Multimedia.
    Práctica de Gráficos por Computador.
    OpenGL con Shaders.
  ------------------------------------------------------------------------------------------

    CarsGL (C) 2012-2016 - Juan Antonio Puchol García (puchol@dccia.ua.es)

    Changelog:

    Versión 1.0 (Noviembre 2012)
        - Versión inicial para Code::Blocks 10.05

    Versión 1.1 (Noviembre 2012)
        - Arreglado el bug de selección incorrecta debido al panel inferior de controles

    Versión 1.2 (Octubre 2013 )
        - Adaptación de la librería GLUI a Code::Blocks 12.11 y 13.12

    Versión 1.3 (Octubre 2014 )
        - Adaptación de la librería GLUI a Code::Blocks 13.12

    Versión 2.0 (Octubre 2015 )
        - Adaptación del código empleando Shaders (Modern OpenGL Graphics)

    Versión 2.1 (Septiembre 2016 )
        - Modificación de los scrollbars de las luces para manipular la posisión (compatible con Code::Blocks 16.01)

    NOTA:   Para que esta aplicación compile se necesita tener copiados los
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


            ACLARACIÓN:
                Hay varias librerías libglui32.a en la carpeta "otros"
                - Renombrar libglui32.10.05.a a libglui32.a para usar Code::Blocks 10.05
                - Renombrar libglui32.12.11.a a libglui32.a para usar Code::Blocks 12.11
                - Renombrar libglui32.13.12.a a libglui32.a para usar Code::Blocks 13.12 o superior

****************************************************************************************************/

#include "Objects.h"
#include <GL\glui.h>

#include <iostream>
using namespace std;

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

    switch (key)
    {
        case GLUT_KEY_UP:   // El coche avanza
            car->rr+=8;
            car->tz += 0.05;
            break;
        case GLUT_KEY_DOWN:   // El coche retrocede
            car->rr-=8;
            car->tz -= 0.05;
            break;
    }

    glutPostRedisplay();
}

/***************************************** myGlutMenu() ***********/

void Menu( int value )
{
  Keyboard( value, 0, 0 );
}

//GLUT_DOWN
//detectar cual es la operacion a realizar en funcion de la combinacion de teclas pulsadas y guardar en last_x y last_y
//la primera posicion del raton.

//GLUT_UP
//detectamos si se ha movido el raton y si no se ha movido el raton vamos a llamar a pick3D, es un click, para saber
//que objeto se ha seleccionado.
void Mouse(int button, int button_state, int x, int y ) //Hay que ampliar esto bastante.
{
    //TODO MODIFICAR
    int tecla;
    tecla = glutGetModifiers(); //obtengo el estado de las teclas especiales. ctrl shift alt
    if (button_state == GLUT_UP){ //si ha soltado el boton
        if(escena.movido == false){
            std::cout << "click para seleccionar" << std::endl;
            //escena.Pick3D(x, y);  TODO CUIDADO
        }
        else{
            escena.movido = false;
            escena.operacion = NINGUNA; //No OPERACION. todo desactivado.
            escena.last_x = 0;
            escena.last_y = 0;
            escena.activo_z = false;
        }
    }
    else{ //lo habre pulsado GLUT_DOWN
        escena.last_x = x;
        escena.last_y = y;
        if(tecla & GLUT_ACTIVE_CTRL){ //si he pulsado el ctlr, la operacion ya sobre el eje z.
            escena.activo_z = true;
        }
        if (button == GLUT_LEFT_BUTTON){
            if(tecla & GLUT_ACTIVE_SHIFT){
                escena.operacion = TRASLADAR; //traslacion.
                cout << "trasladar" << endl;
            }
            else{
                escena.operacion = ROTAR; //rotacion
                cout << "rotar" << endl;
            }
        }
        else{
            escena.operacion = ESCALAR; //escalado.
            cout << "escalar" << endl;
        }
    }
    gui.Mouse(button, button_state, x, y);
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

void Motion(int x, int y){ //Expandirla tambien

    escena.movido = true;
    int difx, dify;
    difx = x - escena.last_x;
    dify = y - escena.last_y;

    escena.last_x = x;     //el anterior pasa a ser el actual.
    escena.last_y = y;
    std::cout << x << ", " << y << endl;

    //hay que poner 3 variables que acumulen las rotaciones a los de los spiner
    if (escena.operacion == ROTAR){ //rotacion
        if (!escena.activo_z){
            escena.rot_x += dify /3.0; // es la velocidad.
            escena.rot_y += difx /3.0;
        }
        else{
            escena.rot_z += difx /3.0;
        }
    }

    //usado tambien las de view_position, aunque podriamos tambien
    if (escena.operacion == TRASLADAR){ //traslacion
        if(!escena.activo_z){
                //usamos el vector view_position ya definido para
                //ir acumulando la transformacion de traslacion
            escena.view_position[0] += difx /26.26;
            escena.view_position[1] += dify /26.26;
        }
        else{
            escena.view_position[2] += dify/26.26;
        }
    }
    if(escena.operacion == ESCALAR){ //escalado.
        if (!escena.activo_z){
                //modificarlo para que cambie la escala en funcion del eje.
            escena.scale += difx/40.0;
            escena.scale += dify/40.0;
        }
        else{
            escena.scale += difx /40.0;
        }
    }

    gui.Motion(x, y);
}

/**************************************** main() ********************/

int main(int argc, char* argv[])
{
    // Inicializa GLUT and crea la ventana principal
    glutInit(&argc, argv);
    glutInitDisplayMode( GLUT_RGBA | GLUT_DOUBLE | GLUT_DEPTH | GLUT_STENCIL | GLUT_MULTISAMPLE );
    glutInitWindowPosition( 50, 50 );
    glutInitWindowSize( 1400, 800 );

    int main_window = glutCreateWindow( "CarGL V2.0 (2015) con Shaders" );

    // Inicializa los valores de OpenGL para esta Aplicación
    escena.InitGL();
    gui.Init(main_window);

    glutDisplayFunc( Render );
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
    TPrimitiva *figura = new TPrimitiva(MI_FIGURITA, MI_FIGURITA); //solo voy a poner uno. Mi_figurita es lo que yo haya modelado con Blender.

    car2->colores[0][0] = 0.3;
    car2->colores[0][1] = 0.8;
    car2->colores[0][2] = 0.4;
    car2->colores[0][3] = 1.0;
    car2->tx = 2;
    car2->tz = 3;

    escena.AddObject(road); //objeto nuevo al final del vector de objetos
                            //la funcion de render ya se encargara de recorrer este vector
                            //y llamara a la funcion para cada objeto que este en el vector.
    escena.AddObject(figura);
    escena.AddCar(car1);
    escena.AddCar(car2);

    /**** Regular GLUT main loop ****/
    glutMainLoop();

    return EXIT_SUCCESS;
}

