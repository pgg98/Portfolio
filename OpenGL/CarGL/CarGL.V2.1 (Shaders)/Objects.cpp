
/****************************************************************************************

    CarGL (Objects.cpp)

    Grado en Ingenier�a Multimedia.
    Pr�ctica de Gr�ficos por Computador.
    OpenGL con Shaders.
  ---------------------------------------------------------------------------------------

    Noviembre 2012 - Septiembre 2016 (C) Juan Antonio Puchol Garc�a (puchol@dccia.ua.es)
    Noviembre 2012 - Septiembre 2016 (C) Juan Antonio Puchol Garc�a (puchol@dccia.ua.es)


*****************************************************************************************/

#include "Objects.h"
#include <GL/glui.h>

#include "load3ds.c"

// Variable para inicializar los vectores correpondientes con los valores iniciales
GLfloat light0_ambient_c[4]  = {   0.2f,   0.2f,  0.2f, 1.0f };
GLfloat light0_diffuse_c[4]  = {   0.8f,   0.8f,  0.8f, 1.0f };
GLfloat light0_specular_c[4] = {   1.0f,   1.0f,  1.0f, 1.0f };
GLfloat light0_position_c[4] = {-100.0f, 100.0f, 50.0f, 1.0f };

GLfloat light1_ambient_c[4]  = {   0.2f,   0.2f,  0.2f, 1.0f };
GLfloat light1_diffuse_c[4]  = {   0.8f,   0.8f,  0.8f, 1.0f };
GLfloat light1_specular_c[4] = {   1.0f,   1.0f,  1.0f, 1.0f };
GLfloat light1_position_c[4] = {   0.0f, 100.0f,  0.0f, 1.0f };

GLfloat mat_ambient_c[4]    = { 0.7f, 0.7f, 0.7f, 1.0f };
GLfloat mat_diffuse_c[4]    = { 0.8f, 0.8f, 0.8f, 1.0f };
GLfloat mat_specular_c[4]   = { 1.0f, 1.0f, 1.0f, 1.0f };
GLfloat mat_shininess_c[1] = { 100.0f };

// Matriz de 4x4 = (I)
float view_rotate_c[16] = { 1,0,0,0, 0,1,0,0, 0,0,1,0, 0,0,0,1 };
float view_position_c[3] = { 0.0, -2.0, -9.0 };

float coloresc_c[2][4] = { {0.8, 0.5, 0.0, 1.0}, {0.5, 0.5, 0.5, 1.0}}; // Color del coche
float coloresr_c[2][4] = { {0.3, 0.3, 0.3, 1.0}, {1.0, 1.0, 1.0, 1.0}}; // Color de la carretera

//************************************************************** Variables de clase

TEscena escena;
TGui    gui;

//************************************************************** Clase TPrimitiva

TPrimitiva::TPrimitiva(int DL, int t)
{

    ID   = DL;
    tipo = t;

    sx = sy = sz = 1;
    rx = ry = rz = 0;
	switch (tipo) {
		case COCHE_ID: { // Creaci�n del coche

        if(DL == 1){
		    tx = -2.0;
		    ty =  0.0;
		    tz =  0.0;
        }
        else{
            tx = 2;
            tz = 3;
            ty = 0;
        }
		    tdx = tx + 0.95;
		    tdy = ty + 0.45;
            tdz = tz - 1.65;

		    tix = tx - 0.95;
		    tiy = ty + 0.45;
		    tiz = tz - 1.65;

		    rr =  0.0;
		    rrz = 0.0;
		    rcar = 0.0;

		    memcpy(colores, coloresc_c, 8*sizeof(float));

            modelo0 = Load3DS("../../Modelos/coche.3ds", &num_vertices0);
            modelo1 = Load3DS("../../Modelos/rueda4.3ds", &num_vertices1);
            modelo2 = Load3DS("../../Modelos/flecha.3ds", &num_vertices2);

            break;
		}

        case CARRETERA_ID: {  // Creaci�n de la carretera
            tx = ty = tz = 0;

            memcpy(colores, coloresr_c, 8*sizeof(float));
            modelo0 = Load3DS("../../Modelos/carretera.3ds", &num_vertices0);
            modelo1 = Load3DS("../../Modelos/linea.3ds", &num_vertices1);

            break;
        }
        		case TODO_ID:{
            tx = ty = tz = 0;
		    memcpy(colores, coloresr_c, 8*sizeof(float));
            modelo0 = Load3DS("../../Modelos/todo.3ds", &num_vertices0);
            break;
        }
        case ARBOL_ID:{
            tx = ty = tz = 0;
		    memcpy(colores, coloresr_c, 8*sizeof(float));
            modelo0 = Load3DS("../../Modelos/arbol.3ds", &num_vertices0);
            break;
        }
        case SEMAFORO_ID:{
            tx = ty = tz = 0;
		    memcpy(colores, coloresr_c, 8*sizeof(float));
            modelo0 = Load3DS("../../Modelos/semaforo.3ds", &num_vertices0);
            break;
        }
        case FAROLA_ID:{
            tx = ty = tz = 0;
		    memcpy(colores, coloresr_c, 8*sizeof(float));
            modelo0 = Load3DS("../../Modelos/farola.3ds", &num_vertices0);
            break;
        }
        case BANCO_ID:{
            tx = ty = tz = 0;
		    memcpy(colores, coloresr_c, 8*sizeof(float));
            modelo0 = Load3DS("../../Modelos/banco.3ds", &num_vertices0);
            break;
        }
        case PAPELERA_ID:{
            tx = ty = tz = 0;
		    memcpy(colores, coloresr_c, 8*sizeof(float));
            modelo0 = Load3DS("../../Modelos/papelera.3ds", &num_vertices0);
            break;
        }
	}
}

void __fastcall TPrimitiva::Render(int seleccion, bool reflejo)
{
    glm::mat4   modelMatrix;
    glm::mat4   modelViewMatrix;
    switch (tipo) {

        case SEMAFORO_ID: {
           float ttx, tty, ttz;
               ttx = tx;
               tty = ty - 1;
               ttz = tz - 30;

                glUniform4fv(escena.uColorLocation, 1, (const GLfloat *) colores[0]);
                modelMatrix     = glm::mat4(1.0f); // matriz identidad
                modelMatrix     = glm::translate(modelMatrix, glm::vec3(ttx, tty, ttz));
                modelMatrix     = glm::scale(modelMatrix, glm::vec3(sx, sy, sz));
                modelViewMatrix = escena.viewMatrix * modelMatrix;
                glUniformMatrix4fv(escena.uMVMatrixLocation, 1, GL_FALSE, &modelViewMatrix[0][0]);

                glBindTexture(GL_TEXTURE_2D, escena.texturas_id[1]);
                glUniform1i(escena.activadaLocation, 1);
                glUniform1i(escena.u_SamplerLocation, 0);
                glActiveTexture(GL_TEXTURE0);


                glVertexAttribPointer(escena.aPositionLocation, POSITION_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0);
                glVertexAttribPointer(escena.aNormalLocation, NORMAL_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0+3);

                glVertexAttribPointer(escena.aTextureCoordLocation, UV_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0 + 6);

                glDrawArrays(GL_TRIANGLES, 0, num_vertices0);
                ttz = ttz + 7;
            break;
        }
        case CARRETERA_ID: {
           float ttx, tty, ttz;
               ttx = tx;
               tty = ty - 1;
               ttz = tz - 30;

                glUniform4fv(escena.uColorLocation, 1, (const GLfloat *) colores[0]);
                modelMatrix     = glm::mat4(1.0f); // matriz identidad
                modelMatrix     = glm::translate(modelMatrix, glm::vec3(ttx, tty, ttz));
                modelMatrix     = glm::scale(modelMatrix, glm::vec3(sx, sy, sz));
                modelViewMatrix = escena.viewMatrix * modelMatrix;
                glUniformMatrix4fv(escena.uMVMatrixLocation, 1, GL_FALSE, &modelViewMatrix[0][0]);

                glBindTexture(GL_TEXTURE_2D, escena.texturas_id[3]);
                glUniform1i(escena.activadaLocation, 1);
                glUniform1i(escena.u_SamplerLocation, 0);
                glActiveTexture(GL_TEXTURE0);

                glVertexAttribPointer(escena.aPositionLocation, POSITION_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0);
                glVertexAttribPointer(escena.aNormalLocation, NORMAL_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0+3);

                glVertexAttribPointer(escena.aTextureCoordLocation, UV_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0 + 6);

                glDrawArrays(GL_TRIANGLES, 0, num_vertices0);
                ttz = ttz + 7;
            break;
        }
        case TODO_ID: {
           float ttx, tty, ttz;
               ttx = tx;
               tty = ty - 1;
               ttz = tz - 30;

                glUniform4fv(escena.uColorLocation, 1, (const GLfloat *) colores[0]);
                modelMatrix     = glm::mat4(1.0f); // matriz identidad
                modelMatrix     = glm::translate(modelMatrix, glm::vec3(ttx, tty, ttz));
                modelMatrix     = glm::scale(modelMatrix, glm::vec3(sx, sy, sz));
                modelViewMatrix = escena.viewMatrix * modelMatrix;
                glUniformMatrix4fv(escena.uMVMatrixLocation, 1, GL_FALSE, &modelViewMatrix[0][0]);

                glBindTexture(GL_TEXTURE_2D, escena.texturas_id[1]);
                glUniform1i(escena.activadaLocation, 1);
                glUniform1i(escena.u_SamplerLocation, 0);
                glActiveTexture(GL_TEXTURE0);

                glVertexAttribPointer(escena.aPositionLocation, POSITION_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0);
                glVertexAttribPointer(escena.aNormalLocation, NORMAL_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0+3);

                glVertexAttribPointer(escena.aTextureCoordLocation, UV_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0 + 6);

                glDrawArrays(GL_TRIANGLES, 0, num_vertices0);
                ttz = ttz + 7;
            break;
        }
        case ARBOL_ID: {
           float ttx, tty, ttz;
               ttx = tx;
               tty = ty - 1;
               ttz = tz - 30;

                glUniform4fv(escena.uColorLocation, 1, (const GLfloat *) colores[0]);
                modelMatrix     = glm::mat4(1.0f); // matriz identidad
                modelMatrix     = glm::translate(modelMatrix, glm::vec3(ttx, tty, ttz));
                modelMatrix     = glm::scale(modelMatrix, glm::vec3(sx, sy, sz));
                modelViewMatrix = escena.viewMatrix * modelMatrix;
                glUniformMatrix4fv(escena.uMVMatrixLocation, 1, GL_FALSE, &modelViewMatrix[0][0]);

                glBindTexture(GL_TEXTURE_2D, escena.texturas_id[4]);
                glUniform1i(escena.activadaLocation, 1);
                glUniform1i(escena.u_SamplerLocation, 0);
                glActiveTexture(GL_TEXTURE0);

                glVertexAttribPointer(escena.aPositionLocation, POSITION_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0);
                glVertexAttribPointer(escena.aNormalLocation, NORMAL_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0+3);

                glVertexAttribPointer(escena.aTextureCoordLocation, UV_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0 + 6);

                glDrawArrays(GL_TRIANGLES, 0, num_vertices0);
                ttz = ttz + 7;
            break;
        }
        case FAROLA_ID: {
           float ttx, tty, ttz;
               ttx = tx;
               tty = ty - 1;
               ttz = tz - 30;

                glUniform4fv(escena.uColorLocation, 1, (const GLfloat *) colores[0]);
                modelMatrix     = glm::mat4(1.0f);
                modelMatrix     = glm::translate(modelMatrix, glm::vec3(ttx, tty, ttz));
                modelMatrix     = glm::scale(modelMatrix, glm::vec3(sx, sy, sz));
                modelViewMatrix = escena.viewMatrix * modelMatrix;
                glUniformMatrix4fv(escena.uMVMatrixLocation, 1, GL_FALSE, &modelViewMatrix[0][0]);

                glBindTexture(GL_TEXTURE_2D, escena.texturas_id[5]);
                glUniform1i(escena.activadaLocation, 1);
                glUniform1i(escena.u_SamplerLocation, 0);
                glActiveTexture(GL_TEXTURE0);

                glVertexAttribPointer(escena.aPositionLocation, POSITION_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0);
                glVertexAttribPointer(escena.aNormalLocation, NORMAL_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0+3);

                glVertexAttribPointer(escena.aTextureCoordLocation, UV_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0 + 6);

                glDrawArrays(GL_TRIANGLES, 0, num_vertices0);
                ttz = ttz + 7;
            break;
        }

        case BANCO_ID: {
           float ttx, tty, ttz;
               ttx = tx;
               tty = ty - 1;
               ttz = tz - 30;

                glUniform4fv(escena.uColorLocation, 1, (const GLfloat *) colores[0]);
                modelMatrix     = glm::mat4(1.0f);
                modelMatrix     = glm::translate(modelMatrix, glm::vec3(ttx, tty, ttz));
                modelMatrix     = glm::scale(modelMatrix, glm::vec3(sx, sy, sz));
                modelViewMatrix = escena.viewMatrix * modelMatrix;
                glUniformMatrix4fv(escena.uMVMatrixLocation, 1, GL_FALSE, &modelViewMatrix[0][0]);

                glBindTexture(GL_TEXTURE_2D, escena.texturas_id[6]);
                glUniform1i(escena.activadaLocation, 1);
                glUniform1i(escena.u_SamplerLocation, 0);
                glActiveTexture(GL_TEXTURE0);


                glVertexAttribPointer(escena.aPositionLocation, POSITION_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0);
                glVertexAttribPointer(escena.aNormalLocation, NORMAL_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0+3);

                glVertexAttribPointer(escena.aTextureCoordLocation, UV_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0 + 6);


                glDrawArrays(GL_TRIANGLES, 0, num_vertices0);
                ttz = ttz + 7;
            break;
        }
        case PAPELERA_ID: {
           float ttx, tty, ttz;
               ttx = tx;
               tty = ty - 1;
               ttz = tz - 30;

                glUniform4fv(escena.uColorLocation, 1, (const GLfloat *) colores[0]);
                modelMatrix     = glm::mat4(1.0f);
                modelMatrix     = glm::translate(modelMatrix, glm::vec3(ttx, tty, ttz));
                modelMatrix     = glm::scale(modelMatrix, glm::vec3(sx, sy, sz));
                modelViewMatrix = escena.viewMatrix * modelMatrix;
                glUniformMatrix4fv(escena.uMVMatrixLocation, 1, GL_FALSE, &modelViewMatrix[0][0]);

                glBindTexture(GL_TEXTURE_2D, escena.texturas_id[1]);
                glUniform1i(escena.activadaLocation, 1);
                glUniform1i(escena.u_SamplerLocation, 0);
                glActiveTexture(GL_TEXTURE0);

                glVertexAttribPointer(escena.aPositionLocation, POSITION_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0);
                glVertexAttribPointer(escena.aNormalLocation, NORMAL_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0+3);

                glVertexAttribPointer(escena.aTextureCoordLocation, UV_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0 + 6);

                glDrawArrays(GL_TRIANGLES, 0, num_vertices0);
                ttz = ttz + 7;
            break;
        }
        case COCHE_ID: {
            if (escena.show_car) {


                if(ID == escena.seleccion){
                    glUniform4fv(escena.uColorLocation, 1, (const GLfloat *) colores[0]);
                    glVertexAttribPointer(escena.aPositionLocation, POSITION_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo2);
                    glVertexAttribPointer(escena.aNormalLocation, NORMAL_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo2 + 3);
                    glVertexAttribPointer(escena.aTextureCoordLocation, UV_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo2 + 6);

                    modelMatrix     = glm::mat4(1.0f);
                    modelMatrix     = glm::translate(modelMatrix, glm::vec3(tx, ty+ 2.5, tz-1.5));
                    modelMatrix     = glm::rotate(modelMatrix, (float) glm::radians(rcar), glm::vec3(0,1,0)); //esto se necesita para girar
                    modelMatrix     = glm::scale(modelMatrix, glm::vec3(0.1, 0.1, 0.1));
                    modelViewMatrix = escena.viewMatrix * modelMatrix;

                    glUniform1i(escena.activadaLocation, 0);
                    glUniformMatrix4fv(escena.uMVMatrixLocation, 1, GL_FALSE, &modelViewMatrix[0][0]);
                    glDrawArrays(GL_TRIANGLES, 0, num_vertices2);
                }
                glUniform1i(escena.activadaLocation, 0);
                glUniform4fv(escena.uColorLocation, 1, (const GLfloat *) colores[0]);
                glVertexAttribPointer(escena.aPositionLocation, POSITION_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0);
                glVertexAttribPointer(escena.aNormalLocation, NORMAL_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0+3);
                glVertexAttribPointer(escena.aTextureCoordLocation, UV_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0 + 6);

                modelMatrix     = glm::mat4(1.0f); // matriz identidad
                modelMatrix     = glm::translate(modelMatrix,glm::vec3(tx, ty, tz));
                modelMatrix     = glm::rotate(modelMatrix, (float) glm::radians(-rcar), glm::vec3(0,1,0)); // para el giro
                modelViewMatrix = escena.viewMatrix * modelMatrix;

                glUniformMatrix4fv(escena.uMVMatrixLocation, 1, GL_FALSE, &modelViewMatrix[0][0]);
                glDrawArrays(GL_TRIANGLES, 0, num_vertices0);
            }


            if (escena.show_wheels)
            {
               glUniform1i(escena.activadaLocation, 0);
                glUniform4fv(escena.uColorLocation, 1, (const GLfloat *) colores[1]);

                glVertexAttribPointer(escena.aPositionLocation, POSITION_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo1);
                glVertexAttribPointer(escena.aNormalLocation, NORMAL_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo1+3);
                glVertexAttribPointer(escena.aTextureCoordLocation, UV_COMPONENT_COUNT, GL_FLOAT, false, STRIDE, modelo0 + 6);
                //*********************************************************************************************************
                // RUEDA DELANTERA IZQUIERDA
                modelMatrix     = glm::mat4(1.0f); // matriz identidad



                modelMatrix     = glm::translate(modelMatrix, glm::vec3(tx-0.10, ty-0.20, tz-0.835));
                modelMatrix     = glm::rotate(modelMatrix, (float) glm::radians(-rcar), glm::vec3(0,1,0));
                modelMatrix     = glm::translate(modelMatrix, glm::vec3(0.95, 0.45, 1.65));
                modelMatrix     = glm::rotate(modelMatrix, (float) glm::radians(180.0), glm::vec3(0,0,1));
                modelMatrix     = glm::rotate(modelMatrix, (float) glm::radians(rrz), glm::vec3(0,1,0));
                modelMatrix     = glm::rotate(modelMatrix, (float) glm::radians(rr), glm::vec3(1,0,0));

                modelViewMatrix = escena.viewMatrix * modelMatrix;

                // Envia al Vertex Shader
                glUniformMatrix4fv(escena.uMVMatrixLocation, 1, GL_FALSE, &modelViewMatrix[0][0]);

                glDrawArrays(GL_TRIANGLES, 0, num_vertices1);
                //********************************************************************************************************************
                // RUEDA DELANTERA DERECHA
                modelMatrix     = glm::mat4(1.0f);


                modelMatrix     = glm::translate(modelMatrix, glm::vec3(tx+0.1, ty-0.20, tz-0.835));
                modelMatrix     = glm::rotate(modelMatrix, (float) glm::radians(-rcar), glm::vec3(0,1,0));
                modelMatrix     = glm::translate(modelMatrix, glm::vec3(-0.95, 0.45, 1.65));
                modelMatrix     = glm::rotate(modelMatrix, (float) glm::radians(180.0), glm::vec3(1,0,0));
                modelMatrix     = glm::rotate(modelMatrix, (float) glm::radians(rrz), glm::vec3(0,1,0));


                modelViewMatrix = escena.viewMatrix * modelMatrix;

                glUniformMatrix4fv(escena.uMVMatrixLocation, 1, GL_FALSE, &modelViewMatrix[0][0]);
                glDrawArrays(GL_TRIANGLES, 0, num_vertices1);
                //**********************************************************************************************************************
                // RUEDA TRASERA IZQUIERDA : C�lculo de la matriz modelo
                modelMatrix     = glm::mat4(1.0f);


                modelMatrix     = glm::translate(modelMatrix, glm::vec3(tx-0.1, ty-0.2, tz+0.7));
                modelMatrix     = glm::rotate(modelMatrix, (float) glm::radians(-rcar), glm::vec3(0,1,0));
                modelMatrix     = glm::translate(modelMatrix, glm::vec3(0.95, 0.45, -1.65));
                modelMatrix     = glm::rotate(modelMatrix, (float) glm::radians(180.0), glm::vec3(0,0,1));


                modelViewMatrix = escena.viewMatrix * modelMatrix;

                glUniformMatrix4fv(escena.uMVMatrixLocation, 1, GL_FALSE, &modelViewMatrix[0][0]);

                glDrawArrays(GL_TRIANGLES, 0, num_vertices1);
                //*************************************************************************************************************************
                // RUEDA TRASERA DERECHA.

                modelMatrix     = glm::mat4(1.0f);

                modelMatrix     = glm::translate(modelMatrix, glm::vec3(tx+0.1, ty-0.2, tz+0.7));
                modelMatrix     = glm::rotate(modelMatrix, (float) glm::radians(-rcar), glm::vec3(0,1,0));
                modelMatrix     = glm::translate(modelMatrix, glm::vec3(-0.95, 0.45, -1.65));


                modelViewMatrix = escena.viewMatrix * modelMatrix;

                glUniformMatrix4fv(escena.uMVMatrixLocation, 1, GL_FALSE, &modelViewMatrix[0][0]);

                glDrawArrays(GL_TRIANGLES, 0, num_vertices1);
                break;

            }
        }
    }

}

//************************************************************** Clase TEscena


TEscena::TEscena() {

    seleccion = 1;
    num_objects = 0;
    num_cars = 0;

    show_car = 1;
    show_wheels = 1;
    show_road = 1;

    // live variables usadas por GLUI en TGui
    wireframe = 0;
    z_buffer = 1;
    culling = 0;

    scale = 1.0;
    xy_aspect = 1;
    last_x = 0;
    last_y = 0;

    memcpy(view_position, view_position_c, 3*sizeof(float));
    memcpy(view_rotate, view_rotate_c, 16*sizeof(float));

    memcpy(light0_ambient, light0_ambient_c, 4*sizeof(float));

    memcpy(light0_ambient, light0_ambient_c, 4*sizeof(float));
    memcpy(light0_diffuse, light0_diffuse_c, 4*sizeof(float));
    memcpy(light0_specular, light0_specular_c, 4*sizeof(float));
    memcpy(light0_position, light0_position_c, 4*sizeof(float));

    memcpy(light1_ambient, light1_ambient_c, 4*sizeof(float));
    memcpy(light1_diffuse, light1_diffuse_c, 4*sizeof(float));
    memcpy(light1_specular, light1_specular_c, 4*sizeof(float));
    memcpy(light1_position, light1_position_c, 4*sizeof(float));

    memcpy(mat_ambient, mat_ambient_c, 4*sizeof(float));
    memcpy(mat_diffuse, mat_diffuse_c, 4*sizeof(float));
    memcpy(mat_specular, mat_specular_c, 4*sizeof(float));
    memcpy(mat_shininess, mat_shininess_c, 1*sizeof(float));
}

void __fastcall TEscena::InitGL()
{
    int tx, ty, tw, th;

    // Habilita el z_buffer
    glEnable(GL_DEPTH_TEST);
    glDepthFunc(GL_LESS);

    // Inicializaci�n de GLEW
    std::cout << "Inicializando GLEW" << std::endl << std::endl;
    if(glewInit() != GLEW_OK)
        throw std::runtime_error("glewInit failed");

    // print out some info about the graphics drivers
    std::cout << "OpenGL version: " << glGetString(GL_VERSION) << std::endl;
    std::cout << "GLSL version: " << glGetString(GL_SHADING_LANGUAGE_VERSION) << std::endl;
    std::cout << "Vendedor: " << glGetString(GL_VENDOR) << std::endl;
    std::cout << "Renderer: " << glGetString(GL_RENDERER) << std::endl;

    // Carga de los Shaders
    std::cout << std::endl << "Cargando Shaders" << std::endl;

    Shader shader;

    std::vector<GLuint> shaders;
    shaders.push_back(shader.LoadShader("../../Shaders/VertexShader.glsl", GL_VERTEX_SHADER));
    //std::cout << "Vertex Shader: " << shader.ReturnShaderID() << std::endl;
    shaders.push_back(shader.LoadShader("../../Shaders/FragmentShader.glsl", GL_FRAGMENT_SHADER));
    //std::cout << "Fragment Shader: " << shader.ReturnShaderID() << std::endl;
    shaderProgram = new Program(shaders);

    //std::cout << "Shader Program: " << shaderProgram->ReturnProgramID() << std::endl;

    glUseProgram(shaderProgram->ReturnProgramID());
    //glValidateProgram(shaderProgram->ReturnProgramID());

    aPositionLocation=shaderProgram->attrib(A_POSITION);
    aNormalLocation=shaderProgram->attrib(A_NORMAL);

    // PARA LAS TEXTURAS--------------------------------------
    aTextureCoordLocation = shaderProgram->attrib(A_TEXTURECORD);
    u_SamplerLocation = shaderProgram->uniform(U_SAMPLER);
    activadaLocation = shaderProgram->uniform("activada");

    uProjectionMatrixLocation = shaderProgram->uniform(U_PROJECTIONMATRIX);
    uMVMatrixLocation = shaderProgram->uniform(U_MVMATRIX);
    uVMatrixLocation = shaderProgram->uniform(U_VMATRIX);
    uColorLocation = shaderProgram->uniform(U_COLOR);

    uLuz0Location = shaderProgram->uniform(U_LUZ0);
    uLuz1Location = shaderProgram->uniform(U_LUZ1);
    uLuz2Location = shaderProgram->uniform(U_LUZ2);


    u_Intensidad0Location = shaderProgram->uniform("u_Intensidad0");

    ///
    u_Position_Luz0Location = shaderProgram->uniform("u_Position_Luz0");
    u_Position_Luz1Location = shaderProgram->uniform("u_Position_Luz1");
    u_Position_Luz2Location = shaderProgram->uniform("u_Position_Luz2");
    ///



    // guardamos el localizador de la variable del shader en uSelectionEnabledLocation para poder luego modificar
    // su valor desde el codigo.
    uSelectionEnabledLocation = shaderProgram->uniform(U_SELECTION_ENABLED);


    // Habilitamos el paso de attributes
    glEnableVertexAttribArray(aPositionLocation);
    glEnableVertexAttribArray(aNormalLocation);

    // PARA LAS TEXTURAS.---------------------------------------
    glEnableVertexAttribArray(aTextureCoordLocation);



    // Estableciendo la matriz de proyecci�n perspectiva
    GLUI_Master.get_viewport_area( &tx, &ty, &tw, &th );
    xy_aspect = (float)tw / (float)th;
    projectionMatrix = glm::perspective(45.0f, xy_aspect, 0.1f, 1000.0f);
    glUniformMatrix4fv(uProjectionMatrixLocation, 1, GL_FALSE, glm::value_ptr(projectionMatrix));
}


void cambiarProyeccion(){
    int tx, ty, tw, th;
    GLUI_Master.get_viewport_area( &tx, &ty, &tw, &th );
    glViewport( tx, ty, tw, th );

    escena.xy_aspect = (float)tw / (float)th;
    if(escena.proyeccion == 0){
        escena.projectionMatrix = glm::perspective(45.0f, escena.xy_aspect, 0.1f, 1000.0f);
    }
    else{
        escena.projectionMatrix = glm::ortho(-10.0f*escena.xy_aspect, 10.0f*escena.xy_aspect, -10.0f, 10.0f, -100.0f, 100.0f);
    }
    glUniformMatrix4fv(escena.uProjectionMatrixLocation, 1, GL_FALSE, glm::value_ptr(escena.projectionMatrix));
}




/************************** TEscena::AddCar(TPrimitiva *car) *****************/

void __fastcall TEscena::AddCar(TPrimitiva *car)
{
    cars[num_cars] = car;
    num_cars++;
}

/******************** TEscena::AddObject(TPrimitiva *object) *****************/

void __fastcall TEscena::AddObject(TPrimitiva *object)
{
    objects[num_objects] = object;
    num_objects++;
}

/******************** TPrimitiva *TEscena::GetCar(int id) ********************/

TPrimitiva __fastcall *TEscena::GetCar(int id)
{
    TPrimitiva *p=NULL;

    for (int i=0; i<num_cars; i++)
    {
        if (cars[i]->ID==id)
        {
            p = cars[i];
        }

    }
    return(p);
}

/******************** TEscena::RenderCars() **********************************/

void __fastcall TEscena::RenderCars(bool reflejo) {

    for (int i=0; i<num_cars; i++)
    {
        cars[i]->Render(seleccion, reflejo);
    }
}

/******************** TEscena::RenderCars() **********************************/

void __fastcall TEscena::RenderObjects(bool reflejo) {

    for (int i=0; i<num_objects; i++)
    {
        objects[i]->Render(seleccion, reflejo);
    }
}

/***************************************** TEscena::Render() *****************/

void __fastcall TEscena::Render()
{
    glm::mat4 rotateMatrix;
    glClearColor(0.0, 0.7, 0.9, 1.0);
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    //glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);

    switch(escena.wireframe){
        case 0:
            glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
            break;
        case 1:
            glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
            break;
        case 2:
            glPolygonMode(GL_FRONT_AND_BACK, GL_POINT);
            break;
   }
    // activa
    if(escena.z_buffer == 1){
        glEnable(GL_DEPTH_TEST);
    }
    else{
        glDisable(GL_DEPTH_TEST);
    }
    ////*****
    if(escena.culling == 1){
        glEnable(GL_CULL_FACE);
    }
    else{
        glDisable(GL_CULL_FACE);
    }

    cambiarProyeccion(); // donde querais a lo largo de esta maravillosa funcion.
    if(escena.camara == 0){
        // C�lculo de la vista (c�mara)
        viewMatrix      = glm::mat4(1.0f);
        rotateMatrix    = glm::make_mat4(view_rotate);
        viewMatrix      = glm::translate(viewMatrix,glm::vec3(view_position[0], view_position[1], view_position[2]));
        viewMatrix      = viewMatrix*rotateMatrix;
            //// para rotar me he 3 variables donde voy almacenando lo que le pasa a la escena.
        viewMatrix     = glm::rotate(viewMatrix, (float) glm::radians(escena.rot_x), glm::vec3(1,0,0));
        viewMatrix     = glm::rotate(viewMatrix, (float) glm::radians(escena.rot_y), glm::vec3(0,1,0));
        viewMatrix     = glm::rotate(viewMatrix, (float) glm::radians(escena.rot_z), glm::vec3(0,0,1));
        ////
        viewMatrix      = glm::scale(viewMatrix,glm::vec3(scale, scale, scale));
    }
    else{
        float tx, ty, tz;
        tx = cars[seleccion-1]->tx;
        ty = cars[seleccion-1]->ty;
        tz = cars[seleccion-1]->tz;
        // camera is at (4,3,3), in World Space
        // and looks at the origin
        // Head is up (set to 0,-1,0 to look upside-down)
        if(escena.camara == 1){
            viewMatrix = glm::lookAt(glm::vec3(tx, 20, tz), glm::vec3(tx, 0, tz), glm::vec3(1, 0, 0));
        }
        else{
            std::cout << seleccion << std::endl;
            if(seleccion != 0){
                std::cout << tx << "," << ty << "," << tz << std::endl;
                viewMatrix = glm::lookAt(glm::vec3(tx, ty+5, tz-10), glm::vec3(tx, ty,tz), glm::vec3(0, 1, 0));
            }
        }
    }

    glUniform1i(uLuz0Location, gui.light0_enabled);
    glUniform1i(uLuz1Location, gui.light1_enabled);
    glUniform1i(uLuz2Location, gui.light2_enabled);

    float intensidad = gui.light0_intensity;
    glUniform1f(u_Intensidad0Location, intensidad);

    glUniformMatrix4fv(uVMatrixLocation, 1, GL_FALSE, glm::value_ptr(viewMatrix)); // Para la luz matrix view pero sin escalado!

    // desactivamos el modo seleccion.
    glUniform1i(uSelectionEnabledLocation, 0);



    // posicion de la luz, antes de renderizar copiamos en la variable del shader
    // el valor del vector que recoge la posicion de la luz.
    glUniform4fv(escena.u_Position_Luz0Location, 1, (const GLfloat *) &escena.light0_position);
    glUniform4fv(escena.u_Position_Luz1Location, 1, (const GLfloat *) &escena.light1_position);
    glUniform4fv(escena.u_Position_Luz2Location, 1, (const GLfloat *) &escena.light2_position);

    // a�adir dos vectores v mas, para cada intensidad de luz.


    // modificarlo tambien en el callback y en la creacion del panel.




    // Dibujar carretera y objetos
    RenderObjects(seleccion);

    // Dibujar coches
    RenderCars(seleccion);

    glutSwapBuffers();
}

void __fastcall TEscena::RenderSelection()
{
    glm::mat4 rotateMatrix;

    glClearColor(0.0, 0.7, 0.9, 1.0);
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
    glEnable(GL_DEPTH_TEST);
    glEnable(GL_CULL_FACE);
    if(escena.camara == 0){
        // C�lculo de la vista (c�mara)
        viewMatrix      = glm::mat4(1.0f);
        rotateMatrix    = glm::make_mat4(view_rotate);
        viewMatrix      = glm::translate(viewMatrix,glm::vec3(view_position[0], view_position[1], view_position[2]));
        viewMatrix      = viewMatrix*rotateMatrix;
        //// para rotar me he 3 variables donde voy almacenando lo que le pasa a la escena.
        viewMatrix     = glm::rotate(viewMatrix, (float) glm::radians(escena.rot_x), glm::vec3(1,0,0));
        viewMatrix     = glm::rotate(viewMatrix, (float) glm::radians(escena.rot_y), glm::vec3(0,1,0));
        viewMatrix     = glm::rotate(viewMatrix, (float) glm::radians(escena.rot_z), glm::vec3(0,0,1));
        ////
        viewMatrix      = glm::scale(viewMatrix,glm::vec3(scale, scale, scale));
    }
    else{
        float tx, ty, tz;
        tx = cars[seleccion-1]->tx;
        ty = cars[seleccion-1]->ty;
        tz = cars[seleccion-1]->tz;
        // camera is at (4,3,3), in World Space and looks at the origin Head is up (set to 0,-1,0 to look upside-down)
        if(escena.camara == 1){
            viewMatrix = glm::lookAt(glm::vec3(tx, 20, tz), glm::vec3(tx, 0, tz), glm::vec3(1, 0, 0));
        }
        else{
            std::cout << seleccion << std::endl;
            if(seleccion != 0){
                std::cout << tx << "," << ty << "," << tz << std::endl;
                viewMatrix = glm::lookAt(glm::vec3(tx, ty+5, tz-10), glm::vec3(tx, ty,tz), glm::vec3(0, 1, 0));
            }
        }


    }

    // modo seleccion al shader
    glUniform1i(uSelectionEnabledLocation, 1);
    // modo sin texturas al fragment
    glUniform1i(escena.activadaLocation, 0);
    // Dibujar carretera y objetos
    RenderObjects(seleccion);
    // Dibujar coches
    RenderCars(seleccion);

    // quitar pavo
    //glutSwapBuffers();
}


// Selecciona un objeto a trav�s del rat�n
void __fastcall TEscena::Pick3D(int mouse_x, int mouse_y)
{
    unsigned char res[4];
    GLint viewport[4];

    RenderSelection(); // dibujamos la escena con colores planos, sin texturas, cada objeto solo tiene un color, distinto del de los demas.
    glGetIntegerv(GL_VIEWPORT, viewport);
    glReadPixels(mouse_x, viewport[3] + viewport[1] - mouse_y, 1, 1, GL_RGBA, GL_UNSIGNED_BYTE, &res);

    std::cout << "color en el pixel seleccionado: " << (int)(res[0]) << std::endl;
    if(res[0] == 204){
        std::cout << "coche seleccionado 0" << std::endl;
          seleccion = 1;
    }
    else{
        if(res[0] == 76){
            std::cout << "coche seleccionado 1" << std::endl;
            seleccion = 2;
        }
        else{
            std::cout << "ningun coche seleccionado" << std::endl;
            seleccion = 0;
        }
    }
    std::cout << mouse_x << " " << mouse_y << std::endl;
    std::cout << (int)res[0] << " " << (int)res[1] << " " << (int)res[2] << std::endl;
}

//************************************************************** Clase TGui

TGui::TGui()
{
    sel = 1;
    enable_panel2 = 1;
    light0_enabled = 1;
    light1_enabled = 1;
    light0_intensity = 0.8;
    light1_intensity = 0.8;
    memcpy(light0_position, light0_position_c, 4*sizeof(float));
    memcpy(light1_position, light1_position_c, 4*sizeof(float));
}

void controlCallback(int control)
{
    gui.ControlCallback(control);
}

void __fastcall TGui::Init(int main_window) {
    printf( "GLUI version: %3.2f\n", GLUI_Master.get_version() );
    window_id = main_window;

    /*** Crea a ventana lateral ***/
    glui = GLUI_Master.create_glui_subwindow( window_id, GLUI_SUBWINDOW_RIGHT );

    obj_panel = new GLUI_Rollout(glui, "Propiedades", true );

    GLUI_Panel *panel_seleccion = new GLUI_Panel(obj_panel, "Coche selec.");
    GLUI_RadioGroup *radioGroup = new GLUI_RadioGroup(panel_seleccion, &sel, SEL_ID, controlCallback);
    glui->add_radiobutton_to_group(radioGroup, "NINGUNO");
    glui->add_radiobutton_to_group(radioGroup, "COCHE 1");
    glui->add_radiobutton_to_group(radioGroup, "COCHE 2");

    GLUI_Panel *panelProyeccion = new GLUI_Panel(obj_panel, "Proyecci�n");
    GLUI_RadioGroup *radioGroupProyeccion = new GLUI_RadioGroup(panelProyeccion, &escena.proyeccion, 1, controlCallback);
    glui->add_radiobutton_to_group(radioGroupProyeccion, "Perspectiva");
    glui->add_radiobutton_to_group(radioGroupProyeccion, "Paralela");

    GLUI_Panel *panelCamara = new GLUI_Panel(obj_panel, "C�MARA");
    GLUI_RadioGroup *radioGroupCamara = new GLUI_RadioGroup(panelCamara, &escena.camara, 1, controlCallback);
    glui->add_radiobutton_to_group(radioGroupCamara, "Libre (por defecto)");
    glui->add_radiobutton_to_group(radioGroupCamara, "A�rea");
    glui->add_radiobutton_to_group(radioGroupCamara, "3� persona");

    /***** Control para las propiedades de escena *****/
    GLUI_Panel *panelModo = new GLUI_Panel(obj_panel, "Modo visualizaci�n");
    GLUI_RadioGroup *radioGroupModo = new GLUI_RadioGroup(panelModo, &escena.wireframe, 1, controlCallback); // 1 => opcion por defecto
    glui->add_radiobutton_to_group(radioGroupModo, "Relleno");
    glui->add_radiobutton_to_group(radioGroupModo, "Al�mbrico");
    glui->add_radiobutton_to_group(radioGroupModo, "Puntos");

    /***** Control para las propiedades de escena *****/
    GLUI_Panel *panelOtras = new GLUI_Panel(obj_panel, "Otras opciones");
    new GLUI_Checkbox( panelOtras , "Culling", &escena.culling, 1, controlCallback );
    glui->add_column_to_panel(panelOtras , true);
    new GLUI_Checkbox( panelOtras , "Z Buffer", &escena.z_buffer, 1, controlCallback );

    // A�ade una separaci�n
    new GLUI_StaticText( glui, "" );
     /***  Rollout de Opciones ***/
    GLUI_Rollout *options = new GLUI_Rollout(glui, "Opciones", true );
    new GLUI_Checkbox( options, "Dibujar Ruedas", &escena.show_wheels );
    new GLUI_Checkbox( options, "Dibujar Coche", &escena.show_car );
    new GLUI_Checkbox( options, "Dibujar Carretera", &escena.show_road );

    /******** A�ade controles para las luces ********/

    // A�ade una separaci�n
    new GLUI_StaticText( glui, "" );
    GLUI_Rollout *roll_lights = new GLUI_Rollout(glui, "Luces", false );
    GLUI_Panel *light0 = new GLUI_Panel( roll_lights, "Luz 1" );
    GLUI_Panel *light1 = new GLUI_Panel( roll_lights, "Luz 2" );


    GLUI_Panel *light2 = new GLUI_Panel( roll_lights, "Luz 3" ); //***new!! puchi!!



    new GLUI_Checkbox( light0, "Encendida", &light0_enabled, LIGHT0_ENABLED_ID, controlCallback );
    light0_spinner = new GLUI_Spinner( light0, "Intensidad:", &light0_intensity,
                            LIGHT0_INTENSITY_ID, controlCallback );
    light0_spinner->set_float_limits( 0.0, 1.0 );
    GLUI_Scrollbar *sb;
    sb = new GLUI_Scrollbar( light0, "X",GLUI_SCROLL_HORIZONTAL,
                            &escena.light0_position[0],LIGHT0_POSITION_ID,controlCallback);
    sb->set_float_limits(-100,100);
    sb = new GLUI_Scrollbar( light0, "Y",GLUI_SCROLL_HORIZONTAL,
                            &escena.light0_position[1],LIGHT0_POSITION_ID,controlCallback);
    sb->set_float_limits(-100,100);
    sb = new GLUI_Scrollbar( light0, "Z",GLUI_SCROLL_HORIZONTAL,
                            &escena.light0_position[2],LIGHT0_POSITION_ID,controlCallback);
    sb->set_float_limits(-100,100);

    new GLUI_Checkbox( light1, "Encendida", &light1_enabled, LIGHT1_ENABLED_ID, controlCallback );
    light1_spinner = new GLUI_Spinner( light1, "Intensidad:", &light1_intensity,
                            LIGHT1_INTENSITY_ID, controlCallback );
    light1_spinner->set_float_limits( 0.0, 1.0 );
    sb = new GLUI_Scrollbar( light1, "X",GLUI_SCROLL_HORIZONTAL,
                            &escena.light1_position[0],LIGHT1_POSITION_ID,controlCallback);
    sb->set_float_limits(-100,100);
    sb = new GLUI_Scrollbar( light1, "Y",GLUI_SCROLL_HORIZONTAL,
                            &escena.light1_position[1],LIGHT1_POSITION_ID,controlCallback);
    sb->set_float_limits(-100,100);
    sb = new GLUI_Scrollbar( light1, "Z",GLUI_SCROLL_HORIZONTAL,
                            &escena.light1_position[2],LIGHT1_POSITION_ID,controlCallback);
    sb->set_float_limits(-100,100);


    new GLUI_Checkbox( light2, "Encendida", &light2_enabled, LIGHT2_ENABLED_ID, controlCallback );
    light2_spinner = new GLUI_Spinner( light2, "Intensidad:", &light2_intensity,
                            LIGHT2_INTENSITY_ID, controlCallback );
    light2_spinner->set_float_limits( 0.0, 1.0 );
    sb = new GLUI_Scrollbar( light2, "X",GLUI_SCROLL_HORIZONTAL,
                            &escena.light2_position[0],LIGHT2_POSITION_ID,controlCallback);
    sb->set_float_limits(-100,100);
    sb = new GLUI_Scrollbar( light2, "Y",GLUI_SCROLL_HORIZONTAL,
                            &escena.light2_position[1],LIGHT2_POSITION_ID,controlCallback);
    sb->set_float_limits(-100,100);
    sb = new GLUI_Scrollbar( light2, "Z",GLUI_SCROLL_HORIZONTAL,
                            &escena.light2_position[2],LIGHT2_POSITION_ID,controlCallback);
    sb->set_float_limits(-100,100);



    // A�ade una separaci�n
    new GLUI_StaticText( glui, "" );

    /*** Disable/Enable botones ***/
    // A�ade una separaci�n
    new GLUI_StaticText( glui, "" );
    new GLUI_Checkbox( glui, "Bloquear Movimiento", &enable_panel2 );
    // A�ade una separaci�n
    new GLUI_StaticText( glui, "" );
    new GLUI_Button( glui, "Resetear Posicion", RESET_ID, controlCallback );

    // A�ade una separaci�n
    new GLUI_StaticText( glui, "" );

    new GLUI_Separator( glui );

     // A�ade una separaci�n
    new GLUI_StaticText( glui, "" );

    new GLUI_StaticText( glui, "  Autor:" );
    new GLUI_StaticText( glui, "  2012-2016 (C) Juan Antonio Puchol  " );

    // A�ade una separaci�n
    new GLUI_StaticText( glui, "" );

    new GLUI_Separator( glui );

    // A�ade una separaci�n
    new GLUI_StaticText( glui, "" );

    /****** A 'quit' button *****/
    new GLUI_Button( glui, "Salir", 0,(GLUI_Update_CB)exit );

    // Crea la subventana inferior
    glui2 = GLUI_Master.create_glui_subwindow( window_id, GLUI_SUBWINDOW_BOTTOM );

    /**** Link windows to GLUI, and register idle callback ******/
    glui->set_main_gfx_window( window_id );
    glui2->set_main_gfx_window( window_id );

    view_rot = new GLUI_Rotation(glui2, "Rotacion Escena", escena.view_rotate );
    view_rot->set_spin( 1.0 );
    new GLUI_Column( glui2, false );
    GLUI_Translation *trans_xy = new GLUI_Translation(glui2, "Traslacion Escena XY", GLUI_TRANSLATION_XY, escena.view_position );
    trans_xy->set_speed( .005 );
    new GLUI_Column( glui2, false );
    GLUI_Translation *trans_x =  new GLUI_Translation(glui2, "Traslacion Escena X", GLUI_TRANSLATION_X, escena.view_position );
    trans_x->set_speed( .005 );
    new GLUI_Column( glui2, false );
    GLUI_Translation *trans_y = new GLUI_Translation( glui2, "Traslacion Escena Y", GLUI_TRANSLATION_Y, &escena.view_position[1] );
    trans_y->set_speed( .005 );
    new GLUI_Column( glui2, false );
    GLUI_Translation *trans_z = new GLUI_Translation( glui2, "Traslacion Escena Z", GLUI_TRANSLATION_Z, &escena.scale );
    trans_z->set_speed( .005 );

}

/**************************************** TGui::ControlCallback() *******************/

void __fastcall TGui::ControlCallback( int control )
{
    switch (control) {
        case LIGHT0_POSITION_ID:{
           // glUniform4fv(escena.u_Position_Luz0Location, 1, (const GLfloat *) &escena.light0_position);
            break;
        }

        case LIGHT0_ENABLED_ID: {
            if ( light0_enabled )
                light0_spinner->enable();
            else
                light0_spinner->disable();
            break;
        }
        case LIGHT1_ENABLED_ID: {
            if ( light1_enabled )
                light1_spinner->enable();
            else
                light1_spinner->disable();
            break;
        }

        case LIGHT2_ENABLED_ID: {
            if ( light2_enabled )
                light2_spinner->enable();
            else
                light2_spinner->disable();
            break;
        }
        case LIGHT0_INTENSITY_ID: {
            float v[] = {
                escena.light0_diffuse[0],  escena.light0_diffuse[1],
                escena.light0_diffuse[2],  escena.light0_diffuse[3] };

            v[0] *= light0_intensity;
            v[1] *= light0_intensity;
            v[2] *= light0_intensity;
            std::cout << "intensidad: " << light0_intensity << std::endl;

            break;
        }
        case LIGHT1_INTENSITY_ID: {
            float v[] = {
                escena.light1_diffuse[0],  escena.light1_diffuse[1],
                escena.light1_diffuse[2],  escena.light1_diffuse[3] };

            v[0] *= light1_intensity;
            v[1] *= light1_intensity;
            v[2] *= light1_intensity;


            break;
        }

        case LIGHT2_INTENSITY_ID: {
            float v[] = {
                escena.light1_diffuse[0],  escena.light1_diffuse[1],
                escena.light1_diffuse[2],  escena.light1_diffuse[3] };

            v[0] *= light1_intensity;
            v[1] *= light1_intensity;
            v[2] *= light1_intensity;


            break;
        }



        case ENABLE_ID: {
            glui2->enable();
            break;
        }
        case DISABLE_ID: {
            glui2->disable();
            break;
        }
        case RESET_ID: {
            memcpy(escena.view_position,view_position_c,3*sizeof(float));
            view_rot->reset();
            escena.scale = 1.0;
            break;
        }
        case SEL_ID: {
            escena.seleccion = sel;
            //GLUI_Master.SetFocus(true);
            glutSetWindow( glui->get_glut_window_id() );
            break;
        }
  } // switch
}

/***************************************** TGui::Idle() ***********/

void __fastcall TGui::Idle( void )
{
  /* According to the GLUT specification, the current window is
     undefined during an idle callback.  So we need to explicitly change
     it if necessary */
  if ( glutGetWindow() != window_id )
    glutSetWindow(window_id);

  /*  GLUI_Master.sync_live_all();  -- not needed - nothing to sync in this
                                       application  */
    if (enable_panel2)

        glui2->enable();
    else
        glui2->disable();

  glutPostRedisplay();
}

/**************************************** TGui::reshape() *************/

void __fastcall TGui::Reshape( int x, int y )
{
    int tx, ty, tw, th;
    GLUI_Master.get_viewport_area( &tx, &ty, &tw, &th );
    glViewport( tx, ty, tw, th );

    escena.xy_aspect = (float)tw / (float)th;
    escena.projectionMatrix = glm::perspective(45.0f, escena.xy_aspect, 0.1f, 1000.0f);
    glUniformMatrix4fv(escena.uProjectionMatrixLocation, 1, GL_FALSE, glm::value_ptr(escena.projectionMatrix));

    //std::cout << "xy aspect: " << escena.xy_aspect << std::endl;

    glutPostRedisplay();
}

/***************************************** gui::motion() **********/

void __fastcall TGui::Motion(int x, int y )
{
    glutPostRedisplay();
}

/***************************************** gui::Mouse() **********/

void __fastcall TGui::Mouse(int button, int button_state, int x, int y )
{
  //  escena.Pick3D(x, y);
}

