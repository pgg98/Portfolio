
/***************************************************************************************

    CarGL (Objects.h)

    Grado en Ingeniería Multimedia.
    Práctica de Gráficos por Computador.
    OpenGL con Shaders.
  --------------------------------------------------------------------------------------

    Noviembre 2012 - Septiembre 2016 (C) Juan Antonio Puchol García (puchol@dccia.ua.es)

****************************************************************************************/

//---------------------------------------------------------------------------
#ifndef ObjectsH
#define ObjectsH
//---------------------------------------------------------------------------

#define GLEW_STATIC

#include "Shader.h"
#include "Program.h"

#include <GL/glui.h>
#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>

// Identificadores internos de los objetos
#define CARRETERA_ID    10


// 3. anyadimos los identificadores.
#define COCHE_ID	    100 // Un coche cada 100
#define TODO_ID         11
#define ARBOL_ID        12
#define SEMAFORO_ID        13
#define FAROLA_ID        14
#define BANCO_ID        15
#define PAPELERA_ID        16

// IDs para los callbacks de TGui
#define LIGHT0_ENABLED_ID    200
#define LIGHT1_ENABLED_ID    201
#define LIGHT2_ENABLED_ID    202

#define LIGHT0_POSITION_ID   210
#define LIGHT1_POSITION_ID   211
#define LIGHT2_POSITION_ID   212

#define LIGHT0_INTENSITY_ID  220
#define LIGHT1_INTENSITY_ID  221
#define LIGHT2_INTENSITY_ID  222

#define ENABLE_ID            300
#define DISABLE_ID           301

#define RESET_ID             400

#define SEL_ID               500

#define MI_ESCENA_ID    600

// Datos del formato 3DS (x, y, z, A, B, C, u, v)
#define POSITION_COMPONENT_COUNT    3
#define NORMAL_COMPONENT_COUNT      3
#define UV_COMPONENT_COUNT          2
// Cálculo del stride (3+3+2)*4 = 8*4 = 32
#define STRIDE                      32

// Nombre de los attributes
#define A_POSITION  "a_Position"
#define A_NORMAL    "a_Normal"

// Nombre de los uniforms
#define U_PROJECTIONMATRIX      "u_ProjectionMatrix"
#define U_MVMATRIX              "u_MVMatrix"
#define U_VMATRIX               "u_VMatrix"
#define U_COLOR                 "u_Color"


#define U_LUZ0                  "u_Luz0"
#define U_LUZ1                  "u_Luz1"
#define U_LUZ2                  "u_Luz2"

// para la seleccion.
#define U_SELECTION_ENABLED     "u_selection_enabled"


// para las texturas
#define A_TEXTURECORD "a_TextureCoord"  // constante con el nombre de la variable en el shader
#define U_SAMPLER "u_Sampler"


enum TOperacion{NINGUNA, ROTAR, TRASLADAR, ESCALAR};

//************************************************************** Clase TPrimtiva

class TPrimitiva
{
public: // Atributos de la clase
		int ID;				    // DisplayLists del objeto
		int tipo;               // Tipo de Objeto
		float tx,ty,tz; 	    // Posición del objeto
		float tdx, tdy, tdz;
		float tix, tiy, tiz;

		float sx,sy,sz; 	    // Escalado del objeto
		float rx,ry,rz;     	// Rotación del objeto

		float rr;               // Rotación de las ruedas

		// giro de las ruedas
		float rrz;      // la rotacion de las ruedas de delante (realmente rry)
		float rcar;     // la rotacion del coche en el ejey

        float velocidad;

		float colores[2][4];    // Color RGB y canal Alfa

		float   *modelo0;        // modelo a representar
		int     num_vertices0;   // número de vértices

        float   *modelo1;        // modelo a representar
		int     num_vertices1;   // número de vértices

		float   *modelo2;
		int     num_vertices2;

public: // Métodos
 		TPrimitiva(int DL, int tipo);
        void __fastcall Render(int seleccion, bool reflejo=false);
};

//************************************************************** Clase TEscena

class TEscena
{
public:
    // TEXTURAS.
    // 1. Texturas (ir a main)
        unsigned char *texturas[3]; // array de tres texturas.
        int texturas_width[3];  // array con las dimensiones de las texturas.
        int texturas_height[3]; // array con las dimensiones de las texturas.
        GLuint texturas_id[3];

public:

        // Atributos de la clase
		int   	seleccion;   	// Objeto seleccionado, 0=ninguno
        int		num_objects;    // Número de objetos (excepto coches)
        int     num_cars;       // Número de coches
        TPrimitiva  *cars[10];
        TPrimitiva  *objects[100];

        ///////////////////////////////////////////////////////////////
        // para el movimiento de la escena con el raton. //////////////
        bool    movido;
        int     last_x, last_y;     // para rotazion y escalado.
        TOperacion operacion;
        bool activo_z;
        GLfloat rot_x, rot_y, rot_z;
        ///////////////////////////////////////////////////////////////

        // Handles de los attributes y uniforms
        int aPositionLocation;
        int aNormalLocation;
        // PARA LAS TEXTURAS.
        int aTextureCoordLocation; /// atributo con la coordenada de textura para cada vertice.
		int u_SamplerLocation; /// la variable que usaremos para cargarle la textura.
		int activadaLocation; /// para saber si tenemos que aplicar textura en el fragment shader.

        int u_Position_Luz0Location;    // guardo el identificador de la variable que me permitira
                                        // modificar el valor de la variable del shader
        int u_Position_Luz1Location;
        int u_Position_Luz2Location;

        int u_Intensidad0Location;



        // ----------- para habilitar el shader en modo seleccion.
        int uSelectionEnabledLocation;
        // ----------- variable para la localizacion del shader.

        int uProjectionMatrixLocation;
        int uMVMatrixLocation;
		int uVMatrixLocation;
		int uColorLocation;

		int uLuz0Location;      // Activada la luz 0

		int uLuz1Location;      // Activada la luz 1
		int uLuz2Location;      // Activada la luz 2

		int proyeccion;         // Proyecceccion seleccionada.  // 0 perspectiva
                                                                // 1 paralela
        int camara;             // tipo de camara seleccionada. // 0 libre
                                                                // 1 aerea
                                                                // 2 tercera persona del sigular del verbo tener.



		glm::mat4 projectionMatrix; // Almacena la matriz de proyección
        glm::mat4 viewMatrix;       // Almacena la matriz de la vista (cámara)

		Program  *shaderProgram;    // Almacena el programa de OpenGL (ShaderProgram)

        // Vectores de luces y materiales
        GLfloat light0_ambient[4];
        GLfloat light0_diffuse[4];
        GLfloat light0_specular[4];
        GLfloat light0_position[4];

        GLfloat light1_ambient[4];
        GLfloat light1_diffuse[4];
        GLfloat light1_specular[4];
        GLfloat light1_position[4];

        GLfloat light2_ambient[4];
        GLfloat light2_diffuse[4];
        GLfloat light2_specular[4];
        GLfloat light2_position[4];

        GLfloat mat_ambient[4];
        GLfloat mat_diffuse[4];
        GLfloat mat_specular[4];
        GLfloat mat_shininess[1];

        float   xy_aspect;


        // live variables usadas por GLUI en TGui
        int     wireframe;
        int     z_buffer;
        int     culling;

        int     show_car;
        int     show_wheels;
        int     show_road;

        GLfloat view_position[3];
        GLfloat view_rotate[16];
        float   scale;

public: // Métodos
		TEscena();

        void __fastcall InitGL();
		void __fastcall Render();


		void __fastcall RenderSelection();


		void __fastcall RenderCars(bool reflejo=false);
		void __fastcall RenderObjects(bool reflejo=false);

		void __fastcall AddCar(TPrimitiva *car);
		void __fastcall AddObject(TPrimitiva *object);

		TPrimitiva __fastcall *GetCar(int id);

		void __fastcall Pick3D(int mouse_x, int mouse_y);


};

//************************************************************** Clase TGui

class TGui
{
public:
        int             window_id;

        // live variables usadas por GLUI
        int             sel;
        int             enable_panel2;
        int             light0_enabled;
        int             light1_enabled;
        int             light2_enabled;

        float           light0_intensity;
        float           light1_intensity;
        float           light2_intensity;

        float           light0_position[4];
        float           light1_position[4];
        float           light2_position[4];

        GLUI            *glui, *glui2;
        GLUI_Spinner    *light0_spinner;
        GLUI_Spinner    *light1_spinner;
        GLUI_Spinner    *light2_spinner;


        GLUI_RadioGroup *radio;
        GLUI_Panel      *obj_panel;
        GLUI_Rotation   *view_rot;

public:
        TGui();
        void __fastcall Init(int main_window);
        void __fastcall ControlCallback(int control);
        void __fastcall Idle( void );
        void __fastcall Reshape( int x, int y  );
        void __fastcall Motion( int x, int y  );
        void __fastcall Mouse(int button, int button_state, int x, int y );
};

//************************************************************** Variables de clase

extern TEscena  escena;
extern TGui     gui;

#endif
